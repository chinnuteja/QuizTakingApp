package com.chinnu.quizapp

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface QuizApi {
    @POST("/api/login")
    suspend fun login(@Body loginRequest: LoginRequest): String

    @GET("/api/questions")
    suspend fun getQuestions(): List<QuizQuestion>
}