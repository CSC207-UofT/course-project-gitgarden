package Client.UI;

import Controller.ControllerInterface;
import Controller.IFetch;

import javax.swing.*;
import java.awt.*;

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
                JOptionPane.showMessageDialog(null,"Accepted");
                int i = 1;
                DefaultListModel<String> listModel2 = new DefaultListModel<>();
                for(String requestId: controller.rank(request, WelcomePage.currUserId)){
                    String[] product_info = presenter.fetchRequestInformation(requestId);
                    listModel2.addElement(i+" "+ "Name: " + product_info[0] + " Quantity: " + product_info[1] +
                            "Price :" + product_info[2]);
                }

                responseList.setModel(listModel2);
            }
        });

        declineButton.addActionListener(e -> {
            if (tempRequest == null) {
                JOptionPane.showMessageDialog(null,"Please Select Something.");
            }
            else{
                controller.declineRequestCheck(tempRequest);
                JOptionPane.showMessageDialog(null,"Declined");
                int i = 1;
                DefaultListModel<String> listModel2 = new DefaultListModel<>();
                for(String requestId: controller.rank(request, WelcomePage.currUserId)){
                    String[] product_info = presenter.fetchRequestInformation(requestId);
                    listModel2.addElement(i+" "+ "Name: " + product_info[0] + " Quantity: " + product_info[1] +
                            "Price :" + product_info[2]);
                }

                responseList.setModel(listModel2);
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
            if(WelcomePage.flag){
                setVisible(false);
                JFrame farmerPage = new FarmerPage(controller, presenter);
                farmerPage.setVisible(true);
            }
            else{
                setVisible(false);
                JFrame distributorPage = new DistributorPage(controller, presenter);
                distributorPage.setVisible(true);
            }
        });
        int i = 1;
        DefaultListModel<String> listModel2 = new DefaultListModel<>();
        for(String requestId: controller.rank(request, WelcomePage.currUserId)){
            String[] product_info = presenter.fetchRequestInformation(requestId);
            listModel2.addElement(i+" "+ "Name: " + product_info[3] + " Quantity: " + product_info[1] +
                    "Price :" + product_info[2]);
        }

        responseList.setModel(listModel2);
        responseList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                String selectedRequest = responseList.getSelectedValue();
                int index = listModel2.indexOf(selectedRequest);
                try {
                    tempRequest = presenter.fetchCounteroffers(request).get(index);
                }
                catch (Exception exception){
                    JOptionPane.showMessageDialog(null, "There are no more counterOffers");
                }
            }
        });
        TrashButton.addActionListener(e -> {
            controller.trashRequestCheck(request);
            JOptionPane.showMessageDialog(null, "Your request has been trashed.");
            if(WelcomePage.flag){
                setVisible(false);
                JFrame farmerPage = new FarmerPage(controller, presenter);
                farmerPage.setVisible(true);
            }
            else{
                setVisible(false);
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
            JLabel[] textsList = {titleText, detailsText, responseText, descriptionText};
            for (JLabel t : textsList) {
                t.setForeground(new Color(0xd6deeb));
            }
            detailsList.setBackground(new Color(0x1d3b53));
            responseList.setBackground(new Color(0x1d3b53));
            detailsList.setForeground(new Color(0xd6deeb));
            responseList.setForeground(new Color(0xd6deeb));
            acceptRequest.setForeground(new Color(0x4C566A));
            declineButton.setForeground(new Color(0x4C566A));
            counterButton.setForeground(new Color(0x4C566A));
            TrashButton.setForeground(new Color(0x4C566A));
            closeButton.setForeground(new Color(0x4C566A));
        }

    }
}
