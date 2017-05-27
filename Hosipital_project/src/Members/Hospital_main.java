package Members;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class SetLayout extends JFrame implements MouseListener {
	JButton resBtn, listBtn, closeBtn;
	JLabel timeLabel, titleLabel, resLabel, listLabel;

	public SetLayout() {

		// 창이름
		super("HRP : Hospital Reservation Progam");

		// 폰트
		Font font1 = new Font("sansSerif", Font.BOLD, 25);
		Font font2 = new Font("sansSerif", Font.PLAIN, 40);

		// 이미지 경로
		String path = "src/Members/icon/";

		// 친친병원
		setLayout(new BorderLayout());
		JPanel tl = new JPanel();
		titleLabel = new JLabel("H R P");
		tl.add(titleLabel);
		titleLabel.setFont(font2);
		tl.add(new Label("     "));

		// 현재시간
		long curr = System.currentTimeMillis();
		SimpleDateFormat aa = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String time = aa.format(curr);

		timeLabel = new JLabel("현재시간은  " + time + "  입니다.");
		tl.add(timeLabel);

		// <메인>
		JPanel main = new JPanel();
		// 이미지버튼
		JPanel rb = new JPanel();
		resBtn = new JButton(new ImageIcon(path + "reservation2.png"));
		listBtn = new JButton(new ImageIcon(path + "reservation_list2.png"));
		resBtn.setBorderPainted(false);
		resBtn.setContentAreaFilled(false);
		resBtn.setFocusPainted(false);
		listBtn.setBorderPainted(false);
		listBtn.setContentAreaFilled(false);
		rb.add(resBtn);
		rb.add(listBtn);

		// 라벨
		JPanel rl = new JPanel();
		resLabel = new JLabel("예약하기");
		listLabel = new JLabel("예약확인");
		resLabel.setFont(font1);
		listLabel.setFont(font1);
		rl.add(resLabel);
		rl.add(new Label("                                               "));
		rl.add(listLabel);

		main.add(rb);
		main.add(rl);

		// 전화번호
		JPanel close = new JPanel();
		closeBtn = new JButton("닫  기");
		close.add(closeBtn);

		// add
		add("North", tl);
		add("Center", main);
		add("South", close);

		// 마우스리스너 이벤트
		resBtn.addMouseListener(this);
		listBtn.addMouseListener(this);
		closeBtn.addMouseListener(this);

		setSize(550, 450);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);

	}// end SetLayout()

	@Override
	public void mouseClicked(MouseEvent e) {

	}// end mouseClicked

	@Override
	public void mouseEntered(MouseEvent e) {

	}// end mouseEntered

	@Override
	public void mouseExited(MouseEvent e) {

	}// end mouseExited

	@Override
	public void mousePressed(MouseEvent e) {
		Object obj = e.getSource();
		if (obj == resBtn) {
			Model login = new Model(1);
			// 1=>예약하기
			// login.check(1);
			login.setVisible(true);

		} else if (obj == listBtn) {
			Model login = new Model(2);
			// 2=>예약확인
			// login.check(2);
			login.setVisible(true);
		} else if (obj == closeBtn) {
			setVisible(false);
		}

	}// end mousePressed

	@Override
	public void mouseReleased(MouseEvent arg0) {
		setVisible(false);

	}// end mouseReleased
}

public class Hospital_main {

	public static void main(String[] args) {
		new SetLayout();
	}// end main

}// end class
