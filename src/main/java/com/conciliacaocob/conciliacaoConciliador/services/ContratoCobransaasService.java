package com.conciliacaocob.conciliacaoConciliador.services;

import com.conciliacaocob.conciliacaoConciliador.cobransaas.*;
import com.conciliacaocob.conciliacaoConciliador.cobransaas.DTO.ContratoCobransaasDTO;
import com.conciliacaocob.conciliacaoConciliador.model.Base;
import com.conciliacaocob.conciliacaoConciliador.model.ContratoCobransaas;
import com.conciliacaocob.conciliacaoConciliador.model.Emissor;
import com.conciliacaocob.conciliacaoConciliador.repository.BaseRepository;
import com.conciliacaocob.conciliacaoConciliador.repository.ContratoCobransaasRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.*;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.FileEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.*;
import java.lang.reflect.Type;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.*;

/**
 * Service ContratoCobransaas
 * @author Diego Rangel
 */
@Service
public class ContratoCobransaasService {

    private static final Logger logger = LoggerFactory.getLogger(ContratoCobransaasService.class);

    public static String ENDERECO_API_CONTRATOS = "api/contratos";

    public static int codigoSucesso = 200;

    @Autowired
    ContratoCobransaasRepository contratoCobransaasRepository;

    @Autowired
    BaseRepository baseRepository;

    public ContratoCobransaas buscarPorId(long id){
        return contratoCobransaasRepository.findById(id);
    }

    @Async
    public ResponseConsultaContratos buscarContratosCobransaas(Emissor emissor, long conciliacao) throws Exception {

        Base base = baseRepository.findById(emissor.getBase().getId());

        DadosAcessoCobransaasDTO dadosAcesso = (DadosAcessoCobransaasDTO) getDadosAcessoApi(base);

        logger.info("[Conciliação Parceiro Externo] - Consultando contratos na Tívea... ");

        int pagina = 0;
        boolean continuarConsultando = false;

        Map<String, String> mapParametros = new HashMap<>();
        mapParametros.put("situacao", "PARCIAL,ABERTO");
        mapParametros.put("page", "0");
        mapParametros.put("size", "2000");

        Type type2 = new TypeToken<ArrayList<ContratoCobransaas>>(){}.getType();

        List<ContratoCobransaasDTO> contratos = new ArrayList<>();
        int numeroDeConsultas = 1;
        ResponseConsultaContratos responseConsultaContratos = new ResponseConsultaContratos();
        responseConsultaContratos.setQuantidadeContratos(0);

        ResponseCobransaas responseCobransaas = new ResponseCobransaas();

        try {
            Type type = new TypeToken<ContratoCobransaas>(){}.getType();
            logger.info("[Conciliação Parceiro Externo] - Disparando primeira consulta... ");
            responseCobransaas = processarRequisicao(dadosAcesso, "GET", mapParametros, ContratoCobransaasService.ENDERECO_API_CONTRATOS, null, type);

            if (!responseCobransaas.isSucesso()) {
                logger.error("[Conciliação Parceiro Externo] - Erro ao consultar todos os contratos do CobranSaaS: ");
                responseConsultaContratos.setStatusConsulta(ResponseConsultaContratos.STATUS_ERRO);
                responseConsultaContratos.setErro(responseCobransaas.getErro().toString());
                throw new Exception("ERRO");
            }

            if (responseCobransaas != null && responseCobransaas.isSucesso()) {

                ListagemContratosCobransaasResponse listagemAtual = (ListagemContratosCobransaasResponse) responseCobransaas.getResponseBody();

                if (listagemAtual != null && !listagemAtual.getContratos().isEmpty()) {

                    contratos = listagemAtual.getContratos();
                    if (listagemAtual != null && listagemAtual.getContratos().size() == 2000) {
                        continuarConsultando = true;
                        pagina++;
                    } else {
                        continuarConsultando = false;
                    }

                    //A api de contratos retorna o número  máximo de registros 2000
                    //Com isso temos que fazer uma nova requisição para pegar os demais registros
                    while(continuarConsultando){

                        pagina++;
                        mapParametros.clear();
                        mapParametros.put("situacao", "PARCIAL,ABERTO");
                        mapParametros.put("page", String.valueOf(pagina));
                        mapParametros.put("size", "2000");
                        logger.info("[Conciliação Parceiro Externo] - Última consulta retornou mais de 2 mil contratos. Page: "+String.valueOf(pagina)+" Consulta de número "+numeroDeConsultas);

                        responseCobransaas = processarRequisicao(dadosAcesso, "GET", mapParametros, ContratoCobransaasService.ENDERECO_API_CONTRATOS, null, type);

                        if (responseCobransaas != null && responseCobransaas.isSucesso()) {
                            listagemAtual = (ListagemContratosCobransaasResponse) responseCobransaas.getResponseBody();
                            if (listagemAtual != null) {
                                contratos.addAll(listagemAtual.getContratos());
                            }
                            if (listagemAtual != null && listagemAtual.getContratos().size() == 2000){
                                continuarConsultando = true;
                            }else{
                                continuarConsultando = false;
                            }
                        }else{
                            continuarConsultando = false;
                        }
                        numeroDeConsultas++;
                    }

                }
                ArrayList<ContratoCobransaas> c = ContratoCobransaas.parseObjetoToListContratoCobransaasDTOtoContratoCobransaas(contratos, conciliacao);
                List<ContratoCobransaas> con = listaContratosSalvos(PageRequest.of(1, 1),conciliacao);
                //Trecho de código passivel de mudança no caso de não salvar os contratos na base local
                if (con!=null || !con.isEmpty() ){
                    contratoCobransaasRepository.deleteByConciliacao(conciliacao);
                }
                contratoCobransaasRepository.saveAll(c);

                responseConsultaContratos.setStatusConsulta(ResponseConsultaContratos.STATUS_SUCESSO);
                responseConsultaContratos.setQuantidadeContratos(c.size());

            }
            } catch (Exception e) {
                logger.error("[Conciliação Parceiro Externo] - Erro ao consultar api de contratos no CobranSaaS - "+e.toString());
                responseConsultaContratos.setStatusConsulta(ResponseConsultaContratos.STATUS_ERRO);
                if (responseCobransaas != null) {
                    responseConsultaContratos.setErro(responseCobransaas.toString());
                }
            }
        logger.info("[Conciliação Parceiro Externo] - Consulta de contratos finalizada!!! ");
        return responseConsultaContratos;
    }

