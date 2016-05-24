package ui;

import controller.Controller;
import entity.AppUser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Ovi on 24-May-16.
 */
public class LoginFrame extends JFrame implements ActionListener{

    JTextField usernameTextField;
    JPasswordField passTextField;
    JButton loginButton;
    Controller controller;

    public LoginFrame(Controller controller) throws HeadlessException {
        this.controller = controller;
        addPanel();
    }

    private void addPanel() {
        JPanel loginPanel = new JPanel();

        JLabel usernameLabel = new JLabel("Username: ");
        loginPanel.add(usernameLabel);

        usernameTextField = new JTextField();
        usernameTextField.setPreferredSize(new Dimension(100, 30));
        loginPanel.add(usernameTextField);

        JLabel passwordLabel = new JLabel("Password: ");
        loginPanel.add(passwordLabel);

        passTextField = new JPasswordField();
        passTextField.setPreferredSize(new Dimension(100, 30));
        loginPanel.add(passTextField);

        loginButton = new JButton("LOGIN");
        loginButton.addActionListener(this);
        loginPanel.add(loginButton);

        add(loginPanel);
        setSize(250, 250);
        setBackground(Color.BLACK);
        setTitle("Monitorizare Angajati");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String username = usernameTextField.getText();
            String pass = passTextField.getText();
            AppUser user;
            try {
                user = controller.login(username, pass);
                if (user.isAdmin()) {
                    new BossFrame(controller, user);
                } else {

                }
                dispose();
                setVisible(false);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        }
    }
}
