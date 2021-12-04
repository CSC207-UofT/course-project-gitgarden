package UI;

import Controller.ControllerInterface;
import Controller.ServiceController;

import javax.swing.*;
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
                        sc.modifyUserCheck(WelcomePage.currUserId, newName, newAddress);
                        sc.modifyFarmerCheck(WelcomePage.currUserId, slider1_value, slider2_value,
                                slider3_value, slider4_value);
                        FarmerPage farmerPage = new FarmerPage();
                        setVisible(false);
                        farmerPage.setVisible(true);
                    }
                    catch (Exception modifyException){
                        JOptionPane.showMessageDialog(null, modifyException.getMessage());
                    }
                } else {
                    try {
                        sc.modifyUserCheck(WelcomePage.currUserId, newName, newAddress);
                        sc.modifyDistributorCheck(WelcomePage.currUserId, slider2_value, slider3_value, slider4_value);
                        DistributorPage distributorPage = new DistributorPage();
                        setVisible(false);
                        distributorPage.setVisible(true);
                    }
                    catch (Exception modifyException){
                        JOptionPane.showMessageDialog(null, modifyException.getMessage());
                    }
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
