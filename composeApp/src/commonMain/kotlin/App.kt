
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.SlideTransition
import di.appModule
import di.viewModule
import habit_feature.presentation.home.components.HomeScreen
import org.jetbrains.compose.ui.tooling.preview.Preview

import org.koin.core.context.startKoin


@Composable
@Preview
fun App() {
    initKoin()
    setView()

}
private fun initKoin(){
    startKoin {
        modules(appModule, viewModule)
    }
}



@Composable
private fun setView(){
    MaterialTheme {
        Navigator(HomeScreen(PaddingValues(vertical = 20.dp))){ navigator ->
            SlideTransition(navigator)
        }
    }
}