package UI;

import Controller.ControllerInterface;
import Controller.ServiceController;
import UseCases.ProfileManager;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class modifyPage extends JFrame{
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
    private JSlider slider1;
    private JLabel priceText;
    private JLabel exposureText;
    private JLabel speedText;
    private JLabel carbonText;
    private JSlider slider2;
    private JPanel JPanel;
    private JSlider slider3;
    private JSlider slider4;
    ControllerInterface sc = new ServiceController();

    public modifyPage(){
        setTitle("modifyPage");
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,700);
        ModifyButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String newAddress = addressInput.getText();
                String newName = nameInput.getText();
                double slider1_value = slider1.getValue();
                double slider2_value = slider2.getValue();
                double slider3_value = slider3.getValue();
                double slider4_value = slider4.getValue();

                if (welcomePage.flag) {
                    sc.modifyUserCheck(welcomePage.currUserId, newName, newAddress);
                    sc.modifyFarmerCheck(welcomePage.currUserId, slider1_value, slider2_value,
                            slider3_value, slider4_value);
                    farmerPage farmerPage = new farmerPage();
                    setVisible(false);
                    farmerPage.setVisible(true);
                }
                else{
                    // TODO: 2021/11/20 do not allow dis to modify price pref
                    sc.modifyUserCheck(welcomePage.currUserId, newName, newAddress);
                    sc.modifyDistributorCheck(welcomePage.currUserId, slider2_value, slider3_value, slider4_value);
                    distributorPage distributorPage = new distributorPage();
                    setVisible(false);
                    distributorPage.setVisible(true);
                }
            }
        });
        // TODO: 2021/11/20 check if these are redundant
        nameInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newUserName = nameInput.getText();
                // TODO: 2021/11/11  
            }
        });
        addressInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String address = addressInput.getText();
                // TODO: 2021/11/11  
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

        // TODO: 2021/11/20 check if these are redundant
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
        
}
