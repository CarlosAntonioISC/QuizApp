package tech.carlosktx.quizapp.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import tech.carlosktx.quizapp.utils.questionDummy


@Preview(showBackground = true)
@Composable
private fun QuestionScreenPreview() {
    QuestionScreen(questionDummy, onQuestionAnswer = {})
}

@Preview(showBackground = true)
@Composable
private fun QuestionTitlePreview() {
    QuestionTitle(title = questionDummy.title)
}


@Preview(showBackground = true)
@Composable
private fun QuestionAnswersPreview() {
    QuestionAnswers(
        answers = questionDummy.answers,
        onClickResponse = {}
    )
}

