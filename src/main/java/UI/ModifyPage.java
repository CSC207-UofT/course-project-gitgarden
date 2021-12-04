package UI;

import Controller.ControllerInterface;
import Controller.DataPresenter;
import Controller.IFetch;
import Controller.ServiceController;
import Entities.Distributor;
import Entities.Farmer;
import Entities.IDistributor;
import Entities.IFarmer;
import UseCases.ProfileInterface;
import UseCases.ProfileManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Stack;

public class ModifyPage extends JFrame{
    private JPanel titlePanel;
    private JLabel titleText;
    private JPanel middlePanel;
    private JPanel textPanel;
    private JPanel namePanel;
    private JLabel nameText;
    private JPanel pricePanel;
    private JLabel addressText;
    private JPanel preferencePanel;
    private JPanel inputPanel;
    private JPanel prefInputPanel;
    private JPanel nameInputPanel;
    private JTextField nameInput;
    private JPanel priceInputPanel;
    private JTextField addressInput;
    private JPanel mainPanel;
    private JPanel buttonPanel;
    private JButton ModifyButton;
    private JSlider PriceSlider;
    private JLabel priceText;
    private JLabel exposureText;
    private JLabel speedText;
    private JLabel carbonText;
    private JSlider ExposureSlider;
    private JPanel speedSliPanel;
    private JSlider SpeedSlider;
    private JSlider CarbonSlider;
    private JButton UndoButton;
    private JPanel priceSliPanel;
    private JPanel exposureSliPanel;
    private JPanel carbonSliPanel;
    ControllerInterface sc = new ServiceController();
    DataPresenter dp = new DataPresenter();
    /*
    Stack<Farmer.Momento> farmerStack = new Stack<>();
    Stack<Distributor.Momento> distributorStack = new Stack<>();

    public ModifyPage() {
        setTitle("modifyPage");
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 700);
        ModifyButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String newAddress = addressInput.getText();
                String newName = nameInput.getText();
                double slider1_value = PriceSlider.getValue();
                double slider2_value = ExposureSlider.getValue();
                double slider3_value = SpeedSlider.getValue();
                double slider4_value = CarbonSlider.getValue();

                if (WelcomePage.flag) {
                    try {
                        String ID = WelcomePage.currUserId;
                        String userName = dp.fetchUserName(ID);
                        String userAddress = dp.fetchUserAddress(ID);

                        ProfileInterface pm = new ProfileManager();
                        IFarmer farmer = (IFarmer) pm.getUserFromId(ID);
                        double prefPrice = farmer.getPrefPrice();
                        double prefExposure = farmer.getPrefExposure();
                        double prefSpeed = farmer.getPrefSpeed();
                        double prefCarbon = farmer.getPrefCarbon();

                        Farmer.Momento farmerState = new Farmer.Momento(userName, userAddress, prefPrice, prefExposure,
                                prefSpeed, prefCarbon);
                        farmerStack.addElement(farmerState);

                        sc.modifyUserCheck(ID, newName, newAddress);
                        sc.modifyFarmerCheck(ID, slider1_value, slider2_value,
                                slider3_value, slider4_value);
                        /*
                        FarmerPage farmerPage = new FarmerPage();
                        setVisible(false);
                        farmerPage.setVisible(true); */
                    } /*
                    catch (Exception modifyException){
                        JOptionPane.showMessageDialog(null, modifyException.getMessage());
                    }
                } else {
                    try {
                        String ID = WelcomePage.currUserId;
                        String userName = dp.fetchUserName(ID);
                        String userAddress = dp.fetchUserAddress(ID);

                        ProfileInterface pm = new ProfileManager();
                        IDistributor distributor = (IDistributor) pm.getUserFromId(ID);
                        // double prefPrice = distributor.getPrice();
                        double prefExposure = distributor.getExposure();
                        double prefSpeed = distributor.getSpeed();
                        double prefCarbon = distributor.getCarbon();

                        Distributor.Momento distributorState = new Distributor.Momento(userName, userAddress,
                                prefExposure, prefSpeed, prefCarbon);
                        distributorStack.addElement(distributorState);

                        sc.modifyUserCheck(WelcomePage.currUserId, newName, newAddress);
                        sc.modifyDistributorCheck(WelcomePage.currUserId, slider2_value, slider3_value, slider4_value);
                        /*
                        DistributorPage distributorPage = new DistributorPage();
                        setVisible(false);
                        distributorPage.setVisible(true); */
                    } /*
                    catch (Exception modifyException){
                        JOptionPane.showMessageDialog(null, modifyException.getMessage());
                    }
                }
            }
        });

        UndoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (WelcomePage.flag) {
                    Farmer.Momento restore = farmerStack.pop().getState();

                    String ID = WelcomePage.currUserId;

                    ProfileInterface pm = new ProfileManager();
                    IFarmer farmer = (IFarmer) pm.getUserFromId(ID);

                    farmer.setUserName(restore.getName());
                    farmer.setUserAddress(restore.getAddress());
                    farmer.setPrefCarbon(restore.getCarbon());
                    farmer.setPrefExposure(restore.getExposure());
                    farmer.setPrefPrice(restore.getPrice());
                    farmer.setPrefSpeed(restore.getSpeed());

                    JOptionPane.showMessageDialog(null,"Your changes have been restored.");
                    UndoButton.requestFocusInWindow();

                    FarmerPage farmerPage = new FarmerPage();
                    setVisible(false);
                    farmerPage.setVisible(true);

                }

                else {
                    Distributor.Momento restore = distributorStack.pop().getState();

                    String ID = WelcomePage.currUserId;

                    ProfileInterface pm = new ProfileManager();
                    IDistributor distributor = (IDistributor) pm.getUserFromId(ID);

                    distributor.setUserName(restore.getName());
                    distributor.setUserAddress(restore.getAddress());
                    distributor.setCarbon(restore.getCarbon());
                    distributor.setExposure(restore.getExposure());
                    distributor.setSpeed(restore.getSpeed());

                    JOptionPane.showMessageDialog(null,"Your changes have been restored.");
                    UndoButton.requestFocusInWindow();

                    DistributorPage distributorPage = new DistributorPage();
                    setVisible(false);
                    distributorPage.setVisible(true);

                }
            }
        });

        PriceSlider.setPaintTicks(true);
        PriceSlider.setMinorTickSpacing(10);
        ExposureSlider.setPaintTicks(true);
        ExposureSlider.setMinorTickSpacing(10);
        SpeedSlider.setPaintTicks(true);
        SpeedSlider.setMinorTickSpacing(10);
        CarbonSlider.setPaintTicks(true);
        CarbonSlider.setMinorTickSpacing(10);
    }
}
*/