package NearestNeighbor;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * 1NNを使う
 * 
 * @author s1710260
 * 
 */
public class OneNearestNeighbor {

	Point[] pointAt = new Point[5];
	Point[] pointX = new Point[5];
	List<Double> distanceAt;
	List<Double> distanceX;
	private JButton[][] buttons = new JButton[20][20];

	/**
	 * 1NN方法
	 */
	public void useONNMethod() {
		// System.out.println(buttons[0][0].getName());
		// get the coordinates of @ and X
		int numAt = 0;
		int numX = 0;
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 20; j++) {
				if (buttons[i][j].getName() == "usedAt") {
					pointAt[numAt] = new Point();
					pointAt[numAt].x = i;
					pointAt[numAt].y = j;
					numAt++;
				}

				if (buttons[i][j].getName() == "usedX") {
					pointX[numX] = new Point();
					pointX[numX].x = i;
					pointX[numX].y = j;
					numX++;
				}

			}
		}

		// 1NN method
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 20; j++) {
				if (buttons[i][j].getName() == null) {
					distanceAt = new ArrayList<Double>();
					distanceX = new ArrayList<Double>();
					for (int k = 0; k < 5; k++) {
						distanceAt.add(k, Math.hypot((i - pointAt[k].x), (j - pointAt[k].y)));
						distanceX.add(k, Math.hypot((i - pointX[k].x), (j - pointX[k].y)));
					}
					double minAt = getListMin(distanceAt);
					double minX = getListMin(distanceX);
					// System.out.println(minAt + " " + minX);
					if (minAt < minX) {
						buttons[i][j].setIcon(new ImageIcon("./image/icon-maru.png"));
					} else {
						buttons[i][j].setIcon(new ImageIcon("./image/icon-batsu.png"));
					}
				} else {
					continue;
				}
			}
		}
	}

	public double getListMin(List<Double> list) {
		double temp = list.get(0);
		// System.out.println("temp:" + temp);
		for (int i = 0; i < list.size() - 1; i++) {
			if (temp > Math.min(list.get(i), list.get(i + 1))) {
				temp = Math.min(list.get(i), list.get(i + 1));
			}
		}
		// System.out.println("temp:" + temp);
		return temp;
	}

	public static void main(String[] args) {
		OneNearestNeighbor onn = new OneNearestNeighbor();
		onn.useONNMethod();
	}

	public JButton[][] getButtons() {
		return buttons;
	}

	public void setButtons(JButton[][] buttons) {
		this.buttons = buttons;
	}
}