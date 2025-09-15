package tw.edu.pu.csim.s1132253.lotto

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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
    var lucky = (1..100).random()

    Column(
        modifier = modifier.fillMaxSize(), // 讓 Column 填滿整個畫面
        horizontalAlignment = Alignment.CenterHorizontally, // 水平置中
        verticalArrangement = androidx.compose.foundation.layout.Arrangement.Center // 垂直置中
    ) {
        Text(
            text = "樂透數字(1-100)為 $lucky",
        )
        Button(
            onClick = { lucky = (1..100).random() }
        ) {
            Text("重新產生樂透碼")
        }
    }
}
