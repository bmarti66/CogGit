package dao;

import dto.SuperHero;
import dto.SuperTeam;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface SuperHeroDao {
    public Map<SuperTeam, List<SuperHero>> getAllSuperHeros();
    public Set<SuperTeam> getAllTeams();
    public List<SuperHero> getHeroByTeam(SuperTeam team);
    public SuperTeam getSuperTeamByName(String teamName);
    public void addNewSuperHero(SuperHero s);

    public List<SuperHero> searchSuperHero(Map<String, String> params);

}
