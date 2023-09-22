package com.dedenko.data.repository

import com.dedenko.data.response.players.PlayersResponse
import com.dedenko.ui.network.ApiDataSource
import com.dedenko.ui.network.BaseDataSource
import com.dedenko.ui.network.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class PlayersRepository @Inject constructor(private val apiDataSource: ApiDataSource) : BaseDataSource() {

    //get team players
    suspend fun getPremierLeagueTeamPlayers(id: String) : Flow<Resource<PlayersResponse>> {
        return flow {
            val result = safeApiCall { apiDataSource.getPremierLeagueTeamPlayers(id) }
            emit(result)
        }.flowOn(Dispatchers.IO)
    }

}
