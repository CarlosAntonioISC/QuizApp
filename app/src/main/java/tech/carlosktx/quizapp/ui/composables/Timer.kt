package tech.carlosktx.quizapp.ui.composables

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.delay
import tech.carlosktx.domain.Seconds
import tech.carlosktx.domain.seconds

@Composable
fun Timer(
    id: Int, duration:
    Seconds, onTimerFinished: () -> Unit,
    modifier: Modifier = Modifier
) {
    var currentDuration by remember { mutableStateOf(duration.value) }

    LaunchedEffect(id) {
        currentDuration = duration.value
        while (currentDuration > 0) {
            delay(1000)
            currentDuration--
        }
        onTimerFinished()
    }

    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = currentDuration.toString())
    }
}

@Preview(showBackground = true)
@Composable
fun TimerPreview() {
    Timer(id = 1, duration = 60.seconds, onTimerFinished = {})
}
