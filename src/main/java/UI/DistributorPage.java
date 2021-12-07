package UI;

import Controller.DataPresenter;
import Controller.IFetch;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DistributorPage extends JFrame{
    public JPanel mainPanel;
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
    private final IFetch presenter = new DataPresenter();
    private final JPanel[] panelList = {mainPanel, titlePanel, titleTextPanel, modifyPanel,existingPanel, 
                                        existingTextPanel, existingRequestPanel, historyPanel,
                                        historyTextPanel,historyListPanel};


    public DistributorPage(){
        setTitle("distributorPage");
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,700);

        modifyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                JFrame modifyPage = new ModifyPage();
                modifyPage.setVisible(true);
            }
        });
        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                JFrame requestListPage = new OthersExistingRequests();
                requestListPage.setVisible(true);
            }
        });
        ArrayList<String> currentRequestIdList = presenter.fetchCurrentUserRequests(WelcomePage.currUserId);
        DefaultListModel<String> listModel = new DefaultListModel<String>();

        for (String request : currentRequestIdList) {
            String[] info = presenter.fetchRequestInformation(request);
            String product_name = info[0];
            String user_name = info[3];
            if(user_name.equals(presenter.fetchUserName(WelcomePage.currUserId))){
                user_name = "me";
            }
            listModel.addElement("Product " + product_name + ", User: "+ user_name);
        }

        ArrayList<String> historyRequestIdList = presenter.fetchRequestHistory(WelcomePage.currUserId);
        DefaultListModel<String> listModel2 = new DefaultListModel<String>();

        for (String request : historyRequestIdList) {
            String[] info = presenter.fetchRequestInformation(request);
            String product_name = info[0];
            String distributor_name = info[3];
            listModel2.addElement("Product " + product_name + ", User: "+ distributor_name);
        }

        existingList.setModel(listModel);
        historyList.setModel(listModel2);

        historyList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    String request = historyList.getSelectedValue().toString();
                    int index = listModel2.indexOf(request);
                    setVisible(false);
                    HistoryPage historyPage = new HistoryPage(historyRequestIdList.get(index));
                    historyPage.setVisible(true);
                }
            }
        });
        existingList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    String request = existingList.getSelectedValue().toString();
                    int index = listModel.indexOf(request);
                    setVisible(false);
                    DetailsPage detailspage = new DetailsPage(currentRequestIdList.get(index));
                    detailspage.setVisible(true);
                }
            }
        });
        if (WelcomePage.dark){
            for (JPanel p : panelList) {
                p.setBackground(new Color(0x011627));
            }
            existingList.setBackground(new Color(0x1d3b53));
            historyList.setBackground(new Color(0x1d3b53));
            existingList.setForeground(new Color(0xECEFF4));
            historyList.setForeground(new Color(0xECEFF4));
            modifyButton.setForeground(new Color(0x4C566A));
            viewButton.setForeground(new Color(0x4C566A));
        }
    }
}

