package com.margin.wine.domain.usecase

import kotlinx.coroutines.flow.Flow

abstract class FlowUseCase<in P, out R> {

    protected abstract fun execute(param: P): Flow<R>

    operator fun invoke(param: P): Flow<R> = execute(param)
}