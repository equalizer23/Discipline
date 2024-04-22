package habit_feature.presentation.home.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen

class HomeScreen(): Screen {

    val habits = listOf<String>(
        "asefg",
        "afwerherth",
        "asefg",
        "afwerherth",
        "asefg",

    )

    @Composable
    override fun Content(){
        HomeBody(habits)
    }

}