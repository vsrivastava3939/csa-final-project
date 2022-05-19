import javax.swing.*;
import java.awt.event.*;

public class Main {
	
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
		
		JButton searchPlayerButton = new JButton("SEARCH PLAYER");
		searchPlayerButton.setFont(Constants.LABEL_FONT);
		searchPlayerButton.setBounds(Constants.WIDTH / 2 - 325, 250, 300, 50);
		search.add(searchPlayerButton);
		
		JButton searchTeamButton = new JButton("SEARCH TEAM");
		searchTeamButton.setFont(Constants.LABEL_FONT);
		searchTeamButton.setBounds(Constants.WIDTH / 2 + 25, 250, 300, 50);
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
				Player player = APIHandler.makePlayer(0, nameInput.getText());
				System.out.println(player);
				PlayerScreen playerScreen = new PlayerScreen(player);
				frame.add(playerScreen);
				search.setVisible(false);
				playerScreen.setVisible(true);
			}
		});

		searchTeamButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
	}

	public static void main(String[] args) {
		new Main();
	}

}
