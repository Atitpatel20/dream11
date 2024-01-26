package com.dream11.dream11.service;

import com.dream11.dream11.payload.TeamsDto;

public interface TeamService {
    TeamsDto createTeam(TeamsDto teamsDto, long userId);
}
