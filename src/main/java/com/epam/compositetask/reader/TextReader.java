package com.epam.compositetask.reader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TextReader {
    private static final Logger logger = LogManager.getLogger(TextReader.class);
    private static final String FILE_PATH = "src/main/resources/data/";

    public String readFromFile(String fileName) {
        StringBuilder str = new StringBuilder(FILE_PATH);
        str.append(fileName).append(".txt");
        StringBuilder text = new StringBuilder();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(str.toString()))) {
            bufferedReader.lines().forEach(text::append);
        } catch (IOException e) {
            logger.error(e);
            e.printStackTrace();
        }
        return text.toString();
    }
}
