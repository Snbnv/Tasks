import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import javax.swing.*;

public class MainConverter {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(
            UIManager.getSystemLookAndFeelClassName ());
        } catch (Exception e) {
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
            constraints.gridwidth  = 1;
            constraints.insets = new Insets(2,20,0,0);
            constraints.ipadx = 10;
            constraints.ipady = 10;

            constraints.gridx = 0;
            constraints.gridy = 1;
            JTextField enterTemp = new JTextField(10);
            enterTemp.setHorizontalAlignment(JTextField.CENTER);
            panel.add(enterTemp, constraints);

            constraints.gridx = 1;
            constraints.gridy = 1;
            JTextField outputCKTemp = new JTextField(10);
            outputCKTemp.setHorizontalAlignment(JTextField.CENTER);
            outputCKTemp.setEnabled(false);
            panel.add(outputCKTemp, constraints);

            constraints.gridx = 0;
            constraints.gridy = 0;
            constraints.ipady = 5;
            JLabel labelEnterTemp = new JLabel("Add temperature");
            panel.add(labelEnterTemp, constraints);

            constraints.gridx = 1;
            constraints.gridy = 2;
            JLabel labelCK = new JLabel("\u00b0K");
            panel.add(labelCK, constraints);

            constraints.gridx = 2;
            constraints.gridy = 1;
            constraints.ipady = 10;
            JTextField outputCFTemp = new JTextField(10);
            outputCFTemp.setHorizontalAlignment(JTextField.CENTER);
            outputCFTemp.setEnabled(false);
            panel.add(outputCFTemp, constraints);

            constraints.gridx = 2;
            constraints.gridy = 2;
            constraints.ipady = 5;
            JLabel labelCF = new JLabel("\u2109");
            panel.add(labelCF, constraints);

            constraints.gridx = 0;
            constraints.gridy = 2;
            String[] box = new String[]{"\u2103", "\u00b0K", "\u2109"};
            JComboBox chooserCKF = new JComboBox(box);
            panel.add(chooserCKF, constraints);

            constraints.gridx = 1;
            constraints.gridy = 4;
            constraints.ipadx = 30;
            constraints.ipady = 20;
            constraints.insets = new Insets(50,20,0,0);
            JButton button = new JButton("Convert");
            panel.add(button, constraints);

            converter.setContentPane(panel);
        });
    }
}
