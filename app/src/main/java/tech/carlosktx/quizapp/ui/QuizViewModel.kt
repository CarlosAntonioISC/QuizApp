package tech.carlosktx.quizapp.ui

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import tech.carlosktx.quizapp.utils.quizDummy

class QuizViewModel : ViewModel() {

    private val _questionToShow = MutableStateFlow(quizDummy.questions.first())
    val currentQuestion = _questionToShow

    fun getNextQuestion() {
        _questionToShow.update { quizDummy.getNextQuestion() }
    }

}