// Complete and fixed Mimo Clone Java Swing project code

package Main;

import javax.swing.*;
import javax.swing.border.AbstractBorder;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.imageio.ImageIO;

public class home extends JFrame {
    private JButton activeButton;
    private CardLayout cardLayout;
    private JPanel mainContentPanel;
    private JPanel fixedTopPanel;
    private JPanel bottomNav;
    private JButton circleButton;
    private Point initialClick;


    public home() throws MalformedURLException {
        setTitle("Codex");
        setSize(816, 590);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout());

        cardLayout = new CardLayout();
        mainContentPanel = new JPanel(cardLayout);

        mainContentPanel.add(createHomePanel(), "Home");
        mainContentPanel.add(createProfilePanel(), "Profile");

        getContentPane().add(mainContentPanel, BorderLayout.CENTER);
        bottomNav = createBottomNav();
        getContentPane().add(bottomNav, BorderLayout.SOUTH);

        circleButton = createCircleButton();
        getLayeredPane().add(circleButton, JLayeredPane.POPUP_LAYER);
        circleButton.setBounds(40, 341, 77, 77);
        
    }

    private JPanel createHomePanel() throws MalformedURLException {
        fixedTopPanel = new JPanel(new BorderLayout());
        fixedTopPanel.setPreferredSize(new Dimension(800, 112));

        JPanel topBar = createTopBar();
        JPanel burgerPanel = createBurgerPanel();

        fixedTopPanel.add(topBar, BorderLayout.NORTH);
        fixedTopPanel.add(new JSeparator(), BorderLayout.CENTER);
        fixedTopPanel.add(burgerPanel, BorderLayout.SOUTH);

        getContentPane().add(fixedTopPanel, BorderLayout.NORTH);

        JPanel mainContent = new JPanel(null);
        mainContent.setBackground(new Color(240, 240, 240));
        mainContent.setPreferredSize(new Dimension(800, 1200));

        JPanel coursePanel = createStatLabelWithBorder("Intro to Web Development");
        coursePanel.setBounds(-14, 10, 814, 80);
        mainContent.add(coursePanel);

        JButton playButton = createPlayButton();
        playButton.setFocusable(false);
        playButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Html html = new Html();
        		html.setVisible(true);
        		dispose();
        	}
        });
        playButton.setBounds(340, 109, 120, 91);
        mainContent.add(playButton);

        JScrollPane scrollPane = new JScrollPane(mainContent);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); // Remove horizontal scroll

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        return mainPanel;
    }

    private JPanel createProfilePanel() throws MalformedURLException {
        JPanel profilePanel = new JPanel(new BorderLayout());
        profilePanel.setBackground(new Color(240, 240, 240));

        // Top panel for settings button
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        topPanel.setBackground(new Color(240, 240, 240));

        // Settings button as icon
        JButton settingsButton = new JButton();
        ImageIcon settingsIcon = loadImage("https://cdn-icons-png.flaticon.com/512/3524/3524659.png", 24, 24);
        settingsButton.setIcon(settingsIcon);
        settingsButton.setBorderPainted(false);
        settingsButton.setContentAreaFilled(false);
        settingsButton.setFocusPainted(false);
        settingsButton.addActionListener(e -> JOptionPane.showMessageDialog(this, "Settings Button Clicked!"));

        // Add hover effect
        settingsButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                settingsButton.setBackground(new Color(220, 220, 220));
                settingsButton.setContentAreaFilled(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                settingsButton.setContentAreaFilled(false);
            }
        });

        topPanel.add(settingsButton);
        profilePanel.add(topPanel, BorderLayout.NORTH);


        // Rest of the profile components (center aligned)
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setBackground(new Color(240, 240, 240));

        ImageIcon profileIcon = new ImageIcon(new ImageIcon(new URL("https://cdn-icons-png.flaticon.com/512/149/149071.png")).getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH));
        JLabel profilePic = new JLabel(profileIcon, JLabel.CENTER);
        profilePic.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel userName = new JLabel("Keed Nahalee L. Madigal", JLabel.CENTER);
        userName.setFont(new Font("Arial", Font.BOLD, 24));
        userName.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel userEmail = new JLabel("keednahaleelm@gmail.com", JLabel.CENTER);
        userEmail.setFont(new Font("Arial", Font.PLAIN, 16));
        userEmail.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel userStats = new JLabel("Streak: 5 Days | XP: 300 | Lessons Completed: 12", JLabel.CENTER);
        userStats.setFont(new Font("Arial", Font.PLAIN, 14));
        userStats.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton logoutButton = new JButton("Logout");
        logoutButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        logoutButton.setFont(new Font("Arial", Font.BOLD, 16));
        logoutButton.setBackground(new Color(255, 69, 58));
        logoutButton.setForeground(Color.WHITE);
        logoutButton.addActionListener(e -> JOptionPane.showMessageDialog(this, "Logged Out!"));

        centerPanel.add(Box.createVerticalStrut(30));
        centerPanel.add(profilePic);
        centerPanel.add(Box.createVerticalStrut(20));
        centerPanel.add(userName);
        centerPanel.add(userEmail);
        centerPanel.add(Box.createVerticalStrut(20));
        centerPanel.add(userStats);
        centerPanel.add(Box.createVerticalStrut(40));
        centerPanel.add(logoutButton);

        profilePanel.add(centerPanel, BorderLayout.CENTER);

        return profilePanel;
    }

    private JPanel createTopBar() throws MalformedURLException {
        JPanel topBar = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        topBar.setPreferredSize(new Dimension(800, 50));

        JLabel hearts = createStatLabel("https://cdn-icons-png.flaticon.com/128/833/833472.png", "5");
        JLabel coins = createStatLabel("https://cdn-icons-png.flaticon.com/128/1828/1828884.png", "200");
        JLabel streak = createStatLabel("https://cdn-icons-png.flaticon.com/128/744/744922.png", "0");

        topBar.add(hearts);
        topBar.add(coins);
        topBar.add(streak);

        return topBar;
    }

    private JLabel createStatLabel(String iconUrl, String text) throws MalformedURLException {
        ImageIcon icon = new ImageIcon(new ImageIcon(new URL(iconUrl)).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
        JLabel label = new JLabel(text, icon, JLabel.LEFT);
        label.setFont(new Font("Arial", Font.BOLD, 16));
        label.setIconTextGap(8);
        return label;
    }

    private JPanel createBurgerPanel() throws MalformedURLException {
        JPanel burgerPanel = new JPanel(new BorderLayout());
        burgerPanel.setPreferredSize(new Dimension(800, 60));

        ImageIcon burgerIcon = new ImageIcon(new ImageIcon(new URL("https://cdn-icons-png.flaticon.com/128/1828/1828859.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
        JLabel burgerLabel = new JLabel(burgerIcon);
        burgerLabel.setPreferredSize(new Dimension(50, 50));

        JLabel titleLabel = new JLabel("Full Stack Developer", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));

        burgerPanel.add(burgerLabel, BorderLayout.WEST);
        burgerPanel.add(titleLabel, BorderLayout.CENTER);

        // Add hover effect
        burgerPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                burgerPanel.setBackground(new Color(220, 220, 220));  // Light gray on hover
            }

            @Override
            public void mouseExited(MouseEvent e) {
                burgerPanel.setBackground(new Color(240, 240, 240));  // Original color
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(null, "Burger Button Clicked!");
            }
        });

        return burgerPanel;
    }



    private JPanel createBottomNav() {
        JPanel bottomNav = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 10));
        bottomNav.setPreferredSize(new Dimension(800, 50));

        bottomNav.add(createNavButton("Learn", "https://cdn-icons-png.flaticon.com/128/2921/2921226.png", () -> showPanel("Home")));
        bottomNav.add(createNavButton("Practice", "https://cdn-icons-png.flaticon.com/128/1039/1039185.png", () -> JOptionPane.showMessageDialog(this, "Practice Section")));
        bottomNav.add(createNavButton("Leaderboard", "https://cdn-icons-png.flaticon.com/128/1828/1828884.png", () -> JOptionPane.showMessageDialog(this, "Leaderboard Section")));
        bottomNav.add(createNavButton("CODEX", "https://cdn-icons-png.flaticon.com/128/6335/6335976.png", () -> JOptionPane.showMessageDialog(this, "CODEX Section")));
        bottomNav.add(createNavButton("Profile", "https://cdn-icons-png.flaticon.com/128/1077/1077114.png", () -> showPanel("Profile")));

        return bottomNav;
    }

    private JButton createNavButton(String text, String iconUrl, Runnable action) {
        JButton button = new JButton();
        button.setLayout(new BorderLayout());
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);

        ImageIcon icon = loadImage(iconUrl, 18, 18);
        JLabel iconLabel = new JLabel(icon, SwingConstants.CENTER);
        JLabel textLabel = new JLabel(text, SwingConstants.CENTER);
        textLabel.setFont(new Font("Verdana", Font.BOLD, 12));

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(iconLabel, BorderLayout.NORTH);
        panel.add(textLabel, BorderLayout.SOUTH);

        button.add(panel, BorderLayout.CENTER);
        button.addActionListener(e -> {
            action.run();
            setActiveButton(button);
        });

        return button;
    }

    private void showPanel(String panelName) {
        cardLayout.show(mainContentPanel, panelName);
        if (panelName.equals("Profile")) {
            getContentPane().remove(fixedTopPanel); // Remove top bar for profile
        } else {
            getContentPane().add(fixedTopPanel, BorderLayout.NORTH); // Add top bar for other panels
        }
        revalidate();
        repaint();
    }

    private ImageIcon loadImage(String url, int width, int height) {
        try {
            BufferedImage image = ImageIO.read(new URL(url));
            return new ImageIcon(image.getScaledInstance(width, height, Image.SCALE_SMOOTH));
        } catch (IOException e) {
            return new ImageIcon();
        }
    }

    private JPanel createStatLabelWithBorder(String text) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new RoundedBorder(20));
        panel.setPreferredSize(new Dimension(400, 100));
        JLabel label = new JLabel(text, SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 22));
        panel.add(label, BorderLayout.CENTER);
        return panel;
    }

    private JButton createPlayButton() throws MalformedURLException {
        URL imageUrl = new URL("https://cdn-icons-png.flaticon.com/512/727/727245.png");
        ImageIcon playIcon = new ImageIcon(new ImageIcon(imageUrl).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
        return new JButton(playIcon);
    }

    private JButton createCircleButton() {
        JButton button = new JButton();
        button.setBorder(new RoundBorder(38));
        button.setFocusable(false);
        button.setBackground(new Color(240, 240, 240));

        try {
            URL iconUrl = new URL("https://cdn-icons-png.flaticon.com/512/2232/2232688.png");
            ImageIcon bookIcon = new ImageIcon(new ImageIcon(iconUrl).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
            button.setIcon(bookIcon);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        final boolean[] isDragging = {false};

        button.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                initialClick = e.getPoint();
                isDragging[0] = false;
            }

            public void mouseReleased(MouseEvent e) {
                if (!isDragging[0]) {
                    JOptionPane.showMessageDialog(null, "Library Button Clicked!");
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(new Color(200, 200, 200)); // Hover color
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(new Color(240, 240, 240)); // Original color
            }
        });

        button.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                isDragging[0] = true;
                int thisX = button.getLocation().x;
                int thisY = button.getLocation().y;
                int xMoved = e.getX() - initialClick.x;
                int yMoved = e.getY() - initialClick.y;
                button.setLocation(thisX + xMoved, thisY + yMoved);
            }
        });

        return button;
    }




    private void setActiveButton(JButton button) {
        if (activeButton != null) {
            activeButton.setForeground(Color.BLACK);
        }
        activeButton = button;
        activeButton.setForeground(Color.DARK_GRAY);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                new home().setVisible(true);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        });
    }

    class RoundBorder extends AbstractBorder {
        private int radius;

        public RoundBorder(int radius) {
            this.radius = radius;
        }

        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
            g2d.dispose();
        }
    }

    class RoundedBorder implements Border {
        private int radius;

        public RoundedBorder(int radius) {
            this.radius = radius;
        }

        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
            g2d.dispose();
        }

        @Override
        public Insets getBorderInsets(Component c) {
            return new Insets(radius, radius, radius, radius);
        }

        @Override
        public boolean isBorderOpaque() {
            return false;
        }
    }
}
