package com.erikriosetiawan.footballclub.view

import com.erikriosetiawan.footballclub.model.Team

interface TeamsView {
    fun showLoading()
    fun hideLoading()
    fun showTeamList(data: List<Team>)
}