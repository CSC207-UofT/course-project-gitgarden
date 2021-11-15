package UI;

import Entities.Farmer;
import Entities.Request;
import UseCases.ProfileManager;

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

        HashMap<String, Request> requestMap = new HashMap<>();
        int i = 1;
        Entities.Farmer farmer = (Farmer) ProfileManager.currentUser;
        ArrayList<Request> requests = farmer.current_requests;
        String [] data = new String[requests.size()];

        for (Request request : requests) {
            requestMap.put(String.valueOf(i), request);
            String product_name = request.getProduct_name();
            data[i-1] =  i + " " + product_name;
            i += 1;
        }

        DefaultListModel<String> listModel = new DefaultListModel<String>();
        for(String item: data){
            listModel.addElement(item);
        }

        String [] data2 = new String[farmer.getOffer_history().size()];

        for (Request pastTransaction : farmer.getOffer_history()) {
            String product_name = pastTransaction.getProduct_name();
            data2[i-1] =  i + " " + product_name;
            i += 1;
        }

        DefaultListModel<String> listModel2 = new DefaultListModel<String>();
        for(String item: data2){
            listModel.addElement(item);
        }

        existingList.setModel(listModel);
        historyList.setModel(listModel2);

        existingList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    String number = existingList.getSelectedValue().toString();
                    String split[] = number.split(" ");
                    String index_number = split[0];
                    Request request = requestMap.get(index_number+"");

                    setVisible(false);

                    detailsPage detailspage = new detailsPage(request);

                    detailspage.setVisible(true);
                }
            }
        });
    }
}