package com.csap3;

import javax.swing.*;

/**
 * The type Search screen.
 *
 * @author Tejas Prabhune, Rushil Chandrupatla
 */
public class SearchScreen extends JPanel {

    /**
     * Instantiates a new Search screen.
     */
    public SearchScreen() {
        JLabel title = new JLabel("Statsketball", (int) CENTER_ALIGNMENT);
        title.setFont(Constants.TITLE_FONT);
        title.setBounds(Constants.WIDTH / 2 - 200, 50, 400, 100);
        add(title);

        JLabel nameLabel = new JLabel("Player/Team Name: ");
        nameLabel.setFont(Constants.LABEL_FONT);
        nameLabel.setBounds(375, 150, 200, 50);
        add(nameLabel);

        JLabel yearLabel = new JLabel("Year: ");
        yearLabel.setFont(Constants.LABEL_FONT);
        yearLabel.setBounds(375, 205, 200, 50);
        add(yearLabel);

        setSize(Constants.WIDTH, Constants.HEIGHT);

        setLayout(null);
        setVisible(false);

    }


}
