
package com.conciliacaocob.conciliacaoConciliador.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Classe para manipular datas
 *
 * @author Diego Rangel
 */
public class FuncoesData {

    public static String DATE_PATTERN = "(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20|21)\\d\\d)";

    public static SimpleDateFormat sdfDataPorExtenso = new SimpleDateFormat("EEEE, d' de 'MMMM' de 'yyyy", new Locale("pt", "BR"));

    public static SimpleDateFormat sdfDataParaNomeArquivo = new SimpleDateFormat("yyyyMMdd");

    public static SimpleDateFormat sdfDataHoraParaNomeArquivo = new SimpleDateFormat("yyyyMMdd_HHmmss");

    public static SimpleDateFormat sdfHoraParaNomeArquivo = new SimpleDateFormat("HHmmss");

    public static SimpleDateFormat sdfDataParaNCS = new SimpleDateFormat("ddMMyyyy");

    public static SimpleDateFormat sdfHoraParaNCS = new SimpleDateFormat("HHmmss");

    public static SimpleDateFormat sdfDataHoraParaNCS = new SimpleDateFormat("ddMMyyyy HHmmss");

    /**
     * Utilizar getSdfData()
     */
    public static SimpleDateFormat sdfData = new SimpleDateFormat("dd/MM/yyyy");

    public static SimpleDateFormat sdfDataAA = new SimpleDateFormat("dd/MM/yy");

    public static SimpleDateFormat sdfHoraSS = new SimpleDateFormat("HH:mm:ss");

    /**
     * Utilizar getSdfDataHora()
     */
    public static SimpleDateFormat sdfDataHora = new SimpleDateFormat("dd/MM/yyyy',' HH:mm");

    public static SimpleDateFormat sdfDataHoraMinSeg = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    public static SimpleDateFormat sdfDataHoraDB = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    public static SimpleDateFormat sdfDataDiaMes = new SimpleDateFormat("dd/MM");

    public static SimpleDateFormat sdfHora = new SimpleDateFormat("hh:mm");

    public static SimpleDateFormat sdfHora24 = new SimpleDateFormat("HH:mm");

    public static SimpleDateFormat SDF_ddMM = new SimpleDateFormat("ddMMM");

    public static SimpleDateFormat SDF_yyMM = new SimpleDateFormat("yyMM");

    public static SimpleDateFormat SDF_MMyy = new SimpleDateFormat("MMyy");

    public static SimpleDateFormat SDF_yyMMdd = new SimpleDateFormat("yyMMdd");

    public static SimpleDateFormat SDF_ddMMyy = new SimpleDateFormat("ddMMyy");

    public static SimpleDateFormat SDF_ddMMyyyy = new SimpleDateFormat("ddMMyyyy");

    public static SimpleDateFormat SDF_ddMMyyyyHHmmss = new SimpleDateFormat("ddMMyyyyHHmmss");

    public static final long MILIS_POR_DIA = 86400000;

    public static final long MILIS_POR_HORA = 3600000;


    /**
     * Valida��o de data para o formato DD/MM/YYYY
     *
     * @param data
     * @return
     */
    public static boolean isPatternDateValida(String data) {
        if (data != null) {
            Pattern p = Pattern.compile(DATE_PATTERN);
            Matcher m = p.matcher(data);
            return m.matches();
        }
        return false;
    }

    public static SimpleDateFormat SDF_HHmm = new SimpleDateFormat("HHmm");

    public static String getDataComFormatacaoEspecifica(Date data, String formatacao) {
        SimpleDateFormat sdfEspecifico = new SimpleDateFormat(formatacao);
        return sdfEspecifico.format(data);
    }

    public static int getDaysBetween(Date d1, Date d2) {
        d1 = getDataComHoraMinima(d1);
        d2 = getDataComHoraMinima(d2);

        long millis1 = d1.getTime();
        long millis2 = d2.getTime();
        long millis = millis2 - millis1;
        int dias = (int) (millis / MILIS_POR_DIA);

        return dias;
    }//getDaysBetween()

