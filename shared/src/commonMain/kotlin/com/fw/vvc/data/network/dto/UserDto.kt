package com.fw.vvc.data.network.dto

import com.fw.vvc.domain.models.User

data class UserDto(
    val id: String,
    val fbId: String,
    val avatar: String,
    val name: String,
    val notes: String? = null,
    val attended: Boolean? = null
) {

    fun toUser() = User(
        id = id,
        fbId = fbId,
        avatar = avatar,
        name = name
    )

}
