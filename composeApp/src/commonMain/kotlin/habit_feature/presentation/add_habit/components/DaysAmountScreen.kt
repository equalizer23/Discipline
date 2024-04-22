package habit_feature.presentation.add_habit.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow

class DaysAmountScreen(private val habitName: String) : Screen{
    @Composable
    override fun Content() {
        var daysAmount by remember {
            mutableStateOf("0")
        }

        var isLoading by remember {
            mutableStateOf(false)
        }

        Column(
            modifier = Modifier.fillMaxSize().padding(vertical = 20.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(
                modifier = Modifier.padding(horizontal = 8.dp),
                text = "How often do you want to do that?",
                fontSize = 24.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSecondary
            )

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth().padding(horizontal = 20.dp),
                value = daysAmount.toString(),
                onValueChange = {days ->
                    daysAmount = days
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                ),
                label = { Text(text = "Amount of Days", color = MaterialTheme.colorScheme.onSecondary) },
                shape = RoundedCornerShape(16.dp),
                singleLine = true,
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = MaterialTheme.colorScheme.primary,
                    unfocusedBorderColor = MaterialTheme.colorScheme.primary
                )
            )

            Button(
                onClick = {
                    isLoading = !isLoading
                },
                modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp).height(50.dp)
            ){
                if(isLoading){
                    CircularProgressIndicator(color = MaterialTheme.colorScheme.secondary, modifier = Modifier.size(24.dp))
                }else{
                    Text("Create Habit", color = MaterialTheme.colorScheme.secondary)
                }
            }
        }
    }
}
