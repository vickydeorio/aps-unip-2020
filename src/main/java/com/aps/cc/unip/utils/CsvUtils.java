package com.aps.cc.unip.utils;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CsvUtils {

    public static  <obj> List<obj> readCsv(String path, Class obj) throws IOException {
        Reader reader = Files.newBufferedReader(Paths.get(path));

        CsvToBean<obj> csvToBean = new CsvToBeanBuilder(reader).withType(obj).build();

        List<obj> objs = csvToBean.parse();

        return objs;
    }

    public static List<String[]> readCsv(String path) throws IOException {
        Reader reader = Files.newBufferedReader(Paths.get(path));
        CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();

        return csvReader.readAll();
    }

    public String escapeSpecialCharacters(String data) {
        String escapedData = data.replaceAll("\\R", " ");
        if (data.contains(",") || data.contains("\"") || data.contains("'")) {
            data = data.replace("\"", "\"\"");
            escapedData = "\"" + data + "\"";
        }
        return escapedData;
    }

    public String convertToCSV(String[] data) {
        return Stream.of(data)
                            .map(this::escapeSpecialCharacters)
                            .collect(Collectors.joining(","));
    }

    public void writeCsv(String path, String fileName, List<String[]> dataLines) throws IOException {
        File csvOutputFile = new File(getFullPath(path, fileName));
        try (PrintWriter pw = new PrintWriter(csvOutputFile)) {
            dataLines.stream()
                    .map(this::convertToCSV)
                    .forEach(pw::println);
        }
    }

    private String getFullPath(String path, String fileName){
        if(path.charAt(path.length()-1) != '/'){
            path += "/";
        }

        return path+fileName;
    }
}
