package UI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class detailsPage extends JFrame{
    private JPanel mainPanel;
    private JPanel titlePanel;
    private JLabel titleText;
    private JPanel detailsPanel;
    private JPanel detailsTextPanel;
    private JLabel detailsText;
    private JPanel detailsListPanel;
    private JList detailsList;
    private JPanel responsePanel;
    private JPanel responseTextPanel;
    private JLabel responseText;
    private JPanel responseListPanel;
    private JList responseList;
    private JPanel buttonPanel;
    private JPanel acceptButtonPanel;
    private JButton acceptRequest;
    private JPanel declineButtonPanel;
    private JButton declineButton;
    private JPanel counterButtonPanel;
    private JButton counterButton;
    private JPanel closeButtonPanel;
    private JButton closeButton;
    private JPanel descriptionPanel;
    private JLabel descriptionText;
    public detailsPage(){
        setTitle("farmerPage");
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,700);
        acceptRequest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: 2021/11/11 accept from backend
            }
        });

        declineButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: 2021/11/11 decline from backend

            }
        });
        counterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                JFrame counterOfferPage = new counterOfferPage();
                counterOfferPage.setVisible(true);
            }
        });
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                if(welcomePage.flag){
                    JFrame farmerPage = new farmerPage();
                    farmerPage.setVisible(true);
                }
                else{
                    JFrame distributorPage = new distributorPage();
                    distributorPage.setVisible(true);
                }
            }
        });
        // TODO: 2021/11/11 display the request details 
    }
}
