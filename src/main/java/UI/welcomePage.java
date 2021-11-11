package UI;

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
    private JButton createButton;
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
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                farmerPage farmerPage = new farmerPage();
                setVisible(false);
                farmerPage.setVisible(true);
                setContentPane(new farmerPage().mainPanel);
            }
        });
        signupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(flag) {
                    farmerPage farmerPage = new farmerPage();
                    setVisible(false);
                    farmerPage.setVisible(true);
                    setContentPane(new farmerPage().mainPanel);
                }
                else{
                    distributorPage distributorPage = new distributorPage();
                    setVisible(false);
                    distributorPage.setVisible(true);
                    setContentPane(new farmerPage().mainPanel);
                }
            }
        });
        nameInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String oldUserName = nameInput.getText();
                // TODO: 2021/11/10 Sign this person in.
                // TODO: 2021/11/11 change flag to true if farmer, false if distributor 
            }
        });

        newUserName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newUsername = newUserName.getText();
            }
        });

        addressInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String address = addressInput.getText();
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
                double score = slider1.getValue();
            }
        });
        slider2.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                double score = slider1.getValue();
            }
        });
        slider3.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                double score = slider1.getValue();
                System.out.print(score);
            }
        });
        slider4.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                double score = slider1.getValue();
            }
        });
    }

    public static void main(String[] args){
        welcomePage welcomePage = new welcomePage();
        welcomePage.setVisible(true);
    }
}
