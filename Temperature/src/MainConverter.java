import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class MainConverter extends JFrame {
    private static String celsius = "\u2103";
    private static String kelvin = "\u00b0K";
    private static String fahrenheit = "\u2109";

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(() -> {
            JFrame converter = new JFrame("Temperature converter");
            converter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            converter.setResizable(true);
            converter.setVisible(true);
            Image icon = Toolkit.getDefaultToolkit().getImage("icon.png");
            converter.setIconImage(icon);
            converter.setSize(500, 400);
            converter.setLocationRelativeTo(null);

            JPanel panel = new JPanel(new GridBagLayout());

            GridBagConstraints constraints = new GridBagConstraints();
            constraints.anchor = GridBagConstraints.CENTER;
            constraints.gridx = 0;
            constraints.gridy = 0;
            constraints.gridheight = 1;
            constraints.gridwidth = 1;
            constraints.insets = new Insets(5, 10, 0, 10);
            constraints.ipadx = 15;
            constraints.ipady = 10;

            constraints.gridy = 1;
            JTextField enterTemp = new JTextField(10);
            enterTemp.setHorizontalAlignment(JTextField.CENTER);
            panel.add(enterTemp, constraints);

            constraints.gridx = 0;
            constraints.gridy = 2;
            String[] box = new String[]{celsius, kelvin, fahrenheit};
            JComboBox chooserCKF = new JComboBox(box);
            panel.add(chooserCKF, constraints);

            constraints.gridx = 1;
            constraints.gridy = 1;
            JTextField outputCKTemp = new JTextField(10);
            outputCKTemp.setHorizontalAlignment(JTextField.CENTER);
            outputCKTemp.setEnabled(false);
            panel.add(outputCKTemp, constraints);

            constraints.gridx = 0;
            constraints.gridy = 0;
            constraints.ipady = 5;
            JLabel labelEnterTemp = new JLabel("Enter temperature");
            panel.add(labelEnterTemp, constraints);

            constraints.gridx = 1;
            constraints.gridy = 2;
            constraints.ipady = 5;
            JLabel labelCK = new JLabel(kelvin);
            panel.add(labelCK, constraints);

            constraints.gridx = 2;
            constraints.gridy = 2;
            constraints.ipady = 5;
            JLabel labelCF = new JLabel(fahrenheit);
            panel.add(labelCF, constraints);

            constraints.gridx = 2;
            constraints.gridy = 1;
            constraints.ipady = 10;
            JTextField outputCFTemp = new JTextField(10);
            outputCFTemp.setHorizontalAlignment(JTextField.CENTER);
            outputCFTemp.setEnabled(false);
            panel.add(outputCFTemp, constraints);

            constraints.gridx = 1;
            constraints.gridy = 4;
            constraints.ipadx = 30;
            constraints.ipady = 20;
            constraints.insets = new Insets(50, 20, 0, 0);
            JButton button = new JButton("Convert");
            panel.add(button, constraints);
            button.addActionListener(e -> {
                if (chooserCKF.getSelectedItem().equals(celsius)){
                    try{
                        double tempCK = Double.parseDouble(enterTemp.getText()) + 273.15;
                        double tempCF = Double.parseDouble(enterTemp.getText()) * 9 / 5 + 32;

                        labelCK.setText(kelvin);
                        labelCF.setText(fahrenheit);

                        outputCKTemp.setText(Double.toString(tempCK));
                        outputCFTemp.setText(Double.toString(tempCF));
                    }catch(Exception x){
                        JOptionPane.showMessageDialog(converter,"incorrect enter data");
                    }
                }
                if (chooserCKF.getSelectedItem().equals(kelvin)) {
                    try {
                        double tempCK = Double.parseDouble(enterTemp.getText()) - 273.15;
                        double tempCF = (Double.parseDouble(enterTemp.getText()) - 273.15) * 9 / 5 + 32;

                        labelCK.setText(celsius);
                        labelCF.setText(fahrenheit);

                        outputCKTemp.setText(Double.toString(tempCK));
                        outputCFTemp.setText(Double.toString(tempCF));
                    } catch (Exception x) {
                        JOptionPane.showMessageDialog(converter, "incorrect enter data");
                    }
                }
                if (chooserCKF.getSelectedItem().equals(fahrenheit)) {
                    try {
                        double tempCK = (Double.parseDouble(enterTemp.getText()) - 32) * 5 / 9 + 273.15;
                        double tempCF = (Double.parseDouble(enterTemp.getText()) - 32) * 5 / 9;

                        labelCK.setText(kelvin);
                        labelCF.setText(celsius);

                        outputCKTemp.setText(Double.toString(tempCK));
                        outputCFTemp.setText(Double.toString(tempCF));
                    } catch (Exception x) {
                        JOptionPane.showMessageDialog(converter, "incorrect enter data");
                    }
                }
            });

            converter.setContentPane(panel);
        });
    }
}