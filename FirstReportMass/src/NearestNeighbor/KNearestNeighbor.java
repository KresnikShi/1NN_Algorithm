package NearestNeighbor;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;

/**
 * use the knn method
 * @author s1710260
 * 
 */
public class KNearestNeighbor {

	Point[] pointAt = new Point[5];
	Point[] pointX = new Point[5];
	List<Double> distanceAt;
	List<Double> distanceX;
	private JButton[][] buttons = new JButton[20][20];
	static int kNeighbor = 5;

	/**
	 * KNN方法
	 */
	public void useKNNMethod() {
		// System.out.println(buttons[0][0].getName());

		//get the coordinates of @ and X
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
		
		//knn method
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 20; j++) {
				if(buttons[i][j].getName()==null){
					distanceAt = new ArrayList<Double>();
					distanceX = new ArrayList<Double>();
					for (int k = 0; k < 5; k++) {
						distanceAt.add(k, Math.hypot((i - pointAt[k].x), (j - pointAt[k].y)));
						distanceX.add(k, Math.hypot((i - pointX[k].x), (j - pointX[k].y)));
					}
				}
			}
		}
		
		upSortList(distanceAt,0,distanceAt.size());
		upSortList(distanceX,0,distanceX.size());

		
	}
	
	// sorting of list
	public void upSortList(List<Double> list, int low, int high) {
		Double privotKey = list.get(low);
		while (low < high) {
			while (list.get(high) >= privotKey)
				--high;
			swap(list, low, high);
			while (list.get(low) <= privotKey)
				++low;
			swap(list, low, high);
		}
	}
	
	public void swap(List<Double> list,int low,int high){
		Double temp1 = list.get(low);
		Double temp2 = list.get(high);
		list.add(low, temp2);
		list.add(high, temp1);
	}
	
	public void setButtons(JButton[][] buttons) {
		this.buttons = buttons;
	}
}
