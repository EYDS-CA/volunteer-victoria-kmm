package com.fw.vvc.data.repositories

import com.fw.vvc.data.cache.SessionDao
import com.fw.vvc.data.network.dto.UserDto
import com.fw.vvc.domain.models.Empty
import com.fw.vvc.domain.models.User
import com.fw.vvc.domain.repositories.SessionRepository

class SessionRepositoryImpl(
    private val dao: SessionDao,
    ): SessionRepository {

    override suspend fun login(fbId: String, avatar: String, name: String): User {
        val userDto = UserDto(
            id = "-1",
            fbId = fbId,
            avatar = avatar,
            name = name
        )
        dao.saveSession(userDto)
        return userDto.toUser()
    }

    override suspend fun logout(): Empty {
        dao.deleteSession()
        return Empty
    }
}