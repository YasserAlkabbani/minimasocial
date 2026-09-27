package com.yasser.minimasocial.core.data.extentions

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.PagingSource
import androidx.paging.map
import kotlinx.coroutines.flow.Flow

private const val PAGING_PAGE_SIZE: Int = 20

fun <T : Any, R : Any> (() -> PagingSource<Int, T>).asPagingData(asModel: T. () -> R): Flow<PagingData<R>> =
    Pager(
        config = PagingConfig(pageSize = PAGING_PAGE_SIZE),
        pagingSourceFactory = { this() }
    ).flow.mapFlow { map { entity -> entity.asModel() } }