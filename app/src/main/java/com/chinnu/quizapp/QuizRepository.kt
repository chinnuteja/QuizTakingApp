package com.chinnu.quizapp

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class QuizRepository(private val api: QuizApi) {

    fun login(username: String, password: String): Flow<String> = flow {
        emit(api.login(LoginRequest(username, password)))
    }

    fun fetchQuestions(): Flow<List<QuizQuestion>> = flow {
        emit(api.getQuestions())
    }
}
