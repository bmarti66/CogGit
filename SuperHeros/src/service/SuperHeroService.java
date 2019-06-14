package service;

import dao.SuperHeroDao;
import dto.AddSuperHero;
import dto.SuperHero;
import dto.SuperTeam;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SuperHeroService {

    SuperHeroDao dao;

    public SuperHeroService(SuperHeroDao dao) {
        this.dao = dao;
    }

    public SuperHero addSuperHero(AddSuperHero supData) {
        SuperTeam team = dao.getSuperTeamByName(supData.getTeamName());

        if (team == null) throw new InvalidTeamNameException(supData.getTeamName() + " is not a team recognized by this system.");

        SuperHero superHero = new SuperHero(supData.getSuperName(), supData.getRealName(), supData.getPowers(), supData.getAge(), supData.getHeight(), supData.getWeight(), supData.getSex(), team);
        dao.addNewSuperHero(superHero);
        return superHero;
    }

    public List<SuperHero> findSuperHeroByName(String teamName) {
        SuperTeam team = dao.getSuperTeamByName(teamName);

        if (team == null) throw new InvalidTeamNameException(teamName + " is not a team name recognized by this system.");

        return dao.getHeroByTeam(team);
    }

    public List<SuperHero> findAllSuperHeros() {
        Map<SuperTeam, List<SuperHero>> heroesMap = dao.getAllSuperHeros();
        List<SuperHero> heroes = new ArrayList<SuperHero>();
        for(List<SuperHero> p : heroesMap.values()) {
            heroes.addAll(p);
        }
        return heroes;
    }

    public List<SuperTeam> getSuperTeam() {
        return new ArrayList<SuperTeam>(dao.getAllTeams());
    }




}
