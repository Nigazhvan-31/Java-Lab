/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.currencyconvertor;

/**
 *
 * @author Nigazhvan
 */
import javax.swing.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.awt.Font;
import java.awt.Color;

public class CurrencyConverter extends javax.swing.JFrame {
    
    private javax.swing.JButton convertButton;
    private javax.swing.JButton clearButton;
    private javax.swing.JButton exitButton;
    private javax.swing.JComboBox<String> fromCurrency;
    private javax.swing.JComboBox<String> toCurrency;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JLabel amountLabel;
    private javax.swing.JLabel fromLabel;
    private javax.swing.JLabel toLabel;
    private javax.swing.JLabel resultLabel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JTextField amountField;
    private javax.swing.JTextField resultField;
    
    // Exchange rates (using USD as base)
    private final double[] rates = {
        1.0,    // USD
        0.85,   // EUR
        0.73,   // GBP
        110.0,  // JPY
        75.0,   // INR
        1.35    // CAD
    };
    
    public CurrencyConverter() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    private void initComponents() {
        headerPanel = new javax.swing.JPanel();
        mainPanel = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        amountLabel = new javax.swing.JLabel();
        fromLabel = new javax.swing.JLabel();
        toLabel = new javax.swing.JLabel();
        resultLabel = new javax.swing.JLabel();
        amountField = new javax.swing.JTextField();
        resultField = new javax.swing.JTextField();
        convertButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        
        String[] currencies = {"USD", "EUR", "GBP", "JPY", "INR", "CAD"};
        fromCurrency = new javax.swing.JComboBox<>(currencies);
        toCurrency = new javax.swing.JComboBox<>(currencies);
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Currency Converter");
        setResizable(false);
        
        // Header Panel Setup
        headerPanel.setBackground(new Color(41, 128, 185));
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setText("Currency Converter");
        headerPanel.add(titleLabel);
        
        // Main Panel Setup
        mainPanel.setBackground(new Color(236, 240, 241));
        
        amountLabel.setFont(new Font("Arial", Font.BOLD, 14));
        amountLabel.setText("Amount:");
        
        fromLabel.setFont(new Font("Arial", Font.BOLD, 14));
        fromLabel.setText("From Currency:");
        
        toLabel.setFont(new Font("Arial", Font.BOLD, 14));
        toLabel.setText("To Currency:");
        
        resultLabel.setFont(new Font("Arial", Font.BOLD, 14));
        resultLabel.setText("Result:");
        
        resultField.setEditable(false);
        
        // Button Setup
        convertButton.setFont(new Font("Arial", Font.BOLD, 14));
        convertButton.setText("Convert");
        convertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                convertCurrency();
            }
        });
        
        clearButton.setFont(new Font("Arial", Font.BOLD, 14));
        clearButton.setText("Clear");
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                clearFields();
            }
        });
        
        exitButton.setFont(new Font("Arial", Font.BOLD, 14));
        exitButton.setText("Exit");
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                System.exit(0);
            }
        });
        
        // Layout Setup
        GroupLayout mainPanelLayout = new GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(amountLabel)
                        .addGap(18, 18, 18)
                        .addComponent(amountField, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(fromLabel)
                        .addGap(18, 18, 18)
                        .addComponent(fromCurrency, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(toLabel)
                        .addGap(18, 18, 18)
                        .addComponent(toCurrency, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(resultLabel)
                        .addGap(18, 18, 18)
                        .addComponent(resultField, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(convertButton)
                        .addGap(10, 10, 10)
                        .addComponent(clearButton)
                        .addGap(10, 10, 10)
                        .addComponent(exitButton)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(amountLabel)
                    .addComponent(amountField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(fromLabel)
                    .addComponent(fromCurrency, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(toLabel)
                    .addComponent(toCurrency, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(resultLabel)
                    .addComponent(resultField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(convertButton)
                    .addComponent(clearButton)
                    .addComponent(exitButton))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        
        // Main Frame Layout
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(headerPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(mainPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(headerPanel, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                .addComponent(mainPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        
        pack();
    }
    
    private void convertCurrency() {
        try {
            double amount = Double.parseDouble(amountField.getText());
            int fromIndex = fromCurrency.getSelectedIndex();
            int toIndex = toCurrency.getSelectedIndex();
            
            // Convert to USD first (if not already USD)
            double usdAmount = amount / rates[fromIndex];
            // Convert from USD to target currency
            double result = usdAmount * rates[toIndex];
            
            DecimalFormat df = new DecimalFormat("#.##");
            resultField.setText(df.format(result));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void clearFields() {
        amountField.setText("");
        resultField.setText("");
        fromCurrency.setSelectedIndex(0);
        toCurrency.setSelectedIndex(0);
        amountField.requestFocus();
    }
    
    public static void main(String args[]) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CurrencyConverter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(() -> {
            new CurrencyConverter().setVisible(true);
        });
    }
}