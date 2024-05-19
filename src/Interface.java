import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interface {

    static JFrame startFrame = new JFrame();
    JFrame addWarehouseFrame = new JFrame();
    JButton openWarehouseButton = new JButton(" Open Warehouse ");
    JButton closeProgramButton = new JButton(" Close Management System ");
    JButton addWarehouseButton;
    JButton addWarehouse = new JButton("Add");
    JButton closeAddingWarehouse = new JButton("Close");

    JTable warehousesTable;

    JTextField newWarehouseID = new JTextField();
    JTextField newWarehouseName = new JTextField();
    JTextField newWarehouseCity = new JTextField();

    JLabel newWarehouseIDLabel = new JLabel("Write new warehouse ID:");
    JLabel newWarehouseNameLabel = new JLabel("Write new warehouse name:");
    JLabel newWarehouseCityLabel = new JLabel("Write new warehouse city:");

    String[] columnNames = {"Warehouse ID", "Name", "City"};
    String[][] data = {
            {"5002", "pups", "Gdon"},
            {"123", "KUp", "Warszawa"}
    };

    DefaultTableModel model = new DefaultTableModel(data, columnNames);

    void startMenu(){
        setOpenWarehouseButton();
        setCloseProgramButton();
        setWarehousesTable();
        setAddWarehouseButton();
        setStartFrame();
    }

    void setStartFrame(){
        startFrame.setSize(600,500);
        startFrame.setLocationRelativeTo(null);
        startFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        startFrame.setResizable(false);

        startFrame.setLayout(null);
        startFrame.setVisible(true);
    }

    void setCloseProgramButton(){
        closeProgramButton.setBounds(350,420, 200, 30);
        closeProgramButton.setFocusable(false);
        closeProgramButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        startFrame.add(closeProgramButton);
    }

    void setOpenWarehouseButton(){
        openWarehouseButton.setBounds(50,420, 200,30);
        openWarehouseButton.setFocusable(false);
        startFrame.add(openWarehouseButton);
    }

    void setWarehousesTable(){
        warehousesTable = new JTable(model);
        warehousesTable.setBounds(10,10,570, 400);

        JScrollPane sp = new JScrollPane(warehousesTable);
        sp.setBounds(10,10,570,400);
        startFrame.add(sp);
    }

    void setAddWarehouseButton(){
        addWarehouseButton = new JButton() {
            // To properly display "+" (because default font was to big)
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.BLACK);
                FontMetrics metrics = g.getFontMetrics();
                int x = (getWidth() - metrics.stringWidth(getText())-6) / 2; // Obliczenie pozycji X znaku
                int y = ((getHeight() - metrics.getHeight()-1) / 2) + metrics.getAscent(); // Obliczenie pozycji Y znaku
                g.drawString("+", x, y); // Narysowanie znaku
            }
        };

        addWarehouseButton.setBounds(560,410, 15, 15);
        addWarehouseButton.setFocusable(false);
        addWarehouseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setAddWarehouseFrame();
            }
        });
        startFrame.add(addWarehouseButton);
    }

    void setAddWarehouseFrame(){
        addWarehouseFrame.setSize(300,250);
        addWarehouseFrame.setLocationRelativeTo(null);
        addWarehouseFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addWarehouseFrame.setResizable(false);

        setAddWarehouseLabels();
        setAddWarehouseTextFields();
        setAddWarehouseButtons();

        addWarehouseFrame.setLayout(null);
        addWarehouseFrame.setVisible(true);
    }

    void setAddWarehouseLabels(){
        newWarehouseIDLabel.setBounds(5, 5, 200, 15);
        newWarehouseNameLabel.setBounds(5, 45, 200, 15);
        newWarehouseCityLabel.setBounds(5, 85, 200, 15);

        addWarehouseFrame.add(newWarehouseIDLabel);
        addWarehouseFrame.add(newWarehouseNameLabel);
        addWarehouseFrame.add(newWarehouseCityLabel);

        newWarehouseIDLabel.setVisible(true);
        newWarehouseNameLabel.setVisible(true);
        newWarehouseCityLabel.setVisible(true);
    }

    void setAddWarehouseTextFields(){
        newWarehouseID.setBounds(10, 20, 200, 20);
        newWarehouseName.setBounds(10, 60, 200, 20);
        newWarehouseCity.setBounds(10, 100, 200, 20);


        addWarehouseFrame.add(newWarehouseID);
        addWarehouseFrame.add(newWarehouseName);
        addWarehouseFrame.add(newWarehouseCity);

        newWarehouseID.setVisible(true);
        newWarehouseName.setVisible(true);
        newWarehouseCity.setVisible(true);

    }

    void setAddWarehouseButtons(){
        addWarehouseFrame.add(addWarehouse);
        addWarehouseFrame.add(closeAddingWarehouse);

        addWarehouse.setBounds(10, 150, 70, 20);
        closeAddingWarehouse.setBounds(140, 150, 70, 20);
        addWarehouse.setFocusable(false);
        closeAddingWarehouse.setFocusable(false);

        closeAddingWarehouse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addWarehouseFrame.setVisible(false);
            }
        });

        if (addWarehouse.getActionListeners().length == 0) { // Avoiding creating multiple ActionListeners
            addWarehouse.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String[] newData = {"12367", "klok", "brand"}; //DODAĆ UZUPEŁNANIE DO TABELI DANYCH Z FORMULARZA!!!!
                    model.addRow(newData);                          //DODAĆ ZAPAMIĘTANIE DODANYCH DANYCH!!!!!!
                    addWarehouseFrame.setVisible(false);
                }
            });
        }

        addWarehouse.setVisible(true);
        closeAddingWarehouse.setVisible(true);
    }
}
