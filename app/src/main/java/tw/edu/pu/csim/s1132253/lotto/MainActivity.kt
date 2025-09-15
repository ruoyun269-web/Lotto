package tw.edu.pu.csim.s1132253.lotto

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import tw.edu.pu.csim.s1132253.lotto.ui.theme.LottoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LottoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    play(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun play(modifier: Modifier = Modifier) {
    // 使用 remember 和 mutableStateOf 儲存樂透數字狀態
    val lucky = remember { mutableStateOf((1..100).random()) }

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "樂透數字(1-100)為 ${lucky.value}")
        Button(onClick = { lucky.value = (1..100).random() }) {
            Text("重新產生樂透碼")
        }
    }
}

