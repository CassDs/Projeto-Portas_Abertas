package br.com.portasabertas.dao.sql;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class NativeSQLQuery {
    public static final String GET_AGENDAMENTO_PARA_O_DIA_PSICOLOGO;

    private NativeSQLQuery() {}

    static {

        GET_AGENDAMENTO_PARA_O_DIA_PSICOLOGO = getResourceFileAsString("getAgendamentoParaODiaPsicologo.sql");

    }

    public static String getResourceFileAsString(final String fileName) {
        final var inputStream = getResourceFileAsInputStream(fileName);
        if (inputStream != null) {
            final  var reader = new BufferedReader(new InputStreamReader(inputStream));
            return reader.lines().collect(Collectors.joining(System.lineSeparator()));
        } else {
            return "";
        }
    }

    public static InputStream getResourceFileAsInputStream(final String fileName) {
        final var classLoader = NativeSQLQuery.class.getClassLoader();
        return classLoader.getResourceAsStream(fileName);
    }
}
