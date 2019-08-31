package com.erikriosetiawan.footballclub.view

import com.erikriosetiawan.footballclub.model.Team

interface MainView {
    fun showLoading()
    fun hideLoading()
    fun showTeamList(data: List<Team>)
}