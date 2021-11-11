package UI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class farmerPage extends JFrame{
    public JPanel mainPanel;
    private JPanel titlePanel;
    private JLabel titleText;
    private JPanel titleTextPanel;
    private JPanel modifyPanel;
    private JButton modifyButton;
    private JPanel buttonPanel;
    private JPanel modifyButtonPanel;
    private JButton createRequest;
    private JButton viewButton;
    private JPanel viewButtonPanel;
    private JPanel existingPanel;
    private JLabel existingText;
    private JPanel existingTextPanel;
    private JPanel existingRequestPanel;
    private JList requestList;
    private JButton acceptButton;
    private JButton declineButton;
    private JButton counterButton;
    private JPanel historyPanel;
    private JPanel historyTextPanel;
    private JLabel historyText;
    private JPanel historyListPanel;
    private JList historyList;
    public farmerPage(){
        setTitle("farmerPage");
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,700);

        modifyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                JFrame modifyPage = new modifyPage();
                modifyPage.setVisible(true);
            }
        });
        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                JFrame requestListPage = new existingRequests();
                requestListPage.setVisible(true);
            }
        });
        createRequest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                JFrame requestPage = new requestPage();
                requestPage.setVisible(true);
            }
        });
        counterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                counterOfferPage counterOfferPage = new counterOfferPage();
                counterOfferPage.setVisible(true);
            }
        });
        acceptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: 2021/11/11
            }
        });
        declineButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: 2021/11/11
            }
        });
    }
}
