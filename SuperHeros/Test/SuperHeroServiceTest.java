import dao.SuperHeroDao;
import dao.SuperHeroInMemory;
import dto.AddSuperHero;
import dto.SuperHero;
import dto.SuperTeam;
import org.junit.Test;
import service.SuperHeroService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class SuperHeroServiceTest {


    @Test
    public void testAddSuperHero() {
        SuperHeroService service = new SuperHeroService(new SuperHeroInMemory(getTestData()));
        AddSuperHero superHero = new AddSuperHero("Dude", "Blake Martin", new ArrayList<String>(List.of("Flying")), 40, 6.0,200,'M',"Justice League");
        assertEquals(service.findSuperHeroByName("Justice League").size(), 3);
        service.addSuperHero(superHero);
        assertEquals(service.findSuperHeroByName("Justice League").size(), 4);



    }

    private static SuperTeam justiceLeague = new SuperTeam("Justice League");
    private static SuperTeam avengers = new SuperTeam("The Avengers");
    private static SuperTeam fantasticFour = new SuperTeam("Fantastic Four");
    private static SuperTeam xMen = new SuperTeam("X-Men");

    public static Map<SuperTeam, List<SuperHero>> getTestData(){
        Map <SuperTeam, List<SuperHero>> prodData = new HashMap<>();
        prodData.put(justiceLeague,  new ArrayList<SuperHero>());
        prodData.put(avengers,  new ArrayList<SuperHero>());
        prodData.put(fantasticFour,  new ArrayList<SuperHero>());
        prodData.put(xMen,  new ArrayList<SuperHero>());
        prodData.get(justiceLeague).add(new SuperHero("Superman", "Clark Kent", new ArrayList<String>(List.of("Flying")), 40, 6.0,200, 'M', justiceLeague));
        prodData.get(justiceLeague).add(new SuperHero("Batman", "Bruce Wayne", new ArrayList<String>(List.of("Money")), 26, 6.2,210, 'M', justiceLeague));
        prodData.get(justiceLeague).add(new SuperHero("Flash", "Barry Allen", new ArrayList<String>(List.of("Fast")), 19, 5.11,140, 'M', justiceLeague));
        prodData.get(avengers).add(new SuperHero("Iron Man", "Tony Stark", new ArrayList<String>(List.of("Rich")), 30, 5.8,180, 'M', avengers));
        prodData.get(avengers).add(new SuperHero("Thor", "Thor Odinson", new ArrayList<String>(List.of("God")), 28, 6.4,220, 'M', avengers));
        prodData.get(avengers).add(new SuperHero("Hulk", "Bruce Banner", new ArrayList<String>(List.of("Strength")), 32, 6.9,310, 'M', avengers));
        prodData.get(fantasticFour).add(new SuperHero("Mister Fantastic", "Reed Richards", new ArrayList<String>(List.of("Everything")), 29, 6.1,175, 'M', fantasticFour));
        prodData.get(fantasticFour).add(new SuperHero("Invisible Woman", "Susan Richards", new ArrayList<String>(List.of("Invisible")), 28, 6.3,135, 'F', fantasticFour));
        prodData.get(fantasticFour).add(new SuperHero("Thing", "Benjamin Grimm", new ArrayList<String>(List.of("Strength")), 35, 6.2,420, 'M', fantasticFour));
        prodData.get(fantasticFour).add(new SuperHero("Human Torch", "Jonathan Storm", new ArrayList<String>(List.of("Fire")), 27, 5.10,160, 'M', fantasticFour));
        prodData.get(xMen).add(new SuperHero("Wolverine", "Logan Howlett", new ArrayList<String>(List.of("Claws")), 40, 5.10,170, 'M', xMen));
        prodData.get(xMen).add(new SuperHero("Storm", "Ororo Munroe", new ArrayList<String>(List.of("Weather")), 37, 5.6,140, 'F', xMen));


        return prodData;
    }

}
