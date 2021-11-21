package UI;

import Controller.ControllerInterface;
import Controller.DataPresenter;
import Controller.IFetch;
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

public class OthersExistingRequests extends JFrame {
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

    private String tempRequest = null;
    private final IFetch presenter = new DataPresenter();
    private final ControllerInterface sc = new ServiceController();

    public OthersExistingRequests() {
        setTitle("requestPage");
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 700);

        acceptRequest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                if (WelcomePage.flag) {
                    JOptionPane.showMessageDialog(null,"Farmer Cannot Accept A Request.");
                }
                else if(tempRequest == null){
                    JOptionPane.showMessageDialog(null,"Must select A Request.");
                }
                else {
                    sc.acceptRequestCheck(tempRequest, WelcomePage.currUserId);

                    JOptionPane.showMessageDialog(null,"Your Offer Has Been Accepted. Thank You " +
                            ":)");
                }
            }
        });

        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                if (WelcomePage.flag) {
                    JFrame farmerPage = new FarmerPage();
                    farmerPage.setVisible(true);
                }
                else {
                    JFrame distributorPage = new DistributorPage();
                    distributorPage.setVisible(true);
                }
            }
        });

        counterOfferButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                if (WelcomePage.flag) {
                    JOptionPane.showMessageDialog(null,"Farmer Cannot Create A Counter Offer To " +
                            "A Request.");
                }
                else if(tempRequest == null){
                    JOptionPane.showMessageDialog(null,"Must select A Request.");
                }
                else{
                    JFrame counterOfferPage = new CounterOfferPage(tempRequest);
                    counterOfferPage.setVisible(true);
                }
            }
        });

        DefaultListModel<String> listModel = new DefaultListModel<>();
        for(String farmer: presenter.fetchAllFarmerNames()){
            if(!farmer.equals(WelcomePage.currUserId)){
                for(String requestId: presenter.fetchCurrentUserRequests(WelcomePage.currUserId)){
                    String product_name = presenter.fetchRequestInformation(requestId)[0];
                    String farmer_name = presenter.fetchUserName(farmer);
                    listModel.addElement(requestId+" "+product_name + ", "+ farmer_name);
                }
            }

        }
        requestList.setModel(listModel);
        requestList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    String selectedRequest = requestList.getSelectedValue().toString();
                    String requestId = selectedRequest.split(" ")[0];
                    tempRequest = requestId;
                }
            }
        });
    }
}