    public DadosAcessoCobransaasDTO getDadosAcessoApi(Base base) {
        DadosAcessoCobransaasDTO dadosAcesso = new DadosAcessoCobransaasDTO(base.getEnderecoCobransaas(),
                base.getAplicativoCobransaas(), base.getSenhaCobransaas());
        if (StringUtils.isBlank(dadosAcesso.getAuthorizationToken())) {
            logger.error("[Conciliação Parceiro Externo] - Não foi possível obter os dados de acesso à API do CobranSaaS");
        }
        return dadosAcesso;
    }

    public ResponseCobransaas processarRequisicao(DadosAcessoCobransaasDTO dadosAcesso, String metodo, Map<String, String> queryParameters, String endpoint, Object requestBody, Type responseType) {

        try ( CloseableHttpClient client = HttpClients.createDefault() ) {

            URIBuilder uriBuilder = new URIBuilder(dadosAcesso.getEndereco() + endpoint);
            if (queryParameters != null) {
                for (String key : queryParameters.keySet()) {
                    uriBuilder.setParameter(key, queryParameters.get(key));
                }
            }

            HttpRequestBase request = new HttpRequestBase() {
                @Override
                public String getMethod() {
                    return null;
                }
            };

            switch (metodo) {
                case HttpPost.METHOD_NAME:
                    request = new HttpPost(uriBuilder.build());
                    break;

                case HttpGet.METHOD_NAME:
                    request = new HttpGet(uriBuilder.build());
                    break;

                case HttpDelete.METHOD_NAME:
                    request = new HttpDelete(uriBuilder.build());
                    break;

                default:
                    logger.error("Método não implementado.");
            }

            request.addHeader(HttpHeaders.AUTHORIZATION, "Basic " + dadosAcesso.getAuthorizationToken());
            request.addHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON+"");

            if (requestBody != null && request instanceof HttpPost) {
                HttpPost post = (HttpPost) request;
                HttpEntity entity = new HttpEntity() {
                    @Override
                    public boolean isRepeatable() {
                        return false;
                    }

                    @Override
                    public boolean isChunked() {
                        return false;
                    }

                    @Override
                    public long getContentLength() {
                        return 0;
                    }

                    @Override
                    public Header getContentType() {
                        return null;
                    }

                    @Override
                    public Header getContentEncoding() {
                        return null;
                    }

                    @Override
                    public InputStream getContent() throws IOException, UnsupportedOperationException {
                        return null;
                    }

                    @Override
                    public void writeTo(OutputStream outputStream) throws IOException {

                    }

                    @Override
                    public boolean isStreaming() {
                        return false;
                    }

                    @Override
                    public void consumeContent() throws IOException {

                    }
                };

                if (requestBody instanceof File) {
                    post.addHeader(HttpHeaders.CONTENT_ENCODING, "gzip");
                    entity = new FileEntity((File) requestBody, ContentType.APPLICATION_JSON);

                } else if (requestBody instanceof String) {
                    entity = new StringEntity((String) requestBody, ContentType.APPLICATION_JSON);

                } else {
                    logger.error("Tipo do request body não suportado.");
                }

                post.setEntity(entity);
            }

            CloseableHttpResponse response = client.execute(request);

            if (response.getStatusLine().getStatusCode() != 200){
                //System.out.println("[CobranSaaS] Erro no acesso a API do CobranSaaS - Erro: "+response.toString());
                logger.error("[CobranSaaS] Erro no acesso a API do CobranSaaS - Erro: "+response.getStatusLine().toString());
            }
            return processarResposta(response, responseType);

        } catch (IOException | URISyntaxException e) {
            logger.error("[CobranSaaS] Erro no acesso a API do CobranSaaS - Erro: "+e.getMessage());
            return null;
        }
    }

    protected ErroCobransaasResponse validarRespostaCobransaas(CloseableHttpResponse response, Gson gson) throws IOException {
        if (200 != response.getStatusLine().getStatusCode()) {
            ErroCobransaasResponse erro = gson.fromJson(new InputStreamReader(response.getEntity().getContent(), "UTF-8"), ErroCobransaasResponse.class);

            // Caso nao seja retornado o obj de erro, preencher manualmente
            if (erro == null) {
                erro = new ErroCobransaasResponse();
                erro.setData(Calendar.getInstance());
                erro.setStatus(String.valueOf(response.getStatusLine().getStatusCode()));
                erro.setMessageByCode(response.getStatusLine().getStatusCode());
            }

            return erro;
        }

        return null;
    }

    public ResponseCobransaas processarResposta(CloseableHttpResponse response, Type responseType) {

        ResponseCobransaas responseCobransaas = new ResponseCobransaas();

            try {

                Gson gson = new GsonBuilder().setLenient().create();

                Type type = responseType;

                type = new TypeToken<ArrayList<Object>>() {}.getType();
                ArrayList<ContratoCobransaasDTO> contratos = gson.fromJson(new InputStreamReader(response.getEntity().getContent(), "UTF-8"), type);

                if (contratos != null) {

                    contratos = ContratoCobransaas.parseObjetoToListContratoCobransaasDTO (contratos);

                }
                responseCobransaas.setResponseBody(new ListagemContratosCobransaasResponse(contratos));

            } catch (IOException | ParseException e) {
                logger.error("[CobranSaaS] Problema ao processar a resposta do serviço");
            }

            return responseCobransaas;

    }

    public boolean removeContratosBaseLocal(Emissor emissor){
        contratoCobransaasRepository.deleteAll();
        return true;
    }

    public boolean removeContratosDaConciliacao(Emissor emissor, long conciliacao){
        contratoCobransaasRepository.deleteByConciliacao(conciliacao);
        return true;
    }

    public List<ContratoCobransaas> listaContratosSalvos (Pageable pageable, long conciliacao){
        return contratoCobransaasRepository.findAllByConciliacao(conciliacao, pageable);
    }





}
