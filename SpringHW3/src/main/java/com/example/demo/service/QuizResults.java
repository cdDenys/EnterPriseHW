package com.example.demo.service;

import com.example.demo.entity.Applicant;

import java.io.FileNotFoundException;

public class QuizResults {
    public void getResult() throws FileNotFoundException {
        Applicant applicant = new Applicant();
        Quiz quiz = new Quiz();
        applicant.setFullname(quiz.nameReader());
        applicant.setPoints(quiz.getPoints(quiz.quiz()));
        System.out.println(applicant.toString());
    }
}
