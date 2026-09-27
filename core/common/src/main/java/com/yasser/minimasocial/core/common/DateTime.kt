package com.yasser.minimasocial.core.common

import kotlin.time.Clock
import kotlin.time.Instant


fun currentTimeInMilliSec() =
    Clock.System.now().toEpochMilliseconds()

fun String.isoToTimestampMillis(): Long =
    Instant.parse(this).toEpochMilliseconds()