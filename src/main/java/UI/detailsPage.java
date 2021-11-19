package UI;

import Controller.ServiceController;
import Entities.Distributor;
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

public class detailsPage extends JFrame{
    private JPanel mainPanel;
    private JPanel titlePanel;
    private JLabel titleText;
    private JPanel detailsPanel;
    private JPanel detailsTextPanel;
    private JLabel detailsText;
    private JPanel detailsListPanel;
    private JList detailsList;
    private JPanel responsePanel;
    private JPanel responseTextPanel;
    private JLabel responseText;
    private JPanel responseListPanel;
    private JList responseList;
    private JPanel buttonPanel;
    private JPanel acceptButtonPanel;
    private JButton acceptRequest;
    private JPanel declineButtonPanel;
    private JButton declineButton;
    private JPanel counterButtonPanel;
    private JButton counterButton;
    private JPanel closeButtonPanel;
    private JButton closeButton;
    private JPanel descriptionPanel;
    private JLabel descriptionText;

    private ArrayList<Request> tempRequests;
    private Request tempVariable;

    /**
    public void addDetails(Request request) {

        DefaultListModel<String> listModel= new DefaultListModel<String>();

        listModel.addElement("Request ID: " + request.getRequest_id());
        listModel.addElement("Product name: " + request.getProduct_name());
        listModel.addElement("Farmer name: " + request.getFarmer().getUser_name());
        listModel.addElement("Farmer address: " + request.getFarmer().getUser_address());
        listModel.addElement("Product Quantity: " + request.getProduct_quantity());
        listModel.addElement("Product Price: " + request.getProduct_price_per_unit());

        detailsList.setModel(listModel);
    } */

    public detailsPage(Request request){
        setTitle("farmerPage");
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,700);

        DefaultListModel<String> listModel= new DefaultListModel<String>();

        for (Farmer farmer : ProfileManager.farmerList) {
            if (farmer.getUser_name().equals(request.farmer_name)){
                request.farmer = farmer;
            }
        }

        listModel.addElement("Request ID: " + request.getRequest_id());
        listModel.addElement("Product name: " + request.getProduct_name());
        listModel.addElement("Farmer name: " + request.getFarmer().getUser_name());
        listModel.addElement("Farmer address: " + request.getFarmer().getUser_address());
        listModel.addElement("Product Quantity: " + request.getProduct_quantity());
        listModel.addElement("Product Price: " + request.getProduct_price_per_unit());

        detailsList.setModel(listModel);

        acceptRequest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);

                if (welcomePage.flag) {
                    if (tempVariable == null) {
                        JOptionPane.showMessageDialog(null,"Please Select Something.");
                        acceptRequest.requestFocusInWindow();
                    }

                    Farmer farmer = (Farmer) ProfileManager.currentUser;

                    for (Distributor distributor : ProfileManager.distributorList) {
                        if (distributor.current_requests.contains(tempVariable)) {
                            Distributor dist = distributor;
                            ServiceController.farmerAcceptOffer(farmer, dist, tempVariable);
                            break;
                        }
                    }

                    JFrame farmerPage = new farmerPage();
                    farmerPage.setVisible(true);
                }

                else{
                    JOptionPane.showMessageDialog(null,"Sorry! You Cannot Accept Your Own Offer.");
                    acceptRequest.requestFocusInWindow();

                    JFrame distributorPage = new distributorPage();
                    distributorPage.setVisible(true);
                }
            }
        });

        declineButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);

                if (welcomePage.flag) {
                    JOptionPane.showMessageDialog(null,"Declined.");
                    acceptRequest.requestFocusInWindow();

                    JFrame farmerPage = new farmerPage();
                    farmerPage.setVisible(true);
                }

                else{
                    JOptionPane.showMessageDialog(null,"Declined");
                    acceptRequest.requestFocusInWindow();

                    JFrame distributorPage = new distributorPage();
                    distributorPage.setVisible(true);
                }

            }
        });
        counterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                counterOfferPage counterOfferPage = new counterOfferPage(tempVariable);
                counterOfferPage.setVisible(true);
            }
        });
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                if(welcomePage.flag){
                    JFrame farmerPage = new farmerPage();
                    farmerPage.setVisible(true);
                }
                else{
                    JFrame distributorPage = new distributorPage();
                    distributorPage.setVisible(true);
                }
            }
        });

        HashMap<String, Request> requestMap = new HashMap<>();
        int i = 1;

        if (welcomePage.flag) {
            System.out.println(tempVariable);
            //Entities.Farmer farmer = (Farmer) ProfileManager.currentUser;
            System.out.println(request);
            tempRequests = request.counteroffer;
            // tempRequest = request;
        }

        else {
            Entities.Distributor distributor = (Distributor) ProfileManager.currentUser;
            tempRequests = distributor.getCurrent_requests();
        }

        String [] data = new String[tempRequests.size()];

        for (Request requests : tempRequests) {
            requestMap.put(String.valueOf(i), requests);
            String product_name = requests.getProduct_name();
            data[i-1] =  i + " " + product_name;
            i += 1;
        }

        DefaultListModel<String> listModel2 = new DefaultListModel<String>();
        for(String item: data){
            listModel2.addElement(item);
        }

        responseList.setModel(listModel2);
        responseList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    String number = responseList.getSelectedValue().toString();
                    String split[] = number.split(" ");
                    String index_number = split[0];
                    Request request = requestMap.get(index_number+"");

                    tempVariable = request;

                    setVisible(false);
                }
            }
        });
    }
}
