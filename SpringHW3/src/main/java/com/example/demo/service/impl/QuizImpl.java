package com.example.demo.service.impl;

import com.example.demo.service.Quiz;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class QuizImpl implements Quiz {
    public Scanner scan = new Scanner(System.in);

    @Override
    public byte getPoints(List<String> applicantAnswers) {
        byte points = 0;
        List<String> correctAnswers = List.of("yes", "inversion of control", "22", "4", "yes");
        for (int i = 0; i < applicantAnswers.size() && i < correctAnswers.size(); i++) {
            if (applicantAnswers.get(i).equals(correctAnswers.get(i))) {
                points++;
            }
        }

        return points;
    }


    @Override
    public List<String> quiz() throws FileNotFoundException {
        List<String> applicantAnswers = new ArrayList();
        QuizReaderImpl quizReader = new QuizReaderImpl();
        for (int i = 0; i < quizReader.readQuiz().size(); i++) {
            System.out.println(quizReader.readQuiz().get(i));
            applicantAnswers.add(scan.nextLine().toLowerCase());
        }
        return applicantAnswers;
    }

    @Override
    public String nameReader() {
        String applicantName;
        System.out.println("Enter your full name:");
        applicantName = scan.nextLine();
        return applicantName;
    }
}
