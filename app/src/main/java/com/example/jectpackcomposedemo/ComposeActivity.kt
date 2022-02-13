package com.example.jectpackcomposedemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Slider
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jectpackcomposedemo.components.CustomInputField
import com.example.jectpackcomposedemo.ui.theme.JectPackComposeDemoTheme
import com.example.jectpackcomposedemo.widgets.RoundIconButton
import javax.sql.RowSet


class ComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(
                modifier = Modifier.padding(12.dp)
            ) {
            MainContent()
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


@OptIn(ExperimentalComposeUiApi::class)
@Preview
@Composable
fun MainContent() {
    Surface(
        modifier = Modifier
            .padding(2.dp)
            .fillMaxWidth(), shape = CircleShape.copy(all = CornerSize(8.dp)),
        border = BorderStroke(width = 1.dp, color = Color.LightGray)
    )
    { Column(modifier = Modifier.padding(all=5.dp), horizontalAlignment = Alignment.Start, verticalArrangement = Arrangement.Top) {
           BillForm(){

           }
    }
    }


}

@ExperimentalComposeUiApi
@Composable
fun BillForm(modifier: Modifier=Modifier,onBillChange:(String)->Unit){
    val totalBill = remember {
        mutableStateOf("")
    }
    val valid= remember(totalBill.value) {
        totalBill.value.trim().isNotEmpty()
    }
val people= remember { mutableStateOf(1)}
    val keyboardController=LocalSoftwareKeyboardController.current

 val tipAmount= remember {
     mutableStateOf(0f)
 }

 val percentage= remember {
     mutableStateOf(0f)
 }
val sliderValue= remember {
    mutableStateOf(0f)
}
    CustomInputField(isSingleLine = true, valueState = totalBill, labelId = stringResource(R.string.enter_bill) , enabled =true,
        onAction = KeyboardActions{
            if(!valid){
                return@KeyboardActions
            }
            onBillChange(totalBill.value.trim())
            keyboardController?.hide()
        })
//    if(valid){
        Row(
            modifier = Modifier.padding(all=3.dp),
            horizontalArrangement = Arrangement.Start
        ){
            Text("Split", modifier = Modifier.align(
                Alignment.CenterVertically
            ) )
            Spacer(modifier = Modifier.width(120.dp))
            Row(modifier = Modifier.padding(all = 3.dp), horizontalArrangement = Arrangement.End){
                RoundIconButton(imageVector = Icons.Default.Remove, onClick = {
                    if(people.value>1){
                        people.value--
                    }
                })
                Text(text="${people.value}", modifier = Modifier
                    .align(CenterVertically)
                    .padding(start = 9.dp, end = 9.dp))
                RoundIconButton(imageVector = Icons.Default.Add, onClick = {
                    people.value++
                })

            }

        }

    Row(modifier = Modifier
        .padding(all = 3.dp)
        .fillMaxWidth()){
        Text(text = "Tip:", modifier = Modifier.align(alignment = CenterVertically))
       Row( modifier = Modifier
           .fillMaxWidth()
           .padding(end = 5.dp), horizontalArrangement = Arrangement.End){ Text(text = "$${tipAmount.value}")}
    }
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(all = 10.dp)) {
        Text(modifier = Modifier.align(CenterHorizontally), text = "%${percentage.value}")
        Spacer(modifier = Modifier.height(14.dp))
        Slider(value = sliderValue.value, onValueChange ={
            sliderValue.value=it
        }, steps = 5)
    }
//    }
//    else Box(){}
}



