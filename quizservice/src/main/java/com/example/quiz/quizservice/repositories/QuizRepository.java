package com.example.quiz.quizservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.quiz.quizservice.entities.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Long> {

}
