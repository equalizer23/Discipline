package habit_feature.presentation.utils

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun CustomTextField(
    modifier : Modifier = Modifier,
    text: String,
    onTextChange: (String) -> Unit,
    keyBoardType: KeyboardType = KeyboardType.Text,
    label: String,
    isEnabled: Boolean = true

) {
    OutlinedTextField(
        modifier = modifier,
        value = text,
        onValueChange = {newText ->
            onTextChange(newText)
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = keyBoardType
        ),
        label = { Text(text = label, color = MaterialTheme.colorScheme.onSecondary) },
        shape = RoundedCornerShape(16.dp),
        singleLine = true,
        enabled = isEnabled,
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = MaterialTheme.colorScheme.primary,
            unfocusedBorderColor = MaterialTheme.colorScheme.primary
        )
    )
}