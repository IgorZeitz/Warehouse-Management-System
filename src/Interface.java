import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interface {

    static JFrame startFrame = new JFrame();
    JFrame addWarehouseFrame = new JFrame();
    JButton openWarehouseButton = new JButton(" Open Warehouse ");
    JButton closeProgramButton = new JButton(" Close Management System ");
    JButton addWarehouseButton;// = new JButton("+");

    JTable warehousesTable; //= new JTable(columnNames);

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
        String[] columnNames = {"Warehouse ID", "Name", "City"};
        String[][] data = {
                {"5002", "Pupa", "Gdańsk"},
                {"123", "KUPSON", "Warszawa"}
        };

        warehousesTable = new JTable(data, columnNames);
        warehousesTable.setBounds(10,10,570, 400);

        JScrollPane sp = new JScrollPane(warehousesTable);
        sp.setBounds(10,10,570,400);
        startFrame.add(sp);
    }

    void setAddWarehouseButton(){
        addWarehouseButton = new JButton() {
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
                //Otworzenie formularza do dodania magazynu
                //i dodanie do warehousesTable
            }
        });
        startFrame.add(addWarehouseButton);
    }

    void setAddWarehouseFrame(){
        addWarehouseFrame.setSize(300,250);
        addWarehouseFrame.setLocationRelativeTo(null);
        addWarehouseFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addWarehouseFrame.setResizable(false);

        addWarehouseFrame.setLayout(null);
        addWarehouseFrame.setVisible(true);
    }

}
