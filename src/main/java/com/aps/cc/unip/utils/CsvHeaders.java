package main.java.com.aps.cc.unip.utils;

public class CsvHeaders {
    private Header header;

    public CsvHeaders(Header header) {
        this.header = header;
    }

    public String[] getHeaderAsArray() {
        String[] arr;

        switch (header) {
            case Aluno:
                arr = new String[]{"studentId", "studentName"};
                break;
            case Curso:
                arr = new String[]{"courseName", "courseType", "courseYear"};
                break;
            case Rendimento:
                arr = new String[]{"id_do_aluno", "nota_NP1", "nota_NP2", "nota_reposicao", "nota_exame"};
                break;
            default:
                arr = new String[0];
                break;
        }

        return arr;
    }
}
