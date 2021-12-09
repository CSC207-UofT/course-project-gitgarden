package Client.UI;

import Controller.ControllerInterface;
import Controller.IFetch;

import javax.swing.*;
import java.awt.*;
import java.util.Stack;

public class ModifyPage extends JFrame {
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
    private JButton CloseButton;
    private JPanel priceSliPanel;
    private JPanel exposureSliPanel;
    private JPanel carbonSliPanel;
    private JPanel priceTextPanel;
    private JPanel exposureTextPanel;
    private JPanel speedTextPanel;
    private JPanel carbonTextPanel;
    private JButton UndoButton;
    public static Stack<String[]> farmerStack = new Stack<>();
    public static Stack<String[]> distributorStack = new Stack<>();

    public ModifyPage(ControllerInterface controller, IFetch presenter) {

        setTitle("modifyPage");
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 700);
        ModifyButton.addActionListener(e -> {
            String newAddress = addressInput.getText();
            String newName = nameInput.getText();
            double slider1_value = PriceSlider.getValue();
            double slider2_value = ExposureSlider.getValue();
            double slider3_value = SpeedSlider.getValue();
            double slider4_value = CarbonSlider.getValue();

            if (WelcomePage.flag) {
                try {
                    controller.modifyUserCheck(WelcomePage.currUserId, newName, newAddress);
                    controller.modifyFarmerCheck(WelcomePage.currUserId, slider1_value, slider2_value,
                            slider3_value, slider4_value);

                    String[] state = {newName, newAddress, String.valueOf(slider1_value),
                            String.valueOf(slider2_value), String.valueOf(slider3_value),
                            String.valueOf(slider4_value)};
                    farmerStack.push(state);

                    FarmerPage farmerPage = new FarmerPage(controller, presenter);
                    setVisible(false);
                    farmerPage.setVisible(true);
                } catch (Exception modifyException) {
                    JOptionPane.showMessageDialog(null, modifyException.getMessage());
                }
            } else {
                try {
                    controller.modifyUserCheck(WelcomePage.currUserId, newName, newAddress);
                    controller.modifyDistributorCheck(WelcomePage.currUserId, slider2_value, slider3_value, slider4_value);

                    String[] state = {newName, newAddress, String.valueOf(slider2_value),
                            String.valueOf(slider3_value), String.valueOf(slider4_value)};
                    distributorStack.push(state);

                    DistributorPage distributorPage = new DistributorPage(controller, presenter);
                    setVisible(false);
                    distributorPage.setVisible(true);
                } catch (Exception modifyException) {
                    JOptionPane.showMessageDialog(null, modifyException.getMessage());
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

        if (WelcomePage.dark) {
            JPanel[] panelList = {titlePanel, textPanel, middlePanel, inputPanel, buttonPanel,
                    namePanel, pricePanel, preferencePanel, prefInputPanel, nameInputPanel,
                    priceInputPanel, buttonPanel, mainPanel, priceTextPanel, exposureTextPanel,
                    speedTextPanel, carbonTextPanel, speedSliPanel, priceSliPanel, exposureSliPanel,
                    carbonSliPanel};
            for (JPanel p : panelList) {
                p.setBackground(new Color(0x011627));
            }
            JLabel[] textsList = {titleText, nameText, addressText, priceText, exposureText, speedText, carbonText};
            for (JLabel t : textsList) {
                t.setForeground(new Color(0xd6deeb));
            }
            nameInput.setBackground(new Color(0x1d3b53));
            addressInput.setBackground(new Color(0x1d3b53));
        }

        CloseButton.addActionListener(e -> {
            if (WelcomePage.flag) {
                FarmerPage farmerPage = new FarmerPage(controller, presenter);
                setVisible(false);
                farmerPage.setVisible(true);
            } else {
                DistributorPage distributorPage = new DistributorPage(controller, presenter);
                setVisible(false);
                distributorPage.setVisible(true);
            }
        });

        UndoButton.addActionListener(e -> {
            if (WelcomePage.flag) {
                try {
                    farmerStack.pop();
                    String[] restore = farmerStack.pop();


                    String id = WelcomePage.currUserId;

                    controller.modifyUserCheck(id, restore[0], restore[1]);
                    controller.modifyFarmerCheck(id, Double.parseDouble(restore[2]), Double.parseDouble(restore[3]),
                            Double.parseDouble(restore[4]), Double.parseDouble(restore[5]));

                    JOptionPane.showMessageDialog(null, "Your changes have been restored.");
                    UndoButton.requestFocusInWindow();

                    FarmerPage farmerPage = new FarmerPage(controller, presenter);
                    setVisible(false);
                    farmerPage.setVisible(true);
                } catch (Exception undoException) {
                    JOptionPane.showMessageDialog(null, undoException.getMessage());
                }
            } else {
                try {
                    distributorStack.pop();
                    String[] restore = distributorStack.pop();

                    String id = WelcomePage.currUserId;

                    controller.modifyUserCheck(id, restore[0], restore[1]);
                    controller.modifyDistributorCheck(id, Double.parseDouble(restore[2]), Double.parseDouble(restore[3]),
                            Double.parseDouble(restore[4]));

                    JOptionPane.showMessageDialog(null, "Your changes have been restored.");
                    UndoButton.requestFocusInWindow();

                    DistributorPage distributorPage = new DistributorPage(controller, presenter);
                    setVisible(false);
                    distributorPage.setVisible(true);
                } catch (Exception undoException) {
                    JOptionPane.showMessageDialog(null, undoException.getMessage());
                }
            }
        });
    }
}