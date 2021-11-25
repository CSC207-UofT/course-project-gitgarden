package UI_Fixed;

import Controller.ControllerInterface;
import Controller.ServiceController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private final ControllerInterface sc = new ServiceController();
    public RequestPage(){
        setTitle("requestPage");
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,700);
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String product = ProductNameInput.getText();
                String quantity = quantityInput.getText();
                String price = priceInput.getText();
                if (product.equals("")|| quantity.equals("")|| price.equals("")) {
                    JOptionPane.showMessageDialog(null,"Please enter all information");
                }
                if (WelcomePage.flag){
                    // TODO: 2021/11/20 what is this try catch block
//                    try {
//                        sc.createRequestCheck(welcomePage.currUserId, product, quantity, price);
//                    } catch (Exception ex) {
//                        ex.printStackTrace();
//                    }
                    sc.createRequestCheck(WelcomePage.currUserId, product, quantity, price);
                    JFrame profile = new FarmerPage();
                    setVisible(false);
                    profile.setVisible(true);
                }
                else{
                    JFrame profile = new DistributorPage();
                    setVisible(false);
                    profile.setVisible(true);
                }
            }
        });
        // TODO: 2021/11/20 check if duplicate
        quantityInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        ProductNameInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        priceInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
    }

}
