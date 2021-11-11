package UI;

import javax.swing.*;

public class requestListPage {
    private JPanel mainPanel;
    private JPanel titlePanel;
    private JLabel titleText;
    private JPanel buttonPanel;
    private JTable table1;
    private JButton offerButton;
    private JButton counterButton;
    public static void main(String[] args){
        JFrame frame = new JFrame("requestListPage");
        frame.setContentPane(new requestListPage().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
