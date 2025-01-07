package com.chinnu.quizapp

data class QuizQuestion(
    val id: Long,
    val questionText: String,
    val options: List<String>,
    val correctAnswer: String
)
