package com.example.demo.service.impl;

import com.example.demo.service.QuizReader;
import org.springframework.stereotype.Component;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class QuizReaderImpl implements QuizReader {

    public final String FILE_PATH = "C:\\Users\\denis\\Desktop\\Hillel\\Enterprise\\SpringHW4\\src\\main\\resources\\questions.cvs";

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
