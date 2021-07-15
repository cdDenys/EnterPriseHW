package com.example.demo.service;

import com.example.demo.entity.Applicant;

import java.io.FileNotFoundException;

public class QuizResultsImpl implements QuizResults {
    @Override
    public void getResult() throws FileNotFoundException {
        Applicant applicant = new Applicant();
        QuizImpl quiz = new QuizImpl();
        applicant.setFullname(quiz.nameReader());
        applicant.setPoints(quiz.getPoints(quiz.quiz()));
        System.out.println(applicant.toString());
    }

}
