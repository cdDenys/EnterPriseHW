package com.example.demo;

import com.example.demo.service.QuizResults;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.FileNotFoundException;

public class HwApplication {

    public static void main(String[] args) throws FileNotFoundException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/beans.xml");
        QuizResults quizResults = context.getBean(QuizResults.class);
        quizResults.getResult();
    }

}
