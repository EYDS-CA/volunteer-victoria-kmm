package com.fw.vvc.data.cache

import com.fw.vvc.UserSession
import com.fw.vvc.data.network.dto.UserDto

interface SessionDao {
    fun saveSession(userDto: UserDto)

    fun getSession(): UserSession?

    fun deleteSession()
}