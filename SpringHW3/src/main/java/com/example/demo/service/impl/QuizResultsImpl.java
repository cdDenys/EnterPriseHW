package com.example.demo.service.impl;

import com.example.demo.entity.Applicant;
import com.example.demo.service.Quiz;
import com.example.demo.service.QuizResults;

import java.io.FileNotFoundException;

public class QuizResultsImpl implements QuizResults {

    private Quiz quiz;
    private Applicant applicant;

    public QuizResultsImpl(Quiz quiz, Applicant applicant) {
        this.quiz = quiz;
        this.applicant = applicant;
    }

    @Override
    public void getResult() throws FileNotFoundException {
        applicant.setFullname(quiz.nameReader());
        applicant.setPoints(quiz.getPoints(quiz.quiz()));
        System.out.println(applicant.toString());
    }

}
