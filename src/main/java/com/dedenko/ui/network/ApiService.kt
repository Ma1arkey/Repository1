package com.dedenko.ui.network

import com.dedenko.BuildConfig
import com.dedenko.data.response.players.PlayersResponse
import com.dedenko.data.response.teams.TeamResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Path

/**
 * Retrofit interface for making network calls with coroutines suspend function (Asynchronously)
 */
interface ApiService {

    //get premier league teams
    @Headers("X-Auth-Token: ${BuildConfig.FOOTBALL_API_KEY}")
    @GET(EndPoints.PREMIER_LEAGUE_TEAMS)
    suspend fun getPremierLeagueTeams()
            : Response<TeamResponse>

    //get single premier league team players
    @Headers("X-Auth-Token: ${BuildConfig.FOOTBALL_API_KEY}")
    @GET(EndPoints.PREMIER_LEAGUE_TEAM_PLAYERS)
    suspend fun getPremierLeagueTeamPlayers(
        @Path("id", encoded = true) id: String?,
    ): Response<PlayersResponse>

}