package UI;

import Controller.ControllerInterface;
import Controller.ServiceController;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
                double slider1_value = slider1.getValue();
                double slider2_value = slider2.getValue();
                double slider3_value = slider3.getValue();
                double slider4_value = slider4.getValue();

                if (WelcomePage.flag) {
                    try {
                        sc.modifyUserCheck(WelcomePage.currUserId, newName, newAddress);
                    }
                    catch (Exception UserCheckException){
                        JOptionPane.showMessageDialog(null,UserCheckException.getMessage());
                    }
                    try {
                        sc.modifyFarmerCheck(WelcomePage.currUserId, slider1_value, slider2_value,
                                slider3_value, slider4_value);
                    }
                    catch (Exception farmerCheckException){
                        JOptionPane.showMessageDialog(null, farmerCheckException.getMessage());
                    }
                    FarmerPage farmerPage = new FarmerPage();
                    setVisible(false);
                    farmerPage.setVisible(true);
                } else {
                    try {
                        sc.modifyUserCheck(WelcomePage.currUserId, newName, newAddress);
                    }
                    catch (Exception UserCheckException){
                        JOptionPane.showMessageDialog(null, UserCheckException.getMessage());
                    }
                    try {
                        sc.modifyDistributorCheck(WelcomePage.currUserId, slider2_value, slider3_value, slider4_value);
                    }
                    catch (Exception distributorCheck){
                        JOptionPane.showMessageDialog(null, distributorCheck.getMessage());
                    }
                    DistributorPage distributorPage = new DistributorPage();
                    setVisible(false);
                    distributorPage.setVisible(true);
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
    }
}
