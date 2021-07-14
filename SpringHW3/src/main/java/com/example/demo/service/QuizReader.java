package com.example.demo.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuizReader {
    public List<String> readQuiz() throws FileNotFoundException {
        Scanner scan = new Scanner(new File("C:\\Users\\denis\\Desktop\\Hillel\\Enterprise\\SpringHW3\\src\\main\\java\\com\\example\\demo\\resources\\questions.cvs"));
        List<String> lines = new ArrayList<>();
        while (scan.hasNextLine()) {
            lines.add(scan.nextLine());
        }
        lines.removeIf(arr -> !arr.contains("QUESTION"));

        return lines;
    }
}
