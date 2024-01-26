package com.dream11.dream11.controller;

import com.dream11.dream11.payload.TeamsDto;
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
}
