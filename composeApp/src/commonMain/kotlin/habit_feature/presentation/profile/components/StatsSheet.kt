package habit_feature.presentation.profile.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import at.maximilianproell.multiplatformchart.barchart.BarChart
import at.maximilianproell.multiplatformchart.barchart.config.BarConfigDefaults.defaultBarConfig
import at.maximilianproell.multiplatformchart.barchart.model.BarChartEntry
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StatsSheet(
    modifier : Modifier = Modifier,
    onDismiss: () -> Unit
) {
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)

    ModalBottomSheet(
        modifier = modifier,
        onDismissRequest = onDismiss,
        sheetState = sheetState
    ) {

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "All time Stats",
            color = MaterialTheme.colorScheme.onSecondary,
            fontSize = 24.sp,
            textAlign = TextAlign.Center
        )

        Box(
            modifier = Modifier
                .padding(top = 15.dp, start = 15.dp, end = 15.dp, bottom = 15.dp)
                .fillMaxWidth()
                .height(300.dp)
                .border(1.dp, color = MaterialTheme.colorScheme.primary)
        ){
            BarChart(
                modifier = Modifier.fillMaxSize().padding(20.dp),
                entries = listOf(
                    BarChartEntry("One", 0.5f),
                    BarChartEntry("Two", 1.25f),
                    BarChartEntry("Three", 3f),
                    BarChartEntry("Four", 1f),
                    BarChartEntry("One", 0.5f),
                    BarChartEntry("Two", 1.25f),
                    BarChartEntry("Three", 3f),
                    BarChartEntry("Four", 1f),
                ),
                maxYValue = 3f,
                barConfig = defaultBarConfig.copy(animate = true, barColor = MaterialTheme.colorScheme.onSecondary),
            )
        }
    }
}