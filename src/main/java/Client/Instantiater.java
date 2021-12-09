package Client;

import Controller.ControllerInterface;
import Controller.DataPresenter;
import Controller.IFetch;
import Controller.ServiceController;
import DataBase.JsonProvider;
import Client.UI.WelcomePage;
import UseCases.ProfileInterface;
import UseCases.ProfileManager;
import UseCases.RequestInterface;
import UseCases.RequestManager;

import java.io.FileNotFoundException;

public class Instantiater implements Facade{
    /**
     * Build to be used to run the program.
     */
    public void build(){
        JsonProvider jp = new JsonProvider();
        try {
            jp.loadAll();
        } catch (FileNotFoundException e){
            System.out.println("First time running, there's nothing to be read yet!");
        }
        ProfileInterface pm = new ProfileManager();
        RequestInterface rm = new RequestManager();
        ControllerInterface sc = new ServiceController(pm, rm);
        IFetch dp = new DataPresenter(pm, rm);
        WelcomePage welcomePage = new WelcomePage(sc, dp);
        welcomePage.setVisible(true);
        Runtime.getRuntime().addShutdownHook(new Thread(jp::writeUsers));
    }
}
