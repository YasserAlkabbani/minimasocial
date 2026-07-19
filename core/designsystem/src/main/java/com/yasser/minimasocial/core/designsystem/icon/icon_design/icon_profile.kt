package com.yasser.minimasocial.core.designsystem.icon.icon_design

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

@Suppress("CheckReturnValue")
val icon_profile: ImageVector
  get() {
    if (_deployed_code_account != null) {
      return _deployed_code_account!!
    }
    _deployed_code_account =
      ImageVector.Builder(
          name = "deployed_code_account",
          defaultWidth = 24.dp,
          defaultHeight = 24.dp,
          viewportWidth = 24f,
          viewportHeight = 24f,
        )
        .apply {
          path(
            fill = SolidColor(Color.Black),
            fillAlpha = 1f,
            stroke = null,
            strokeAlpha = 1f,
            strokeLineWidth = 1f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Bevel,
            strokeLineMiter = 1f,
            pathFillType = PathFillType.NonZero,
          ) {
            moveTo(16.6f, 20.98f)
            quadTo(16.4f, 20.93f, 16.23f, 20.8f)
            lineToRelative(-3f, -1.75f)
            quadToRelative(-0.35f, -0.2f, -0.54f, -0.54f)
            quadTo(12.5f, 18.18f, 12.5f, 17.77f)
            verticalLineTo(14.25f)
            quadToRelative(0f, -0.4f, 0.19f, -0.74f)
            reflectiveQuadToRelative(0.54f, -0.54f)
            lineToRelative(3f, -1.75f)
            quadTo(16.4f, 11.1f, 16.6f, 11.05f)
            reflectiveQuadTo(17f, 11f)
            reflectiveQuadToRelative(0.39f, 0.06f)
            reflectiveQuadToRelative(0.36f, 0.16f)
            lineToRelative(3f, 1.75f)
            quadToRelative(0.35f, 0.2f, 0.55f, 0.54f)
            reflectiveQuadToRelative(0.2f, 0.74f)
            verticalLineToRelative(3.52f)
            quadToRelative(0f, 0.4f, -0.2f, 0.74f)
            reflectiveQuadToRelative(-0.55f, 0.54f)
            lineToRelative(-3f, 1.75f)
            quadToRelative(-0.18f, 0.1f, -0.36f, 0.16f)
            reflectiveQuadTo(17f, 21.03f)
            reflectiveQuadTo(16.6f, 20.98f)
            close()
            moveTo(2f, 20f)
            verticalLineTo(17.2f)
            quadTo(2f, 16.38f, 2.43f, 15.65f)
            reflectiveQuadTo(3.6f, 14.55f)
            quadTo(4.88f, 13.9f, 6.48f, 13.45f)
            reflectiveQuadTo(10f, 13f)
            quadToRelative(0.2f, 0f, 0.35f, 0f)
            reflectiveQuadToRelative(0.3f, 0.05f)
            quadToRelative(-0.72f, 1.8f, -0.6f, 3.58f)
            reflectiveQuadTo(11.25f, 20f)
            horizontalLineTo(2f)
            close()
            moveTo(7.18f, 10.83f)
            quadTo(6f, 9.65f, 6f, 8f)
            reflectiveQuadTo(7.18f, 5.18f)
            reflectiveQuadTo(10f, 4f)
            reflectiveQuadToRelative(2.83f, 1.18f)
            reflectiveQuadTo(14f, 8f)
            reflectiveQuadToRelative(-1.17f, 2.82f)
            reflectiveQuadTo(10f, 12f)
            reflectiveQuadTo(7.18f, 10.83f)
            close()
            moveToRelative(7.48f, 3.03f)
            lineTo(17f, 15.23f)
            lineToRelative(2.35f, -1.38f)
            lineTo(17f, 12.5f)
            lineToRelative(-2.35f, 1.35f)
            close()
            moveToRelative(3.1f, 5.2f)
            lineTo(20f, 17.75f)
            verticalLineTo(15f)
            lineToRelative(-2.25f, 1.32f)
            verticalLineToRelative(2.73f)
            close()
            moveTo(14f, 17.75f)
            lineToRelative(2.25f, 1.32f)
            verticalLineTo(16.35f)
            lineTo(14f, 15.03f)
            verticalLineToRelative(2.72f)
            close()
          }
        }
        .build()
    return _deployed_code_account!!
  }

private var _deployed_code_account: ImageVector? = null
