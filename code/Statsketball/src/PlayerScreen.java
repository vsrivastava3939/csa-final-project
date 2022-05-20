import java.awt.Image;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;

public class PlayerScreen extends JPanel {

	public PlayerScreen(ArrayList<EntityInfo> playerInfo) {
		Player player = (Player) playerInfo.get(0);
		PlayerStats stats = (PlayerStats) playerInfo.get(1);

		String name = player.getFirstName() + " " + player.getLastName();

		JLabel title = new JLabel(name, (int) CENTER_ALIGNMENT);
		title.setFont(Constants.TITLE_FONT);
		title.setBounds(Constants.WIDTH / 2 - 200, 50, 400, 100);
		add(title);

		JLabel playerPic = new JLabel();
		playerPic.setBounds(Constants.WIDTH / 2 - 100, 200, 300, 300);
		try {
			URL picURL = new URL(APIHandler.getImage(APIHandler.replaceSpaces(name), false));
			System.out.println(picURL);
			Image playerPicImage = ImageIO.read(picURL);
			playerPic.setIcon(new ImageIcon(
					new ImageIcon(playerPicImage).getImage().getScaledInstance(200, 300, Image.SCALE_DEFAULT)));
		} catch (Exception e) {
			try {
				URL picURL = new URL("https://upload.wikimedia.org/wikipedia/commons/thumb/4/46/Question_mark_%28black%29.svg/800px-Question_mark_%28black%29.svg.png");
				Image playerPicImage = ImageIO.read(picURL);
				playerPic.setIcon(new ImageIcon(
						new ImageIcon(playerPicImage).getImage().getScaledInstance(200, 300, Image.SCALE_DEFAULT)));
			} catch(Exception f) {}
		}
		add(playerPic);

		JLabel ppgLabel = new JLabel("Points per Game: ");
		ppgLabel.setFont(Constants.LABEL_FONT);
		ppgLabel.setBounds(150, 250, 200, 50);
		add(ppgLabel);

		JLabel astLabel = new JLabel("Assists per Game: ");
		astLabel.setFont(Constants.LABEL_FONT);
		astLabel.setBounds(150, 325, 200, 50);
		add(astLabel);

		JLabel rpgLabel = new JLabel("Rebounds per Game: ");
		rpgLabel.setFont(Constants.LABEL_FONT);
		rpgLabel.setBounds(150, 400, 200, 50);
		add(rpgLabel);

		JLabel gpLabel = new JLabel("Games Played: ");
		gpLabel.setFont(Constants.LABEL_FONT);
		gpLabel.setBounds(800, 250, 200, 50);
		add(gpLabel);

		JLabel trLabel = new JLabel("Turnovers: ");
		trLabel.setFont(Constants.LABEL_FONT);
		trLabel.setBounds(800, 325, 200, 50);
		add(trLabel);

		JLabel stlLabel = new JLabel("Steals: ");
		stlLabel.setFont(Constants.LABEL_FONT);
		stlLabel.setBounds(800, 400, 200, 50);
		add(stlLabel);

		JLabel ppgRLabel = new JLabel(Double.toString(stats.getPts()));
		ppgRLabel.setFont(Constants.LABEL_FONT);
		ppgRLabel.setBounds(315, 250, 200, 50);
		add(ppgRLabel);

		JLabel astRLabel = new JLabel(Double.toString(stats.getAst()));
		astRLabel.setFont(Constants.LABEL_FONT);
		astRLabel.setBounds(320, 325, 200, 50);
		add(astRLabel);

		JLabel rpgRLabel = new JLabel(Double.toString(stats.getReb()));
		rpgRLabel.setFont(Constants.LABEL_FONT);
		rpgRLabel.setBounds(350, 400, 200, 50);
		add(rpgRLabel);

		JLabel gpRLabel = new JLabel(Double.toString(stats.getGamesPlayed()));
		gpRLabel.setFont(Constants.LABEL_FONT);
		gpRLabel.setBounds(940, 250, 200, 50);
		add(gpRLabel);

		JLabel trRLabel = new JLabel(Double.toString(stats.getTurnover()));
		trRLabel.setFont(Constants.LABEL_FONT);
		trRLabel.setBounds(900, 325, 200, 50);
		add(trRLabel);

		JLabel stlRLabel = new JLabel(Double.toString(stats.getStl()));
		stlRLabel.setFont(Constants.LABEL_FONT);
		stlRLabel.setBounds(865, 400, 200, 50);
		add(stlRLabel);

		setSize(Constants.WIDTH, Constants.HEIGHT);

		setLayout(null);
		setVisible(false);
	}
}
