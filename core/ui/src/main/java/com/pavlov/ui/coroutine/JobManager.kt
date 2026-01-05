package com.pavlov.ui.coroutine

import kotlinx.coroutines.Job

interface JobManager {

    fun add(job: Job): Job

    fun add(key: String, job: Job): Job

    fun get(key: String): Job?

    fun isActive(key: String): Boolean

    fun isCancelled(key: String): Boolean

    fun isCompleted(key: String): Boolean

    fun cancel(key: String): Boolean

    fun cancelAll()
}