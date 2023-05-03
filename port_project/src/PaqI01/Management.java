package PaqI01;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Management extends JFrame{
    private JPanel mainPanel;
    private JTextField textField1;
    private JComboBox comboBox1;
    private JTextField textField2;
    private JRadioButton a1RadioButton;
    private JRadioButton a2RadioButton;
    private JRadioButton a3RadioButton;
    private JTextArea descriptionTextArea1;
    private JTextArea stateTextArea;
    private JTextField textField3;
    private JTextField textField4;
    private JCheckBox customInspectionCheckBox;
    private JButton pileButton;
    private JButton unpileButton;
    private JTextField columNumberTextField;
    private JButton showDescriptionButton;
    private JTextArea descriptionTextArea;
    private JButton amountOfContainersButton;
    private JComboBox comboBox2;
    private JTextField textField5;
    private JTextField hubNumTextField;

    public JTextField getTextField1() {
        return textField1;
    }

    public void setTextField1(JTextField textField1) {
        this.textField1 = textField1;
    }

    public JComboBox getComboBox1() {
        return comboBox1;
    }

    public void setComboBox1(JComboBox comboBox1) {
        this.comboBox1 = comboBox1;
    }

    public JTextField getTextField2() {
        return textField2;
    }

    public void setTextField2(JTextField textField2) {
        this.textField2 = textField2;
    }

    public JRadioButton getA1RadioButton() {
        return a1RadioButton;
    }

    public void setA1RadioButton(JRadioButton a1RadioButton) {
        this.a1RadioButton = a1RadioButton;
    }

    public JRadioButton getA2RadioButton() {
        return a2RadioButton;
    }

    public void setA2RadioButton(JRadioButton a2RadioButton) {
        this.a2RadioButton = a2RadioButton;
    }

    public JRadioButton getA3RadioButton() {
        return a3RadioButton;
    }

    public void setA3RadioButton(JRadioButton a3RadioButton) {
        this.a3RadioButton = a3RadioButton;
    }

    public JTextArea getDescriptionTextArea1() {
        return descriptionTextArea1;
    }

    public void setDescriptionTextArea1(JTextArea descriptionTextArea1) {
        this.descriptionTextArea1 = descriptionTextArea1;
    }

    public JTextArea getStateTextArea() {
        return stateTextArea;
    }

    public void setStateTextArea(JTextArea stateTextArea) {
        this.stateTextArea = stateTextArea;
    }

    public JTextField getTextField3() {
        return textField3;
    }

    public void setTextField3(JTextField textField3) {
        this.textField3 = textField3;
    }

    public JTextField getTextField4() {
        return textField4;
    }

    public void setTextField4(JTextField textField4) {
        this.textField4 = textField4;
    }

    public JCheckBox getCustomInspectionCheckBox() {
        return customInspectionCheckBox;
    }

    public void setCustomInspectionCheckBox(JCheckBox customInspectionCheckBox) {
        this.customInspectionCheckBox = customInspectionCheckBox;
    }

    public JButton getPileButton() {
        return pileButton;
    }

    public void setPileButton(JButton pileButton) {
        this.pileButton = pileButton;
    }

    public JButton getUnpileButton() {
        return unpileButton;
    }

    public void setUnpileButton(JButton unpileButton) {
        this.unpileButton = unpileButton;
    }

    public JTextField getColumNumberTextField() {
        return columNumberTextField;
    }

    public void setColumNumberTextField(JTextField columNumberTextField) {
        this.columNumberTextField = columNumberTextField;
    }

    public JButton getShowDescriptionButton() {
        return showDescriptionButton;
    }

    public void setShowDescriptionButton(JButton showDescriptionButton) {
        this.showDescriptionButton = showDescriptionButton;
    }

    public JTextArea getDescriptionTextArea() {
        return descriptionTextArea;
    }

    public void setDescriptionTextArea(JTextArea descriptionTextArea) {
        this.descriptionTextArea = descriptionTextArea;
    }

    public JButton getAmountOfContainersButton() {
        return amountOfContainersButton;
    }

    public void setAmountOfContainersButton(JButton amountOfContainersButton) {
        this.amountOfContainersButton = amountOfContainersButton;
    }

    public JComboBox getComboBox2() {
        return comboBox2;
    }

    public void setComboBox2(JComboBox comboBox2) {
        this.comboBox2 = comboBox2;
    }

    public JTextField getTextField5() {
        return textField5;
    }

    public void setTextField5(JTextField textField5) {
        this.textField5 = textField5;
    }

    public Management(){
        setTitle("Port Management");
        setContentPane(mainPanel);
        setSize(900, 800);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        Hub hub1 = new Hub();
        Hub hub2 = new Hub();
        Hub hub3 = new Hub();

        pileButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(textField1.getText());
                    int weight = Integer.parseInt(textField2.getText());
                    if (!a1RadioButton.isSelected() && !a2RadioButton.isSelected() && !a3RadioButton.isSelected()) {
                        throw new Exception("Priority not assessed, please select it");
                    } } catch (NumberFormatException exception) {
                    JOptionPane.showMessageDialog(Management.this, "ID Number and Weight must be integers", "Wrong Input", JOptionPane.ERROR_MESSAGE);
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(Management.this, exception.getMessage(), "Invalid Input", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                Container C01 = new Container();
                C01.setID(Integer.parseInt(textField1.getText()));
                C01.setWeight(Integer.parseInt(textField2.getText()));
                C01.setDescription(descriptionTextArea1.getText());
                C01.setSender(textField3.getText());
                C01.setReciver(textField4.getText());
                C01.setOrg((String) comboBox1.getSelectedItem());
                C01.setInspected(customInspectionCheckBox.isSelected());
                if (a1RadioButton.isSelected()) {
                    C01.priority = 1;
                } else if (a2RadioButton.isSelected()) {
                    C01.priority = 2;
                } else if (a3RadioButton.isSelected()) {
                    C01.priority = 3;
                }

                if(hub1.stackContainer(C01)==true){
                    stateTextArea.setText("Hub 1\n"+hub1.printHub());
                }
                else if(hub1.stackContainer(C01)==false){
                    if(hub2.stackContainer(C01)==true){
                        stateTextArea.setText("Hub 2\n" + hub2.printHub());
                    }
                    else if(hub2.stackContainer(C01)==false){
                        try{
                            if(hub3.stackContainer(C01)==false){
                                throw new Exception("This column of the hubs is full");
                            }}catch(Exception excp){
                            JOptionPane.showMessageDialog(Management.this,excp.getMessage(),"Full", JOptionPane.ERROR_MESSAGE);
                        }
                        stateTextArea.setText("Hub 3\n" + hub3.printHub());
                    }
                }
            }
        });
        unpileButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int column = Integer.parseInt(columNumberTextField.getText());
                int hub = Integer.parseInt(hubNumTextField.getText());
                if(hub == 1) {
                    hub1.removeContainer(column);
                    stateTextArea.setText("Hub 1\n" + hub1.printHub());
                }
                else if(hub==2) {
                        hub2.removeContainer(column);
                        stateTextArea.setText("Hub 2\n" + hub2.printHub());
                    }
                else if(hub == 3){
                            hub3.removeContainer(column);
                            stateTextArea.setText("Hub 3\n"+hub3.printHub());

                }


            }
        });

        showDescriptionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(textField1.getText());
                descriptionTextArea.setText(hub1.showDescription(id));
            }
        });


        amountOfContainersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == amountOfContainersButton) {
                    String country = (String) comboBox2.getSelectedItem();
                    int count = (int) hub1.count(country)+ hub2.count(country) + hub3.count(country);
                    textField5.setText(" " + count);
                }
            }
        });
    }
    public static void main(String[] args) {
      new Management();
    }
}
