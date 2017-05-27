package Members;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.*;

import Members.dao.MembersDAO;
import Members.dto.MembersDTO;
import Members.dto.MembersDTO2;

import javax.swing.border.*;

public class Hospital_cancel extends JFrame implements MouseListener, ActionListener {

	JLabel dateL, timeL, diseaseL;
	JTextField dateF, timeF, diseaseF;
	JButton deleteBtn, modifyBtn;

	MembersDTO2 mDto;

	public Hospital_cancel(MembersDTO2 dto) {
		mDto = dto;

		JPanel main = new JPanel();
		main.setBorder(new TitledBorder("예  약  현  황"));

		JPanel date = new JPanel();
		dateL = new JLabel("날   짜 : ");
		dateF = new JTextField(mDto.getRdto().getDates());
		date.add(dateL);
		date.add(dateF);

		JPanel time = new JPanel();
		timeL = new JLabel("시   간 : ");
		timeF = new JTextField(mDto.getRdto().getTime());
		time.add(timeL);
		time.add(timeF);

		JPanel disease = new JPanel();
		diseaseL = new JLabel("진료과목 : ");
		diseaseF = new JTextField(mDto.getRdto().getDisease());
		disease.add(diseaseL);
		disease.add(diseaseF);

		main.add(date);
		main.add(time);
		main.add(disease);

		JPanel mo = new JPanel();
		modifyBtn = new JButton("수   정");
		mo.add(modifyBtn);

		JPanel del = new JPanel();
		deleteBtn = new JButton("삭   제");
		del.add(deleteBtn);

		JPanel but = new JPanel();
		but.add(mo);
		but.add(del);

		add("Center", main);
		add("South", but);

		deleteBtn.addMouseListener(this);
		modifyBtn.addMouseListener(this);
		deleteBtn.addActionListener(this);
		modifyBtn.addActionListener(this);

		setSize(380, 200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);

	}// end Hospital_cacle()

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		String imfo = "";
		System.out.println(dateF.getText());
		MembersDAO dao = MembersDAO.getInstance();
		MembersDTO dto = MembersDTO.getInstance();

		if (obj == modifyBtn) {

			String date = dateF.getText();
			String time = timeF.getText();
			String disease = diseaseF.getText();
			String jumin = dto.getJumin();
			String m_code = mDto.getRdto().getM_code();
			String dates = mDto.getRdto().getDates();

			ArrayList<MembersDTO> mm = dao.listMethod(date, disease, time, jumin, m_code, dates);
			// dateF, timeF, diseaseF;

			imfo += "날      짜 : \t" + dateF.getText() + "\n";
			imfo += "시      간 : \t" + timeF.getText() + "\n";
			imfo += "진료과목 : \t" + diseaseF.getText() + "\n";
			imfo += "수 정 하 시 겠 습 니 까?";

			int option = JOptionPane.showConfirmDialog(this, imfo);
			setVisible(false);

		} // modifyBtn

		if (obj == deleteBtn) {

			String jumin = MembersDTO.getInstance().getJumin();
			String dates = dateF.getText();
			String time = timeF.getText();
			String disease = diseaseF.getText();

			ArrayList<MembersDTO> mm = dao.listMethod(jumin, dates, time, disease);

			imfo += MembersDTO.getInstance().getName() + "님의 예약정보를 삭제하시겠습니까?";
			int option = JOptionPane.showConfirmDialog(this, imfo);
			setVisible(false);
		} // delete()

	}// end actionPerformed()

	@Override
	public void mouseClicked(MouseEvent e) {

	}// end mouseClicked()

	@Override
	public void mouseEntered(MouseEvent e) {
		Object obj = e.getSource();
		if (obj == deleteBtn) {
			deleteBtn.setText("Delete");
		}
		if (obj == modifyBtn) {
			modifyBtn.setText("Modify");
		}

	}// end mouseEntered()

	@Override
	public void mouseExited(MouseEvent e) {
		Object obj = e.getSource();
		if (obj == deleteBtn) {
			deleteBtn.setText("삭   제");
		}
		if (obj == modifyBtn) {
			modifyBtn.setText("수  정");
		}

	}// end mouseExited()

	@Override
	public void mousePressed(MouseEvent e) {

	}// end mousePressed()

	@Override
	public void mouseReleased(MouseEvent e) {

	}// end mouseReleased()

}// end Hospital_cancle
