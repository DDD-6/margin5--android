package com.margin.wine.domain.executor

import kotlinx.coroutines.CoroutineDispatcher

interface PostExecutor {
    val main: CoroutineDispatcher
    val io: CoroutineDispatcher
    val default: CoroutineDispatcher
}