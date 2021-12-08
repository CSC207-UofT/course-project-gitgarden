package Client.UI;

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
    private JPanel closeButtonPanel;
    private JButton closeButton;
    private JList<String> requestList;
    private JPanel buttonPanel;
    private JPanel counterOfferPanel;
    private JButton counterOfferButton;

    private String tempRequest = null;
    private final IFetch presenter = new DataPresenter();
    private final ControllerInterface sc = new ServiceController();
    private final JPanel[] panelList = {mainPanel, titlePanel, listPanel, descriptionPanel, acceptButtonPanel, 
                                        closeButtonPanel, buttonPanel, counterOfferPanel};

    public OthersExistingRequests() {
        setTitle("requestPage");
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 700);

        acceptRequest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (WelcomePage.flag) {
                    JOptionPane.showMessageDialog(null,"Farmers cannot accept requests.");
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
                if (WelcomePage.flag) {
                    JOptionPane.showMessageDialog(null,"Farmer Cannot Create A Counter Offer To " +
                            "A Request.");
                }
                else if(tempRequest == null){
                    JOptionPane.showMessageDialog(null,"Must select A Request.");
                }
                else{
                    setVisible(false);
                    JFrame counterOfferPage = new CounterOfferPage(tempRequest);
                    counterOfferPage.setVisible(true);
                }
            }
        });

        DefaultListModel<String> listModel = new DefaultListModel<>();
        for(String farmer: presenter.fetchAllFarmerNames()){
            if(!farmer.equals(presenter.fetchUserName(WelcomePage.currUserId))){
                for(String request: presenter.fetchCurrentUserRequests(presenter.fetchUserId(farmer))){
                    String[] info = presenter.fetchRequestInformation(request);
                    listModel.addElement("Request ID: " + request + ", Product name: " + info[0] +
                            ", Farmer name: " + info[3] + ", Product Quantity: " + info[1] +
                            ", Product Price: " + info[2]);
                }
            }
        }
        requestList.setModel(listModel);
        requestList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    String selectedRequest = requestList.getSelectedValue().toString();
                    tempRequest = selectedRequest.split(" ")[0];
                }
            }
        });

        if (WelcomePage.dark){
            for (JPanel p : panelList) {
                p.setBackground(new Color(0x011627));
            }
            requestList.setBackground(new Color(0x1d3b53));
            requestList.setForeground(new Color(0xECEFF4));
            acceptRequest.setForeground(new Color(0x4C566A));
            counterOfferButton.setForeground(new Color(0x4C566A));
            closeButton.setForeground(new Color(0x4C566A));
        }

    }
}
