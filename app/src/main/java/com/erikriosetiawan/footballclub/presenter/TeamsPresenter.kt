package com.erikriosetiawan.footballclub.presenter

import com.erikriosetiawan.footballclub.api.ApiRepository
import com.erikriosetiawan.footballclub.api.TheSportDBApi
import com.erikriosetiawan.footballclub.model.TeamResponse
import com.erikriosetiawan.footballclub.view.TeamsView
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class TeamsPresenter(
    private val view: TeamsView,
    private val apiRepository: ApiRepository,
    private val gson: Gson
) {
    fun getTeamList(league: String?) {
        view.showLoading()

        GlobalScope.launch(Dispatchers.Main) {
            val data =
                gson.fromJson(
                    apiRepository.doRequest(TheSportDBApi.getTeams(league)).await(),
                    TeamResponse::class.java
                )

            view.showTeamList(data.teams)
            view.hideLoading()
        }
    }
}