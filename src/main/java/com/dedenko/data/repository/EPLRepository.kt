package com.dedenko.data.repository

import com.dedenko.data.response.teams.TeamResponse
import com.dedenko.ui.network.ApiDataSource
import com.dedenko.ui.network.BaseDataSource
import com.dedenko.ui.network.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class EPLRepository @Inject constructor(private val apiDataSource: ApiDataSource) : BaseDataSource() {

    //get premiership clubs
    suspend fun getPremierLeagueTeams() : Flow<Resource<TeamResponse>> {
        return flow {
            val result = safeApiCall { apiDataSource.getPremierLeagueTeams() }
            emit(result)
        }.flowOn(Dispatchers.IO)
    }

}
