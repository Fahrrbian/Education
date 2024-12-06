package com.example.demo.phonebook;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class PhoneBookApp extends JPanel {
    private JTable table;
    private DefaultTableModel tableModel;
    private List<PhoneBookEntry> entries;

    private PhoneBookEntryDAO dao = new PhoneBookEntryDAO();

 // Initialisiere die Datenbankeinträge
 private void loadEntriesFromDatabase() {
     entries = dao.findAll();
     updateTable();
 }
    
    public PhoneBookApp() {
    	
        entries = new ArrayList<>();       

              
        // Layout setup
        setLayout(new BorderLayout());

        // Table setup
        tableModel = new DefaultTableModel(new String[]{"ID", "Name", "Phone Number", "Business"}, 0);
        table = new JTable(tableModel);
        add(new JScrollPane(table), BorderLayout.CENTER);

        // Buttons
        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Add");
        JButton editButton = new JButton("Edit");
        JButton deleteButton = new JButton("Delete");

        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // Button listeners
        addButton.addActionListener(e -> openEntryDialog(null));
        editButton.addActionListener(e -> editSelectedEntry());
        deleteButton.addActionListener(e -> deleteSelectedEntry());
    }

    private void openEntryDialog(PhoneBookEntry entry) {
        JDialog dialog = new JDialog();
        dialog.setSize(300, 200);
        dialog.setLayout(new GridLayout(4, 2));

        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField(entry != null ? entry.getName() : "");
        JLabel phoneLabel = new JLabel("Phone Number:");
        JTextField phoneField = new JTextField(entry != null ? entry.getPhoneNumber() : "");
        JLabel businessLabel = new JLabel("Business:");
        JCheckBox businessCheckBox = new JCheckBox();
        if (entry != null) businessCheckBox.setSelected(entry.isBusiness());

        JButton saveButton = new JButton("Save");
        JButton cancelButton = new JButton("Cancel");

        dialog.add(nameLabel);
        dialog.add(nameField);
        dialog.add(phoneLabel);
        dialog.add(phoneField);
        dialog.add(businessLabel);
        dialog.add(businessCheckBox);
        dialog.add(saveButton);
        dialog.add(cancelButton);

        saveButton.addActionListener(e -> {
            String name = nameField.getText();
            String phone = phoneField.getText();
            boolean isBusiness = businessCheckBox.isSelected();

            if (name.isEmpty() || phone.isEmpty()) {
                JOptionPane.showMessageDialog(dialog, "Name and Phone Number are required!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (entry == null) {
                PhoneBookEntry newEntry = new PhoneBookEntry(name, phone, isBusiness);
                dao.save(newEntry);
                entries.add(newEntry);
                addEntryToTable(newEntry);
            } else {
                entry.setName(name);
                entry.setPhoneNumber(phone);
                entry.setBusiness(isBusiness);
                dao.update(entry);
                updateTable();
            }

            dialog.dispose();
        });

        cancelButton.addActionListener(e -> dialog.dispose());

        dialog.setVisible(true);
    }

    private void addEntryToTable(PhoneBookEntry entry) {
        tableModel.addRow(new Object[]{entries.indexOf(entry) + 1, entry.getName(), entry.getPhoneNumber(), entry.isBusiness() ? "Yes" : "No"});
    }

    private void editSelectedEntry() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            PhoneBookEntry entry = entries.get(selectedRow);
            openEntryDialog(entry);
        } else {
            JOptionPane.showMessageDialog(this, "Please select a row to edit.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deleteSelectedEntry() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
        	PhoneBookEntry entry = entries.get(selectedRow);
        	dao.delete(entry.getId());
            entries.remove(selectedRow);          
            tableModel.removeRow(selectedRow);
        } else {
            JOptionPane.showMessageDialog(this, "Please select a row to delete.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateTable() {
        tableModel.setRowCount(0);
        for (PhoneBookEntry entry : entries) {
            addEntryToTable(entry);
        }
    }
}
