package com.fw.vvc.interactor.session

import com.fw.vvc.domain.repositories.SessionRepository

class LoginInteractor(
    private val sessionRepository: SessionRepository
) {

    suspend fun execute(fbId: String, avatar: String, name: String) {
        sessionRepository.login(fbId, avatar, name)
    }

}