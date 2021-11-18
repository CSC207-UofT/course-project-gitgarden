package UI;

import Controller.ServiceController;
import Entities.*;
import UseCases.ProfileManager;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

public class existingRequests extends JFrame {
    private JPanel mainPanel;
    private JPanel titlePanel;
    private JLabel titleText;
    private JPanel listPanel;
    private JButton offerButton;
    private JButton counterButton;
    private JPanel descriptionPanel;
    private JLabel descriptionText;
    private JPanel acceptButtonPanel;
    private JButton acceptRequest;
    private JPanel declineButtonPanel;
    private JButton declineButton;
    private JPanel closeButtonPanel;
    private JButton closeButton;
    private JList<String> requestList;
    private JPanel buttonPanel;
    private JPanel counterButtonPanel;
    private JButton counterOfferButton;

    private Request tempVariable;

    public existingRequests() {
        setTitle("requestPage");
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 700);

        acceptRequest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: 2021/11/12 show message
                setVisible(false);
                if (welcomePage.flag) {
                    JOptionPane.showMessageDialog(null,"Farmer Cannot Accept A Request.");
                    acceptRequest.requestFocusInWindow();
                    JFrame farmerPage = new farmerPage();
                    farmerPage.setVisible(true);
                }
                else {
                    // Distributor dist = (Distributor) ProfileManager.currentUser;
                    Farmer farmer = tempVariable.getFarmer();

                    ServiceController.distributorAcceptOffer(farmer, (Distributor) ProfileManager.currentUser, tempVariable);

                    JOptionPane.showMessageDialog(null,"Your Offer Has Been Accepted. Thank You " +
                            ":)");
                    acceptRequest.requestFocusInWindow();

                    JFrame distributorPage = new distributorPage();
                    distributorPage.setVisible(true);
                }
            }
        });

        declineButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: 2021/11/12 show message
                setVisible(false);
                if (welcomePage.flag) {
                    JOptionPane.showMessageDialog(null,"Farmer Cannot Decline A Request.");
                    declineButton.requestFocusInWindow();
                    JFrame farmerPage = new farmerPage();
                    farmerPage.setVisible(true);
                }
                else {
                    JOptionPane.showMessageDialog(null,"Declined.");
                    declineButton.requestFocusInWindow();
                    JFrame distributorPage = new distributorPage();
                    distributorPage.setVisible(true);
                }
            }
        });

        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                if (welcomePage.flag) {
                    JFrame farmerPage = new farmerPage();
                    farmerPage.setVisible(true);
                }
                else {
                    JFrame distributorPage = new distributorPage();
                    distributorPage.setVisible(true);
                }
            }
        });

        counterOfferButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                if (welcomePage.flag) {
                    JOptionPane.showMessageDialog(null,"Farmer Cannot Create A Counter Offer To " +
                            "A Request.");
                    declineButton.requestFocusInWindow();
                    JFrame farmerPage = new farmerPage();
                    farmerPage.setVisible(true);
                } else {
                    JFrame counterOfferPage = new counterOfferPage(tempVariable);
                    counterOfferPage.setVisible(true);
                }
            }
        });

        HashMap<String, Request> requestMap = new HashMap<>();
        int i = 1;
        User user = ProfileManager.currentUser;

        ArrayList<Request> request = new ArrayList<>();

        for (Farmer farmer : ProfileManager.farmerList) {
            for (Request requests : farmer.getCurrent_requests()) {
                if (welcomePage.flag) {
                    if ((Farmer) user != farmer) {
                        request.add(requests);
                    }
                }

                else {
                    request.add(requests);
                }
            }
        }

        String [] data = new String[request.size()];

        for (Request requests : request) {
            requestMap.put(String.valueOf(i), requests);
            String product_name = requests.getProduct_name();
            data[i-1] =  i + " " + product_name;
            i += 1;
        }

        DefaultListModel<String> listModel= new DefaultListModel<String>();
        for(String item: data){
            listModel.addElement(item);
        }
        requestList.setModel(listModel);
        requestList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    String number = requestList.getSelectedValue().toString();
                    String split[] = number.split(" ");
                    String index_number = split[0];
                    Request request = requestMap.get(index_number+"");

                    tempVariable = request;

                    setVisible(false);

                    JFrame detailsPage = new detailsPage(tempVariable);
                    detailsPage.setVisible(true);
                }
            }
        });
    }
}