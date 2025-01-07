package com.chinnu.quizapp

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun QuizScreen(viewModel: QuizViewModel) {
    val questions = viewModel.questions.collectAsState().value

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(questions) { question ->
            Text(text = question.questionText)
            Spacer(modifier = Modifier.height(8.dp))
            question.options.forEach { option ->
                Text(text = "- $option")
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}