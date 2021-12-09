package Client.UI;

import Controller.ControllerInterface;
import Controller.IFetch;

import javax.swing.*;
import java.awt.*;

public class CounterOfferPage extends JFrame{
    private JPanel mainPanel;
    private JPanel titlePanel;
    private JPanel buttonPanel;
    private JLabel titleText;
    private JPanel middlePanel;
    private JPanel textPanel;
    private JLabel quantityText;
    private JLabel priceText;
    private JPanel priceTextPanel;
    private JPanel quantityTextPanel;
    private JPanel inputPanel;
    private JPanel priceInputPanel;
    private JPanel quantityInputPanel;
    private JTextField priceInput;
    private JTextField quantityInput;
    private JButton createButton;

    public CounterOfferPage(String request, ControllerInterface controller, IFetch presenter) {

        setTitle("counterOffer");
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,700);

        createButton.addActionListener(e -> {
            String price = priceInput.getText();
            String quantity = quantityInput.getText();
            try {
                controller.createCounterOfferCheck(request, WelcomePage.currUserId, quantity, price);
                DistributorPage distributorPage = new DistributorPage(controller, presenter);
                setVisible(false);
                distributorPage.setVisible(true);
                setContentPane(new DistributorPage(controller, presenter).mainPanel);
            }
            catch (Exception counterOfferException){
                JOptionPane.showMessageDialog(null, counterOfferException.getMessage());
            }
        });

        if (WelcomePage.dark){
            JPanel[] panelList = {mainPanel, titlePanel, buttonPanel, middlePanel, textPanel, priceTextPanel,
                    quantityTextPanel, inputPanel, priceInputPanel, quantityInputPanel};
            for (JPanel p : panelList) {
                p.setBackground(new Color(0x011627));
            }
            JLabel[] textsList = {titleText, quantityText, priceText,};
            for (JLabel t : textsList) {
                t.setForeground(new Color(0xd6deeb));
            }
            priceInput.setBackground(new Color(0x1d3b53));
            quantityInput.setBackground(new Color(0x1d3b53));
            priceInput.setForeground(new Color(0xd6deeb));
            quantityInput.setForeground(new Color(0xd6deeb));
            createButton.setForeground(new Color(0x4C566A));
        }
    }
}
