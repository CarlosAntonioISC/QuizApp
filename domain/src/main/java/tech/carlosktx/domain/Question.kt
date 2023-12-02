package tech.carlosktx.domain

class Question(
    val id: Int,
    val title: String,
    val answers: List<Answer>,
    val timeToResponse: Seconds
) {

    init {
        require(answers.size == 3)
    }

}