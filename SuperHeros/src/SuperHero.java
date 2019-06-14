
import controller.SuperHeroController;
import dao.SuperHeroDao;
import dao.SuperHeroData;
import dao.SuperHeroInMemory;
import service.SuperHeroService;
import view.Runner;
import view.SuperHeroView;

public class SuperHero {

    public static void main(String[] args) {
        SuperHeroDao dao = new SuperHeroInMemory(SuperHeroData.getProdData());
        Runner view = new SuperHeroView();
        SuperHeroService service = new SuperHeroService(dao);
        SuperHeroController s = new SuperHeroController(view, service);

    }

}
