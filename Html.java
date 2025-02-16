package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.MalformedURLException;

public class Html extends JFrame {

    private JPanel mainPanel; 

    public Html() {
        setTitle("CODEX");
        setSize(816, 590);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        add(createTopBar(), BorderLayout.NORTH);

        mainPanel = new JPanel(new BorderLayout());
        add(mainPanel, BorderLayout.CENTER);

        switchToPanel(introduction());
    }

    private JPanel introduction() {
        JPanel panel = new JPanel(new BorderLayout());

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

        panel.add(centerPanel, BorderLayout.CENTER);

        JButton continueButton = new JButton("CONTINUE");
        continueButton.setBackground(new Color(114, 46, 209));
        continueButton.setForeground(Color.WHITE);
        continueButton.setFont(new Font("SansSerif", Font.BOLD, 14));
        continueButton.setFocusPainted(false);
        continueButton.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0));

        continueButton.addActionListener(e -> switchToPanel(guessTheLetterPanel()));

        panel.add(continueButton, BorderLayout.SOUTH);
        return panel;
    }

    private JPanel guessTheLetterPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        JPanel progressPanel = new JPanel();
        progressPanel.setLayout(new BoxLayout(progressPanel, BoxLayout.Y_AXIS));
        progressPanel.setBackground(Color.WHITE);

        JProgressBar progressBar = new JProgressBar(0, 100);
        progressBar.setValue(30);
        progressBar.setForeground(new Color(168, 129, 255));
        progressBar.setBackground(new Color(230, 230, 250));
        progressBar.setBorderPainted(false);

        progressPanel.add(progressBar);
        panel.add(progressPanel, BorderLayout.NORTH);

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBackground(new Color(245, 250, 255));

        JLabel htmlText = new JLabel("<html>Hypertext Markup Language, or <b>HTML</b>, is the computer language that structures the web pages on the internet.<br><br>On top of HTML, you can build stunning web pages with buttons, images, and lots more.</html>");
        htmlText.setFont(new Font("SansSerif", Font.PLAIN, 16));
        htmlText.setAlignmentX(Component.CENTER_ALIGNMENT);
        htmlText.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JPanel guessPanel = new JPanel();
        guessPanel.setBackground(new Color(200, 200, 230));
        guessPanel.setLayout(new BoxLayout(guessPanel, BoxLayout.Y_AXIS));
        guessPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel guessText = new JLabel("Guess the letter", SwingConstants.CENTER);
        guessText.setFont(new Font("SansSerif", Font.BOLD, 20));
        guessText.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel wordLabel = new JLabel("_ O G", SwingConstants.CENTER);
        wordLabel.setFont(new Font("SansSerif", Font.BOLD, 30));
        wordLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 3, 10, 10));
        buttonPanel.setBackground(new Color(200, 200, 230));

        JButton letterQ = createLetterButton("Q");
        JButton letterR = createLetterButton("L");
        JButton letterD = createLetterButton("D");

        buttonPanel.add(letterQ);
        buttonPanel.add(letterR);
        buttonPanel.add(letterD);

        guessPanel.add(guessText);
        guessPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        guessPanel.add(wordLabel);
        guessPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        guessPanel.add(buttonPanel);

        contentPanel.add(htmlText);
        contentPanel.add(guessPanel);

        panel.add(contentPanel, BorderLayout.CENTER);

        JButton continueButton = new JButton("CONTINUE");
        continueButton.setBackground(new Color(114, 46, 209));
        continueButton.setForeground(Color.WHITE);
        continueButton.setFont(new Font("SansSerif", Font.BOLD, 14));
        continueButton.setFocusPainted(false);
        continueButton.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0));
        continueButton.setEnabled(false);

        panel.add(continueButton, BorderLayout.SOUTH);

        letterQ.addActionListener(e -> JOptionPane.showMessageDialog(this, "Wrong choice! Try again."));
        letterR.addActionListener(e -> {
            wordLabel.setText("L O G");
            continueButton.setEnabled(true);
        });
        letterD.addActionListener(e -> JOptionPane.showMessageDialog(this, "Wrong choice! Try again."));

        continueButton.addActionListener(e -> switchToPanel(createHtmlQuizPanel()));

        return panel;
    }
    
    private JPanel createHtmlQuizPanel() {
    	JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(245, 248, 250)); 

        JLabel questionLabel = new JLabel(
            "<html>By adding the HTML code <span style='font-family:monospace'>&lt;button&gt;Like&lt;/button&gt;</span>, " +
            "you can create a button with the label 'Like'.<br><br>" +
            "<span style='color:#5865F2; font-size:12px;'>ⓘ Tap the snippets below</span></html>"
        );
        questionLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
        questionLabel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        JTextField answerBox = new JTextField();
        answerBox.setFont(new Font("Courier New", Font.BOLD, 16)); 
        answerBox.setBackground(new Color(240, 240, 240)); 
        answerBox.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        answerBox.setEditable(false);
        answerBox.setPreferredSize(new Dimension(200, 30));

        JLabel fileLabel = new JLabel("index.html");
        fileLabel.setFont(new Font("SansSerif", Font.BOLD, 12));
        fileLabel.setBorder(BorderFactory.createEmptyBorder(5, 20, 5, 20));

        JPanel answerPanel = new JPanel(new BorderLayout());
        answerPanel.setBorder(BorderFactory.createEmptyBorder(5, 20, 5, 20));
        answerPanel.add(fileLabel, BorderLayout.NORTH);
        answerPanel.add(answerBox, BorderLayout.CENTER);

        JButton htmlButton = new JButton("<html>&lt;button&gt;Like&lt;/button&gt;</html>") {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                g2.setColor(getBackground());
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 25, 25); 

                super.paintComponent(g);
            }
        };

        htmlButton.setFont(new Font("Courier New", Font.BOLD, 14));
        htmlButton.setBackground(Color.WHITE);
        htmlButton.setFocusPainted(false);
        htmlButton.setBorder(BorderFactory.createEmptyBorder(8, 15, 8, 15)); // Padding
        htmlButton.setOpaque(false);
        htmlButton.setContentAreaFilled(false);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        buttonPanel.add(htmlButton);

        JButton continueButton = new JButton("CONTINUE");
        continueButton.setBackground(new Color(114, 46, 209));
        continueButton.setForeground(Color.WHITE);
        continueButton.setFont(new Font("SansSerif", Font.BOLD, 14));
        continueButton.setFocusPainted(false);
        continueButton.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0));
        continueButton.setEnabled(false); 

        htmlButton.addActionListener(e -> {
            answerBox.setText("<button>Like</button>");
            htmlButton.setVisible(false); 
            continueButton.setEnabled(true);
        });

        answerBox.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!answerBox.getText().isEmpty()) { 
                    answerBox.setText(""); 
                    htmlButton.setVisible(true); 
                    continueButton.setEnabled(false); 
                }
            }
        });

        continueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userAnswer = answerBox.getText().trim();

                if (userAnswer.isEmpty()) {
                    JOptionPane.showMessageDialog(panel, "Please fill in the blank!", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (!userAnswer.equals("<button>Like</button>")) {
                    JOptionPane.showMessageDialog(panel, "Your answer is incorrect!", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(panel, "Correct! You may continue.", "Success", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        answerBox.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent evt) {
                continueButton.setEnabled(answerBox.getText().trim().equals("<button>Like</button>"));
            }
        });

        JPanel bottomPanel = new JPanel(new GridLayout(2, 1, 0, 5)); 
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        bottomPanel.add(buttonPanel);
        bottomPanel.add(continueButton);

        panel.add(questionLabel, BorderLayout.NORTH);
        panel.add(answerPanel, BorderLayout.CENTER);
        panel.add(bottomPanel, BorderLayout.SOUTH);

        return panel;
    }




    private JButton createLetterButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("SansSerif", Font.BOLD, 20));
        button.setForeground(Color.WHITE);
        button.setBackground(Color.DARK_GRAY);
        button.setFocusPainted(false);
        button.setPreferredSize(new Dimension(60, 60));
        return button;
    }

    private JPanel createTopBar() {
        JPanel topBar = new JPanel(new BorderLayout());
        topBar.setBackground(Color.WHITE);

        JButton closeButton = new JButton("\u274C");
        closeButton.setBorderPainted(false);
        closeButton.setContentAreaFilled(false);
        closeButton.setBounds(350, 10, 30, 30); 

        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                home main;
				try {
					main = new home();
					 main.setVisible(true);
		                dispose();
				} catch (MalformedURLException e1) {
					e1.printStackTrace();
				}
               
            }
        });


        JButton flagButton = new JButton("\u2691"); 
        flagButton.setBorderPainted(false);
        flagButton.setContentAreaFilled(false);

        topBar.add(closeButton, BorderLayout.WEST);
        topBar.add(flagButton, BorderLayout.EAST);

        return topBar;
    }

    private void switchToPanel(JPanel panel) {
        mainPanel.removeAll();
        mainPanel.add(panel, BorderLayout.CENTER);
        mainPanel.revalidate();
        mainPanel.repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Html().setVisible(true));
    }
}
