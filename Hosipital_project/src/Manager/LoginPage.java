package Manager;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class LoginPage extends JFrame {

	LoginPage selfFrame;

	JLabel lbl_id;
	JTextField tfd_id;

	JLabel lbl_pw;
	JPasswordField tfd_pw;

	JButton btn_login;

	public LoginPage() {

		// selfFrame = this;

		Font font = new Font("sansSerif", 0, 17);

		lbl_id = new JLabel("ID");
		lbl_id.setFont(font);
		lbl_id.setBounds(15, 10, 30, 40);
		this.add(lbl_id);

		lbl_pw = new JLabel("PW");
		lbl_pw.setFont(font);
		lbl_pw.setBounds(10, 60, 30, 40);
		this.add(lbl_pw);

		tfd_id = new JTextField();
		tfd_id.setFont(font);
		tfd_id.setBounds(55, 10, 180, 40);
		this.add(tfd_id);

		tfd_pw = new JPasswordField();
		tfd_pw.setFont(font);
		tfd_pw.setBounds(55, 60, 180, 40);
		this.add(tfd_pw);

		btn_login = new JButton("로그인");
		btn_login.setBounds(250, 10, 120, 90);
		this.add(btn_login);

		this.setLayout(null);
		this.setTitle("HMP : Hosipital Manager Program");
		this.setVisible(true);
		this.setSize(400, 140);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setResizable(false);

	}

}
