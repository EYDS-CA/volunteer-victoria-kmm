package com.fw.vvc.domain.models

data class Attendants(
    val id: String,
    val fbiD: String?,
    val avatar: String?,
    val name: String?,
    val notes: String?,
    val attended: Boolean?
)