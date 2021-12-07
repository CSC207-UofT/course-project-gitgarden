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

public class DetailsPage extends JFrame{
    private JPanel mainPanel;
    private JPanel titlePanel;
    private JLabel titleText;
    private JPanel detailsPanel;
    private JPanel detailsTextPanel;
    private JLabel detailsText;
    private JPanel detailsListPanel;
    private JList<String> detailsList;
    private JPanel responsePanel;
    private JPanel responseTextPanel;
    private JLabel responseText;
    private JPanel responseListPanel;
    private JList<String> responseList;
    private JButton acceptRequest;
    private JButton declineButton;
    private JButton counterButton;
    private JButton closeButton;
    private JPanel descriptionPanel;
    private JLabel descriptionText;
    private JPanel buttonPanel;
    private JPanel acceptButtonPanel;
    private JPanel declineButtonPanel;
    private JPanel counterButtonPanel;
    private JPanel closeButtonPanel;
    private JPanel trashButtonPanel;
    private JButton TrashButton;
    private JCheckBox RankingButton;

    private String tempRequest = null;

    public DetailsPage(String request, ControllerInterface controller, IFetch presenter){
        setTitle("farmerPage");
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,700);

        DefaultListModel<String> listModel= new DefaultListModel<>();
        String[] info = presenter.fetchRequestInformation(request);

        listModel.addElement("Request ID: " + request);
        listModel.addElement("Product name: " + info[0]);
        listModel.addElement("Farmer name: " + info[3]);
        listModel.addElement("Farmer address: " + presenter.fetchUserAddress(WelcomePage.currUserId));
        listModel.addElement("Product Quantity: " + info[1]);
        listModel.addElement("Product Price: " + info[2]);

        detailsList.setModel(listModel);

        acceptRequest.addActionListener(e -> {
            if (tempRequest == null) {
                JOptionPane.showMessageDialog(null,"Please Select Something.");
            }
            else{
                controller.acceptRequestCheck(tempRequest, WelcomePage.currUserId);
            }
        });

        declineButton.addActionListener(e -> {
            if (tempRequest == null) {
                JOptionPane.showMessageDialog(null,"Please Select Something.");
            }
            else{
                controller.declineRequestCheck(tempRequest, WelcomePage.currUserId);
            }
        });
        counterButton.addActionListener(e -> {
            if(tempRequest == null){
                JOptionPane.showMessageDialog(null,"Please Select Something.");
            }
            else{
                setVisible(false);
                CounterOfferPage counterOfferPage = new CounterOfferPage(tempRequest, controller, presenter);
                counterOfferPage.setVisible(true);
            }
        });
        closeButton.addActionListener(e -> {
            setVisible(false);
            if(WelcomePage.flag){
                JFrame farmerPage = new FarmerPage(controller, presenter);
                farmerPage.setVisible(true);
            }
            else{
                JFrame distributorPage = new DistributorPage(controller, presenter);
                distributorPage.setVisible(true);
            }
        });
        int i = 1;
        DefaultListModel<String> listModel2 = new DefaultListModel<>();
        for(String requestId: controller.rank(request, WelcomePage.currUserId)){
            String[] product_info = presenter.fetchRequestInformation(requestId);
            listModel2.addElement(i+" "+ "Name: " + product_info[0] + " Quantity: " + product_info[1] +
                    "Price :" + product_info[2]);
        }

        responseList.setModel(listModel2);
        responseList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                String selectedRequest = responseList.getSelectedValue();
                int index = listModel.indexOf(selectedRequest);
                tempRequest = presenter.fetchCounteroffers(request).get(index);
            }
        });
        TrashButton.addActionListener(e -> {
            controller.trashRequestCheck(request);
            JOptionPane.showMessageDialog(null, "Your request has been trashed.");
            setVisible(false);
            if(WelcomePage.flag){
                JFrame farmerPage = new FarmerPage(controller, presenter);
                farmerPage.setVisible(true);
            }
            else{
                JFrame distributorPage = new DistributorPage(controller, presenter);
                distributorPage.setVisible(true);
            }
        });

        if (WelcomePage.dark){
            JPanel[] panelList = {mainPanel, titlePanel, detailsPanel, detailsTextPanel, detailsListPanel,
                    responsePanel, responseTextPanel, responseListPanel, descriptionPanel,
                    buttonPanel, acceptButtonPanel, declineButtonPanel, counterButtonPanel,
                    closeButtonPanel, trashButtonPanel};
            for (JPanel p : panelList) {
                p.setBackground(new Color(0x011627));
            }
            detailsList.setBackground(new Color(0x1d3b53));
            responseList.setBackground(new Color(0x1d3b53));
            acceptRequest.setForeground(new Color(0x4C566A));
            declineButton.setForeground(new Color(0x4C566A));
            counterButton.setForeground(new Color(0x4C566A));
            TrashButton.setForeground(new Color(0x4C566A));
            closeButton.setForeground(new Color(0x4C566A));
        }

    }
}
