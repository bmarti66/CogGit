package controller;

import dto.AddSuperHero;
import dto.SuperHero;
import dto.SuperTeam;
import view.Runner;
import service.SuperHeroService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SuperHeroController {
    private Runner frontEnd;
    private SuperHeroService service;

    public SuperHeroController(Runner frontEnd, SuperHeroService service) {
        super();
        this.frontEnd = frontEnd;
        this.service = service;
        frontEnd.run(this);
}

    public SuperHero addSuperHero(AddSuperHero supData) {
        return service.addSuperHero(supData);
    }

    public List<SuperHero> listSuperHeroes() {
        return service.findAllSuperHeros();
    }

    public List<SuperHero> listSuperHeroes(String teams){
        return service.findSuperHeroByName(teams);
    }



    public List<String> getSuperTeam() {
        List<SuperTeam> teams = service.getSuperTeam();
        List<String> teamNames = new ArrayList<>();
        for(SuperTeam s: teams) {
            teamNames.add(s.getTeamName());
        }
        Collections.sort(teamNames);
        return teamNames;
    }


}