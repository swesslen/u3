package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LPanel extends JPanel implements ActionListener {
    private JList<Object> leftPanelList;
    private JButton btnShowAccessories;
    private JButton btnShowMotorcycles;
    private JButton btnShowOrderHistory;
    private JButton btnCustomMotorcycle;
    private JButton btnAddSelectionToOrder;
    private JLabel titleLeftPanel;

    private int width;
    private int height;

    private MainFrame mainFrame;

    public LPanel(int width, int height, MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        this.setLayout(null);
        this.width = width;
        this.height = height;
        this.setSize(width, height);
        setLocation(0, 0);
        setUp();
    }

    private void setUp() {
        titleLeftPanel = new JLabel("Make menu choice with buttons");
        titleLeftPanel.setLocation(20, 0);
        titleLeftPanel.setSize(width/2, 20);
        this.add(titleLeftPanel);

        leftPanelList = new JList<>();
        leftPanelList.setLocation(0, 23);
        leftPanelList.setSize(width, height - 100);
        this.add(leftPanelList);

        btnShowMotorcycles = new JButton("Motorcycles");
        btnShowMotorcycles.setEnabled(true);
        btnShowMotorcycles.setSize(width / 5, 30);
        btnShowMotorcycles.setLocation(0, height - 75);
        btnShowMotorcycles.addActionListener(this);
        this.add(btnShowMotorcycles);

        btnShowAccessories = new JButton("Accessories");
        btnShowAccessories.setEnabled(true);
        btnShowAccessories.setSize(width / 5, 30);
        btnShowAccessories.setLocation(width / 5, height - 75);
        btnShowAccessories.addActionListener(this);
        this.add(btnShowAccessories);

        btnCustomMotorcycle = new JButton("Custom Motorcycle");
        btnCustomMotorcycle.setEnabled(true);
        btnCustomMotorcycle.setSize(width / 5, 30);
        btnCustomMotorcycle.setLocation((width / 5)*2, height - 75);
        btnCustomMotorcycle.addActionListener(this); // For VG task
        this.add(btnCustomMotorcycle);

        btnAddSelectionToOrder = new JButton("Add");
        btnAddSelectionToOrder.setEnabled(true);
        btnAddSelectionToOrder.setSize(width / 5, 30);
        btnAddSelectionToOrder.addActionListener(this);
        btnAddSelectionToOrder.setLocation((width / 5)*3, height - 75);
        this.add(btnAddSelectionToOrder);

        btnShowOrderHistory = new JButton("Order history");
        btnShowOrderHistory.setEnabled(true);
        btnShowOrderHistory.setSize(width / 5, 30);
        btnShowOrderHistory.setLocation((width/5)*4, height - 75);
        btnShowOrderHistory.addActionListener(this);
        this.add(btnShowOrderHistory);
    }

    protected JList<Object> getLeftPanelList() {
        return leftPanelList;
    }

    protected JButton getShowOrderHistory() {
        return btnShowOrderHistory;
    }

    protected JButton getBtnShowAccessories() {
        return btnShowAccessories;
    }

    protected JButton getBtnShowMotorcycles() { return btnShowMotorcycles; }

    protected JButton getBtnAddSelectionToOrder() { return btnAddSelectionToOrder; }

    protected JButton getBtnCustomMotorcycle() { return btnCustomMotorcycle; }

    /**
     * This method sets the information in the panel's list view.
     *
     * @param informationArray An array of String where each element will be shown as
     *                        one line in the panel.
     */
    public void populateList(String[] informationArray){
        leftPanelList.setListData(informationArray);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.btnAddSelectionToOrder){
            this.mainFrame.buttonPressed(ButtonType.Add);
        }
        if (e.getSource() == this.btnShowAccessories){
            this.mainFrame.buttonPressed(ButtonType.Accessories);
        }
        if (e.getSource() == this.btnCustomMotorcycle){
            this.mainFrame.buttonPressed(ButtonType.CustomMotorcycle);
        }
        if (e.getSource() == this.btnShowMotorcycles){
            this.mainFrame.buttonPressed(ButtonType.Motorcycles);
        }
        if (e.getSource() == this.btnShowOrderHistory){
            this.mainFrame.buttonPressed(ButtonType.OrderHistory);
        }
    }
}
