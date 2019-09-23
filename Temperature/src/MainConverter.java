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


            panel.setLayout(new GridLayout(2, 3 ,5 , 10));
            panel.add(enterData);
            converter.setContentPane(panel);

            converter.setResizable(false);
            converter.setVisible(true);

        });
    }
}
