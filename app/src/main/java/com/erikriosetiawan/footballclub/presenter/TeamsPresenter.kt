package com.erikriosetiawan.footballclub.presenter

import com.erikriosetiawan.footballclub.api.ApiRepository
import com.erikriosetiawan.footballclub.api.TheSportDBApi
import com.erikriosetiawan.footballclub.model.TeamResponse
import com.erikriosetiawan.footballclub.view.TeamsView
import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class TeamsPresenter(
    private val view: TeamsView,
    private val apiRepository: ApiRepository,
    private val gson: Gson
) {
    fun getTeamList(league: String?) {
        view.showLoading()
        doAsync {
            val data = gson.fromJson(
                apiRepository.doRequest(TheSportDBApi.getTeams(league)),
                TeamResponse::class.java
            )

            uiThread {
                view.hideLoading()
                view.showTeamList(data.teams)
            }
        }
    }
}