package UI;

import Controller.ControllerInterface;
import Controller.DataPresenter;
import Controller.IFetch;
import Controller.ServiceController;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FarmerPage extends JFrame{
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
    private final IFetch presenter = new DataPresenter();
    private final ControllerInterface sc = new ServiceController();
    private final JPanel[] panelList = {mainPanel, titlePanel, titleTextPanel, modifyPanel, buttonPanel, 
                                        modifyButtonPanel, viewButtonPanel, existingPanel, existingTextPanel,
                                        existingRequestPanel, historyPanel, historyTextPanel,historyListPanel};

    public FarmerPage(){
        setTitle("farmerPage");
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
        createRequest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                JFrame requestPage = new RequestPage();
                requestPage.setVisible(true);
            }
        });

        int i = 1;
        ArrayList<String> currentRequestIdList = presenter.fetchCurrentUserRequests(WelcomePage.currUserId);
        DefaultListModel<String> listModel = new DefaultListModel<String>();

        for (String request : currentRequestIdList) {
            String product_name = presenter.fetchRequestInformation(request)[0];
            listModel.addElement(i + " " + product_name);
            i += 1;
        }

        i = 1;
        ArrayList<String> historyRequestIdList = presenter.fetchCurrentUserRequests(WelcomePage.currUserId);
        DefaultListModel<String> listModel2 = new DefaultListModel<String>();
        for (String requestId : presenter.fetchRequestHistory(WelcomePage.currUserId)) {
            String product_name = presenter.fetchRequestInformation(requestId)[0];
            listModel2.addElement(i + " " + product_name);
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
                    HistoryPage historyPage= new HistoryPage(historyRequestIdList.get(index));
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
            modifyButton.setForeground(new Color(0x4C566A));
            viewButton.setForeground(new Color(0x4C566A));
            createRequest.setForeground(new Color(0x4C566A));
        }
    }
}
