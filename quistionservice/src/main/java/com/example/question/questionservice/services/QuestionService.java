package com.example.question.questionservice.services;

import com.example.question.questionservice.entities.Question;
import com.example.question.questionservice.exception.ResourceNotFoundException;
import com.example.question.questionservice.repositories.QuestionRepository;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/question")
@RestController
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    public Question getQuestionById(Long id) {
        return questionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No question found for id " + id));
    }

    public Question saveQuestion(Question question) {
        return questionRepository.save(question);
    }
}
