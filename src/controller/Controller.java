package controller;

//only imports what is strictly necessary from view-package
import view.CustomBikeFrame;
import view.MainFrame;
import view.ButtonType;

public class Controller {
    private MainFrame view;
    private CustomBikeFrame newBikeType;
    private ButtonType currentLeftMenu = ButtonType.NoChoice;
    private String [] mcMenuString; // for test purposes only
    private String [] accessoriesMenuString; // for test purposes only
    private String [] orderHistoryMenuString; // for test purposes only
    private String [] order1Simulation; // for test purposes only
    private String [] currentOrderArray; // for test purposes only
    private double costCurrentOrder = 0; // for test purposes only
    private int nbrOfOrders = 0; // for test purposes only

    public Controller() {
        view = new MainFrame(1000, 500, this);
        loadStringTestValues(); //for test purposes - remove when not needed more
        view.enableAllButtons();
        view.disableAddMenuButton();
        view.disableViewSelectedOrderButton();
    }

    //This method is only used for test purposes - remove when no longer needed
    private void loadStringTestValues() {
        mcMenuString = new String[10];
        accessoriesMenuString = new String[10];
        orderHistoryMenuString = new String[10];
        order1Simulation = new String[10];
        currentOrderArray = new String[10];

        mcMenuString[0] = "mc0, storlek: 350 cc, typ: Naked, colour1, colour2, Pris0";
        mcMenuString[1] = "mc1, storlek: 500 cc, typ: Cruiser,  colour1, colour2, Pris1";
        mcMenuString[2] = "mc2, storlek: 650 cc, typ: Sport,  colour1, colour2, Pris2";
        mcMenuString[3] = "mc3, storlek: 800 cc, typ: Touring,  colour1, colour2, Pris3";

        accessoriesMenuString[0] = "Hjälm, Pris11";
        accessoriesMenuString[1] = "Sidoväska, Pris22";

        orderHistoryMenuString[0] = "order1: kostnad:100";
        orderHistoryMenuString[1] = "order2: kostand:200";

        order1Simulation[0] = "Order 1";
        order1Simulation[1] = "mc1 Pris1";
        order1Simulation[2] = "mc2 Pris2";
        order1Simulation[3] = "Hjälm Pris11";

    }

    //This method is called by class MinFrame when a button in teh GUI is pressed
    public void buttonPressed(ButtonType button){

        switch (button) {
            case Add:
                addItemToOrder(view.getSelectionLeftPanel());
                break;

            case Motorcycles:
                setToMotorcycleMenu();
                break;

            case Accessories:
                setToAccessoriesMenu();
                break;

            case CustomMotorcycle:
                addNewMotorcycle();
                break;

            case OrderHistory:
                setToOrderHistoryMenu();
                break;

            case Order:
                placeOrder();
                break;

            case ViewOrder:
                viewSelectedOrder(view.getSelectionLeftPanel());
                break;
        }
    }

    public void addItemToOrder(int selectionIndex) {
        System.out.println("Index selection left panel: " + selectionIndex); //for test purposes  - remove when not needed

        if (selectionIndex != -1){ // if something is selected in the left menu list
            switch (currentLeftMenu) { //This might need to change depending on architecture
                case Motorcycles:
                    currentOrderArray[nbrOfOrders] = mcMenuString[selectionIndex].toString(); //for test purposes - needs to be replaced with solution of finding chosen menu item matching architecture for model
                    break;
                case Accessories:
                    currentOrderArray[nbrOfOrders] = accessoriesMenuString[selectionIndex].toString(); //see comment for case above
                    break;
            }
            nbrOfOrders++; //for test purposes - need to be removed or changed when model for handling orders is implemented
            costCurrentOrder = costCurrentOrder + 100; //for test purposes - replace with calculation of cost when how orders are handled is implemented in model
            view.populateRightPanel(currentOrderArray); //update left panel with new item - this takes a shortcut in updating the entire information in the panel not just adds to the end
            view.setTextCostLabelRightPanel("Total cost of order: " + String.valueOf(costCurrentOrder)); //set the text to show cost of current order
        }

    }

    public void viewSelectedOrder(int selectionIndex){
        System.out.println("Index selection left panel: " + selectionIndex); //for test purposes  - remove when not needed

        if ((selectionIndex != -1) && currentLeftMenu==ButtonType.OrderHistory){
            costCurrentOrder = 100; //for test purposes - replace with calculation of cost when how orders are handled is implemented in model
            view.populateRightPanel(order1Simulation); //update left panel with order details - this takes a shortcut in updating the entire information in the panel not just adds to the end
            view.setTextCostLabelRightPanel("Total cost of order: " + String.valueOf(costCurrentOrder)); //set the text to show cost of current order
        }
    }

    public void setToMotorcycleMenu() {
        currentLeftMenu = ButtonType.Motorcycles;
        view.populateLeftPanel(mcMenuString);
        view.populateRightPanel(currentOrderArray); //update left panel with new item - this takes a shortcut in updating the entire information in the panel not just adds to the end
        view.setTextCostLabelRightPanel("Total cost of order: " + String.valueOf(costCurrentOrder)); //set the text to show cost of current order
        view.enableAllButtons();
        view.disableMotorcycleMenuButton();
        view.disableViewSelectedOrderButton();
    }

    public void setToAccessoriesMenu() {
        currentLeftMenu = ButtonType.Accessories;
        view.populateLeftPanel(accessoriesMenuString);
        view.populateRightPanel(currentOrderArray); //update left panel with new item - this takes a shortcut in updating the entire information in the panel not just adds to the end
        view.setTextCostLabelRightPanel("Total cost of order: " + String.valueOf(costCurrentOrder)); //set the text to show cost of current order
        view.enableAllButtons();
        view.disablePerUnitItemMenuButton();
        view.disableViewSelectedOrderButton();
    }

    public void setToOrderHistoryMenu() {
        currentLeftMenu = ButtonType.OrderHistory;
        view.clearRightPanel();
        view.populateLeftPanel(orderHistoryMenuString);
        view.enableAllButtons();
        view.disableAddMenuButton();
        view.disableOrderButton();
    }

    public void addNewMotorcycle() {
        newBikeType = new CustomBikeFrame(this);
        //For grade VG: Add more code to save the new motorcycle and update menu.
        view.enableAllButtons();
    }

    public void placeOrder() {
        System.out.println("Pressed Order to create a new order"); //for test purposes - remove when not needed more
        currentOrderArray = new String[10];  // for test purposes - remove when not needed more
        costCurrentOrder = 0;
        view.clearRightPanel(); //Removes information from right panel in GUI
        view.setTextCostLabelRightPanel("TOTAL COST: 0");
        view.enableAllButtons();
        view.disableAddMenuButton();
        view.disableViewSelectedOrderButton();
    }


}
