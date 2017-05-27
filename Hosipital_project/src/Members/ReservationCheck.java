package Members;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ReservationCheck extends JFrame implements ActionListener {
	JLabel mentTop, mentBoT, name1, date1, disease1, dName1, time1;
	JLabel dName2, date2, disease2, time2;
	JButton reB, firstB, closeB;

	public ReservationCheck() {

	}

	public void check(String name, String date, String disease, String dName, String time) {
		mentTop = new JLabel("님");
		mentBoT = new JLabel("예약 되었습니다. 감사합니다.");
		name1 = new JLabel(name);
		date1 = new JLabel("예약날짜 :");
		date2 = new JLabel(date);
		disease1 = new JLabel("진료과목 :");
		disease2 = new JLabel(disease);
		dName1 = new JLabel("담당의사 :");
		dName2 = new JLabel(dName);
		time1 = new JLabel("예약시간 :");
		time2 = new JLabel(time);

		reB = new JButton("예약확인");
		firstB = new JButton("처음으로");
		closeB = new JButton("종료");

		// 폰트 설정
		Font font = new Font("sansSerif", 0, 12);
		mentTop.setFont(font);
		mentBoT.setFont(font);
		name1.setFont(font);
		date1.setFont(font);
		date2.setFont(font);
		disease1.setFont(font);
		disease2.setFont(font);
		dName1.setFont(font);
		dName2.setFont(font);
		time1.setFont(font);
		time2.setFont(font);

		JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel1.add(name1);
		panel1.add(mentTop);

		JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel2.add(disease1);
		panel2.add(disease2);

		JPanel panel3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel3.add(dName1);
		panel3.add(dName2);

		JPanel panel4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel4.add(date1);
		panel4.add(date2);
		panel4.add(time1);
		panel4.add(time2);

		JPanel panel5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel5.add(mentBoT);

		JPanel panel6 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel6.add(reB);
		panel6.add(firstB);
		panel6.add(closeB);

		JPanel top = new JPanel(new GridLayout(6, 1));
		top.add(panel1);
		top.add(panel2);
		top.add(panel3);
		top.add(panel4);
		top.add(panel5);
		top.add("Center", panel6);

		setLayout(new BorderLayout());
		add("Center", top);

		reB.addActionListener(this);
		firstB.addActionListener(this);
		closeB.addActionListener(this);

		setSize(500, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
	}

	public static void main(String[] args) {
		new ReservationCheck();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();

		if (obj == reB) {
			new SetLayout();

			setVisible(false);
		} else if (obj == firstB) {
			new SetLayout();
			setVisible(false);
		} else if (obj == closeB) {
			System.exit(0);
		}

	}
}
