package com.example.demo;

import com.example.demo.service.QuizImpl;
import com.example.demo.service.QuizReader;
import com.example.demo.service.QuizReaderImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.FileNotFoundException;
import java.util.List;

@SpringBootApplication
public class HwApplication {

    public static void main(String[] args) throws FileNotFoundException {
        SpringApplication.run(HwApplication.class, args);
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        QuizReader quizReader = context.getBean("quizReader", QuizReader.class);

        List<String> list = quizReader.readQuiz();
        System.out.println(list);
    }

}
