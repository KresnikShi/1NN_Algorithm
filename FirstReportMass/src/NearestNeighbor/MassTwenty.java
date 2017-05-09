package NearestNeighbor;

import javax.swing.*;

import java.awt.*;

/**
 * ２０×２０のマスを作る
 * 
 * @author s1710260
 * 
 */
public class MassTwenty extends JPanel {

	private static final long serialVersionUID = 1L;

	JFrame frame = new JFrame();
	// ボタン
	JButton AtButton = new JButton("@");
	JButton XButton = new JButton("X");
	JButton OneNNMethod = new JButton("1NN");
	JButton KNNMethod = new JButton("KNN");
	JButton RandomButton = new JButton("Random");
	JButton ResetButton = new JButton("Reset");
	Image IconImage = Toolkit.getDefaultToolkit().getImage("./image/icon.png");
	JButton[][] MassButton = new JButton[20][20];
	ButtonListener ButtonListener = new ButtonListener();

	// ２０×２０のマス
	public static final int COMS = 30;
	public static final int NUMS = 20;

	/**
	 * ２０×２０マスの画面
	 */
	public void paintMass() {

		frame.setTitle("20*20mass");
		frame.setSize(727, 630);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setLayout(null);

		AtButton.setToolTipText("５つのみ");
		XButton.setToolTipText("５つのみ");
		AtButton.setBounds(10, 10, 100, 30);
		XButton.setBounds(10, 50, 100, 30);
		OneNNMethod.setBounds(10, 90, 100, 30);
		KNNMethod.setBounds(10, 130, 100, 30);
		RandomButton.setBounds(10, 170, 100, 30);
		ResetButton.setBounds(10, 210, 100, 30);
		
		// ボタンを加える
		this.add(AtButton);
		this.add(XButton);
		this.add(OneNNMethod);
		this.add(KNNMethod);
		this.add(RandomButton);
		this.add(ResetButton);

		AtButton.addMouseListener(ButtonListener);
		XButton.addMouseListener(ButtonListener);
		OneNNMethod.addMouseListener(ButtonListener);
		KNNMethod.addMouseListener(ButtonListener);
		RandomButton.addMouseListener(ButtonListener);
		ResetButton.addMouseListener(ButtonListener);

		// マスをコンテナに入る
		for (int i = 0; i < NUMS; i++) {
			for (int j = 0; j < NUMS; j++) {
				MassButton[i][j]=new JButton(new ImageIcon("./image/icon.png"));
				MassButton[i][j].setBounds(120+COMS*j, COMS*i, 30, 30);
				this.add(MassButton[i][j]);
			}
		}
		ButtonListener.setButtons(MassButton);
		
		frame.add(this);
		frame.setResizable(false);
		// 中心にする
		frame.setLocationRelativeTo(getRootPane());
		frame.setVisible(true);
		ButtonListener.setFrame(frame);
	}
	
	public static void main(String[] args) {
		MassTwenty mass = new MassTwenty();
		mass.paintMass();
	}

};
