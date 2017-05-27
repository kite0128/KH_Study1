package Manager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

import javax.swing.JFrame;

import Manager.dao.ManagerDAO;
import Manager.dto.ManagerDTO;

public class Login extends JFrame implements ActionListener {

	LoginPage page;
	ManagerDAO mdao;

	public Login() {
		page = new LoginPage();
		mdao = ManagerDAO.getInstance();

		page.btn_login.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj.equals(page.btn_login)) {

			String id = page.tfd_id.getText();
			int pw = Integer.parseInt(page.tfd_pw.getText());

			mdao.loginMethod(id, pw);
			clearText();

			// page.setVisible(false);
		}

	}

	// id,pw 입력창 리셋
	public void clearText() {
		page.tfd_id.setText("");
		page.tfd_pw.setText("");
	}

	public static void main(String[] args) {
		new Login();

	}

}
