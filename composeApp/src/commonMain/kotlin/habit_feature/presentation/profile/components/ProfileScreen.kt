package habit_feature.presentation.profile.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import habit_feature.presentation.utils.CustomTextField
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import kotlinx.coroutines.launch

class ProfileScreen : Screen{
    @Composable
    override fun Content() {
        val scope = rememberCoroutineScope()
        var showBottomSheet by remember { mutableStateOf(false) }
        var nameText by remember { mutableStateOf("") }
        val emailText by remember { mutableStateOf("") }

        val navigator = LocalNavigator.currentOrThrow

        Box(modifier = Modifier.fillMaxSize().padding(20.dp)){
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Card(
                    modifier = Modifier.size(100.dp),
                    shape = CircleShape
                ){
                    KamelImage(
                        resource = asyncPainterResource("https://www.advanced-healthclinic.com/wp-content/uploads/2020/12/blank-profile-picture-973460_1280-680x680.png"),
                        contentDescription = "Profile Image",
                        contentScale = ContentScale.Fit
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                CustomTextField(
                    modifier = Modifier.fillMaxWidth(),
                    text = nameText,
                    onTextChange = {nameText = it},
                    label = "Name"
                )

                Spacer(modifier = Modifier.height(10.dp))

                CustomTextField(
                    modifier = Modifier.fillMaxWidth(),
                    text = emailText,
                    onTextChange = {nameText = it},
                    label = "Email",
                    isEnabled = false
                )

                Spacer(modifier = Modifier.height(80.dp))

                InfoContainer(
                    text = "Completed Habits",
                    icon = Icons.Default.Search,
                    onClick = {
                        navigator.push(CompletedHabitsScreen())
                    }
                )

                Spacer(modifier = Modifier.height(20.dp))

                InfoContainer(
                    text = "Statistics",
                    icon = Icons.Default.Star,
                    onClick = {
                        showBottomSheet = true
                    }
                )

                if(showBottomSheet){
                    StatsSheet(
                        modifier = Modifier.fillMaxWidth(),
                        onDismiss = {showBottomSheet = false}
                    )
                }
            }
        }
    }

}