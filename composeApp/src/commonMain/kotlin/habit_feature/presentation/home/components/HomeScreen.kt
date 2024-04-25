package habit_feature.presentation.home.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import cafe.adriel.voyager.core.screen.Screen

class HomeScreen(): Screen {

    @Composable
    override fun Content(){
        HomeBody()
    }

}