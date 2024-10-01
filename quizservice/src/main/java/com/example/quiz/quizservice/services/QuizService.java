package com.example.quiz.quizservice.services;

import com.example.quiz.quizservice.entities.Quiz;
import com.example.quiz.quizservice.exception.ResourceNotFoundException;
import com.example.quiz.quizservice.repositories.QuizRepository;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/quiz")
@RestController
public class QuizService {

    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private QuestionClient questionClient;

    public List<Quiz> getAllQuizs() {
        List<Quiz> quizes = quizRepository.findAll();
        List<Quiz> newQuizList = quizes.stream().map(quiz -> {
            quiz.setQuestions(questionClient.getQuestionByQuiz(quiz.getId()));
            return quiz;
        }).collect(Collectors.toList());

        return newQuizList;
    }

    public Quiz getQuizById(Long id) {
        Quiz quiz = quizRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No quiz found for id " + id));
        quiz.setQuestions(questionClient.getQuestionByQuiz(quiz.getId()));
        return quiz;
    }

    public Quiz saveQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }
}
