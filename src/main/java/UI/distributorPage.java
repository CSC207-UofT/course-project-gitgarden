package UI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class distributorPage extends JFrame{
    private JPanel mainPanel;
    private JPanel titlePanel;
    private JPanel titleTextPanel;
    private JLabel titleText;
    private JPanel modifyPanel;
    private JButton modifyButton;
    private JPanel existingPanel;
    private JPanel existingTextPanel;
    private JLabel existingText;
    private JPanel existingRequestPanel;
    private JButton acceptButton;
    private JButton declineButton;
    private JButton counterButton;
    private JPanel historyPanel;
    private JPanel historyTextPanel;
    private JLabel historyText;
    private JPanel historyListPanel;
    private JList<String> historyList;
    private JButton viewButton;
    private JList<String> existingList;

    public distributorPage(){
        setTitle("distributorPage");
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
