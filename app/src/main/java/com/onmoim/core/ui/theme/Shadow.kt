package com.onmoim.core.ui.theme

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

fun Modifier.advancedShadow(
    color: Color = Color.Black,
    alpha: Float = 1f,
    cornersRadius: Dp = 0.dp,
    shadowBlurRadius: Dp = 0.dp,
    offsetY: Dp = 0.dp,
    offsetX: Dp = 0.dp
) = drawBehind {
    val shadowColor = color.copy(alpha = alpha).toArgb()
    val transparentColor = color.copy(alpha = 0f).toArgb()

    drawIntoCanvas {
        val paint = Paint()
        val frameworkPaint = paint.asFrameworkPaint()
        frameworkPaint.color = transparentColor
        frameworkPaint.setShadowLayer(
            shadowBlurRadius.toPx(),
            offsetX.toPx(),
            offsetY.toPx(),
            shadowColor
        )
        it.drawRoundRect(
            0f,
            0f,
            this.size.width,
            this.size.height,
            cornersRadius.toPx(),
            cornersRadius.toPx(),
            paint
        )
    }
}

fun Modifier.shadow1(
    cornersRadius: Dp = 0.dp
) = this.advancedShadow(
    color = Color(0xFF878787),
    alpha = 0.25f,
    cornersRadius = cornersRadius,
    shadowBlurRadius = 3.dp,
    offsetX = 0.dp,
    offsetY = 1.dp
)

fun Modifier.shadow2Block(
    cornersRadius: Dp = 0.dp
) = this.advancedShadow(
    color = Color(0xFF878787),
    alpha = 0.2f,
    cornersRadius = cornersRadius,
    shadowBlurRadius = 10.dp,
    offsetX = 0.dp,
    offsetY = 3.dp
)