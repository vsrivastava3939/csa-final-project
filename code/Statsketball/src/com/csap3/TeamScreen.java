package com.csap3;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.*;

/**
 * The type Team screen.
 *
 * @author Tejas Prabhune, Rushil Chandrupatla
 */
public class TeamScreen extends JPanel {
    /**
     * Instantiates a new Team screen.
     *
     * @param teamInfo the team info
     */
    public TeamScreen(ArrayList<EntityInfo> teamInfo) {
        Team team = (Team) teamInfo.get(0);
        TeamStats stats = (TeamStats) teamInfo.get(1);

        String name = team.getName();

        JLabel title = new JLabel(team.getFullName(), (int) CENTER_ALIGNMENT);
        title.setFont(Constants.TITLE_FONT);
        title.setBounds(Constants.WIDTH / 2 - 300, 50, 600, 100);
        add(title);

        JLabel teamPic = new JLabel();
        teamPic.setBounds(Constants.WIDTH / 2 - 100, 200, 300, 300);
        teamPic.setIcon(new ImageIcon(
                new ImageIcon("res/TeamPics/" + name + ".png").getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT)));
        add(teamPic);

        JLabel ppgLabel = new JLabel("Points per Game: ");
        ppgLabel.setFont(Constants.LABEL_FONT);
        ppgLabel.setBounds(150, 325, 200, 50);
        add(ppgLabel);

        JLabel ppgRLabel = new JLabel(Double.toString(stats.getPts()));
        ppgRLabel.setFont(Constants.LABEL_FONT);
        ppgRLabel.setBounds(315, 325, 200, 50);
        add(ppgRLabel);

        JLabel winLabel = new JLabel("Wins this Season: ");
        winLabel.setFont(Constants.LABEL_FONT);
        winLabel.setBounds(800, 325, 200, 50);
        add(winLabel);

        JLabel winRLabel = new JLabel(Double.toString(stats.getWins()));
        winRLabel.setFont(Constants.LABEL_FONT);
        winRLabel.setBounds(965, 325, 200, 50);
        add(winRLabel);

        setSize(Constants.WIDTH, Constants.HEIGHT);

        setLayout(null);
        setVisible(false);
    }
}
