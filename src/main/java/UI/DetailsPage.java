package UI;

import Controller.ControllerInterface;
import Controller.DataPresenter;
import Controller.IFetch;
import Controller.ServiceController;
import Entities.Distributor;
import Entities.Request;
import UseCases.ProfileManager;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

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
    private JButton button1;

    private String tempRequest = null;
    private final IFetch presenter = new DataPresenter();
    private final ControllerInterface sc = new ServiceController();

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

    public DetailsPage(String request){
        setTitle("farmerPage");
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,700);

        DefaultListModel<String> listModel= new DefaultListModel<String>();
        String[] info = presenter.fetchRequestInformation(request);

        listModel.addElement("Request ID: " + request);
        listModel.addElement("Product name: " + info[0]);
        listModel.addElement("Farmer name: " + info[3]);
        listModel.addElement("Farmer address: " + presenter.fetchUserAddress(WelcomePage.currUserId));
        listModel.addElement("Product Quantity: " + info[1]);
        listModel.addElement("Product Price: " + info[2]);

        detailsList.setModel(listModel);

        acceptRequest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tempRequest == null) {
                    JOptionPane.showMessageDialog(null,"Please Select Something.");
                }
                else{
                    sc.acceptRequestCheck(tempRequest, WelcomePage.currUserId);
                }
            }
        });

        declineButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tempRequest == null) {
                    JOptionPane.showMessageDialog(null,"Please Select Something.");
                }
                else{
                    sc.declineRequestCheck(tempRequest, WelcomePage.currUserId);
                }
            }
        });
        counterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(tempRequest == null){
                    JOptionPane.showMessageDialog(null,"Please Select Something.");
                }
                else{
                    setVisible(false);
                    CounterOfferPage counterOfferPage = new CounterOfferPage(tempRequest);
                    counterOfferPage.setVisible(true);
                }
            }
        });
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                if(WelcomePage.flag){
                    JFrame farmerPage = new FarmerPage();
                    farmerPage.setVisible(true);
                }
                else{
                    JFrame distributorPage = new DistributorPage();
                    distributorPage.setVisible(true);
                }
            }
        });
        int i = 1;
        DefaultListModel<String> listModel2 = new DefaultListModel<>();
        for(String requestId: sc.rank(request, WelcomePage.currUserId)){
            String[] product_info = presenter.fetchRequestInformation(requestId);
            listModel2.addElement(i+" "+ "Name: " + product_info[0] + " Quantity: " + product_info[1] +
                    "Price :" + product_info[2] + "Rating:" + product_info[5]);
        }

        responseList.setModel(listModel2);
        responseList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    String selectedRequest = responseList.getSelectedValue().toString();
                    int index = listModel.indexOf(selectedRequest);
                    tempRequest = presenter.fetchCounteroffers(request).get(index);
                }
            }
        });
        TrashButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sc.trashRequestCheck(request);
                JOptionPane.showMessageDialog(null, "Your request has been trashed.");
                setVisible(false);
                if(WelcomePage.flag){
                    FarmerPage farmerPage = new FarmerPage();
                    farmerPage.setVisible(true);
                }
                else{
                    DistributorPage distributorPage = new DistributorPage();
                    distributorPage.setVisible(true);
                }
            }
        });
    }
}
