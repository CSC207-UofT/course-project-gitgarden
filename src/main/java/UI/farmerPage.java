package UI;

import Controller.ControllerInterface;
import Controller.DataPresenter;
import Controller.IFetch;
import Controller.ServiceController;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

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
    private final IFetch presenter = new DataPresenter();
    private final ControllerInterface sc = new ServiceController();

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

        int i = 1;
        ArrayList<String> requestIdList = presenter.fetchCurrentUserRequests(welcomePage.currUserId);
        DefaultListModel<String> listModel = new DefaultListModel<String>();

        for (String request : requestIdList) {
            String product_name = presenter.fetchRequestInformation(request)[0];
            listModel.addElement(i + " " + product_name);
            i += 1;
        }

        i = 1;
        DefaultListModel<String> listModel2 = new DefaultListModel<String>();
        for (String requestId : presenter.fetchRequestHistory(welcomePage.currUserId)) {
            String product_name = presenter.fetchRequestInformation(requestId)[0];
            listModel2.addElement(i + " " + product_name);
        }

        existingList.setModel(listModel);
        historyList.setModel(listModel2);

        existingList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    String request = existingList.getSelectedValue().toString();
                    int index = listModel.indexOf(request);
                    setVisible(false);
                    detailsPage detailspage = new detailsPage(requestIdList.get(index));
                    detailspage.setVisible(true);
                }
            }
        });
    }
}