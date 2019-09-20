import javax.swing.*;
import java.awt.*;

public class MainConverter {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame converter = new JFrame("Конвертер температуры");
            converter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Image icon = Toolkit.getDefaultToolkit().getImage("icon.png");
            converter.setIconImage(icon);
            converter.setSize(500, 400);
            JPanel enterData = new JPanel();
            converter.add(enterData, FlowLayout.LEFT);
            converter.setResizable(false);
            converter.setVisible(true);

        });
    }
}
