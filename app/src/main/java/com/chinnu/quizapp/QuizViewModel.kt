package com.chinnu.quizapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class QuizViewModel(private val repository: QuizRepository) : ViewModel() {

    private val _loginStatus = MutableStateFlow("")
    val loginStatus: StateFlow<String> get() = _loginStatus

    private val _questions = MutableStateFlow<List<QuizQuestion>>(emptyList())
    val questions: StateFlow<List<QuizQuestion>> get() = _questions

    fun login(username: String, password: String) {
        viewModelScope.launch {
            repository.login(username, password).collect { response ->
                _loginStatus.value = response
            }
        }
    }

    fun fetchQuestions() {
        viewModelScope.launch {
            repository.fetchQuestions().collect { questionList ->
                _questions.value = questionList
            }
        }
    }
}