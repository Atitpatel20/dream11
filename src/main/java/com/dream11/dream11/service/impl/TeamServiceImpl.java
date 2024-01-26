package com.dream11.dream11.service.impl;

import com.dream11.dream11.entity.Team;
import com.dream11.dream11.entity.User;
import com.dream11.dream11.exception.ResourceNotFoundException;
import com.dream11.dream11.payload.TeamsDto;
import com.dream11.dream11.repository.TeamRepository;
import com.dream11.dream11.repository.UserRepository;
import com.dream11.dream11.service.TeamService;
import org.springframework.stereotype.Service;

@Service
public class TeamServiceImpl implements TeamService {
    private TeamRepository teamRepository;
    private UserRepository userRepository;

    public TeamServiceImpl(TeamRepository teamRepository, UserRepository userRepository) {
        this.teamRepository = teamRepository;
        this.userRepository = userRepository;
    }

    @Override
    public TeamsDto createTeam(TeamsDto teamsDto, long userId) {
        User user = userRepository.findById(userId).orElseThrow(
                ()-> new ResourceNotFoundException("User not found with id:"+userId)
        );
       // System.out.println("DEBUG: userId = " + userId);
        Team team = new Team();
        team.setTeamName(teamsDto.getTeamName());
        team.setUserName(teamsDto.getUserName());
        team.setUser(user);
        Team savedTeam = teamRepository.save(team);

        TeamsDto teamsDtos= new TeamsDto();
        teamsDtos.setId(savedTeam.getId());
        teamsDtos.setTeamName(savedTeam.getTeamName());
        // Set the correct property using teamsDto.getEmail()
        teamsDtos.setUserName(savedTeam.getUserName());
        return teamsDtos;
    }
}
