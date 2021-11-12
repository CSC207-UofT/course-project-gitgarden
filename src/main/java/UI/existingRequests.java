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

        acceptRequest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: 2021/11/12 show message
                setVisible(false);
                if (welcomePage.flag){
                    JFrame farmerPage = new farmerPage();
                    farmerPage.setVisible(true);
                }
                else{
                    JFrame distributorPage = new distributorPage();
                    distributorPage.setVisible(true);
                }
            }
        });
        declineButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: 2021/11/12 show message
                setVisible(false);
                if (welcomePage.flag){
                    JFrame farmerPage = new farmerPage();
                    farmerPage.setVisible(true);
                }
                else{
                    JFrame distributorPage = new distributorPage();
                    distributorPage.setVisible(true);
                }
            }
        });
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                if (welcomePage.flag){
                    JFrame farmerPage = new farmerPage();
                    farmerPage.setVisible(true);
                }
                else{
                    JFrame distributorPage = new distributorPage();
                    distributorPage.setVisible(true);
                }
            }
        });
    }
}
