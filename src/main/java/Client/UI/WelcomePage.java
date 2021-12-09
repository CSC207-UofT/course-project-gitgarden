package Client.UI;

import Controller.ControllerInterface;
import Controller.IFetch;

import javax.swing.*;
import java.awt.*;

public class WelcomePage extends JFrame{
    private JPanel mainPanel;
    private JPanel titlePanel;
    private JLabel titleText;
    private JPanel signInPanel;
    private JPanel textPanel;
    private JPanel inputPanel;
    private JPanel signInButtonPanel;
    private JTextField nameInput;
    private JLabel nameText;
    private JButton signInButton;
    private JPanel sinUpPanel;
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
    private final JPanel[] panelList = {titlePanel, signInPanel, textPanel, inputPanel, signInButtonPanel, sinUpPanel,
            namePanel, pricePanel, preferencePanel, prefInputPanel, nameInputPanel, priceInputPanel, textsPanel,
            inputsPanel, separatePanel, farmerPanel, choicePanel, buttonPanel, userTextPanel, distributorPanel,
            mainPanel, priceTextPanel, exposureTextPanel, speedTextPanel, carbonTextPanel, pricePrePanel,
            exposurePrePanel, speedPrePanel, carbonPrePanel};
    private final JLabel[] textsList = {titleText, nameText, priceText, addressText, exposureText, speedText,
            carbonText, orText, userTest};
    public WelcomePage(ControllerInterface controller, IFetch presenter) {
        setContentPane(mainPanel);
        setTitle("Welcome");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 700);

        signInButton.addActionListener(e -> {
            String username = nameInput.getText();

            if (username.equals("")) {
                JOptionPane.showMessageDialog(null,"Please enter your User Name");
                newUserName.requestFocusInWindow();
            }
            else {
                if (presenter.fetchAllFarmerNames().contains(username)){
                    currUserId = presenter.fetchUserId(username);
                    flag = true;
                    FarmerPage farmerPage = new FarmerPage(controller, presenter);
                    setVisible(false);
                    farmerPage.setVisible(true);
                }
                else if (presenter.fetchAllDistNames().contains(username)){
                    currUserId = presenter.fetchUserId(username);
                    flag = false;
                    DistributorPage distributorPage = new DistributorPage(controller,presenter);
                    setVisible(false);
                    distributorPage.setVisible(true);
                }
                else {
                    JOptionPane.showMessageDialog(null, "Please enter a valid User Name or " +
                            "Create a new Profile");
                    newUserName.requestFocusInWindow();
                }
            }
        });
        farmerButton.addActionListener(e -> flag = true);
        distributorButton.addActionListener(e -> flag = false);
        signupButton.addActionListener(e -> {
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
                    currUserId = controller.createProfileCheck(name,address, flag);
                    if (flag) {
                        controller.modifyFarmerCheck(currUserId, slider1_value, slider2_value, slider3_value, slider4_value);
                      
                        String[] state = {name, address, String.valueOf(slider1_value),
                                    String.valueOf(slider2_value), String.valueOf(slider3_value),
                                    String.valueOf(slider4_value)};
                        ModifyPage.farmerStack.push(state);
                      
                        FarmerPage farmerPage = new FarmerPage(controller, presenter);
                        setVisible(false);
                        farmerPage.setVisible(true);
                        setContentPane(new FarmerPage(controller, presenter).mainPanel);
                    } else {
                        controller.modifyDistributorCheck(currUserId, slider2_value, slider3_value, slider4_value);
                      
                        String[] state = {name, address, String.valueOf(slider2_value),
                                    String.valueOf(slider3_value), String.valueOf(slider4_value)};
                        ModifyPage.distributorStack.push(state);
                      
                        DistributorPage distributorPage = new DistributorPage(controller, presenter);
                        setVisible(false);
                        distributorPage.setVisible(true);
                        setContentPane(new DistributorPage(controller, presenter).mainPanel);
                    }
                }
                catch (Exception profileException){
                    JOptionPane.showMessageDialog(null,profileException.getMessage());

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

        darkCheckBox.addActionListener(e -> {
            if (darkCheckBox.isSelected()){
                dark = true;
                for (JPanel p : panelList) {
                    p.setBackground(new Color(0x011627));
                }
                for (JLabel t : textsList) {
                    t.setForeground(new Color(0xd6deeb));
                }
            }
            else{
                dark = false;
                for (JPanel p : panelList) {
                    p.setBackground(new Color(0x4C566A));
                }
                for (JLabel t : textsList) {
                    t.setForeground(new Color(0xECEFF4));
                }
            }
        });
    }
}