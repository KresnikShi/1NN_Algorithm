package NearestNeighbor;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * ボタンのリスナー
 * 
 * @author s1710260
 * 
 */
public class ButtonListener implements MouseListener {

	String command;
	private JButton[][] buttons = new JButton[20][20];
	private JFrame frame;
	OneNearestNeighbor onn = new OneNearestNeighbor();
	KNearestNeighbor knn = new KNearestNeighbor();

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public void actionPerformed(ActionEvent e) {

	}

	/**
	 *  listeners of buttons
	 */
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		command = ((JButton) e.getSource()).getText();

		switch (command) {
		case "@":
			((JButton) e.getSource()).setBorder(BorderFactory
					.createLoweredBevelBorder());
			for (int i = 0; i < 20; i++) {
				for (int j = 0; j < 20; j++) {
					buttons[i][j].addMouseListener(new FrameListener(command, buttons[i][j], e));
				}
			}
			break;

		case "X":
			((JButton) e.getSource()).setBorder(BorderFactory
					.createLoweredBevelBorder());
			for (int i = 0; i < 20; i++) {
				for (int j = 0; j < 20; j++) {
					buttons[i][j].addMouseListener(new FrameListener(command, buttons[i][j], e));
				}
			}

			break;

		case "1NN":
			onn.setButtons(buttons);
			onn.useONNMethod();
			break;

		case "KNN":
			knn.setButtons(buttons);
			knn.useKNNMethod();
			break;

		case "Random":
			Random rand = new Random();
			int[] x = new int[10];
			int[] y = new int[10];
			x[0] = rand.nextInt(20);
			y[0] = rand.nextInt(20);
			for (int i = 0; i < 10; i++) {
				x[i] = rand.nextInt(20);
				y[i] = rand.nextInt(20);
				for (int j = 0; j < i; j++) {
					if (x[i] == x[j] && y[i] == y[j]) {
						x[i] = rand.nextInt(20);
						y[i] = rand.nextInt(20);
						continue;
					}
				}
				// System.out.println(x[i] + " " + y[i]);
			}

			for (int n = 0; n < 10; n++) {
				if (n < 5) {
					buttons[x[n]][y[n]].setIcon(new ImageIcon("./image/icon-@.png"));
					buttons[x[n]][y[n]].setName("usedAt");
				} else {
					buttons[x[n]][y[n]].setIcon(new ImageIcon("./image/icon-X.png"));
					buttons[x[n]][y[n]].setName("usedX");
				}
			}

			break;

		case "Reset":
			// panel.removeAll();

			// frame.revalidate();
			// frame.repaint();
			frame.dispose();
			MassTwenty mass = new MassTwenty();
			mass.paintMass();
			break;
		}
	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public JButton[][] getButtons() {
		return buttons;
	}

	public void setButtons(JButton[][] buttons) {
		this.buttons = buttons;
	}
}
