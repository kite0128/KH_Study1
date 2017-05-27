package Members;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Members.dao.loginDAO;

class Model extends JFrame implements ActionListener, KeyListener {
	int check = 0;
	JLabel label1, namel, juminl;
	JTextField nameTxt, juminTxt;
	// , juminTxt2;
	JPasswordField juminTxt2;
	JButton button;
	boolean focusButton;

	public Model() {

	}

	public Model(int check) {
		super(" HRP : Hospital Reservate Program ");
		this.check = check;

		setLayout(new BorderLayout());
		JPanel jp = new JPanel();
		label1 = new JLabel("정보 입력하기");
		jp.add(label1);

		JPanel main = new JPanel();

		JPanel id = new JPanel();
		namel = new JLabel("이 름  : ");
		nameTxt = new JTextField(15);
		id.add(namel);
		id.add(nameTxt);

		JPanel pw = new JPanel();
		juminl = new JLabel("주 민 번 호  :    ");
		juminTxt = new JTextField(6);
		// juminTxt = new JTextField(7);
		juminTxt2 = new JPasswordField(7);
		juminTxt2.setEchoChar('*'); // 뒷자리는 *로 표시된다.
		pw.add(juminl);
		pw.add(juminTxt);
		pw.add(new JLabel("-"));
		pw.add(juminTxt2);

		main.add(id);
		main.add(pw);

		JPanel bt = new JPanel();
		button = new JButton("확    인");
		button.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				Object obj = e.getKeyCode();
				if (obj == button && e.getKeyCode() == KeyEvent.VK_ENTER) {
				}
			}

		});
		bt.add(button);

		add("North", jp);
		add("Center", main);
		add("South", bt);

		button.addActionListener(this);
		juminTxt.addActionListener(this);
		juminTxt2.addActionListener(this);
		juminTxt.addKeyListener(this);
		juminTxt2.addKeyListener(this);

		setSize(300, 200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);

	}// Model()

	public void check(int check) {
		this.check(check);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Object obj = new Object();
		loginDAO dao = loginDAO.getInstance();
		String name = nameTxt.getText();
		String data = juminTxt.getText() + "-" + juminTxt2.getText();

		if (name.length() == 0) {
			int up = JOptionPane.showConfirmDialog(this, "이름을 입력해주세요.", "종료", JOptionPane.OK_OPTION);
		}
		if (data.length() != 14) {
			int pop = JOptionPane.showConfirmDialog(this, "주민번호13자리를 입력해주세요", "종료", JOptionPane.OK_OPTION);
		}

		if (name != null && data.length() == 14) {

			if (dao.listMethod(name, data) > 0) {

				int log = JOptionPane.showConfirmDialog(this, name + " 님 확인되었습니다.", "종료", JOptionPane.OK_OPTION);

				if (log == JOptionPane.YES_OPTION) {
					if (this.check == 1) {
						// 첫 화면에서 예약접수 클릭했을 떄
						new Reservation();
						setVisible(false);
					} else if (this.check == 2) {
						// 첫 화면에서 예약확인 클릭했을 때
						Hospital_model hmodel = new Hospital_model();
						setVisible(false);
						// hmodel.setVisible(true);
					}
				}

			} else {
				if (this.check == 1) {
					int po = JOptionPane.showConfirmDialog(this, "입력된 정보가 없습니다.\n개인정보 입력 후 예약가능합니다.", "종료",
							JOptionPane.OK_OPTION);
					if (po == JOptionPane.YES_OPTION) {
						new Reservation();
						setVisible(false);
					}

				} else if (this.check == 2) {
					int po = JOptionPane.showConfirmDialog(this, "입력된 정보가 없습니다.\n예약하기 메뉴에서 예약 접수해 주세요", "종료",
							JOptionPane.OK_OPTION);
					if (po == JOptionPane.YES_OPTION) {
						new Reservation();
						setVisible(false);
					}

				}

			}

		}

		setClear();
	}// end actionPerformed()

	public void setClear() {
		// nameTxt, juminTxt, juminTxt2
		nameTxt.setText("");
		juminTxt.setText("");
		juminTxt2.setText("");
		nameTxt.requestFocus();
	}// end set Clear()

	@Override
	public void keyPressed(KeyEvent e) {

	}

	// 주민 앞자리 6자리입력되면 자동으로 뒷자리필드로 이동 6자리 ,7자리 이상 입력못하게 하기
	@Override
	public void keyReleased(KeyEvent e) {
		String str = juminTxt.getText().trim();
		String strstr = null;
		if (str.length() >= 6) {
			if (str.length() > 6) {
				strstr = str.substring(0, 6);
				juminTxt2.setText(strstr);
			}
			juminTxt2.requestFocus();
		}
		String str1 = juminTxt2.getText().trim();
		String str2 = null;
		if (str1.length() >= 7) {
			if (str1.length() > 7) {
				str2 = str1.substring(0, 7);
				juminTxt2.setText(str2);
			}
			juminTxt2.requestFocus();
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

}// end model

public class Hospital_login {

	public static void main(String[] args) {

		// new Model(1);

	}// end main

}// end Hospital_login
