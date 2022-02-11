package com.example.jectpackcomposedemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jectpackcomposedemo.ui.theme.JectPackComposeDemoTheme

class ComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(
                modifier = Modifier.padding(12.dp)
            ) {

            }

        }
    }
}


@Composable
fun Content(container: @Composable () -> Unit) {
    JectPackComposeDemoTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(all = 10.dp),
            color = MaterialTheme.colors.background
        ) {
            container()
        }
    }
}


//@Preview(showBackground = true)
@Composable
fun TopHeader(totalPerPerson: Float = 0f) {
    Surface(
        Modifier
            .fillMaxWidth()
            .height(150.dp)
            .clip(shape = CircleShape.copy(all = CornerSize(12.dp))), color = Color(0xFFD7CADA)
    ) {
        Column(
            modifier = Modifier.padding(all = 12.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val total = "%.2f".format(totalPerPerson)
            Text(
                text = "Total Per Person",
                textAlign = TextAlign.Center, fontStyle = FontStyle.Normal,
                fontSize = 17.sp,
                fontWeight = FontWeight.Medium
            )
            Text(
                text = "$$total",
                textAlign = TextAlign.Center, fontStyle = FontStyle.Normal,
                fontSize = 20.sp,
                fontWeight = FontWeight.ExtraBold
            )
        }
    }
}

@Preview
@Composable
fun MainContent() {
    Surface(
        modifier = Modifier
            .padding(2.dp)
            .fillMaxWidth(), shape = CircleShape.copy(all = CornerSize(8.dp)),
        border = BorderStroke(width = 1.dp, color = Color.LightGray)
    )
    { Column() {}
    }
}



