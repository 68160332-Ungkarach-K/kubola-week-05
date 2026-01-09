import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;

public class LapOOP_05_04 {

    public static void main(String[] args) {

        // สร้าง Frame
        JFrame frame = new JFrame("Progam with JTextArea");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // สร้าง TextArea
        JTextArea textArea = new JTextArea(8, 30);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        // ใส่ ScrollBar ให้ TextArea
        JScrollPane scrollPane = new JScrollPane(textArea);

        // สร้างปุ่ม
        JButton btnShow = new JButton("Show message");
        JButton btnSave = new JButton("Save"); // ปุ่มใหม่

        // เมื่อกดปุ่ม Show
        btnShow.addActionListener(e -> {
            String text = textArea.getText();
            JOptionPane.showMessageDialog(frame, text,
                    "Your message:", JOptionPane.INFORMATION_MESSAGE);
        });

        // เมื่อกดปุ่ม Save
        btnSave.addActionListener(e -> {
            try {
                FileWriter writer = new FileWriter("D:\\message.txt");
                writer.write(textArea.getText());
                writer.close();

                JOptionPane.showMessageDialog(frame,
                        "Save file successfully!",
                        "Save", JOptionPane.INFORMATION_MESSAGE);

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(frame,
                        "Error saving file!",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Panel สำหรับปุ่ม
        JPanel panel = new JPanel();
        panel.add(btnShow);
        panel.add(btnSave);

        // จัด Layout
        frame.setLayout(new BorderLayout());
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(panel, BorderLayout.SOUTH);

        // แสดงหน้าจอ
        frame.setVisible(true);
    }
}
