package UI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    public CounterOfferPage(Request request) {
        setTitle("counterOffer");
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,700);

        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                if(WelcomePage.flag) {
                    /*
                    String price = priceInput.getText();
                    String quantity = quantityInput.getText();
                    Farmer farmer = (Farmer) ProfileManager.currentUser;

                    try {
                        ServiceController.createCounterOffer(request, farmer, quantity, price);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    } */

                    JOptionPane.showMessageDialog(null,"Farmer Cannot Create A Counter Offer.");
                    createButton.requestFocusInWindow();

                    FarmerPage farmerPage = new FarmerPage();
                    farmerPage.setVisible(true);
                }
                else{
                    String price = priceInput.getText();
                    String quantity = quantityInput.getText();
                    Distributor distributor = (Distributor) ProfileManager.currentUser;

                    try {
                        ServiceController.createCounterOffer(request, distributor, quantity, price);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                    DistributorPage distributorPage = new DistributorPage();
                    distributorPage.setVisible(true);
                }
            }
        });

        priceInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        quantityInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });


    }
}
