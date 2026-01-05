package com.pavlov.ui.coroutine

import kotlinx.coroutines.Job
import java.util.UUID
import javax.inject.Inject

class JobManagerImpl @Inject constructor(): JobManager {

    private val jobs = mutableMapOf<String, Job>()

    override fun add(job: Job): Job {
        return add(UUID.randomUUID().toString(), job)
    }

    override fun add(key: String, job: Job): Job {
        jobs[key] = job
        return job
    }

    override fun get(key: String): Job? {
        return jobs[key]
    }

    override fun isActive(key: String): Boolean {
        return jobs[key]?.isActive?: false
    }

    override fun isCancelled(key: String): Boolean {
        return jobs[key]?.isCancelled?: false
    }

    override fun isCompleted(key: String): Boolean {
        return jobs[key]?.isCompleted?: false
    }

    override fun cancel(key: String): Boolean {
        if (isActive(key)) {
            jobs[key]?.cancel()
            return true
        }
        return false
    }

    override fun cancelAll() {
        jobs.forEach {
            if (it.value.isActive) {
                it.value.cancel()
            }
        }
    }

}