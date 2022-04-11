package com.fw.vvc.domain.models

data class Opportunity(
    val id: String,
    val creatorId: String?,
    val opportunityName: String?,
    val description: String?,
    val location: String?,
    val requiredPeople: String?,
    val date: String?,
    val eventTimeRange: String?,
    val indoors: String?,
    val criminalCheck: String?,
    val idealVolunteer: String?,
    val additionalInformation: String?,
    val contactName: String?,
    val email: String?,
    val phone: String?,
    val interestedParties: List<Attendants?>?
)