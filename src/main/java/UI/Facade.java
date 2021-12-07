package UI;

import Controller.ControllerInterface;
import Controller.DataPresenter;
import Controller.IFetch;
import Controller.ServiceController;
import DataBase.JsonProvider;
import UseCases.ProfileInterface;
import UseCases.ProfileManager;
import UseCases.RequestInterface;
import UseCases.RequestManager;

import java.io.FileNotFoundException;

public class Facade {
    public static void build(){
        try {
            JsonProvider jp = new JsonProvider();
            jp.loadFarmer("farmers.json");
            jp.loadDistributor("distributors.json");
            jp.modifyFarmer("farmerMod.json");
            jp.modifyDistributor("distMod.json");
            jp.loadRequests("requests.json");
            jp.loadCounterOffers("counters.json");
        } catch (FileNotFoundException e){
            System.out.println("First time running, there's nothing to be read yet!");
        }
        ProfileInterface pm = new ProfileManager();
        RequestInterface rm = new RequestManager();
        ControllerInterface sc = new ServiceController(pm, rm);
        IFetch dp = new DataPresenter(pm, rm);
        WelcomePage welcomePage = new WelcomePage(sc, dp);
        welcomePage.setVisible(true);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            JsonProvider jp = new JsonProvider();
            jp.writeUsers();
        }));
    }
}
