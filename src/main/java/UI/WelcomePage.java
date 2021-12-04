package UI;

import Controller.ControllerInterface;
import Controller.DataPresenter;
import Controller.IFetch;
import Controller.ServiceController;
import DataBase.JsonProvider;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class WelcomePage extends JFrame{
    private JPanel mainPanel;
    private JPanel titlePanel;
    private JLabel titleText;
    private JPanel signinPanel;
    private JPanel textPanel;
    private JPanel inputPanel;
    private JPanel signinButtonPanel;
    private JTextField nameInput;
    private JLabel nameText;
    private JButton signInButton;
    private JPanel sinupPanel;
    private JPanel namePanel;
    private JPanel pricePanel;
    private JLabel addressText;
    private JPanel preferencePanel;
    private JLabel priceText;
    private JLabel exposureText;
    private JLabel speedText;
    private JLabel carbonText;
    private JPanel prefInputPanel;
    private JSlider slider1;
    private JPanel nameInputPanel;
    private JPanel priceInputPanel;
    private JPanel textsPanel;
    private JPanel inputsPanel;
    private JPanel separatePanel;
    private JPanel farmerPanel;
    private JLabel orText;
    private JPanel choicePanel;
    private JPanel buttonPanel;
    private JPanel userTextPanel;
    private JPanel distributorPanel;
    private JButton signupButton;
    private JButton farmerButton;
    private JButton distributorButton;
    private JTextField newUserName;
    private JTextField addressInput;
    private JSlider slider2;
    private JSlider slider3;
    private JSlider slider4;
    private JLabel userTest;
    private JCheckBox darkCheckBox;
    private JPanel priceTextPanel;
    private JPanel exposureTextPanel;
    private JPanel speedTextPanel;
    private JPanel carbonTextPanel;
    private JPanel pricePrePanel;
    private JPanel exposurePrePanel;
    private JPanel speedPrePanel;
    private JPanel carbonPrePanel;
    public static Boolean flag;
    public static String currUserId = "";
    public static Boolean dark = false;
    private final ControllerInterface sc = new ServiceController();
    private final IFetch presenter = new DataPresenter();
    private JPanel[] panelList = {titlePanel, signinPanel, textPanel, inputPanel, signinButtonPanel, sinupPanel,
            namePanel, pricePanel, preferencePanel, prefInputPanel, nameInputPanel, priceInputPanel, textsPanel,
            inputsPanel, separatePanel, farmerPanel, choicePanel, buttonPanel, userTextPanel, distributorPanel,
            mainPanel, priceTextPanel, exposureTextPanel, speedTextPanel, carbonTextPanel, pricePrePanel,
            exposurePrePanel, speedPrePanel, carbonPrePanel};
    public WelcomePage() {
        setContentPane(mainPanel);
        setTitle("Welcome");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(800, 700);

        signInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = nameInput.getText();

                if (username.equals("")) {
                    JOptionPane.showMessageDialog(null,"Please enter your User Name");
                    newUserName.requestFocusInWindow();
                }
                else {
                    if (presenter.fetchAllFarmerNames().contains(username)){
                        currUserId = presenter.fetchUserId(username);
                        flag = true;
                        FarmerPage farmerPage = new FarmerPage();
                        setVisible(false);
                        farmerPage.setVisible(true);
                    }
                    else if (presenter.fetchAllDistNames().contains(username)){
                        currUserId = presenter.fetchUserId(username);
                        flag = false;
                        DistributorPage distributorPage = new DistributorPage();
                        setVisible(false);
                        distributorPage.setVisible(true);
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Please enter a valid User Name or " +
                                "Create a new Profile");
                        newUserName.requestFocusInWindow();
                    }
                }
            }
        });
        farmerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                flag = true;
            }
        });
        distributorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                flag = false;
            }
        });
        signupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String address = addressInput.getText();
                double slider1_value = slider1.getValue();
                double slider2_value = slider2.getValue();
                double slider3_value = slider3.getValue();
                double slider4_value = slider4.getValue();
                String name = newUserName.getText();
                if (flag == null) {
                    JOptionPane.showMessageDialog(null,"Please choose farmer or distributor");
                }
                else{
                    try{
                        currUserId = sc.createProfileCheck(name,address, flag);
                        if (flag) {
                            sc.modifyFarmerCheck(currUserId, slider1_value, slider2_value, slider3_value, slider4_value);
                            FarmerPage farmerPage = new FarmerPage();
                            setVisible(false);
                            farmerPage.setVisible(true);
                            setContentPane(new FarmerPage().mainPanel);
                        } else {
                            sc.modifyDistributorCheck(currUserId, slider2_value, slider3_value, slider4_value);
                            DistributorPage distributorPage = new DistributorPage();
                            setVisible(false);
                            distributorPage.setVisible(true);
                            setContentPane(new DistributorPage().mainPanel);
                        }
                    }
                    catch (Exception profileException){
                        JOptionPane.showMessageDialog(null,profileException.getMessage());
                    }
                }
            }
        });
        slider1.setPaintTicks(true);
        slider1.setMinorTickSpacing(10);
        slider2.setPaintTicks(true);
        slider2.setMinorTickSpacing(10);
        slider3.setPaintTicks(true);
        slider3.setMinorTickSpacing(10);
        slider4.setPaintTicks(true);
        slider4.setMinorTickSpacing(10);

        darkCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (darkCheckBox.isSelected()){
                    dark = true;
                    for (JPanel p : panelList) {
                        p.setBackground(new Color(0x011627));
                    }
                }
                else{
                    dark = false;
                    for (JPanel p : panelList) {
                        p.setBackground(new Color(0x4C566A));
                    }
                }
            }
        });

    }


    public static void main(String[] args){
        try {
            JsonProvider jp = new JsonProvider();
            jp.loadFarmer("farmers.json");
            jp.loadDistributor("distributors.json");
            jp.modifyFarmer("farmerMod.json");
            jp.modifyDistributor("distMod.json");
            jp.loadRequests("requests.json");
        } catch (FileNotFoundException e){
            System.out.println("First time running, there's nothing to be read yet!");
        }

        WelcomePage welcomePage = new WelcomePage();
        welcomePage.setVisible(true);

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            JsonProvider jp = new JsonProvider();
            jp.writeUsers();
        }));
    }
}