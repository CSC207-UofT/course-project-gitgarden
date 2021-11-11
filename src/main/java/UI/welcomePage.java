package UI;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

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
    private JLabel orText;
    private JPanel buttonPanel;
    private JButton signupButton;
    private JButton farmerButton;
    private JButton distributorButton;
    private JTextField newUserName;
    private JTextField getAddress;
    private JSlider slider2;
    private JSlider slider3;
    private JSlider slider4;

    // TODO: 2021/11/10 set size
    public welcomePage() {
        setContentPane(mainPanel);
        setTitle("Welcome");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(1000, 1000);
        final boolean[] flag = new boolean[1];
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                farmerPage farmerPage = new farmerPage();
                setVisible(false);
                farmerPage.setVisible(true);
                setContentPane(new farmerPage().mainPanel);
            }
        });
        nameInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String oldUserName = nameInput.getText();
                // TODO: 2021/11/10 Sign this person in
            }
        });

        newUserName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newUsername = newUserName.getText();
            }
        });

        getAddress.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String address = getAddress.getText();
            }
        });
        farmerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                flag[0] = true;
            }
        });
        distributorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                flag[0] = false;
            }
        });
        if (flag[0]){
            // TODO: 2021/11/11 create farmer
        }
        else{
            // TODO: 2021/11/11 create distributor
        }
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
