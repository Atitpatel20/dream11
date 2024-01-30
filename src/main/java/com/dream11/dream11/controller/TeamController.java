package com.dream11.dream11.controller;

import com.dream11.dream11.payload.TeamsDto;
import com.dream11.dream11.payload.UserDto;
import com.dream11.dream11.service.TeamService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/teams")
public class TeamController {
    private TeamService teamService;
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }
// http://localhost:8080/api/teams?userId=1
    @PostMapping
    public ResponseEntity<TeamsDto> createTeam(
            @RequestBody TeamsDto teamsDto,
            @RequestParam long userId
    ){
        TeamsDto dtos = teamService.createTeam(teamsDto, userId);
        System.out.println("debug"+userId);
        return new ResponseEntity<>(dtos, HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String>deleteTeams(@PathVariable long id){
        teamService.deleteTeams(id);
        return new ResponseEntity<>("Teams is deleted",HttpStatus.OK);
    }
    // http://localhost:8080/api/teams/2/user/2
    @PutMapping("/{id}/user/{userId}")
    public ResponseEntity<TeamsDto>updateTeams(@PathVariable long id,@RequestBody TeamsDto teamsDto,@PathVariable long userId){
        TeamsDto dto=teamService.updateTeams(id,teamsDto,userId);
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }
}
