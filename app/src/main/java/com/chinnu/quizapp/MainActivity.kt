package com.chinnu.quizapp

import android.os.Bundle
import android.view.Surface
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material3.MaterialTheme
import androidx.navigation.compose.rememberNavController
import com.example.quizapp.ui.LoginScreen
import com.example.quizapp.ui.QuizScreen
import com.example.quizapp.viewmodel.QuizViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val viewModel: QuizViewModel = hiltViewModel()

            Surface(color = MaterialTheme.colors.background) {
                if (/* condition for login */) {
                    LoginScreen(viewModel, onLoginSuccess = {
                        navController.navigate("quiz")
                    })
                } else {
                    QuizScreen(viewModel)
                }
            }
        }
    }
}