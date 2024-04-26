package habit_feature.presentation.profile.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import habit_feature.presentation.home.components.HabitItem

class CompletedHabitsScreen : Screen {
    @Composable
    override fun Content() {

        val navigator = LocalNavigator.currentOrThrow

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
            modifier = Modifier.fillMaxSize().padding(horizontal = 10.dp, vertical = 20.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            item {

                Box(modifier = Modifier.fillMaxWidth()) {
                    IconButton(
                        modifier = Modifier.align(Alignment.TopStart),
                        onClick = {
                            navigator.pop()
                        }
                    ){
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }


                Spacer(modifier = Modifier.height(20.dp))
            }

           items(habits){
               HabitItem(modifier = Modifier
                   .fillMaxWidth()
                   .padding(10.dp)
                   .height(50.dp),
                   isFullyCompleted = true
               )
           }
        }
    }
}