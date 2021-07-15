package com.example.demo.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuizReaderImpl implements QuizReader{

    private String filePath;


    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<String> readQuiz() throws FileNotFoundException {
        Scanner scan = new Scanner(new File(filePath));
        List<String> lines = new ArrayList<>();
        while (scan.hasNextLine()) {
            lines.add(scan.nextLine());
        }
        lines.removeIf(arr -> !arr.contains("QUESTION"));

        return lines;
    }

}
