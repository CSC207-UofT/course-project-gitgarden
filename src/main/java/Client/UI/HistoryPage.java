package Client.UI;

import Controller.ControllerInterface;
import Controller.IFetch;

import javax.swing.*;
import java.awt.*;

public class HistoryPage extends JFrame{
    private JPanel mainPanel;
    private JPanel titlePanel;
    private JLabel titleText;
    private JPanel detailsPanel;
    private JPanel detailsTextPanel;
    private JLabel detailsText;
    private JPanel detailsListPanel;
    private JList<String> detailsList;
    private JPanel buttonPanel;
    private JPanel closeButtonPanel;
    private JButton closeButton;

    public HistoryPage(String request, ControllerInterface controller, IFetch presenter){
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

        if (WelcomePage.dark){
            JPanel[] panelList = {mainPanel, titlePanel, detailsPanel, detailsTextPanel, detailsListPanel,
                    buttonPanel, closeButtonPanel};
            for (JPanel p : panelList) {
                p.setBackground(new Color(0x011627));
            }
            JLabel[] textsList = {titleText, detailsText};
            for (JLabel t : textsList) {
                t.setForeground(new Color(0xd6deeb));
            }
            detailsList.setBackground(new Color(0x1d3b53));
            detailsList.setForeground(new Color(0xd6deeb));
            closeButton.setForeground(new Color(0x4C566A));
        }

    }
}
