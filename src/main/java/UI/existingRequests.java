package UI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class existingRequests extends JFrame{
    private JPanel mainPanel;
    private JPanel titlePanel;
    private JLabel titleText;
    private JPanel buttonPanel;
    private JTable table1;
    private JButton offerButton;
    private JButton counterButton;
    private JPanel descriptionPanel;
    private JLabel descriptionText;
    private JPanel acceptButtonPanel;
    private JButton acceptRequest;
    private JPanel declineButtonPanel;
    private JButton declineButton;
    private JPanel closeButtonPanel;
    private JButton closeButton;

    public existingRequests(){
        setTitle("requestPage");
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,700);

        counterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!welcomePage.flag) {
                    setVisible(false);
                    counterOfferPage counterOfferPage = new counterOfferPage();
                    counterOfferPage.setVisible(true);
                }
            }
        });
        offerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                if (!welcomePage.flag){
                    setVisible(false);
                    distributorPage distributorPage = new distributorPage();
                    distributorPage.setVisible(true);
                }
            }
        });
    }
}
