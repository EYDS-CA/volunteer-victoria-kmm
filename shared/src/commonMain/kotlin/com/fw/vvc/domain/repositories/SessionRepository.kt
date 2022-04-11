package com.fw.vvc.domain.repositories

import com.fw.vvc.domain.models.Empty
import com.fw.vvc.domain.models.User

interface SessionRepository {
    suspend fun login(fbId: String, avatar: String, name: String): User
    suspend fun logout(): Empty
}