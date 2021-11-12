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
    private JList<String> existingList;
    private JButton acceptButton;
    private JButton declineButton;
    private JButton counterButton;
    private JPanel historyPanel;
    private JPanel historyTextPanel;
    private JLabel historyText;
    private JPanel historyListPanel;
    private JList<String> historyList;
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
        String [] data = {"one", "two", "three", "four"};
        DefaultListModel<String> listModel= new DefaultListModel<String>();
        for(String item: data){
            listModel.addElement(item);
        }
        historyList.setModel(listModel);
        existingList.setModel(listModel);
        existingList.addListSelectionListener(e -> {
            //example for how to get the value
                    // TODO: 2021/11/11 pass the corresponding request to details page to make details.
            String number = historyList.getSelectedValue();
            System.out.print(number);
            setVisible(false);
            JFrame detailsPage = new detailsPage();
            detailsPage.setVisible(true);
                }
                );
    }
}
