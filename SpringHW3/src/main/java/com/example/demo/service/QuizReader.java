package com.example.demo.service;

import java.io.FileNotFoundException;
import java.util.List;

public interface QuizReader {
    List<String> readQuiz() throws FileNotFoundException;
}
