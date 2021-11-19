package UI;

import Controller.ControllerInterface;
import Controller.ServiceController;
import Entities.Farmer;
import Entities.IFarmer;
import Entities.IUser;
import UseCases.ProfileManager;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class welcomePage extends JFrame{
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
    public static boolean flag;
    public static IUser currentUser = null;
    // TODO: 2021/11/18 check if instantiating entity level interface is allowed

    public ControllerInterface sc = new ServiceController();
    // TODO: 2021/11/10 set size
    public welcomePage() {
        setContentPane(mainPanel);
        setTitle("Welcome");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(800, 700);

        signInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = nameInput.getText();

                if (username.equals("") || username == null) {
                    JOptionPane.showMessageDialog(null,"Please enter your User Name");
                    newUserName.requestFocusInWindow();
                }

                else {
                    // TODO: 2021/11/18 fetch farmer list.
                    for (IUser farmer : sc.fetch()) {
                        if (farmer.getUserName().equals(username)) {
                            // TODO: 2021/11/18 find the farmer, and assign it. Need instance of current user too.
                            // PofileManager.currentUser = farmer;
                            // TODO: 2021/11/18 get this farmer
                            currentUser = sc.fetch();
                            flag = true;
                        }
                    }
                    // TODO: 2021/11/18 fetch distributor list
                    for (IUser distributor : sc.fetch()) {
                        if (distributor.getUserName().equals(username)) {
                            // TODO: 2021/11/18 find the distributor, assign it. Also need the instance.
                            // ProfileManager.currentUser = distributor;
                            currentUser = sc.fetch();
                            flag = false;
                        }
                    }

                    if (currentUser == null) {
                        JOptionPane.showMessageDialog(null,"Please enter a valid User Name or " +
                                "Create a new Profile");
                        newUserName.requestFocusInWindow();
                    }

                    else if (currentUser instanceof Farmer) {
                        farmerPage farmerPage = new farmerPage();
                        setVisible(false);
                        farmerPage.setVisible(true);
                    }

                    else {
                        distributorPage distributorPage = new distributorPage();
                        setVisible(false);
                        distributorPage.setVisible(true);
                    }

                }
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
                if (name.equals("") || name == null) {
                    JOptionPane.showMessageDialog(null,"Please enter your User Name.");
                    newUserName.requestFocusInWindow();
                }

                else {
                    try {
                        // TODO: 2021/11/18 change so we can edit farmer, right now, no user instance to use
                        sc.createProfileCheck(name, address, flag);
                        sc.modifyFarmerCheck(sc.fetch(),slider1_value,slider2_value,slider3_value,slider4_value);
                    }
                    catch (Exception ex) {
                        ex.printStackTrace();
                    }

                    if (flag) {
                        farmerPage farmerPage = new farmerPage();
                        setVisible(false);
                        farmerPage.setVisible(true);
                        setContentPane(new farmerPage().mainPanel);
                    }
                    else {
                        distributorPage distributorPage = new distributorPage();
                        setVisible(false);
                        distributorPage.setVisible(true);
                        setContentPane(new distributorPage().mainPanel);
                    }
                }
            }
        });
        // TODO: 2021/11/18 test if we need them or not, if not delete all listeners
        nameInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });

        newUserName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });

        addressInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
        slider1.setPaintTicks(true);
        slider1.setMinorTickSpacing(10);
        slider2.setPaintTicks(true);
        slider2.setMinorTickSpacing(10);
        slider3.setPaintTicks(true);
        slider3.setMinorTickSpacing(10);
        slider4.setPaintTicks(true);
        slider4.setMinorTickSpacing(10);
        slider1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                // double score = slider1.getValue(); REDUNDANT
            }
        });
        slider2.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
               // double score = slider1.getValue(); REDUNDANT
            }
        });
        slider3.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                // double score = slider1.getValue(); REDUNDANT
                // System.out.print(score);
            }
        });
        slider4.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
               // double score = slider1.getValue(); REDUNDANT
            }
        });
    }

    public static void main(String[] args){
        try {
            // TODO: 2021/11/18 data persistency team's method, double check names
            ServiceController.read();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }

        welcomePage welcomePage = new welcomePage();
        welcomePage.setVisible(true);

        Runtime.getRuntime().addShutdownHook(new Thread()
        {
            public void run()
            {
                try {
                    // TODO: 2021/11/18 data persistency team's method, double check names.
                    ServiceController.write();
                } catch (FileNotFoundException e){
                    e.printStackTrace();
                }
                System.out.println("Shutdown Hook is running !");
            }
        });
    }
}