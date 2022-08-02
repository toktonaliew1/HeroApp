package com.example.android4hw1.models

import com.google.gson.annotations.SerializedName

data class DetailHeroModel(

    @SerializedName("duration")
    val duration: Int = 0,

    @SerializedName("kills")
    val kills: Int = 0,

    @SerializedName("start_time")
    val startTime: Int = 0,

    @SerializedName("radiant_win")
    val radiantWin: Boolean = false,

    @SerializedName("account_id")
    val accountId: Int = 0,

    @SerializedName("assists")
    val assists: Int = 0,

    @SerializedName("league_id")
    val leagueId: Int = 0,

    @SerializedName("match_id")
    val matchId: Long = 0,

    @SerializedName("league_name")
    val     leagueName: String = "",

    @SerializedName("player_slot")
    val playerSlot: Int = 0,

    @SerializedName("radiant")
    val radiant: Boolean = false,

    @SerializedName("deaths")
    val deaths: Int = 0
)