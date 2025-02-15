package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.MalformedURLException;

public class Html extends JFrame {

    public Html() {
        setTitle("Mimo Welcome Screen");
        setSize(816, 590);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel topBar = new JPanel(new BorderLayout());
        topBar.setBackground(Color.WHITE);

        JButton closeButton = new JButton("\u274C");
        closeButton.setBorderPainted(false);
        closeButton.setContentAreaFilled(false);
        closeButton.setFocusPainted(false);
        closeButton.setFont(new Font("SansSerif", Font.PLAIN, 18));
        closeButton.addActionListener(e -> {
            try {
				new home().setVisible(true);
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
            dispose();
        });
        topBar.add(closeButton, BorderLayout.WEST);

        JButton flagButton = new JButton("\u2691");
        flagButton.setBorderPainted(false);
        flagButton.setContentAreaFilled(false);
        flagButton.setFocusPainted(false);
        flagButton.setFont(new Font("SansSerif", Font.PLAIN, 18));
        flagButton.addActionListener(e -> JOptionPane.showMessageDialog(this, "Flag clicked!"));
        topBar.add(flagButton, BorderLayout.EAST);

        add(topBar, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setBackground(new Color(245, 250, 255));

        JLabel illustration = new JLabel(new ImageIcon("path_to_your_image.png"));
        illustration.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel welcomeText = new JLabel("<html><center>Welcome! You're about to learn technologies like HTML, CSS, JavaScript, React, and everything else we'll need to build for the web.<br><br>Before you realize it, we'll be creating real-life projects. Let's start with <b>HTML.</b></center></html>");
        welcomeText.setFont(new Font("SansSerif", Font.PLAIN, 16));
        welcomeText.setAlignmentX(Component.CENTER_ALIGNMENT);
        welcomeText.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        centerPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        centerPanel.add(illustration);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        centerPanel.add(welcomeText);

        add(centerPanel, BorderLayout.CENTER);

        JButton continueButton = new JButton("CONTINUE");
        continueButton.setBackground(new Color(114, 46, 209));
        continueButton.setForeground(Color.WHITE);
        continueButton.setFont(new Font("SansSerif", Font.BOLD, 14));
        continueButton.setFocusPainted(false);
        continueButton.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0));

        add(continueButton, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Html().setVisible(true));
    }

    
}
