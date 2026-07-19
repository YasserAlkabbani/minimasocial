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
val icon_search_selected: ImageVector
  get() {
    if (_category_search != null) {
      return _category_search!!
    }
    _category_search =
      ImageVector.Builder(
          name = "category_search",
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
            moveTo(2f, 20.5f)
            verticalLineToRelative(-8f)
            horizontalLineToRelative(8f)
            verticalLineToRelative(8f)
            horizontalLineTo(2f)
            close()
            moveToRelative(2f, -2f)
            horizontalLineTo(8f)
            verticalLineToRelative(-4f)
            horizontalLineTo(4f)
            verticalLineToRelative(4f)
            close()
            moveTo(5.5f, 10f)
            lineTo(11f, 1f)
            lineToRelative(5.5f, 9f)
            horizontalLineTo(5.5f)
            close()
            moveTo(9.05f, 8f)
            horizontalLineToRelative(3.9f)
            lineTo(11f, 4.85f)
            lineTo(9.05f, 8f)
            close()
            moveTo(21.58f, 22.95f)
            lineTo(18.93f, 20.3f)
            quadToRelative(-0.52f, 0.35f, -1.14f, 0.52f)
            reflectiveQuadTo(16.5f, 21f)
            quadToRelative(-1.88f, 0f, -3.19f, -1.31f)
            reflectiveQuadTo(12f, 16.5f)
            reflectiveQuadToRelative(1.31f, -3.19f)
            reflectiveQuadTo(16.5f, 12f)
            reflectiveQuadToRelative(3.19f, 1.31f)
            reflectiveQuadTo(21f, 16.5f)
            quadToRelative(0f, 0.65f, -0.17f, 1.26f)
            reflectiveQuadToRelative(-0.5f, 1.14f)
            lineToRelative(2.65f, 2.65f)
            lineToRelative(-1.4f, 1.4f)
            close()
            moveToRelative(-3.3f, -4.68f)
            quadTo(19f, 17.55f, 19f, 16.5f)
            reflectiveQuadTo(18.28f, 14.73f)
            reflectiveQuadTo(16.5f, 14f)
            reflectiveQuadToRelative(-1.77f, 0.72f)
            reflectiveQuadTo(14f, 16.5f)
            reflectiveQuadToRelative(0.73f, 1.77f)
            reflectiveQuadTo(16.5f, 19f)
            reflectiveQuadToRelative(1.78f, -0.73f)
            close()
            moveTo(8f, 14.5f)
            close()
            moveTo(11f, 8f)
            close()
          }
        }
        .build()
    return _category_search!!
  }

private var _category_search: ImageVector? = null