    public static int getDiasEntreDatas(Date d1, Date d2) {
        long millis1 = d1.getTime();
        long millis2 = d2.getTime();

        long millis = 0;
        if (millis1 > millis2) {
            millis = millis1 - millis2;
        } else {
            millis = millis2 - millis1;
        }

        millis += 3600000;//Adiciona 1 hora por causa do horario de verao
        return (int) (millis / MILIS_POR_DIA);
    }

    public static int getDaysBetween(Calendar c1, Calendar c2) {
        return getDaysBetween(c1.getTime(), c2.getTime());
    }

    public static int getDaysBetween360(Calendar atual, Calendar proximoVencimento) {
        int dias = 0;
        int meses = 0;

        if (proximoVencimento.before(atual)) {
            dias = 0;

        } else if (atual.before(proximoVencimento)) {
            Calendar dataClone = (Calendar) atual.clone();
            dataClone.add(Calendar.MONTH, 1);
            while ((dataClone.before(proximoVencimento) || dataClone.equals(proximoVencimento))) {
                meses++;
                int mesesClone = meses;
                dataClone = (Calendar) atual.clone();
                dataClone.add(Calendar.MONTH, mesesClone + 1);
            }

            atual.add(Calendar.MONTH, meses);

            if (atual.get(Calendar.MONTH) != proximoVencimento.get(Calendar.MONTH)) {
                dias = (30 - atual.get(Calendar.DATE));
                if (dias < 0) {
                    dias = 0;
                }
                dias += proximoVencimento.get(Calendar.DATE);
            } else {
                dias =FuncoesData.getDaysBetween(atual, proximoVencimento);
            }


            dias += meses * 30;
        }

        return dias;
    }

    public static int getHorasEntre(Date dateMenor, Date dateMaior) {
        return (int) ((dateMaior.getTime() - dateMenor.getTime()) / MILIS_POR_HORA);
    }

    public static int getNumeroDiasDoMes(Date data) {
        Calendar cData = getCalendar();
        cData.setTime(data);
        return cData.getActualMaximum(Calendar.DAY_OF_MONTH);
    }//getNumeroDiasDoMes()

    public static int getNumeroDiasDoMes(Calendar data) {
        return data.getActualMaximum(Calendar.DAY_OF_MONTH);

    }//getNumeroDiasDoMes()

    public static Calendar getCalendar() {
        return Calendar.getInstance(Locale.ITALY);
    }

    public static Calendar getCalendar(Date data) {
        Calendar calendar = Calendar.getInstance(Locale.ITALY);
        calendar.setTime(data);

        return calendar;
    }

    public static Calendar getVencimentoPorCorte(Calendar dataCorte, int diaVencimento) {
        int diaCorte = dataCorte.get(Calendar.DAY_OF_MONTH);

        Calendar dataVencimento = getCalendar(dataCorte.getTime());
        dataVencimento.set(Calendar.DAY_OF_MONTH, diaVencimento);

        if (diaCorte > diaVencimento) {
            dataVencimento.add(Calendar.MONTH, 1);
        }

        return dataVencimento;
    }

    public static Calendar[] getVencimentosInternos(Calendar data1, Calendar data2, int diaVencimento) {
        Calendar[] datasVencimento = new Calendar[2];

        Calendar vencimento1 = (Calendar) data1.clone();
        Calendar vencimento2 = (Calendar) data2.clone();

        // SETANDO OS DIAS DO VENCIMENTO
        vencimento1.set(Calendar.DAY_OF_MONTH, diaVencimento);
        vencimento2.set(Calendar.DAY_OF_MONTH, diaVencimento);

        if (diaVencimento < data1.get(Calendar.DAY_OF_MONTH)) {
            vencimento1.add(Calendar.MONTH, 1);
        }

        if (diaVencimento > data2.get(Calendar.DAY_OF_MONTH)) {
            vencimento2.add(Calendar.MONTH, -1);
        }

        // SE NAO FOR 'AFTER',SIGNIFICA QUE EXISTE VENCIMENTO ENTRE AS DATAS
        if (!(vencimento1.after(vencimento2))) {
            datasVencimento[0] = vencimento1;
            datasVencimento[1] = vencimento2;
            return datasVencimento;
        } else {
            return null;
        }

    }

