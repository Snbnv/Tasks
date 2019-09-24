import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class MainConverter {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame converter = new JFrame("Конвертер температуры");
            converter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Image icon = Toolkit.getDefaultToolkit().getImage("icon.png");
            converter.setIconImage(icon);
            converter.setSize(500, 400);
            JPanel panel = new JPanel();
            JTextField enterData = new JTextField(10);
            enterData.setHorizontalAlignment(JTextField.CENTER);
            enterData.setSize(10, 20);
            JTextField kcData = new JTextField(10);
            kcData.setHorizontalAlignment(JTextField.CENTER);
            kcData.setSize(10, 20);
            JTextField fcData = new JTextField(10);
            fcData.setHorizontalAlignment(JTextField.CENTER);
            fcData.setSize(10, 20);
            JComboBox ckf = new JComboBox();

            ckf.addItem("Цельсий");
            ckf.addItem("Кельвин");
            ckf.addItem("Фаренгейт");



            panel.setLayout(new GridLayout(0,3,10,10));
            panel.add(String.valueOf(new TitledBorder("sdg")), enterData);
            panel.add(kcData);
            panel.add(fcData);
            panel.add(ckf);
            converter.setContentPane(panel);

            converter.setResizable(false);
            converter.setVisible(true);

        });
    }
}
