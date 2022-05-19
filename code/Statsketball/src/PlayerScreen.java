import java.awt.Image;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;

public class PlayerScreen extends JPanel {
	public PlayerScreen(Player player) {
		
		String name = player.getFirstName() + " " + player.getLastName();
		
		JLabel title = new JLabel(name, (int) CENTER_ALIGNMENT);
		title.setFont(Constants.TITLE_FONT);
		title.setBounds(Constants.WIDTH / 2 - 200, 50, 400, 100);
		add(title);
		
		JLabel playerPic = new JLabel();
		playerPic.setBounds(Constants.WIDTH / 2 - 100, 200, 300, 300);
		try {
			URL picURL = new URL("https://upload.wikimedia.org/wikipedia/commons/b/bf/LeBron_James_-_51959723161_%28cropped%29.jpg");
			Image playerPicImage = ImageIO.read(picURL);
			playerPic.setIcon(new ImageIcon(new ImageIcon(playerPicImage).getImage().getScaledInstance(200, 300, Image.SCALE_DEFAULT)));
		} catch(Exception e) {
			e.printStackTrace();
		}
		add(playerPic);

		setSize(Constants.WIDTH, Constants.HEIGHT);

		setLayout(null);
		setVisible(false);
	}
}
