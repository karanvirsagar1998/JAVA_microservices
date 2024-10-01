package com.example.quiz.quizservice.services;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.quiz.quizservice.entities.Question;

@FeignClient(url = "http://localhost:8081", value = "Question-Client")
public interface QuestionClient {

    @GetMapping("/question/quiz/{quiz_id}")
    List<Question> getQuestionByQuiz(@PathVariable Long quiz_id);
}