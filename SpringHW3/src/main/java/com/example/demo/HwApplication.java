package com.example.demo;

import com.example.demo.service.Quiz;
import com.example.demo.service.QuizReader;
import com.example.demo.service.QuizResults;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileNotFoundException;

@SpringBootApplication
public class HwApplication {

    public static void main(String[] args) throws FileNotFoundException {
        SpringApplication.run(HwApplication.class, args);
        QuizResults quizResults = new QuizResults();
        quizResults.getResult();

    }

}
