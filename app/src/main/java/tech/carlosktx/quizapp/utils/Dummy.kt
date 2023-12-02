package tech.carlosktx.quizapp.utils

import tech.carlosktx.domain.Answer
import tech.carlosktx.domain.Question
import tech.carlosktx.domain.Quiz
import tech.carlosktx.domain.seconds

val questionDummy = Question(
    id = 1,
    title = "What's the name of the pokemon with lightning bolt",
    answers = listOf(
        Answer(1, "Pikachu", true),
        Answer(2, "Bulbasaur", false),
        Answer(3, "Charizard", false),
    ),
    timeToResponse = 60.seconds
)

val questionDummy2 = Question(
    id = 2,
    title = "Hola como estas",
    answers = listOf(
        Answer(4, "Bien", true),
        Answer(5, "Mal", false),
        Answer(6, "Maso", false),
    ),
    timeToResponse = 60.seconds
)

val quizDummy = Quiz(
    questions = listOf(questionDummy, questionDummy2)
)