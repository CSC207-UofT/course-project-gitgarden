package UI;

import javax.swing.*;

public class distributorPage {
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
    private JList requestList;
    private JButton acceptButton;
    private JButton declineButton;
    private JButton counterButton;
    private JPanel historyPanel;
    private JPanel historyTextPanel;
    private JLabel historyText;
    private JPanel historyListPanel;
    private JList historyList;
    private JButton viewButton;
    public static void main(String[] args){
        JFrame frame = new JFrame("distributorPage");
        frame.setContentPane(new distributorPage().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
