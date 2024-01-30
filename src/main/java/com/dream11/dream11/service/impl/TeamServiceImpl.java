package com.dream11.dream11.service.impl;

import com.dream11.dream11.entity.Team;
import com.dream11.dream11.entity.User;
import com.dream11.dream11.exception.ResourceNotFoundException;
import com.dream11.dream11.payload.TeamsDto;
import com.dream11.dream11.repository.TeamRepository;
import com.dream11.dream11.repository.UserRepository;
import com.dream11.dream11.service.TeamService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class TeamServiceImpl implements TeamService {
    private TeamRepository teamRepository;
    private ModelMapper modelMapper;
    private UserRepository userRepository;

    public TeamServiceImpl(TeamRepository teamRepository, UserRepository userRepository,ModelMapper modelMapper) {
        this.teamRepository = teamRepository;
        this.userRepository = userRepository;
        this.modelMapper=modelMapper;
    }

    @Override
    public TeamsDto createTeam(TeamsDto teamsDto, long userId) {
        User user = userRepository.findById(userId).orElseThrow(
                ()-> new ResourceNotFoundException("User not found with id:"+userId)
        );
       // System.out.println("DEBUG: userId = " + userId);
        Team team = mapToEntity(teamsDto);
//        Team team = new Team();
//        team.setTeamName(teamsDto.getTeamName());
//        team.setUserName(teamsDto.getUserName());
//        team.setUser(user);
        Team savedTeam = teamRepository.save(team);

//        TeamsDto teamsDtos= new TeamsDto();
//        teamsDtos.setId(savedTeam.getId());
//        teamsDtos.setTeamName(savedTeam.getTeamName());
//        // Set the correct property using teamsDto.getEmail()
//        teamsDtos.setUserName(savedTeam.getUserName());
        return mapToDto(savedTeam);
    }

    @Override
    public void deleteTeams(long id) {
        teamRepository.deleteById(id);
    }

    @Override
    public TeamsDto updateTeams(long id, TeamsDto teamsDto, long userId) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User not found with id:" + userId)
        );
        Team team = teamRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("teams not found with id:" + id)
        );
        Team t = mapToEntity(teamsDto);
        t.setId(team.getId());
        t.setUser(user);
        Team update = teamRepository.save(t);
        return mapToDto(update);
    }
    TeamsDto mapToDto(Team team){
        TeamsDto dto = modelMapper.map(team, TeamsDto.class);
        return dto;
    }
    Team mapToEntity(TeamsDto teamsDto){
        Team team = modelMapper.map(teamsDto, Team.class);
        return team;
    }
}
