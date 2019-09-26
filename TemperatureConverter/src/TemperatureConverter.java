import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class TemperatureConverter extends JFrame {
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
            JTextField enterData = new JTextField(10);
            enterData.setHorizontalAlignment(JTextField.CENTER);
            panel.add(enterData, constraints);

            constraints.gridx = 1;
            JTextField outputDataCK = new JTextField(10);
            outputDataCK.setHorizontalAlignment(JTextField.CENTER);
            outputDataCK.setEnabled(false);
            panel.add(outputDataCK, constraints);

            constraints.gridx = 2;
            JTextField outputDataCF = new JTextField(10);
            outputDataCF.setHorizontalAlignment(JTextField.CENTER);
            outputDataCF.setEnabled(false);
            panel.add(outputDataCF, constraints);

            constraints.gridx = 0;
            constraints.gridy = 2;
            constraints.ipady = 5;
            String[] box = new String[]{celsius, kelvin, fahrenheit};
            JComboBox<String> chooserCKF = new JComboBox<>(box);
            panel.add(chooserCKF, constraints);

            constraints.gridy = 0;
            constraints.insets = new Insets(5, 10, 0, 0);
            JLabel labelEnterTemp = new JLabel("Enter temperature");
            panel.add(labelEnterTemp, constraints);

            constraints.gridx = 1;
            constraints.gridy = 2;
            JLabel labelCK = new JLabel(kelvin);
            panel.add(labelCK, constraints);

            constraints.gridx = 2;
            JLabel labelCF = new JLabel(fahrenheit);
            panel.add(labelCF, constraints);

            constraints.gridx = 1;
            constraints.gridy = 4;
            constraints.ipadx = 30;
            constraints.ipady = 20;
            constraints.insets = new Insets(50, 0, 0, 0);
            JButton button = new JButton("Convert");
            panel.add(button, constraints);

            button.addActionListener(e -> {
                try {
                    double dataCK;
                    double dataCF;

                    if (Objects.requireNonNull(chooserCKF.getSelectedItem()).equals(celsius)) {
                        dataCK = Double.parseDouble(enterData.getText()) + 273.15;
                        dataCF = Double.parseDouble(enterData.getText()) * 9 / 5 + 32;

                        labelCK.setText(kelvin);
                        labelCF.setText(fahrenheit);

                    } else if (chooserCKF.getSelectedItem().equals(kelvin)) {
                        dataCK = Double.parseDouble(enterData.getText()) - 273.15;
                        dataCF = (Double.parseDouble(enterData.getText()) - 273.15) * 9 / 5 + 32;

                        labelCK.setText(celsius);
                        labelCF.setText(fahrenheit);

                    } else {
                        dataCK = (Double.parseDouble(enterData.getText()) - 32) * 5 / 9 + 273.15;
                        dataCF = (Double.parseDouble(enterData.getText()) - 32) * 5 / 9;

                        labelCK.setText(kelvin);
                        labelCF.setText(celsius);
                    }

                    outputDataCK.setText(Double.toString(dataCK));
                    outputDataCF.setText(Double.toString(dataCF));

                } catch (Exception x) {
                    JOptionPane.showMessageDialog(converter, "incorrect enter data");
                }
            });
            converter.setContentPane(panel);
        });
    }
}