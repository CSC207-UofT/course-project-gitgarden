package UI;

import Controller.DataPresenter;
import Controller.IFetch;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private JPanel ratePanel;
    private JPanel rateTextPanel;
    private JLabel rateText;
    private JPanel ratingSliPanel;
    private JSlider RatingSlider;

    private final IFetch presenter = new DataPresenter();
    private final JPanel[] panelList = {mainPanel, titlePanel, detailsPanel, detailsTextPanel, detailsListPanel,
                                        buttonPanel, closeButtonPanel,ratePanel, rateTextPanel, ratingSliPanel};

    public HistoryPage(String request){
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

        if (WelcomePage.dark){
            for (JPanel p : panelList) {
                p.setBackground(new Color(0x011627));
            }
            detailsList.setBackground(new Color(0x1d3b53));
            closeButton.setForeground(new Color(0x4C566A));
        }

    }
}
