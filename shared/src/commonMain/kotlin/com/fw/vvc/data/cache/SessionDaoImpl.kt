package com.fw.vvc.data.cache

import com.fw.vvc.AppDatabase
import com.fw.vvc.UserSession
import com.fw.vvc.data.DatabaseDriverFactory
import com.fw.vvc.data.network.dto.UserDto

class SessionDaoImpl(databaseDriverFactory: DatabaseDriverFactory): SessionDao {

    private val dbQueries = AppDatabase(databaseDriverFactory.createDriver()).appDatabaseQueries

    override fun saveSession(userDto: UserDto) {
        deleteSession()
        dbQueries.insertUserSession(
            id = userDto.id,
            fbId = userDto.fbId,
            avatar = userDto.avatar,
            name = userDto.name,
        )
    }

    override fun getSession(): UserSession? {
        return dbQueries.selectUserSession().executeAsList().firstOrNull()
    }

    override fun deleteSession() {
        dbQueries.removeUserSession()
    }

}