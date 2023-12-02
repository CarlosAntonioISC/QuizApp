package tech.carlosktx.quizapp.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.SuggestionChipDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import tech.carlosktx.domain.Answer
import tech.carlosktx.domain.Question
import tech.carlosktx.quizapp.ui.composables.Timer
import tech.carlosktx.quizapp.utils.questionDummy

@Composable
fun QuestionScreen(
    question: Question,
    onQuestionAnswer: () -> Unit
) {
    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Timer(
            id = question.id,
            duration = question.timeToResponse,
            onTimerFinished = { onQuestionAnswer.invoke() },
            modifier = Modifier
                .weight(1f)
        )
        QuestionTitle(
            title = question.title,
            modifier = Modifier.weight(2f)
        )
        QuestionAnswers(
            answers = question.answers,
            onClickResponse = { onQuestionAnswer.invoke() },
            modifier = Modifier
                .fillMaxWidth()
                .weight(3f)
                .align(Alignment.CenterHorizontally)
        )
    }
}

@Composable
fun QuestionTitle(title: String, modifier: Modifier = Modifier) {
    Box(modifier = modifier, contentAlignment = Alignment.Center) {
        Text(
            text = title,
            textAlign = TextAlign.Center,
            fontSize = MaterialTheme.typography.headlineMedium.fontSize
        )
    }
}

@Composable
fun QuestionAnswers(
    answers: List<Answer>,
    onClickResponse: (Answer) -> Unit,
    modifier: Modifier = Modifier,
) {
    var answersEnabled by remember { mutableStateOf(true) }
    val coroutineScope = rememberCoroutineScope()
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(answers, key = { item -> item.id }) { answer ->
            ItemAnswer(
                answer = answer,
                isEnabled = answersEnabled,
                onClickResponse = {
                    coroutineScope.launch {
                        answersEnabled = false
                        delay(3000)
                        onClickResponse.invoke(answer)
                        answersEnabled = true
                    }
                })
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ItemAnswer(
    answer: Answer,
    isEnabled: Boolean,
    onClickResponse: (Answer) -> Unit,
) {
    var isAnswerCorrect by remember { mutableStateOf<Boolean?>(null) }
    val color = when (isAnswerCorrect) {
        null -> Color.White
        true -> Color.Green
        false -> Color.Red
    }
    SuggestionChip(
        onClick = {
            if (isEnabled) {
                isAnswerCorrect = answer.isCorrect
                onClickResponse(answer)
            }
        },
        label = {
            Text(
                text = answer.text,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold)
            )
        },
        colors = SuggestionChipDefaults.suggestionChipColors(containerColor = color),
        modifier = Modifier
            .fillMaxWidth()
    )
}