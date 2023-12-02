package tech.carlosktx.quizapp.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import tech.carlosktx.domain.Quiz
import tech.carlosktx.quizapp.utils.quizDummy

@Composable
fun QuizScreen(quiz: Quiz, viewModel: QuizViewModel = QuizViewModel()) {

    val currentQuestion = viewModel.currentQuestion.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        QuestionScreen(
            question = currentQuestion.value,
            onQuestionAnswer = { viewModel.getNextQuestion() }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun QuizScreenPreview() {
    QuizScreen(quiz = quizDummy)
}

