package UI;

import Entities.Distributor;
import Entities.Farmer;
import Entities.Offer;
import Entities.Request;
import UseCases.ProfileManager;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

public class distributorPage extends JFrame{
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

        HashMap<String, Request> requestMap = new HashMap<>();
        int i = 1;
        Entities.Distributor distributor = (Distributor) ProfileManager.currentUser;

        ArrayList<Request> request = distributor.getCurrent_requests();
        String [] data = new String[request.size()];

        for (Request requests : request) {
            requestMap.put(String.valueOf(i), requests);
            String product_name = requests.getProduct_name();
            data[i-1] =  i + " " + product_name;
            i += 1;
        }

        DefaultListModel<String> listModel = new DefaultListModel<String>();
        for(String item: data){
            listModel.addElement(item);
        }

        String [] data2 = new String[distributor.getOffer_history().size()];

        for (Offer pastTransaction : distributor.getOffer_history()) {
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

