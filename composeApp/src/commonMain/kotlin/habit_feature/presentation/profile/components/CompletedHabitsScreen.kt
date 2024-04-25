package habit_feature.presentation.profile.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import habit_feature.presentation.home.components.HabitItem

class CompletedHabitsScreen : Screen {
    @Composable
    override fun Content() {

        val habits by remember {
            mutableStateOf(
                listOf<String>(
                    "asefg",
                    "afwerherth",
                    "earhrh",
                    "aeneer",
                    ",idy,ret",
                    "asefg",
                    "afwerherth",
                    "earhrh",
                    "aeneer",
                    ",idy,ret"
                )
            )
        }

        LazyColumn(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            item {
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    modifier = Modifier.padding(horizontal = 8.dp),
                    text = "Completed Habits",
                    fontSize = 32.sp,
                    textAlign = TextAlign.Left,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSecondary
                )

                Spacer(modifier = Modifier.height(20.dp))
            }

           items(habits){
               HabitItem(modifier = Modifier
                   .fillMaxWidth()
                   .padding(10.dp)
                   .height(50.dp)
               )
           }
        }
    }
}