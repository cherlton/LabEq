package com.example.myapplication
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.PointerIcon.Companion.Text
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme
class MainActivity : ComponentActivity() {
 override fun onCreate(savedInstanceState: Bundle?) {
 super.onCreate(savedInstanceState)
 setContent {
 MyApplicationTheme {
 Surface (modifier = Modifier.fillMaxSize(), color =
 MaterialTheme.colorScheme.background){
 LabEq("10-140")
 }
 }
 }
 }
}
@Composable
fun LabEq(labNumber: String) {
 var numberOfKeyboards by remember {
 mutableStateOf(TextFieldValue())
 }
 var numberOfComputers by remember {
 mutableStateOf(TextFieldValue())
 }
 var numberOfScreens by remember {
 mutableStateOf(TextFieldValue())
 }
 var totalCost by remember {
 mutableStateOf(0)
 }
 var showTotalCost by remember {
 mutableStateOf(false)
 }
 Column (modifier = Modifier
 .fillMaxSize()
 .padding(20.dp), verticalArrangement = Arrangement.Top){
 OutlinedTextField(value = numberOfComputers,
 onValueChange = {numberOfComputers = it},
 label = {
 Text(
 text = stringResource(id = R.string.computer_num)
 )
 }
 )
 OutlinedTextField(value = numberOfScreens,
 onValueChange = {numberOfScreens = it},
 label = {
 Text(
 text = stringResource(id = R.string.screen_num)
 )
 }
 )
 OutlinedTextField(value = numberOfKeyboards,
 onValueChange = {numberOfKeyboards = it},
 label = {
 Text(
 text = stringResource(id = R.string.key_num),
 )
 }
 )
 Button(
 onClick = {
 totalCost = (5000 * numberOfComputers.text.toInt()) +
 (2000 * numberOfScreens.text.toInt()) +
 (200 * numberOfKeyboards.text.toInt())
 showTotalCost = true
 })
 {
 Text(
 text = stringResource(id = R.string.calculate_cost)
 )
 }
 if(showTotalCost) {
 Text(
 text = "Total Lab Assets Value for $labNumber: R$totalCost",
 modifier = Modifier.padding(top = 16.dp)
 )
 }
 }
}
@Preview (showBackground = true)
@Composable
fun LabEqPreview(){
 LabEq("")
}
