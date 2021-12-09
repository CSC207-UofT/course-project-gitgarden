package Client.UI;

import Controller.ControllerInterface;
import Controller.IFetch;

import javax.swing.*;
import java.awt.*;

public class OthersExistingRequests extends JFrame {
    private JPanel mainPanel;
    private JPanel titlePanel;
    private JLabel titleText;
    private JPanel listPanel;
    private JPanel descriptionPanel;
    private JLabel descriptionText;
    private JPanel acceptButtonPanel;
    private JButton acceptRequest;
    private JPanel closeButtonPanel;
    private JButton closeButton;
    private JList<String> requestList;
    private JPanel buttonPanel;
    private JPanel counterOfferPanel;
    private JButton counterOfferButton;
    private String tempRequest = null;

    public OthersExistingRequests(ControllerInterface controller, IFetch presenter) {
        setTitle("requestPage");
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 700);

        acceptRequest.addActionListener(e -> {
            if (WelcomePage.flag) {
                JOptionPane.showMessageDialog(null,"Farmers cannot accept requests.");
            }
            else if(tempRequest == null){
                JOptionPane.showMessageDialog(null,"Must select A Request.");
            }
            else {
                controller.acceptRequestCheck(tempRequest, WelcomePage.currUserId);

                JOptionPane.showMessageDialog(null,"Your Offer Has Been Accepted. Thank You " +
                        ":)");
                DefaultListModel<String> listModel = new DefaultListModel<>();
                for(String farmer: presenter.fetchAllFarmerNames()){
                    if(!farmer.equals(presenter.fetchUserName(WelcomePage.currUserId))){
                        for(String request: presenter.fetchCurrentUserRequests(presenter.fetchUserId(farmer))){
                            String[] info = presenter.fetchRequestInformation(request);
                            if (info[4] == null) {
                                listModel.addElement("Request ID: " + request + " , Product name: " + info[0] +
                                        ", Farmer name: " + info[3] + ", Product Quantity: " + info[1] +
                                        ", Product Price: " + info[2]);
                            }
                        }
                    }
                }
                requestList.setModel(listModel);
            }
        });

        closeButton.addActionListener(e -> {
            setVisible(false);
            if (WelcomePage.flag) {
                JFrame farmerPage = new FarmerPage(controller, presenter);
                farmerPage.setVisible(true);
            }
            else {
                JFrame distributorPage = new DistributorPage(controller, presenter);
                distributorPage.setVisible(true);
            }
        });

        counterOfferButton.addActionListener(e -> {
            if (WelcomePage.flag) {
                JOptionPane.showMessageDialog(null,"Farmer Cannot Create A Counter Offer To " +
                        "A Request.");
            }
            else if(tempRequest == null){
                JOptionPane.showMessageDialog(null,"Must select A Request.");
            }
            else{
                setVisible(false);
                JFrame counterOfferPage = new CounterOfferPage(tempRequest, controller, presenter);
                counterOfferPage.setVisible(true);
            }
        });

        DefaultListModel<String> listModel = new DefaultListModel<>();
        for(String farmer: presenter.fetchAllFarmerNames()){
            if(!farmer.equals(presenter.fetchUserName(WelcomePage.currUserId))){
                for(String request: presenter.fetchCurrentUserRequests(presenter.fetchUserId(farmer))){
                    String[] info = presenter.fetchRequestInformation(request);
                    if (info[4] == null) {
                        listModel.addElement("Request ID: " + request + " , Product name: " + info[0] +
                                ", Farmer name: " + info[3] + ", Product Quantity: " + info[1] +
                                ", Product Price: " + info[2]);
                    }
                }
            }
        }
        requestList.setModel(listModel);
        requestList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                String selectedRequest = requestList.getSelectedValue();
                tempRequest = selectedRequest.split(" ")[2];
            }
        });

        if (WelcomePage.dark){
            JPanel[] panelList = {mainPanel, titlePanel, listPanel, descriptionPanel, acceptButtonPanel,
                    closeButtonPanel, buttonPanel, counterOfferPanel};
            for (JPanel p : panelList) {
                p.setBackground(new Color(0x011627));
            }
            JLabel[] textsList = {titleText, descriptionText};
            for (JLabel t : textsList) {
                t.setForeground(new Color(0xd6deeb));
            }
            requestList.setBackground(new Color(0x1d3b53));
            requestList.setForeground(new Color(0xd6deeb));
            acceptRequest.setForeground(new Color(0x4C566A));
            counterOfferButton.setForeground(new Color(0x4C566A));
            closeButton.setForeground(new Color(0x4C566A));
        }

    }
}
