package com.csap3;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * The type Main.
 * @author Tejas Prabhune, Rushil Chandrupatla
 */
public class Main {

    /**
     * Instantiates a new Main.
     */
    public Main() {
        JFrame frame = new JFrame();
        frame.setSize(Constants.WIDTH, Constants.HEIGHT);
        frame.setVisible(true);

        HomeScreen home = new HomeScreen();
        JButton start = new JButton("START");
        start.setFont(Constants.LABEL_FONT);
        start.setBounds(Constants.WIDTH / 2 - 100, Constants.HEIGHT / 2 - 100, 200, 100);
        home.add(start);
        frame.add(home);

        SearchScreen search = new SearchScreen();

        JTextField nameInput = new JTextField();
        nameInput.setFont(Constants.LABEL_FONT);
        nameInput.setBounds(575, 150, 200, 50);
        search.add(nameInput);

        JTextField yearInput = new JTextField();
        yearInput.setFont(Constants.LABEL_FONT);
        yearInput.setBounds(575, 205, 200, 50);
        search.add(yearInput);

        JButton searchPlayerButton = new JButton("SEARCH PLAYER");
        searchPlayerButton.setFont(Constants.LABEL_FONT);
        searchPlayerButton.setBounds(Constants.WIDTH / 2 - 325, 300, 300, 50);
        search.add(searchPlayerButton);

        JButton searchTeamButton = new JButton("SEARCH TEAM");
        searchTeamButton.setFont(Constants.LABEL_FONT);
        searchTeamButton.setBounds(Constants.WIDTH / 2 + 25, 300, 300, 50);
        search.add(searchTeamButton);

        frame.add(search);

        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                home.setVisible(false);
                search.setVisible(true);
            }
        });

        searchPlayerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<EntityInfo> playerInfo = APIHandler.makePlayer(nameInput.getText(),
                        Integer.valueOf(yearInput.getText()));
                for(EntityInfo entity : playerInfo) {
                	System.out.println("Entity Instance Variables: " + entity.toString());
                }
                PlayerScreen playerScreen = new PlayerScreen(playerInfo);
                JButton backButton = new JButton("Back");
                backButton.setFont(Constants.LABEL_FONT);
                backButton.setBounds(Constants.WIDTH / 2 - 100, 550, 200, 50);
                playerScreen.add(backButton);

                backButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        playerScreen.setVisible(false);
                        search.setVisible(true);
                    }
                });

                frame.add(playerScreen);
                search.setVisible(false);
                playerScreen.setVisible(true);
            }
        });

        searchTeamButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<EntityInfo> teamInfo = APIHandler.makeTeam(nameInput.getText(),
                        Integer.valueOf(yearInput.getText()));
                for(EntityInfo entity : teamInfo) {
                	System.out.println("Entity Instance Variables: " + entity.toString());
                }
                TeamScreen teamScreen = new TeamScreen(teamInfo);

                JButton backButton = new JButton("Back");
                backButton.setFont(Constants.LABEL_FONT);
                backButton.setBounds(Constants.WIDTH / 2 - 100, 550, 200, 50);
                teamScreen.add(backButton);

                backButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        teamScreen.setVisible(false);
                        search.setVisible(true);
                    }
                });
                frame.add(teamScreen);
                search.setVisible(false);
                teamScreen.setVisible(true);
            }
        });
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        new Main();
    }

}
