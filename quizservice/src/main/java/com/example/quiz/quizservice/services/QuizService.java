package com.example.quiz.quizservice.services;

import com.example.quiz.quizservice.entities.Quiz;
import com.example.quiz.quizservice.exception.ResourceNotFoundException;
import com.example.quiz.quizservice.repositories.QuizRepository;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/quiz")
@RestController
public class QuizService {

    @Autowired
    private QuizRepository quizRepository;

    public List<Quiz> getAllQuizs() {
        return quizRepository.findAll();
    }

    public Quiz getQuizById(Long id) {
        return quizRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No quiz found for id " + id));
    }

    public Quiz saveQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }
}
