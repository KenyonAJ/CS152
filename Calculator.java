import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.text.DecimalFormat;

/**
 * Class Calculator - CS 152-70 Project 5
 * 
 * @author Andrew Kenyon 
 * @version 0.99
 */

public class Calculator extends JApplet {
    
    private JLabel upperLab1, upperLab2, inputLab1, inputLab2, outputLab1;
    private JTextField inputField1, inputField2;
    private JButton buttonAdd, buttonSub, buttonMul, buttonDiv, buttonMod;
    private int numField1, numField2, numOutput;
    private JPanel corePanel, northPanel, southPanel, eastPanel, westPanel, midPanel;
    private Dimension buttonDimension, buttonSpacer, labelSpacer;
    private Font buttonFont, inputFieldFont, labelFont1, labelFont2;
    private ButtonListener buttonListener;
        
    public void init() {
        
        buttonDimension = new Dimension(70, 40);
        buttonSpacer = new Dimension(70, 10);
        labelSpacer = new Dimension (0, 4);
        buttonFont = new Font ("Dialog", Font.BOLD, 15);
        inputFieldFont = new Font ("Monospaced", Font.BOLD, 14);
        labelFont1 = new Font ("Dialog", Font.BOLD, 12);
        labelFont2 = new Font ("Dialog", Font.BOLD, 14);
        buttonListener = new ButtonListener();
        
        corePanel = new JPanel();
        corePanel.setLayout (new BorderLayout());
        corePanel.setPreferredSize(new Dimension(500,400));
        northPanel = new JPanel();
        northPanel.setLayout (new BoxLayout (northPanel, BoxLayout.Y_AXIS));
        southPanel = new JPanel();
        eastPanel = new JPanel();
        westPanel = new JPanel();
        midPanel = new JPanel();
        midPanel.setLayout (new BoxLayout (midPanel, BoxLayout.Y_AXIS));
                     
        upperLab1 = new JLabel ("First, enter two integers into text fields.");
        upperLab1.setAlignmentX (this.CENTER_ALIGNMENT);
        upperLab1.setFont (labelFont1);
        upperLab2 = new JLabel ("Next, press button of operation to perform arithmetic.");
        upperLab2.setAlignmentX (this.CENTER_ALIGNMENT);
        upperLab2.setFont (labelFont1);
        inputLab1 = new JLabel ("Enter first number");
        inputLab1.setFont (labelFont1);
        inputLab2 = new JLabel ("Enter second number");
        inputLab2.setFont (labelFont1);
        outputLab1 = new JLabel ("Result:                     ");
        outputLab1.setFont (labelFont2);
        
        buttonAdd = new JButton (" + ");
        buttonAdd.setMaximumSize(buttonDimension);
        buttonAdd.setFont (buttonFont);
        buttonAdd.setAlignmentX (this.CENTER_ALIGNMENT);
        buttonAdd.addActionListener (buttonListener);
        buttonSub = new JButton (" - ");
        buttonSub.setMaximumSize(buttonDimension);
        buttonSub.setFont (buttonFont);
        buttonSub.setAlignmentX (this.CENTER_ALIGNMENT);
        buttonSub.addActionListener (buttonListener);
        buttonMul = new JButton (" * ");
        buttonMul.setMaximumSize(buttonDimension);
        buttonMul.setFont (buttonFont);
        buttonMul.setAlignmentX (this.CENTER_ALIGNMENT);
        buttonMul.addActionListener (buttonListener);
        buttonDiv = new JButton (" / ");
        buttonDiv.setMaximumSize(buttonDimension);
        buttonDiv.setFont (buttonFont);
        buttonDiv.setAlignmentX (this.CENTER_ALIGNMENT);
        buttonDiv.addActionListener (buttonListener);
        buttonMod = new JButton (" % ");
        buttonMod.setMaximumSize(buttonDimension);
        buttonMod.setFont (buttonFont);
        buttonMod.setAlignmentX (this.CENTER_ALIGNMENT);
        buttonMod.addActionListener (buttonListener);
        
        inputField1 = new JTextField (10);
        inputField1.setFont (inputFieldFont);
        inputField2 = new JTextField (10);
        inputField2.setFont (inputFieldFont);
               
        northPanel.add (upperLab1);
        northPanel.add (Box.createRigidArea(labelSpacer));
        northPanel.add (upperLab2);
        northPanel.add (Box.createRigidArea(labelSpacer));
        westPanel.add (inputLab1);
        westPanel.add (inputField1);
        eastPanel.add (inputLab2);
        eastPanel.add (inputField2);
        southPanel.add (outputLab1);
        midPanel.add (Box.createRigidArea(new Dimension(70, 5)));
        midPanel.add (buttonAdd);
        midPanel.add (Box.createRigidArea(buttonSpacer));
        midPanel.add (buttonSub);
        midPanel.add (Box.createRigidArea(buttonSpacer));
        midPanel.add (buttonMul);
        midPanel.add (Box.createRigidArea(buttonSpacer));
        midPanel.add (buttonDiv);
        midPanel.add (Box.createRigidArea(buttonSpacer));
        midPanel.add (buttonMod);
        midPanel.add (Box.createVerticalGlue());
        
        corePanel.add (northPanel, BorderLayout.NORTH);
        corePanel.add (southPanel, BorderLayout.SOUTH);
        corePanel.add (eastPanel, BorderLayout.EAST);
        corePanel.add (westPanel, BorderLayout.WEST);
        corePanel.add (midPanel, BorderLayout.CENTER);
        
        add (corePanel);
        
    }
   
   private class ButtonListener implements ActionListener {
       
            private DecimalFormat fmt = new DecimalFormat("0.##");
       
       public void actionPerformed (ActionEvent e) {
           /**
            * getActionCommand() returns a String object, which is not a valid parameter type
            * for switch statement, hence the conversion to Char.
            */
           char idChar;
           idChar = e.getActionCommand().charAt(1); // space buffer in button constructor
           String resultText;
           double inputTextField1, inputTextField2, result;
           inputTextField1 = Double.parseDouble(inputField1.getText());
           inputTextField2 = Double.parseDouble(inputField2.getText());
           
           switch (idChar) {
               
               case '+':
                    result = inputTextField1 + inputTextField2;
                    outputLab1.setText ( inputTextField1 + " plus " + inputTextField2 +
                                            " is " + result + ".");
                    break;
               case '-':
                    result = inputTextField1 - inputTextField2;
                    outputLab1.setText ( inputTextField1 + " minus " + inputTextField2 +
                                            " is " + result + ".");
                    break;
               case '*':
                    result = inputTextField1 * inputTextField2;
                    outputLab1.setText ( inputTextField1 + " multiplied by " + inputTextField2 +
                                            " is " + result + ".");
                    break;
               case '/':
                    if (inputTextField2 == 0.0) {
                        outputLab1.setText ("Division by zero is undefined.");
                        break;}
                    result = inputTextField1 / inputTextField2;
                    resultText = fmt.format(result);
                    outputLab1.setText ( inputTextField1 + " divided by " + inputTextField2 +
                                            " is " + resultText + ".");
                    break;
               case '%':
                    if (inputTextField2 == 0.0) {
                        outputLab1.setText ("Modulo by zero is undefined.");
                        break;}
                    result = inputTextField1 % inputTextField2;
                    outputLab1.setText ( inputTextField1 + " modulo " + inputTextField2 +
                                            " equals " + result + ".");
                    break;
               default:
                    outputLab1.setText ("Operator event not recognized.");
                    break;
                }
            }
        }
  }
