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
val icon_home: ImageVector
  get() {
    if (_home_app_logo != null) {
      return _home_app_logo!!
    }
    _home_app_logo =
      ImageVector.Builder(
          name = "home_app_logo",
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
            moveTo(6f, 21f)
            quadTo(4.75f, 21f, 3.88f, 20.13f)
            reflectiveQuadTo(3f, 18f)
            verticalLineTo(12f)
            quadTo(3f, 11.4f, 3.23f, 10.85f)
            reflectiveQuadTo(3.88f, 9.88f)
            lineToRelative(6f, -6f)
            quadTo(10.3f, 3.42f, 10.86f, 3.21f)
            reflectiveQuadTo(12f, 3f)
            reflectiveQuadToRelative(1.13f, 0.21f)
            reflectiveQuadToRelative(1f, 0.66f)
            lineToRelative(0.75f, 0.75f)
            lineTo(7f, 12.5f)
            verticalLineTo(17f)
            horizontalLineTo(17f)
            verticalLineTo(12.5f)
            lineTo(13.4f, 8.9f)
            lineTo(16.28f, 6.05f)
            lineToRelative(3.85f, 3.82f)
            quadToRelative(0.43f, 0.42f, 0.65f, 0.97f)
            reflectiveQuadTo(21f, 12f)
            verticalLineToRelative(6f)
            quadToRelative(0f, 1.25f, -0.88f, 2.13f)
            reflectiveQuadTo(18f, 21f)
            horizontalLineTo(6f)
            close()
          }
        }
        .build()
    return _home_app_logo!!
  }

private var _home_app_logo: ImageVector? = null
