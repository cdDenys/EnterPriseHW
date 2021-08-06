package com.example.demo.service;

import java.io.FileNotFoundException;
import java.util.List;

public interface Quiz {
    byte getPoints(List<String> applicantAnswers);
    List<String> quiz() throws FileNotFoundException;
    String nameReader();
}
