package habit_feature.presentation.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeBody(
    habits: List<String>
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ){
        item {
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                modifier = Modifier.padding(horizontal = 8.dp),
                text = "Welcome Back, Nazariy Ravlyuk",
                fontSize = 32.sp,
                textAlign = TextAlign.Left,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSecondary)
            Spacer(modifier = Modifier.height(20.dp))
        }

        if(habits.isNotEmpty()){
            item{
                habits.forEach {
                    HabitItem(modifier = Modifier.fillMaxWidth().padding(10.dp).height(50.dp))
                }
            }
        }else{
            item{
                Text(
                    modifier = Modifier.padding(horizontal = 8.dp),
                    text = "No tasks yet",
                    fontSize = 18.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Normal,
                    color = MaterialTheme.colorScheme.onSecondary
                )
            }
        }

        item{
            Spacer(modifier = Modifier.height(20.dp))

            SubsItem()

            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}

@Composable
fun SubsItem(){
    Text(
        modifier = Modifier.padding(horizontal = 6.dp),
        text = "Get full experience of Dog App",
        color = MaterialTheme.colorScheme.onSecondary,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        textAlign = TextAlign.Center,
    )
    Text(
        modifier = Modifier.padding(top = 16.dp, start = 6.dp, end = 6.dp),
        text = "Track your results better with our subscription",
        color = MaterialTheme.colorScheme.onSecondary,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        textAlign = TextAlign.Center
    )

    Button(
        modifier = Modifier.fillMaxWidth().padding(top = 16.dp, start = 16.dp, end = 16.dp),
        onClick = {},
        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
    ){
        Text("Subscribe for only 10$", color = MaterialTheme.colorScheme.secondary)
    }
}