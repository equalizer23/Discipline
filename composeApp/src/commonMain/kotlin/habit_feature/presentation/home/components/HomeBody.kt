package habit_feature.presentation.home.components

import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import habit_feature.presentation.habit.HabitScreen

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeBody(){

    val navigator = LocalNavigator.currentOrThrow

    var habits by remember {
        mutableStateOf(
            listOf<String>(
                "asefg",
                "afwerherth",
                "earhrh",
                "aeneer",
                ",idy,ret"
                )
        )
    }

    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Box(modifier = Modifier.fillMaxWidth().weight(0.1f)){
            Text(
                modifier = Modifier.padding(horizontal = 8.dp).align(Alignment.Center),
                text = "Welcome Back, Nazariy Ravlyuk",
                fontSize = 32.sp,
                textAlign = TextAlign.Left,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSecondary
            )
        }

        Box(modifier = Modifier.fillMaxWidth().weight(0.5f)){
            LazyColumn(userScrollEnabled = true, modifier = Modifier.align(Alignment.Center)){
                items(items = habits, key = { it }) { habit ->
                    HabitItem(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp)
                            .height(50.dp)
                            .animateItemPlacement(animationSpec = tween(durationMillis = 600)),
                        onComplete = {
                            habits = habits.toMutableList().apply {
                                remove(habit)
                                add(habit)
                            }
                        },
                        onReset = {
                            habits = habits.toMutableList().apply {
                                remove(habit)
                                add(0, habit)
                            }
                        },
                        onCardClick = {
                            navigator.push(HabitScreen())
                        }
                    )
                }
            }
        }

        Box(modifier = Modifier.fillMaxWidth().weight(0.25f)){
            SubsItem()
        }
    }

//    Box(
//        modifier = Modifier.fillMaxSize(),
//        contentAlignment = Alignment.Center
//    ) {
//        LazyColumn(
//            modifier = Modifier.fillMaxSize(),
//            horizontalAlignment = Alignment.CenterHorizontally,
//        ){
//            item {
//                Spacer(modifier = Modifier.height(20.dp))
//                Text(
//                    modifier = Modifier.padding(horizontal = 8.dp),
//                    text = "Welcome Back, Nazariy Ravlyuk",
//                    fontSize = 32.sp,
//                    textAlign = TextAlign.Left,
//                    fontWeight = FontWeight.Bold,
//                    color = MaterialTheme.colorScheme.onSecondary
//                )
//                Spacer(modifier = Modifier.height(20.dp))
//            }
//
//            if (habits.isNotEmpty()) {
//                items(items = habits, key = { it }) { habit ->
//                    HabitItem(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .padding(10.dp)
//                            .height(50.dp)
//                            .animateItemPlacement(animationSpec = tween(durationMillis = 600)),
//                        onComplete = {
//                            habits = habits.toMutableList().apply {
//                                remove(habit)
//                                add(habit)
//                            }
//                        },
//                        onReset = {
//                            habits = habits.toMutableList().apply {
//                                remove(habit)
//                                add(0, habit)
//                            }
//                        }
//                    )
//                }
//            } else {
//                item{
//                    Text(
//                        modifier = Modifier.padding(horizontal = 8.dp),
//                        text = "No tasks yet",
//                        fontSize = 18.sp,
//                        textAlign = TextAlign.Center,
//                        fontWeight = FontWeight.Normal,
//                        color = MaterialTheme.colorScheme.onSecondary
//                    )
//                }
//            }
//
//            item {
//                Spacer(modifier = Modifier.height(20.dp))
//                SubsItem()
//                Spacer(modifier = Modifier.height(20.dp))
//            }
//        }
//    }
}

@Composable
fun SubsItem(){
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
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

        Spacer(modifier = Modifier.height(40.dp))
    }
}