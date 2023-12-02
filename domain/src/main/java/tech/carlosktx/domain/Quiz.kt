package tech.carlosktx.domain

class Quiz(
    val questions: List<Question>
) {

    private var index = 0

    fun getNextQuestion(): Question {
        return questions[1]
    }

}