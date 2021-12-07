package Client.UI;

import Controller.ControllerInterface;
import Controller.IFetch;

import javax.swing.*;
import java.awt.*;

public class RequestPage extends JFrame{
    private JPanel mainPanel;
    private JPanel titlePanel;
    private JPanel middlePanel;
    private JPanel buttonPanel;
    private JLabel titleText;
    private JPanel textPanel;
    private JPanel inputPanel;
    private JPanel namePanel;
    private JPanel quanInputPanel;
    private JPanel pricePanel;
    private JPanel nameInputPanel;
    private JPanel quantityPanel;
    private JPanel priceInputPanel;
    private JLabel nameText;
    private JLabel priceText;
    private JLabel quantityText;
    private JTextField ProductNameInput;
    private JTextField quantityInput;
    private JTextField priceInput;
    private JButton createButton;
    private final ControllerInterface sc;


    public RequestPage(ControllerInterface controller, IFetch presenter){
        sc = controller;
        setTitle("requestPage");
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,700);
        createButton.addActionListener(e -> {
            String product = ProductNameInput.getText();
            String quantity = quantityInput.getText();
            String price = priceInput.getText();
            if (product.equals("")|| quantity.equals("")|| price.equals("")) {
                JOptionPane.showMessageDialog(null,"Please enter all information");
            }
            try{
                sc.createRequestCheck(WelcomePage.currUserId, product, quantity, price);
                JFrame profile = new FarmerPage(controller, presenter);
                setVisible(false);
                profile.setVisible(true);
            }
            catch(Exception requestException){
                JOptionPane.showMessageDialog(null,requestException.getMessage());
            }
        });

        if (WelcomePage.dark){
            JPanel[] panelList = {mainPanel, titlePanel, middlePanel, buttonPanel, textPanel, inputPanel,
                    namePanel, quanInputPanel, pricePanel, nameInputPanel, quantityPanel,
                    priceInputPanel};
            for (JPanel p : panelList) {
                p.setBackground(new Color(0x011627));
            }
            ProductNameInput.setBackground(new Color(0x1d3b53));
            priceInput.setBackground(new Color(0x1d3b53));
            quantityInput.setBackground(new Color(0x1d3b53));
            createButton.setForeground(new Color(0x4C566A));
        }

    }

}