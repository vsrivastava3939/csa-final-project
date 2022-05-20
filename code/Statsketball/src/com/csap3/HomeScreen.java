package com.csap3;

import javax.swing.*;

/**
 * The type Home screen.
 *
 * @author Tejas Prabhune, Rushil Chandrupatla
 */
public class HomeScreen extends JPanel {

    /**
     * Instantiates a new Home screen.
     */
    public HomeScreen() {

        JLabel title = new JLabel("Statsketball", (int) CENTER_ALIGNMENT);
        title.setFont(Constants.TITLE_FONT);
        title.setBounds(Constants.WIDTH / 2 - 200, Constants.HEIGHT / 2 - 200, 400, 100);
        add(title);

        JLabel authors = new JLabel("By Tejas, Saaketh, Shray, Sourish, Vaibhav, and Rushil", (int) CENTER_ALIGNMENT);
        authors.setFont(Constants.LABEL_FONT);
        authors.setBounds(Constants.WIDTH / 2 - 500, Constants.HEIGHT / 2, 1000, 100);
        add(authors);

        setSize(Constants.WIDTH, Constants.HEIGHT);

        setVisible(true);
    }
}