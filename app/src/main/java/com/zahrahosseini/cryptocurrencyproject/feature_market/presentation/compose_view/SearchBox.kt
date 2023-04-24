package com.zahrahosseini.cryptocurrencyproject.feature_market.presentation.compose_view

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zahrahosseini.cryptocurrencyproject.R
import com.zahrahosseini.cryptocurrencyproject.core.presentation.design_system.shapes.bgRounded12Neutral05
import com.zahrahosseini.cryptocurrencyproject.core.presentation.design_system.shapes.bgRounded5Neutral05StrokePrimary
import com.zahrahosseini.cryptocurrencyproject.core.presentation.design_system.theme.cryptoCurrencyColors
import com.zahrahosseini.cryptocurrencyproject.core.utils.compose.noRippleClickable



@Composable
fun SearchBox(
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null,
    onFocusChanged: ((focusState: FocusState) -> Unit)? = null,
    text: MutableState<String> = mutableStateOf("")
) {

    val interactionSource = remember { MutableInteractionSource() }
    val isFocused by interactionSource.collectIsFocusedAsState()

    val focusRequester = remember { FocusRequester() }

    val focusModifier = if (isFocused) {
        modifier
            .padding(horizontal = 8.dp)
            .bgRounded5Neutral05StrokePrimary()
    } else {
        modifier
            .padding(horizontal = 8.dp)
            .bgRounded12Neutral05()
    }
    Row(
        modifier = focusModifier
            .fillMaxWidth()
            .wrapContentHeight()
            .height(32.dp)
            .focusRequester(focusRequester)
            .onFocusChanged {

                onFocusChanged?.let { focusState ->
                    focusState(it)
                }
            }
            .noRippleClickable {
                onClick?.let { it() }
            },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_search),
            contentDescription = "ic_search",
            Modifier
                .padding(10.dp)
                .width(12.dp)
                .height(12.dp)
        )

        var value by rememberSaveable { mutableStateOf("") }

        BasicTextField(
            cursorBrush = SolidColor(Color.Black),
            value = value,
            onValueChange = {
                value = it
                text.value = it
            },
            interactionSource = interactionSource,
            textStyle = TextStyle(
                fontSize = 12.sp,
                color = MaterialTheme.cryptoCurrencyColors.designSystem.Neutral45
            ),
            decorationBox = { innerTextField ->
                Row(modifier = Modifier.fillMaxWidth()) {
                    if (value.isEmpty()) {
                        Text(
                            text = stringResource(id = R.string.search),
                            color = MaterialTheme.cryptoCurrencyColors.designSystem.Neutral20,
                            style = TextStyle(fontSize = 12.sp),
                        )
                    }
                }
                innerTextField()
            },
            singleLine = true,
        )
    }


}


@Composable
fun SearchBoxText(
    onClick: (() -> Unit)? = null
) {
    Row(
        modifier = Modifier
            .padding(horizontal = 8.dp)
            .fillMaxWidth()
            .height(32.dp)
            .bgRounded12Neutral05()
            .noRippleClickable {
                onClick?.let { it() }
            },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_search),
            contentDescription = "ic_search",
            Modifier
                .padding(10.dp)
                .width(12.dp)
                .height(12.dp)
        )

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(id = R.string.search),
            color = MaterialTheme.cryptoCurrencyColors.designSystem.Neutral20,
            style = TextStyle(fontSize = 12.sp),
        )
    }
}