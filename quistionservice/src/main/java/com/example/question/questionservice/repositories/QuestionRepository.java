package com.example.question.questionservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.question.questionservice.entities.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {

}
