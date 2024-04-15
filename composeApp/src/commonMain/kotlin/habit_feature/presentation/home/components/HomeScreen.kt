package habit_feature.presentation.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen

class HomeScreen(
    private val padding: PaddingValues
) : Screen {

    val habits = emptyList<String>()

    @Composable
    override fun Content() {
        Box(modifier = Modifier.fillMaxSize().padding(padding)){
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                item {
                    Text(
                        modifier = Modifier.padding(horizontal = 8.dp),
                        text = "Welcome Back, Nazariy Ravlyuk" ,
                        fontSize = 32.sp,
                        textAlign = TextAlign.Left,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                }

                if(habits.isNotEmpty()){
                    items(habits){

                    }
                }else{
                    item{
                        Text(
                            modifier = Modifier.padding(horizontal = 8.dp),
                            text = "No tasks yet",
                            fontSize = 18.sp,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Normal,
                            color = Color.Black
                        )
                    }
                }

                item {
                    Text(
                        modifier = Modifier.padding(horizontal = 6.dp),
                        text = "Get full experience of Dog App",
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp,
                        textAlign = TextAlign.Center,
                    )
                    Text(
                        modifier = Modifier.padding(top = 16.dp, start = 6.dp, end = 6.dp),
                        text = "Track your results better with our subscription",
                        color = Color.Black,
                        fontWeight = FontWeight.Normal,
                        fontSize = 16.sp,
                        textAlign = TextAlign.Center
                    )

                    Button(onClick = {}){
                        Text("Subscribe for only 10$")
                    }
                }
            }
        }
    }

}