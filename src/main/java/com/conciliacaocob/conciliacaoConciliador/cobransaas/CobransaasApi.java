package com.conciliacaocob.conciliacaoConciliador.cobransaas;

import com.conciliacaocob.conciliacaoParcExt.model.ContratoCobransaas;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * @author Diego Rangel - diegorangeljpa@gmail.com
 */
public class CobransaasApi {

    public static final String ENDPOINT_CONTRATOS = "/api/contratos";


    public ArrayList<ContratoCobransaas> buscarContratos() throws Throwable {

        ArrayList<ContratoCobransaas> contratos = new ArrayList<>();

            try {

                Gson gson = new Gson();




//                        .registerTypeHierarchyAdapter(Date.class,
//                                new GsonDateDeserializer("yyyy-MM-dd'T'HH:mm:ss", "yyyy-MM-dd'T'HH:mm:ss.S",
//                                        "yyyy-MM-dd'T'HH:mm:ss.SS", "yyyy-MM-dd'T'HH:mm:ss.SSS", "yyyy-MM-dd"))
//                        .create();

                Type type =  new TypeToken<Object>() {}.getType();


                type = new TypeToken<ArrayList<Object>>() {}.getType();
                contratos = gson.fromJson("", type);

                if (contratos != null && !contratos.isEmpty()) {

                    //contratos = ContratoCobransaasDTO.parseObjetoToListContratoCobransaasDTO (contratos);

                }
                //responseCobransaas.setResponseBody(new ListagemContratosCobransaasResponse(contratos));

            } catch (Exception e) {
//                ErroLogicoException erro = new ErroLogicoException(
//                        "[CobranSaaS] Problema ao processar a resposta do serviço");
//                LoggerNeus.errorCobranSaaS(getClass(), erro);
                throw new Throwable(e);
            }


        return contratos;
    }

//    @Override
//    public ResponseCobransaas processarRequisicao(DadosAcessoCobransaasDTO dadosAcesso, String metodo, Map<String, String> queryParameters, String endpoint, Object requestBody, Type responseType) throws ErroLogicoException {
//
//        try ( CloseableHttpClient client = HttpClients.createDefault() ) {
//
//            URIBuilder uriBuilder = new URIBuilder(dadosAcesso.getEndereco() + endpoint);
//            if (queryParameters != null) {
//                for (String key : queryParameters.keySet()) {
//                    uriBuilder.setParameter(key, queryParameters.get(key));
//                }
//            }
//
//            HttpRequestBase request;
//
//            switch (metodo) {
//                case HttpPost.METHOD_NAME:
//                    request = new HttpPost(uriBuilder.build());
//                    break;
//
//                case HttpGet.METHOD_NAME:
//                    request = new HttpGet(uriBuilder.build());
//                    break;
//
//                case HttpDelete.METHOD_NAME:
//                    request = new HttpDelete(uriBuilder.build());
//                    break;
//
//                default:
//                    ErroLogicoException erro = new ErroLogicoException("Método não implementado.", new NotImplementedException("Método " + metodo + " não implementado."));
//                    LoggerNeus.errorCobranSaaS(getClass(), erro);
//                    throw erro;
//            }
//
//            request.addHeader(HttpHeaders.AUTHORIZATION, "Basic " + dadosAcesso.getAuthorizationToken());
//            request.addHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON);
//
//            if (requestBody != null && request instanceof HttpPost) {
//                HttpPost post = (HttpPost) request;
//                HttpEntity entity;
//
//                if (requestBody instanceof File) {
//                    post.addHeader(HttpHeaders.CONTENT_ENCODING, "gzip");
//                    entity = new FileEntity((File) requestBody, ContentType.APPLICATION_JSON);
//
//                } else if (requestBody instanceof String) {
//                    entity = new StringEntity((String) requestBody, ContentType.APPLICATION_JSON);
//
//                } else {
//                    ErroLogicoException erro = new ErroLogicoException("Tipo do request body não suportado.", new NotImplementedException("Tipo não implementado: " + requestBody.getClass()));
//                    LoggerNeus.errorCobranSaaS(getClass(), erro);
//                    throw erro;
//                }
//
//                post.setEntity(entity);
//            }
//
//            CloseableHttpResponse response = client.execute(request);
//            return processarResposta(response, responseType);
//
//        } catch (IOException | URISyntaxException e) {
//            //ErroLogicoException erro = new ErroLogicoException("[CobranSaaS] Erro no acesso a API do CobranSaaS", e);
//            //LoggerNeus.errorCobranSaaS(getClass(), erro);
//            throw erro;
//        }
//    }
//
//    public File montarArquivo(Date dataExecucao, ProcessamentoCobransaas processamento, List<String> linhas)
//            throws ErroLogicoException {
//        //ErroLogicoException erro = new ErroLogicoException(new NotImplementedException("Método não implementado"));
//        //LoggerNeus.errorCobranSaaS(getClass(), erro);
//        throw erro;
//    }



}
