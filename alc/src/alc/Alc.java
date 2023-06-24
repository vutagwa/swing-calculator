/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alc;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Alc extends JFrame implements ActionListener {

    /**
     * @param args the command line arguments
     */
   

    private JTextField displayField;

    public Alc() {
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        displayField = new JTextField(10);
        displayField.setHorizontalAlignment(JTextField.RIGHT);
        displayField.setEditable(false);
        displayField.setFont(new Font("Arial", Font.PLAIN, 20));

        JPanel buttonPanel = new JPanel(new GridLayout(4, 4, 5, 5));

        String[] buttonLabels = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+"
        };

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.setFont(new Font("Arial", Font.PLAIN, 20));
            button.addActionListener(this);
            buttonPanel.add(button);
        }

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(displayField, BorderLayout.NORTH);
        getContentPane().add(buttonPanel, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equals("=")) {
            String expression = displayField.getText();
            try {
                double result = evaluateExpression(expression);
                displayField.setText(Double.toString(result));
            } catch (Exception ex) {
                displayField.setText("Error");
            }
        } else {
            displayField.setText(displayField.getText() + command);
        }
    }

    private double evaluateExpression(String expression) {
        // Evaluate the expression using your own logic or a library
        // For simplicity, we'll use a dummy implementation here
        return 0.0;
    }

     public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Alc().setVisible(true);
            }
        });
    }
}
 
    
