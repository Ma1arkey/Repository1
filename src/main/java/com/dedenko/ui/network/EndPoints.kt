package com.dedenko.ui.network

class EndPoints {

    companion object {

        //BASE
        const val BASE_URL = "https://api.football-data.org/v2/"

        //GET PREMIER LEAGUE TEAMS
        const val PREMIER_LEAGUE_TEAMS = "competitions/2021/teams"

        //GET SINGLE PREMIER LEAGUE TEAM PLAYERS
        const val PREMIER_LEAGUE_TEAM_PLAYERS = "teams/{id}"

    }

}