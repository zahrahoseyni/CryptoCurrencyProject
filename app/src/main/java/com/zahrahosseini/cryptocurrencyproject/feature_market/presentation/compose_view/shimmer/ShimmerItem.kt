package com.zahrahosseini.cryptocurrencyproject.feature_market.presentation.compose_view.shimmer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout


@Composable
fun ShimmerItem(
    brush: Brush
) {

    ConstraintLayout(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .wrapContentHeight()
    ) {

        val (imgLogo, txtSymbol, txtName, txChangePercent, txtPrice, txtVolume) = createRefs()

        Spacer(modifier = Modifier
            .constrainAs(imgLogo) {
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                end.linkTo(parent.end)
            }
            .background(brush = brush, shape = RoundedCornerShape(30.dp)))

        Spacer(
            modifier = Modifier
                .constrainAs(txtName) {
                    top.linkTo(txtSymbol.bottom , 5.dp)
                    end.linkTo(imgLogo.start, 8.dp)
                }
                .background(brush = brush)
                .width(70.dp)
                .height(10.dp)

        )

        Spacer(
            modifier = Modifier
                .constrainAs(txtSymbol) {
                    top.linkTo(parent.top)
                    end.linkTo(imgLogo.start, 8.dp)
                }
                .background(brush = brush)
                .width(70.dp)
                .height(10.dp)


        )

        Spacer(
            modifier = Modifier
                .constrainAs(txtVolume) {
                    top.linkTo(parent.top)
                    start.linkTo(txChangePercent.end, 8.dp)
                }
                .background(brush = brush)
                .width(80.dp)
                .height(10.dp)


        )


        Spacer(
            modifier = Modifier
                .constrainAs(txtPrice) {
                    top.linkTo(txtVolume.bottom, 5.dp)
                    start.linkTo(txChangePercent.end, 8.dp)
                }
                .background(brush = brush)
                .width(80.dp)
                .height(10.dp)


        )

        Spacer(modifier = Modifier
            .constrainAs(txChangePercent) {
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
            }
            .background(brush = brush)
            .width(50.dp)
            .height(20.dp)

        )


    }
}