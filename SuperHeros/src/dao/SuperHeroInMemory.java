package dao;

import dto.SuperHero;
import dto.SuperTeam;

import java.util.*;

public class SuperHeroInMemory implements SuperHeroDao {
    private Map<SuperTeam, List<SuperHero>> superHeros;

    public SuperHeroInMemory(Map<SuperTeam, List<SuperHero>> superHeros) {
        super();
        this.superHeros = superHeros;
    }

    @Override
    public Map<SuperTeam, List<SuperHero>> getAllSuperHeros(){
        return new HashMap<SuperTeam, List<SuperHero>>(superHeros);
    }

    public Set<SuperTeam> getAllTeams() {
        return superHeros.keySet();
    }


    @Override
    public List<SuperHero> getHeroByTeam(SuperTeam team) {
        return superHeros.get(team);
    }

    public SuperTeam getSuperTeamByName(String teamName) {
        Set<SuperTeam> teams = superHeros.keySet();
        SuperTeam team = teams.stream()
                .filter(b->b.getTeamName().equals(teamName))
                .findFirst()
                .orElse(null);
        return team;
    }

    @Override
    public void addNewSuperHero(SuperHero s) {
        if(superHeros.keySet().contains(s.getTeam())) {
            superHeros.get(s.getTeam()).add(s);
        }
        else {
            superHeros.put(s.getTeam(), new ArrayList<SuperHero>());
            superHeros.get(s.getTeam()).add(s);
        }
    }


    public List<SuperHero> searchSuperHero(Map<String, String> params) {
        return null;
    }


}

