package UI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Controller.ControllerInterface;
import Controller.DataPresenter;
import Controller.ServiceController;
import Entities.Distributor;
import Entities.Request;
import UseCases.ProfileManager;

public class CounterOfferPage extends JFrame{
    private JPanel mainPanel;
    private JPanel titlePanel;
    private JPanel buttonPanel;
    private JLabel titleText;
    private JPanel middlePanel;
    private JPanel textPanel;
    private JLabel quantityText;
    private JLabel priceText;
    private JLabel title;
    private JPanel priceTextPanel;
    private JPanel quantityTextPanel;
    private JPanel inputPanel;
    private JPanel priceInputPanel;
    private JPanel quantityInputPanel;
    private JTextField priceInput;
    private JTextField quantityInput;
    private JButton createButton;
    private final ControllerInterface sc = new ServiceController();

    public CounterOfferPage(String request) {
        setTitle("counterOffer");
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,700);

        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String price = priceInput.getText();
                String quantity = quantityInput.getText();
                try {
                    sc.createCounterOfferCheck(WelcomePage.currUserId, request, quantity, price);
                    DistributorPage distributorPage = new DistributorPage();
                    setVisible(false);
                    distributorPage.setVisible(true);
                    setContentPane(new DistributorPage().mainPanel);
                }
                catch (Exception counterOfferException){
                    JOptionPane.showMessageDialog(null, counterOfferException.getMessage());
                }
            }
        });
    }
}
