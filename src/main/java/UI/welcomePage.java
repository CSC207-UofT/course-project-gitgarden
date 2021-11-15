package UI;

import Controller.ServiceController;
import Entities.Farmer;
import Entities.User;
import UseCases.ProfileManager;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

                    for (Entities.Farmer farmer : ProfileManager.farmerList) {
                        if (farmer.getUser_name() == username) {
                            ProfileManager.currentUser = farmer;
                        }
                    }

                    for (Entities.Distributor distributor : ProfileManager.distributorList) {
                        if (distributor.getUser_name() == username) {
                            ProfileManager.currentUser = distributor;
                        }
                    }

                    if (ProfileManager.currentUser == null) {
                        JOptionPane.showMessageDialog(null,"Please enter a valid User Name or " +
                                "Create a new Profile");
                        newUserName.requestFocusInWindow();
                    }

                    else if (ProfileManager.currentUser instanceof Farmer) {
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
                        ServiceController.createProfile(name, address, slider1_value, slider2_value, slider3_value,
                                slider4_value, flag);

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
        nameInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: 2021/11/10 Sign this person in.
                // TODO: 2021/11/11 change flag to true if farmer, false if distributor
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
        if (flag){
            // TODO: 2021/11/11 create farmer
        }
        else{
            // TODO: 2021/11/11 create distributor
        }
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
        welcomePage welcomePage = new welcomePage();
        welcomePage.setVisible(true);
    }
}