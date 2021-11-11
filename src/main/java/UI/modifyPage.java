package UI;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class modifyPage extends JFrame{
    private JPanel titlePanel;
    private JLabel titleText;
    private JPanel middlePanel;
    private JPanel textPanel;
    private JPanel namePanel;
    private JLabel nameText;
    private JPanel pricePanel;
    private JLabel addressText;
    private JPanel preferencePanel;
    private JPanel inputPanel;
    private JPanel prefInputPanel;
    private JPanel nameInputPanel;
    private JTextField nameInput;
    private JPanel priceInputPanel;
    private JTextField addressInput;
    private JPanel mainPanel;
    private JPanel buttonPanel;
    private JButton createButton;
    private JSlider slider1;
    private JLabel priceText;
    private JLabel exposureText;
    private JLabel speedText;
    private JLabel carbonText;
    private JSlider slider2;
    private JPanel JPanel;
    private JSlider slider3;
    private JSlider slider4;

    public modifyPage(){
        setTitle("modifyPage");
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,700);
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: 2021/11/11
                if (welcomePage.flag) {
                    farmerPage farmerPage = new farmerPage();
                    setVisible(false);
                    farmerPage.setVisible(true);
                }
                else{
                    distributorPage distributorPage = new distributorPage();
                    setVisible(false);
                    distributorPage.setVisible(true);
                }
            }
        });
        nameInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newUserName = nameInput.getText();
                // TODO: 2021/11/11  
            }
        });
        addressInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String address = addressInput.getText();
                // TODO: 2021/11/11  
            }
        });
        slider1.setPaintTicks(true);
        slider1.setMinorTickSpacing(10);
        slider2.setPaintTicks(true);
        slider2.setMinorTickSpacing(10);
        slider3.setPaintTicks(true);
        slider3.setMinorTickSpacing(10);
        slider4.setPaintTicks(true);
        slider4.setMinorTickSpacing(10);
        slider1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                double score = slider1.getValue();
            }
        });
        slider2.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                double score = slider1.getValue();
            }
        });
        slider3.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                double score = slider1.getValue();
                System.out.print(score);
            }
        });
        slider4.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                double score = slider1.getValue();
            }
        });
        }
        
}
