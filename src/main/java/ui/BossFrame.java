package ui;

import controller.Controller;
import entity.AppUser;

import javax.swing.*;
import java.awt.*;
import java.util.*;

/**
 * Created by Ovi on 24-May-16.
 */
public class BossFrame extends JFrame{

    Controller controller;
    AppUser currentUser;
    java.util.List<AppUser> presentsEmployes;

    public BossFrame(Controller controller, AppUser user) {
        this.controller = controller;
        this.currentUser = user;

        presentsEmployes = controller.getPresentsEmployes();
        addPanel();
    }

    public void addPanel() {
        JPanel bossPanel = new JPanel();

        JList<String> employeList = new JList<String>(getData());
        employeList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        employeList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        employeList.setVisibleRowCount(-1);
        JScrollPane listScroller = new JScrollPane(employeList);
        listScroller.setPreferredSize(new Dimension(250, 120));
        bossPanel.add(listScroller);

        add(bossPanel);
        setSize(400, 300);
        setBackground(Color.BLACK);
        setTitle("Monitorizare Angajati");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    private String[] getData() {
        String[] stringUsers = new String[presentsEmployes.size()];
        int count = 0;
        for (AppUser user : presentsEmployes) {
            stringUsers[count] = user.getName() + "\t" + user.getArriveHour();
            count++;
        }
        return stringUsers;
    }
}
