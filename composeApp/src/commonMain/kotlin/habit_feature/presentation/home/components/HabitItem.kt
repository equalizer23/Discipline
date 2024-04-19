package habit_feature.presentation.home.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import discipline.composeapp.generated.resources.Res
import discipline.composeapp.generated.resources.compose_multiplatform
import discipline.composeapp.generated.resources.flame_icon
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.vectorResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun HabitItem(
    modifier : Modifier = Modifier
) {
    Row(
        modifier = modifier
    ){
        Card(
            modifier = Modifier.weight(0.8F),
            shape = RoundedCornerShape(8.dp),
            border = BorderStroke(width = 1.dp, color = MaterialTheme.colorScheme.primary),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ){
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ){

                Text(text = "Do push ups", color = MaterialTheme.colorScheme.secondary, fontSize = 16.sp)

                Row(verticalAlignment = Alignment.CenterVertically){
                    Image(
                        painter = painterResource(Res.drawable.flame_icon),
                        contentDescription = "Flame",
                        modifier = Modifier.size(32.dp)
                    )
                    Text(text = "5", color = MaterialTheme.colorScheme.secondary, fontSize = 20.sp)
                }
            }
        }

        Card(
            modifier = Modifier.weight(0.2F).size(50.dp).padding(start = 8.dp),
            onClick = {},
            shape = RoundedCornerShape(8.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primary)
        ){
            Box(modifier = Modifier.fillMaxSize()){
                Icon(
                    modifier = Modifier.size(18.dp).align(Alignment.Center),
                    imageVector =  Icons.Default.Check,
                    contentDescription = "Complete Task",
                    tint = MaterialTheme.colorScheme.secondary
                )
            }
        }
    }
}