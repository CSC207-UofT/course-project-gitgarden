package Client.UI;

import Controller.ControllerInterface;
import Controller.IFetch;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DistributorPage extends JFrame {
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
    private JPanel historyPanel;
    private JPanel historyTextPanel;
    private JLabel historyText;
    private JPanel historyListPanel;
    private JList<String> historyList;
    private JButton viewButton;
    private JList<String> existingList;

    public DistributorPage(ControllerInterface controller, IFetch presenter) {
        setTitle("distributorPage");
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 700);

        modifyButton.addActionListener(e -> {
            setVisible(false);
            JFrame modifyPage = new ModifyPage(controller, presenter);
            modifyPage.setVisible(true);
        });
        viewButton.addActionListener(e -> {
            setVisible(false);
            JFrame requestListPage = new OthersExistingRequests(controller, presenter);
            requestListPage.setVisible(true);
        });
        ArrayList<String> currentRequestIdList = presenter.fetchCurrentUserRequests(WelcomePage.currUserId);
        DefaultListModel<String> listModel = new DefaultListModel<>();

        for (String request : currentRequestIdList) {
            String[] info = presenter.fetchRequestInformation(request);
            String product_name = info[0];
            String user_name = info[3];
            if (user_name.equals(presenter.fetchUserName(WelcomePage.currUserId))) {
                listModel.addElement("Product " + product_name + ", User: me");
            }
        }

        ArrayList<String> historyRequestIdList = presenter.fetchRequestHistory(WelcomePage.currUserId);
        DefaultListModel<String> listModel2 = new DefaultListModel<>();

        for (String request : historyRequestIdList) {
            String[] info = presenter.fetchRequestInformation(request);
            String product_name = info[0];
            String distributor_name = info[3];
            listModel2.addElement("Product " + product_name + ", User: " + distributor_name);
        }

        existingList.setModel(listModel);
        historyList.setModel(listModel2);

        historyList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                String request = historyList.getSelectedValue();
                int index = listModel2.indexOf(request);
                setVisible(false);
                HistoryPage historyPage = new HistoryPage(historyRequestIdList.get(index), controller, presenter);
                historyPage.setVisible(true);
            }
        });
        existingList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                String request = existingList.getSelectedValue();
                int index = listModel.indexOf(request);
                setVisible(false);
                DetailsPage detailspage = new DetailsPage(currentRequestIdList.get(index), controller, presenter);
                detailspage.setVisible(true);
            }
        });
        if (WelcomePage.dark) {
            JPanel[] panelList = {mainPanel, titlePanel, titleTextPanel, modifyPanel, existingPanel,
                    existingTextPanel, existingRequestPanel, historyPanel,
                    historyTextPanel, historyListPanel};
            for (JPanel p : panelList) {
                p.setBackground(new Color(0x011627));
            }
            JLabel[] textsList = {titleText, existingText, historyText};
            for (JLabel t : textsList) {
                t.setForeground(new Color(0xd6deeb));
            }
            existingList.setBackground(new Color(0x1d3b53));
            historyList.setBackground(new Color(0x1d3b53));
            existingList.setForeground(new Color(0xd6deeb));
            historyList.setForeground(new Color(0xd6deeb));
            modifyButton.setForeground(new Color(0x4C566A));
            viewButton.setForeground(new Color(0x4C566A));
        }
    }
}

