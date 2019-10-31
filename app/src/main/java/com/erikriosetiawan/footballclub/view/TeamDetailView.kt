package com.erikriosetiawan.footballclub.view

import com.erikriosetiawan.footballclub.model.Team

interface TeamDetailView {
    fun showLoading()
    fun hideLoading()
    fun showTeamDetail(data: List<Team>)
}