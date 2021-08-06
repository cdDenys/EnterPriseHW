package com.example.demo.service.impl;

import com.example.demo.entity.Applicant;
import com.example.demo.service.Quiz;
import com.example.demo.service.QuizResults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import java.io.FileNotFoundException;

@Service
public class QuizResultsImpl implements QuizResults {

    private Quiz quiz;

    @Autowired
    public QuizResultsImpl(Quiz quiz) {
        this.quiz = quiz;
    }

    @Override
    public void getResult() throws FileNotFoundException {
        Applicant applicant = new Applicant();
        applicant.setFullname(quiz.nameReader());
        applicant.setPoints(quiz.getPoints(quiz.quiz()));
        System.out.println(applicant.toString());
    }

    @PostConstruct
    public void start() throws FileNotFoundException {
        getResult();
    }

}