    public static Date tirarHoras(Date dataComHoras) {
        Date dataSemHoras = null;
        try {
            SimpleDateFormat sdfData = getSdfData();
            String strDataComHoras = sdfData.format(dataComHoras);
            dataSemHoras = sdfData.parse(strDataComHoras);
        } catch (ParseException erro) {
            //LoggerNeus.error(FuncoesData.class, "", erro);
            System.out.println("Erro: " + erro.getMessage());
        }

        return dataSemHoras;

    }

    public static String formatarDataSemHoraParaNomeArquivo(Date data) {
        return sdfDataParaNomeArquivo.format(data);
    }

    public static String formatarDataSemHora(Date data) {
        return sdfData.format(data);
    }

    public static String getDataFormatacaoEspecifica(String data, String formatacaoEntrada, String formatacaoSaida) {
        String dataFormata = null;
        try {
            dataFormata = FuncoesData.getDataComFormatacaoEspecifica(FuncoesData.getDataFormatacaoEspecifica(data, formatacaoEntrada), formatacaoSaida);
        } catch (ParseException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return dataFormata;
    }

    public static String formatarDataComHora(Date data) {
        if (data != null) {
            return new SimpleDateFormat("dd/MM/yyyy',' HH:mm").format(data);
        }
        return null;
    }

    public static String formatarHora(Date data) {
        return sdfHora.format(data);
    }

    public static String formatarHora24(Date data) {
        return sdfHora24.format(data);
    }

    public static String formatatDataPorExtenso(Date date) {
        return sdfDataPorExtenso.format(date);
    }

    public static Date getData(String data) throws ParseException {
        return sdfData.parse(data);
    }

    public static Date getDataFormatacaoEspecifica(String data, String formatacao) throws ParseException {
        return getDataFormatacaoEspecifica(data, formatacao, false);
    }

    public static Date getDataFormatacaoEspecifica(String data, String formatacao, boolean lenient) throws ParseException {
        SimpleDateFormat sdfEspecifico = new SimpleDateFormat(formatacao);
        sdfEspecifico.setLenient(lenient);
        return sdfEspecifico.parse(data);
    }

    public static String getDataFormatacaoEspecifica(Date data, String formatacao) throws ParseException {
        SimpleDateFormat sdfEspecifico = new SimpleDateFormat(formatacao);
        return sdfEspecifico.format(data);
    }

    public static Date getDataHora(String data) throws ParseException {
        return getSdfDataHora().parse(data);
    }

    public static Date getDataDiaMes(String data) throws ParseException {
        return sdfDataDiaMes.parse(data);
    }

    public static void println(String s, Date data) {
        //LoggerNeus.info(FuncoesData.class, s + " - " + sdfData.format(data));
        //System.out.println("Erro: "+e.getMessage());
    }

    /**
     * Testa se o propriet�rio de uma data de nascimento j� tem a idade passada
     * por par�metro
     */
    public static boolean testarAtingiuIdade(Date dataNascimento, int idade) {
        boolean jaTemIdade = true;
        Calendar dataAtualCalendar = FuncoesData.getCalendar();
        Calendar dataNascimentoCalendar = FuncoesData.getCalendar(dataNascimento);
        dataNascimentoCalendar.add(Calendar.YEAR, idade);
        if (dataNascimentoCalendar.after(dataAtualCalendar)) {
            jaTemIdade = false;
        }
        return jaTemIdade;
    }

    public static boolean testaPassouDaIdade(Date dataNascimento, int idadeMax) {
        boolean jaPassouDaIdade = false;

        Calendar dataIdadeMax = Calendar.getInstance();
        dataIdadeMax.setTime(dataNascimento);
        dataIdadeMax.add(Calendar.YEAR, idadeMax + 1);

        Calendar dataAtual = Calendar.getInstance();
        if (dataAtual.after(dataIdadeMax)) {
            jaPassouDaIdade = true;
        }
        return jaPassouDaIdade;
    }

    /**
     * M�todo utilizado para pegar as datas no intervalo de dias especificado.
     *
     * @param diaInicial Valor referente ao dia do primeiro intervalo de datas.
     * @param mesInicial Valor referente ao mes do primeiro intervalo de datas.
     * @param anoInicial Valor referente ao ano do primeiro intervalo de datas.
     * @param diaFinal   Valor referente ao dia do segundo intervalo de datas.
     * @param mesFinal   Valor referente ao mes do segundo intervalo de datas.
     * @param anoFinal   Valor referente ao ano do segundo intervalo de datas.
     * @return Um array de datas contendo as datas inicial e final que serao
     * utilizadas para serem filtradas.
     */
    public static Date[] to_char(int diaInicial, int mesInicial, int anoInicial, int diaFinal, int mesFinal, int anoFinal) {
        Date[] resultado = new Date[2];
        Calendar calendar = getCalendar(new Date());

        // setando o primeiro filtro de datas
        calendar.set(Calendar.YEAR, anoInicial);
        calendar.set(Calendar.MONTH, mesInicial);
        calendar.set(Calendar.DAY_OF_MONTH, diaInicial);
        calendar.set(Calendar.HOUR_OF_DAY, calendar.getMinimum(Calendar.HOUR_OF_DAY));
        calendar.set(Calendar.MINUTE, calendar.getMinimum(Calendar.MINUTE));
        calendar.set(Calendar.SECOND, calendar.getMinimum(Calendar.SECOND));
        resultado[0] = calendar.getTime();

        // setando o segundo filtro de datas
        calendar.set(Calendar.YEAR, anoFinal);
        calendar.set(Calendar.MONTH, mesFinal);
        calendar.set(Calendar.DAY_OF_MONTH, diaFinal);
        calendar.set(Calendar.HOUR_OF_DAY, calendar.getMaximum(Calendar.HOUR_OF_DAY));
        calendar.set(Calendar.MINUTE, calendar.getMaximum(Calendar.MINUTE));
        calendar.set(Calendar.SECOND, calendar.getMaximum(Calendar.SECOND));
        resultado[1] = calendar.getTime();

        return resultado;
    }

    public static Date getDateComHoraMinima(Date data) {

        Calendar date = getCalendar(data);
        date.set(Calendar.HOUR_OF_DAY, 0);
        date.set(Calendar.MINUTE, 0);
        date.set(Calendar.SECOND, 0);
        date.set(Calendar.MILLISECOND, 0);

        return date.getTime();
    }

    public static Date getDataComHoraMinima(Date data) {
        Calendar calendar = getCalendar(data);
        return getDataComHoraMinima(calendar).getTime();
    }

    public static Calendar getDataComHoraMinima(Calendar data) {
        Calendar calendar = (Calendar) data.clone();
        calendar.set(Calendar.HOUR_OF_DAY, calendar.getMinimum(Calendar.HOUR_OF_DAY));
        calendar.set(Calendar.MINUTE, calendar.getMinimum(Calendar.MINUTE));
        calendar.set(Calendar.SECOND, calendar.getMinimum(Calendar.SECOND));
        calendar.set(Calendar.MILLISECOND, calendar.getMinimum(Calendar.MILLISECOND));

        return calendar;
    }

    public static Calendar getCalendarComHoraMinima(Calendar calendar) {
        calendar.set(Calendar.HOUR_OF_DAY, calendar.getMinimum(Calendar.HOUR_OF_DAY));
        calendar.set(Calendar.MINUTE, calendar.getMinimum(Calendar.MINUTE));
        calendar.set(Calendar.SECOND, calendar.getMinimum(Calendar.SECOND));
        calendar.set(Calendar.MILLISECOND, calendar.getMinimum(Calendar.MILLISECOND));

        return calendar;
    }

    public static Date getDataComHoraMaxima(Date data) {
        Calendar calendar = getCalendar(data);
        calendar.set(Calendar.HOUR_OF_DAY, calendar.getMaximum(Calendar.HOUR_OF_DAY));
        calendar.set(Calendar.MINUTE, calendar.getMaximum(Calendar.MINUTE));
        calendar.set(Calendar.SECOND, calendar.getMaximum(Calendar.SECOND));
        calendar.set(Calendar.MILLISECOND, calendar.getMaximum(Calendar.MILLISECOND));

        return calendar.getTime();
    }


    public static Date getDataAPartirStringComAno2Digitos(String dataPagamentoStr) throws ParseException {
        String anoCom2Digitos = dataPagamentoStr.substring(4, 6);
        String ano = "" + (Integer.parseInt(anoCom2Digitos) + 2000);
        String data = dataPagamentoStr.substring(0, 4) + ano;

        return FuncoesData.sdfDataParaNCS.parse(data);
    }

    public static String getStringComAno2DigitosAPartirDeData(Date data) {
        String dataRet = "";
        dataRet = FuncoesData.sdfDataParaNCS.format(data);
        dataRet = dataRet.substring(0, 4) + dataRet.substring(6, 8);

        return dataRet;
    }

    public static String getString_yyyyMMdd(Date data) {
        String dataRet = "";
        dataRet = FuncoesData.sdfDataHoraParaNomeArquivo.format(data);

        return dataRet;
    }

    public static boolean isAniversarioEntreCorteAtualEProximo(Date dataNascimento, Calendar dataCorteatual) {

        if (dataNascimento == null) {
            return false;
        }

        if (dataCorteatual == null) {
            return false;
        }

        // TEMOS QUE VERIFICAR SE A DATA DE NASCIMENTO DO CLIENTE ESTA
        // ENTRE AS DATAS DO CORTE ATUAL E A DO PROXIMO
        dataNascimento = FuncoesData.tirarHoras(dataNascimento);

        Calendar calAniversario = FuncoesData.getCalendar(dataNascimento);

        Calendar calProximoCorte = FuncoesData.getCalendar(dataCorteatual.getTime());
        calProximoCorte.add(Calendar.MONTH, 1);
        calAniversario.set(Calendar.YEAR, dataCorteatual.get(Calendar.YEAR));

        if ((calAniversario.compareTo(dataCorteatual)) >= 0 && (calAniversario.compareTo(calProximoCorte) < 0)) {
            return true;
        }

        return false;
    }

    // Funcao que retorna o numero de meses entre as datas, assumindo que a data final eh maior que a inicial.
    // Ela sempre arredonda pra cima se o numero de dias da final for maior.
    public static int getMonthsBetween(Date dataInicial, Date dataFinal) {
        Calendar calendarIni = getCalendar(tirarHoras(dataInicial));
        Calendar calendarFinal = getCalendar(tirarHoras(dataFinal));

        int numMeses =
                calendarFinal.get(Calendar.MONTH) - calendarIni.get(Calendar.MONTH) + (calendarFinal.get(Calendar.YEAR) - calendarIni.get(Calendar.YEAR)) * 12;

        if ((calendarFinal.get(Calendar.DAY_OF_MONTH) - calendarIni.get(Calendar.DAY_OF_MONTH)) > 0) {
            numMeses += 1;
        }

        return numMeses;
    }

    /**
     * Valida se a data informada &eacute; menor que a atual.
     *
     * @param data A data a ser validada.
     * @return se &eacute; anterior a data atual.
     */
    public static boolean isAnteriorDataAtual(Date data) {
        Date dataAtual = FuncoesData.tirarHoras(Calendar.getInstance().getTime());
        Date dataValidar = FuncoesData.tirarHoras(data);

        return dataValidar.before(dataAtual);
    }

    /**
     * Valida se a dataBase informada &eacute; menor que a dataValidacao.
     *
     * @param dataBase      A data a ser levada como data base para a valida&ccedil;&atilde;o.
     * @param dataValidacao A data a ser validada.
     * @return O resultado da compara&ccedil;&atilde;o.
     */
    public static boolean isAnterior(Date dataBase, Date dataValidacao) {
        Date dataB = FuncoesData.tirarHoras(dataBase);
        Date dataV = FuncoesData.tirarHoras(dataValidacao);

        return dataB.before(dataV);
    }

    /**
     * Valida se a dataBase informada &eacute; maior que a dataValidacao.
     *
     * @param dataBase      A data a ser levada como data base para a valida&ccedil;&atilde;o.
     * @param dataValidacao A data a ser validada.
     * @return O resultado da compara&ccedil;&atilde;o.
     */
    public static boolean isPosterior(Date dataBase, Date dataValidacao) {
        Date dataB = FuncoesData.tirarHoras(dataBase);
        Date dataV = FuncoesData.tirarHoras(dataValidacao);

        return dataB.after(dataV);
    }

    /**
     * Passando uma data tipo String no formato dd/MM/yyyy,
     * o retorno será um Date com o horário mínimo
     *
     * @param data
     * @return <code>Data valida</code>
     * <code>null</code>
     */
    public static Date getDataComHoraMinima(String data) {
        Date date;
        try {
            date = FuncoesData.getSdfData().parse(data);
            date = FuncoesData.getDataComHoraMinima(date);

            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }


    /**
     * Passando uma data tipo String no formato dd/MM/yyyy,
     * o retorno será um Date com o horário mínimo
     *
     * @param data
     * @return <code>Data valida</code>
     * <code>null</code>
     */
    public static Date getDataComHoraMaxima(String data) {
        Date date;
        try {
            date = FuncoesData.getSdfData().parse(data);
            date = FuncoesData.getDataComHoraMaxima(date);

            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }


    public static void main(String[] args) throws ParseException {
        String t = "1307";

        Date f = FuncoesData.getDataFormatacaoEspecifica(t, FuncoesData.SDF_yyMM.toPattern());

        System.out.println(f);
        System.out.println(FuncoesData.getDataFormatacaoEspecifica(f, FuncoesData.SDF_yyMM.toPattern()));

    }

    /**
     * Calcula a diferen�a entre duas datas
     *
     * @param data1 Data menor
     * @param data2 Data maior
     * @return Diferen�a considerando dias, horas e minutos.
     */
    public static String getDiferencaDiasHorasMinutos(Date data1, Date data2) {
        long differenceMilliSeconds = data2.getTime() - data1.getTime();

        long dias = (differenceMilliSeconds / 1000 / 60 / 60 / 24);
        long horas = (differenceMilliSeconds / 1000 / 60 / 60 % 24);
        long minutos = (differenceMilliSeconds / 1000 / 60 % 60);

        String dataString = null;
        if (dias == 0) {
            if (horas == 0) {
                dataString = minutos + "min";
            } else {
                dataString = horas + "h e " + minutos + "min";
            }
        } else if (dias == 1) {
            dataString = dias + " dia, " + horas + "h e " + minutos + "min";
        } else {
            dataString = dias + " dias, " + horas + "h e " + minutos + "min";
        }
        return dataString;
    }

    /**
     * Verifica se as datas correspondem ao mesmo dia.
     * N�o ser�o validadas horas, minutos ou segundos.
     *
     * @param data1
     * @param data2
     * @return <code><b>true</b></code> Caso sejam do mesmo dia;
     * <code><b>false</b><code> caso contr�rio
     */
    public static boolean isDataMesmoDia(Date data1, Date data2) {

        Calendar calendar1 = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();

        calendar1.setTime(data1);
        calendar2.setTime(data2);

        if (calendar1.get(Calendar.DAY_OF_MONTH) == calendar2.get(Calendar.DAY_OF_MONTH)) {
            if (calendar1.get(Calendar.MONTH) == calendar2.get(Calendar.MONTH)) {
                if (calendar1.get(Calendar.YEAR) == calendar2.get(Calendar.YEAR)) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Verifica se as datas correspondem ao mesmo dia.
     * N�o ser�o validadas horas, minutos ou segundos.
     *
     * @param data1
     * @param data2
     * @return <code><b>true</b></code> Caso sejam do mesmo dia;
     * <code><b>false</b><code> caso contr�rio
     */
    public static boolean isDataMesmoMes(Date data1, Date data2) {

        Calendar calendar1 = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();

        calendar1.setTime(data1);
        calendar2.setTime(data2);

        if (calendar1.get(Calendar.MONTH) == calendar2.get(Calendar.MONTH)) {
            if (calendar1.get(Calendar.YEAR) == calendar2.get(Calendar.YEAR)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Valida se a data passada est� no intervalo 08:00 as 18:00 (Horario Comercial).
     *
     * @param calendar
     * @return <code>true</code> caso esteja no horario comercial
     * <code>false</code> caso contrario.
     */
    public static boolean validaHorarioComercial(Calendar calendar) {

        return !(calendar.get(Calendar.HOUR_OF_DAY) < 8 || calendar.get(Calendar.HOUR_OF_DAY) > 18);
    }

    /**
     * Retorna o nome do m�s de uma data
     *
     * @param data
     * @param abreviado - Se true retorna "Jan" | Se false retorna "Janeiro"
     * @return
     */
    public static String getNomeMes(Calendar data, boolean abreviado) {
        int style = abreviado ? Calendar.SHORT : Calendar.LONG;
        String nome = data.getDisplayName(Calendar.MONTH, style, Locale.forLanguageTag("pt-BR"));

        return nome != null ? nome.trim() : "";
    }

    /*
     * O SimpleDateFormat n�o � Thread-Safe e por isso deve-se evitar o uso das vari�veis static.
     * O aconselh�vel � criar uma nova inst�ncia (local) toda vez que for utiliz�-lo.
     */
    public static SimpleDateFormat getSdf(String formato) {
        return new SimpleDateFormat(formato);
    }

    public static SimpleDateFormat getSdfData() {
        return new SimpleDateFormat("dd/MM/yyyy");
    }

    public static SimpleDateFormat getSdfDataHoraMinSeg() {
        return new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    }

    public static SimpleDateFormat getSdfDataHora() {
        return new SimpleDateFormat("dd/MM/yyyy',' HH:mm");
    }

    public static SimpleDateFormat getSdfDataDiaMesAno() {
        return new SimpleDateFormat("ddMMyyyy");
    }

    /**
     * Metodo que adiciona valores a uma determinada data, seja ele um campo de ANO, MES, DIA, HORA, MINUTO, SEGUNDO...
     *
     * @param date            - data que ira adicionar os valores
     * @param idValorCalendar - constannte do Calendar para cada valores, Calendar.DAY_OF_MONTH, Calendar.MONTH, Calendar.YAER, Calendar.MINUTE...
     * @param quantidade      - valor a adicionar
     * @return data incrementada
     */
    public static Date adicionaValorData(Date date, int idValorCalendar, int quantidade) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        calendar.add(idValorCalendar, quantidade);

        return calendar.getTime();
    }

    public static boolean ultrapassaTempoMaximo(Date data, int maximo, TimeUnit unidadeDeTempo) {
        Calendar c = Calendar.getInstance();
        c.setTime(data);

        switch (unidadeDeTempo) {
            case DAYS:
                c.add(Calendar.DAY_OF_MONTH, maximo);
                break;
            case HOURS:
                c.add(Calendar.HOUR_OF_DAY, maximo);
                break;
            case MINUTES:
                c.add(Calendar.MINUTE, maximo);
                break;
            default: //SECONDS
                c.add(Calendar.SECOND, maximo);
                break;
        }

        return Calendar.getInstance().after(c);
    }

}
