package com.example.demo.service.impl;

import com.example.demo.service.QuizReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuizReaderImpl implements QuizReader {

    public static final String FILE_PATH = "C:\\Users\\denis\\Desktop\\SpringHW3\\src\\main\\resources\\questions.cvs";

    @Override
    public List<String> readQuiz() throws FileNotFoundException {
        Scanner scan = new Scanner(new File(FILE_PATH));
        List<String> lines = new ArrayList<>();
        while (scan.hasNextLine()) {
            lines.add(scan.nextLine());
        }
        lines.removeIf(arr -> !arr.contains("QUESTION"));

        return lines;
    }

}
