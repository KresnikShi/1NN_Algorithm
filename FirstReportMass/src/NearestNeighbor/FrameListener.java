package NearestNeighbor;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * 20*20マスのリスナー
 * @author s1710260
 *
 */
public class FrameListener implements MouseListener {

	String command;
	private static int counterAt, counterX;
	JButton button;
	MouseEvent event;

	public FrameListener(String command, JButton button, MouseEvent event) {
		this.command = command;
		this.button = button;
		this.event = event;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

		if (command == "@") {
			if (counterAt < 5) {
				button.setName("usedAt");
				button.setIcon(new ImageIcon("./image/icon-@.png"));
				counterAt++;
			}
		}

		if (command == "X") {
			if (counterX < 5) {
				button.setName("usedX");
				button.setIcon(new ImageIcon("./image/icon-X.png"));
				counterX++;
			}
		}
		// System.out.println(counter);

		if (counterAt == 5 || counterX == 5) {
			((JButton) event.getSource()).setBorder(BorderFactory
					.createRaisedBevelBorder());
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public static int getCounterX() {
		return counterX;
	}

}
