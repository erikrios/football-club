package com.erikriosetiawan.footballclub.presenter

import com.erikriosetiawan.footballclub.api.ApiRepository
import com.erikriosetiawan.footballclub.api.TheSportDBApi
import com.erikriosetiawan.footballclub.model.TeamResponse
import com.erikriosetiawan.footballclub.view.TeamDetailView
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class TeamDetailPresenter(
    private val view: TeamDetailView,
    private val apiRepository: ApiRepository,
    private val gson: Gson
) {

    fun getTeamDetail(teamId: String) {
        view.showLoading()

        GlobalScope.launch(Dispatchers.Main) {
            val data = gson.fromJson(
                apiRepository
                    .doRequest(TheSportDBApi.getTeamDetail(teamId)).await(),
                TeamResponse::class.java
            )

            view.showTeamDetail(data.teams)
            view.hideLoading()
        }
    }
}