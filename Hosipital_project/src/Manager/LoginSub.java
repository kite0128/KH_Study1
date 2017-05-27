package Manager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Manager.dao.ReservationDAO;
import Manager.dao.ReservationDAO2;
import Manager.dto.MembersDTO;
import Manager.dto.ReservationDTO;
import Manager.dto.ReservationDTO2;
import Members.ReservationCheck;
import Members.dao.ManagerDAO;
import Members.dao.MembersDAO;
import Members.dto.ManagerDTO;
import Members.dto.MembersDTO2;

class Members_join extends JPanel implements ActionListener, KeyListener {

	public int year, mon, day;
	public String m_code;
	Vector<String> time;
	Vector<String> timeR;

	// 환자 변수
	JLabel nameL, juminL, phoneL, genderL, addrL;
	JTextField nameF, jumin1F, jumin2F, phone1F, phone2F, addrF;
	JRadioButton genderW_R, genderM_R;
	JButton insertBtn, clearBtn;
	DefaultComboBoxModel phoneMmodel;
	JComboBox phoneC;

	// 예약 변수
	String dName;
	JLabel datesL, diseaseL, timeL, yearL, monthL, dayL, reL, dnameL, rTimeL, endL;
	DefaultComboBoxModel diseaseModel, mModel, dModel, timeModel;
	JRadioButton m_nameP, m_nameJ, m_nameK, m_nameN, m_nameB;
	JComboBox diseaseC;
	JComboBox<Object> yearC, mC, dC, timeC;

	// 핸드폰 앞번호
	Object[] phoneStr = { "010", "011", "016", "017", "018", "019" };
	// 진료 과목
	Object[] diseaseStr = { "  ::진료과목::", "외과", "내과", "신경외과", "정형외과", "소아과" };

	Calendar cal = Calendar.getInstance();
	Calendar yearCal = cal.getInstance();
	DefaultComboBoxModel<Object> yearModel;

	public Members_join() {

		// 년
		yearModel = new DefaultComboBoxModel<Object>();
		yearModel.addElement("  선택");
		for (int i = getYear(); i < getYear() + 2; i++) {
			yearModel.addElement(i);
		}

		yearC = new JComboBox<Object>(yearModel);
		yearC.setPreferredSize(new Dimension(65, 21));

		// 월
		mModel = new DefaultComboBoxModel<Object>();
		mModel.addElement("  선택");
		for (int i = 1; i <= 12; i++) {
			mModel.addElement(i);
		}
		mC = new JComboBox<Object>(mModel);
		mC.setPreferredSize(new Dimension(65, 21));

		// 일
		dModel = new DefaultComboBoxModel<Object>();
		dModel.addElement("  선택");
		dC = new JComboBox<Object>(dModel);
		dC.setPreferredSize(new Dimension(65, 21));

		// 예약시간
		timeModel = new DefaultComboBoxModel<Object>();
		timeModel.addElement("  선택");
		timeC = new JComboBox<Object>(timeModel);
		timeC.setPreferredSize(new Dimension(100, 21));
		// JLabel, JButton, JRadio 이름 지정
		nameL = new JLabel("성명 :");
		juminL = new JLabel("주민번호 :");
		phoneL = new JLabel("연락처 :");
		addrL = new JLabel("주소 :");
		genderL = new JLabel("성별 : ");
		diseaseL = new JLabel("진료과목 :");
		reL = new JLabel("예약날짜 :");
		yearL = new JLabel("년");
		monthL = new JLabel("월");
		dayL = new JLabel("일");
		dnameL = new JLabel("담당의사 :");
		dnameL.setVisible(false);
		rTimeL = new JLabel("예약시간 :");
		endL = new JLabel("예약가능한 시간이 없습니다. 다른 날짜를 선택해주세요");
		endL.setVisible(false);

		insertBtn = new JButton("예약하기");
		clearBtn = new JButton("초기화");
		genderW_R = new JRadioButton("여자");
		genderM_R = new JRadioButton("남자");
		m_nameP = new JRadioButton("박두리");
		m_nameK = new JRadioButton("김연성");
		m_nameJ = new JRadioButton("장성일");
		m_nameN = new JRadioButton("남궁은지");
		m_nameB = new JRadioButton("백나연");

		m_nameP.setVisible(false);
		m_nameK.setVisible(false);
		m_nameJ.setVisible(false);
		m_nameN.setVisible(false);
		m_nameB.setVisible(false);

		// 라디오 버튼을 그룹으로 묶어준다.
		ButtonGroup bg = new ButtonGroup();
		bg.add(genderW_R);
		bg.add(genderM_R);

		// 폰트 설정
		Font font = new Font("sansSerif", 0, 12);
		nameL.setFont(font);
		juminL.setFont(font);
		phoneL.setFont(font);
		addrL.setFont(font);
		genderL.setFont(font);
		diseaseL.setFont(font);
		yearL.setFont(font);
		monthL.setFont(font);
		dayL.setFont(font);
		reL.setFont(font);
		genderW_R.setFont(font);
		genderM_R.setFont(font);
		insertBtn.setFont(font);
		clearBtn.setFont(font);
		rTimeL.setFont(font);
		endL.setFont(font);

		phoneMmodel = new DefaultComboBoxModel(phoneStr);
		phoneC = new JComboBox(phoneMmodel);
		phoneC.setPreferredSize(new Dimension(65, 21));

		// 진료과목
		diseaseModel = new DefaultComboBoxModel(diseaseStr);
		diseaseC = new JComboBox(diseaseModel);
		diseaseC.setPreferredSize(new Dimension(100, 21));

		MembersDTO dto = MembersDTO.getInstance();

		// JTextField 크기 설정
		if (dto.getName() != null)
			nameF = new JTextField(dto.getName());
		else
			nameF = new JTextField(18);

		if (dto.getJumin() != null) {
			jumin1F = new JTextField(dto.getJumin().substring(0, 6));
			jumin2F = new JTextField(dto.getJumin().substring(7, 14));
		} else {
			jumin1F = new JTextField(6);
			jumin2F = new JTextField(7);
		}

		phone1F = new JTextField(4);
		phone2F = new JTextField(4);
		addrF = new JTextField(20);

		// 이름 TextField
		JPanel nameP = new JPanel(new FlowLayout(FlowLayout.LEFT));
		nameP.add(nameL);
		nameP.add(nameF);
		nameP.add(genderL);
		nameP.add(genderW_R);
		nameP.add(genderM_R);

		// 주민1 TextField
		JPanel jumin1P = new JPanel(new FlowLayout(FlowLayout.LEFT));
		jumin1P.add(jumin1F);

		// 주민2 TextField
		JPanel jumin2P = new JPanel(new FlowLayout(FlowLayout.LEFT));
		jumin2P.add(jumin2F);

		JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel1.add(nameP);

		// 주민 TextField 합치기
		JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel2.add(juminL);
		panel2.add(jumin1P);
		panel2.add(new JLabel("-"));
		panel2.add(jumin2P);

		// 연락처
		JPanel panel3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel3.add(phoneL);
		panel3.add(phoneC);
		panel3.add(new JLabel("-"));
		panel3.add(phone1F);
		panel3.add(new JLabel("-"));
		panel3.add(phone2F);

		// 주소
		JPanel panel4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel4.add(addrL);
		panel4.add(addrF);

		// 예약날짜
		JPanel panel5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel5.add(reL);
		panel5.add(yearC);
		panel5.add(yearL);
		panel5.add(mC);
		panel5.add(monthL);
		panel5.add(dC);
		panel5.add(dayL);

		// 진료과목
		JPanel panel6 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel6.add(diseaseL);
		panel6.add(diseaseC);
		panel6.add(dnameL);
		panel6.add(m_nameP);
		panel6.add(m_nameK);
		panel6.add(m_nameJ);
		panel6.add(m_nameB);
		panel6.add(m_nameN);

		// 예약시간
		JPanel panel7 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel7.add(rTimeL);
		panel7.add(timeC);
		panel7.add(endL);

		// 버튼
		JPanel buttonP = new JPanel();
		buttonP.add(insertBtn);
		buttonP.add(clearBtn);

		JPanel top = new JPanel(new GridLayout(8, 1));
		top.add(nameP);
		top.add(panel2);
		top.add(panel3);
		top.add(panel4);
		top.add(panel5);
		top.add(panel6);
		top.add(panel7);
		top.add("Center", buttonP);

		JPanel north = new JPanel(new BorderLayout());
		// north.setBorder(new TitledBorder("진료 예약 접수"));
		north.add("Center", top);

		setLayout(new BorderLayout());
		add("Center", north);

		// 이벤트 리스너 연결
		insertBtn.addActionListener(this);
		clearBtn.addActionListener(this);
		yearC.addActionListener(this);
		mC.addActionListener(this);
		dC.addActionListener(this);
		diseaseC.addActionListener(this);
		m_nameP.addActionListener(this);
		m_nameK.addActionListener(this);
		m_nameJ.addActionListener(this);
		m_nameN.addActionListener(this);
		m_nameB.addActionListener(this);	
		timeC.addActionListener(this);
		phone1F.addKeyListener(this);
		phone2F.addKeyListener(this);

		setSize(500, 400);
		setVisible(true);
	}// end 생성자//////////////////////////////////////////////////

	// 년도 구하기
	public int getYear() {
		return cal.get(Calendar.YEAR);
	}

	// 예약 등록
	public void insert() {
		// members 테이블에 저장할 변수
		String name, jumin, phone, gender, addr;

		// reservation 테이블에 저장할 변수
		String dates, disease, time;

		name = nameF.getText();
		jumin = jumin1F.getText() + "-" + jumin2F.getText();
		phone = (String) phoneC.getSelectedItem() + phone1F.getText() + phone2F.getText();

		dates = String.valueOf(yearC.getSelectedItem()) + "-" + String.valueOf(mC.getSelectedItem()) + "-"
				+ String.valueOf(dC.getSelectedItem());
		disease = (String) diseaseC.getSelectedItem();
		time = (String) timeC.getSelectedItem();

		if (genderW_R.isSelected()) {
			gender = "여";
		} else {
			gender = "남";
		}

		addr = addrF.getText();

		MembersDAO daoM = MembersDAO.getInstance();
		daoM.insertMethod(new MembersDTO2(name, jumin, phone, addr, gender));
		// String dates, String disease, String jumin, String name, String
		// m_code, String time
		ReservationDAO2 daoR = ReservationDAO2.getInstance();
		daoR.insertMethod(new ReservationDTO2(dates, disease, jumin, name, m_code, time));
		// name2, date2, subject2, doctor2, time2;
		/*
		 * ReservationCheck rc = new ReservationCheck(); rc.check(name, dates,
		 * disease, dName, time);
		 */
		setVisible(false);

	}

	// [초기화]버튼 클릭했을때 실행
	public void allClear() {
		nameF.setText("");
		jumin1F.setText("");
		jumin2F.setText("");
		phone1F.setText("");
		phone2F.setText("");
		addrF.setText("");
	}// end allClear()

	public int lastDay() {
		int year = this.year;
		int mon = this.mon;

		cal.set(year, mon - 1, 1);
		day = cal.getActualMaximum(Calendar.DATE);
		return day;
	}

	// 진료과목 선택하면 해당하는 의사정보 불러오기
	public void searchMethod(String name) {

		String msubject;

		ManagerDAO dao = ManagerDAO.getInstance();
		ArrayList<ManagerDTO> aList = dao.searchMethod(name);

		for (ManagerDTO dto : aList) {
			m_code = dto.getM_code();
			dName = dto.getM_name();
			msubject = dto.getM_subject();

			if (m_nameP.getText().equals(dName)) {
				dnameL.setVisible(true);
				m_nameP.setVisible(true);
				m_nameK.setVisible(false);
				m_nameJ.setVisible(false);
				m_nameN.setVisible(false);
				m_nameB.setVisible(false);
			} else if (m_nameK.getText().equals(dName)) {
				dnameL.setVisible(true);
				m_nameK.setVisible(true);
				m_nameP.setVisible(false);
				m_nameJ.setVisible(false);
				m_nameN.setVisible(false);
				m_nameB.setVisible(false);
			} else if (m_nameJ.getText().equals(dName)) {
				dnameL.setVisible(true);
				m_nameJ.setVisible(true);
				m_nameP.setVisible(false);
				m_nameK.setVisible(false);
				m_nameN.setVisible(false);
				m_nameB.setVisible(false);
			} else if (m_nameN.getText().equals(dName)) {
				dnameL.setVisible(true);
				m_nameN.setVisible(true);
				m_nameJ.setVisible(false);
				m_nameB.setVisible(false);
				m_nameP.setVisible(false);
				m_nameK.setVisible(false);
			} else if (m_nameB.getText().equals(dName)) {
				dnameL.setVisible(true);
				m_nameB.setVisible(true);
				m_nameN.setVisible(false);
				m_nameJ.setVisible(false);
				m_nameP.setVisible(false);
				m_nameK.setVisible(false);

			}
		}

	}// end searchMethod()

	// 예약 가능한 시간 구하기
	public void searchDate(String dcode) {
		time = new Vector<String>();
		timeR = new Vector<String>();
		timeR.add("9");
		timeR.add("10");
		timeR.add("11");
		timeR.add("12");
		timeR.add("1");
		timeR.add("2");
		timeR.add("3");
		timeR.add("4");
		timeR.add("5");
		String date = yearC.getSelectedItem() + "-" + mC.getSelectedItem() + "-" + dC.getSelectedItem();
		ReservationDAO2 dao = ReservationDAO2.getInstance();
		ArrayList<ReservationDTO2> aList = dao.searchDate(dcode);

		for (int i = 0; i < aList.size(); i++) {
			if (date.equals(aList.get(i).getDates())) {
				time.add(aList.get(i).getTime().substring(2).replace("시", ""));
			}
		}

		if (time.size() != 9) {
			for (int i = 0; i < timeR.size(); i++) {
				for (int j = 0; j < time.size(); j++) {
					if (timeR.get(i).equals(time.get(j))) {
						timeR.set(i, "");
					}
				}
			}

			for (int i = 0; i < timeR.size(); i++) {
				if (timeR.get(i) == "") {
					timeR.remove(i);
				}
			}
			for (int i = 0; i < timeR.size(); i++) {
				if (timeR.get(i) == "") {
					timeR.remove(i);
				}
			}
		}
	}// searchDate()

	// 예약시간 콤보박스 생성
	public void createComBo() {
		timeModel.removeAllElements();
		if (time.size() != 9) {
			timeModel.addElement("  선택");
			for (int i = 0; i < timeR.size(); i++) {
				if (Integer.parseInt(timeR.get(i)) >= 9) {
					timeModel.addElement("오전" + timeR.get(i) + "시");
				} else if (!(Integer.parseInt(timeR.get(i)) > 9)) {
					timeModel.addElement("오후" + timeR.get(i) + "시");
				}
			}
		} else {
			timeModel.removeAllElements();
			timeModel.addElement("예약마감");
			endL.setVisible(true);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == clearBtn) {
			allClear();
		} else if (obj == insertBtn) {
			insert();
		} else if (obj == yearC) {
			this.year = (Integer) yearC.getSelectedItem();

		} else if (obj == mC) {
			this.mon = (Integer) mC.getSelectedItem();

			for (int i = 1; i <= lastDay(); i++) {
				dModel.addElement(i);
			}

		} else if (obj == diseaseC) {
			searchMethod((String) diseaseC.getSelectedItem());
			if (diseaseC.getSelectedItem() == "  ::진료과목::") {
				dnameL.setVisible(false);
				m_nameK.setVisible(false);
				m_nameJ.setVisible(false);
				m_nameP.setVisible(false);
				m_nameN.setVisible(false);
				m_nameB.setVisible(false);
			}
		} else if (obj == m_nameP) {
			searchDate(m_code);
			createComBo();
		} else if (obj == m_nameK) {
			searchDate(m_code);
			createComBo();
		} else if (obj == m_nameJ) {
			searchDate(m_code);
			createComBo();
		} else if (obj == m_nameN) {
			searchDate(m_code);
			createComBo();
		} else if (obj == m_nameB) {
			searchDate(m_code);
			createComBo();
		}

	}// end actionPerformed

	// 전화번호 4자리 입력했으면 다음필드로 넘어가기
	@Override
	public void keyReleased(KeyEvent e) {
		String str = phone1F.getText().trim();
		String strstr = null;
		if (str.length() >= 4) {
			if (str.length() > 4) {
				strstr = str.substring(0, 4);
				phone2F.setText(strstr);
			}
			phone2F.requestFocus();
		}
		String str1 = phone2F.getText().trim();
		String str2 = null;
		if (str1.length() >= 7) {
			if (str1.length() > 7) {
				str2 = str1.substring(0, 7);
				phone2F.setText(str2);
			}
			phone2F.requestFocus();
		}
	}// end keyReleased()

	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}
}

class Members_edit extends JPanel implements ActionListener, MouseListener {

	JButton modify_btn, delete_btn, confirm_btn, format_btn;
	JScrollPane scrollpane;
	JTable table;
	DefaultTableModel model;
	JTextField tfd_search;
	JTextField tfd_dates, tfd_time, tfd_disease, tfd_jumin, tfd_m_code;

	private int crow = -1;

	ArrayList<MembersDTO> aList;
	ArrayList<MembersDTO2> mList;

	MembersDTO dto = MembersDTO.getInstance();

	public Members_edit() {

		Object[] obj = { "번호", "이름", "주민", "담당의사", "진료과", "예약일", "예약시간" };

		model = new DefaultTableModel(obj, 0) {
			public boolean isCellEditable(int row, int col) {

				return false;
			}
		};

		table = new JTable(model);
		table.getTableHeader().setReorderingAllowed(false); // 컬럼이동불가능
		table.setRowSelectionAllowed(false);
		table.setColumnSelectionAllowed(false);
		table.setRowHeight(20);
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(1).setPreferredWidth(45);
		table.getColumnModel().getColumn(2).setPreferredWidth(70);
		table.getColumnModel().getColumn(3).setPreferredWidth(45);
		table.getColumnModel().getColumn(4).setPreferredWidth(45);
		table.getColumnModel().getColumn(5).setPreferredWidth(60);
		table.getColumnModel().getColumn(6).setPreferredWidth(45);

		table.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					setInputRecord();
				}
			}
		});

		JPanel main = new JPanel(new BorderLayout());
		scrollpane = new JScrollPane(table);

		JPanel north = new JPanel();
		tfd_search = new JTextField(20);
		north.add(tfd_search);

		JPanel south = new JPanel();
		confirm_btn = new JButton("예약확인");
		modify_btn = new JButton("예약수정");
		delete_btn = new JButton("예약삭제");
		format_btn = new JButton("초기화");
		south.add(confirm_btn);
		south.add(delete_btn);
		south.add(format_btn);

		main.add("North", north);
		main.add("Center", scrollpane);
		main.add("South", south);

		setLayout(new BorderLayout());
		add("Center", main);

		confirm_btn.addActionListener(this);
		modify_btn.addActionListener(this);
		delete_btn.addActionListener(this);
		format_btn.addActionListener(this);

	}

	// private int crow멤버변수의 setter & getter메소드 정의
	public void setRow(int crow) {
		this.crow = crow;
	}// end setRow();

	public int getRow() {
		return crow;
	}

	// 테이블의 행 번호를 다시 생성하기 createNumber();
	public void createNumber() {
		for (int i = 0; i < table.getRowCount(); i++) {
			if (table.getValueAt(i, 0) == null)
				break;
			table.setValueAt(Integer.toString(i + 1), i, 0);
		}

	}// end createNumber

	// 메세지 형식1
	public void setMessage(String msg) {
		JLabel label = new JLabel(msg);
		label.setFont(new Font("sansSerif", 0, 13));
		label.setForeground(Color.blue);
		JOptionPane.showMessageDialog(this, label);
	}// end setMessage

	// 메세지 형식2
	public int getConfirmMessage(String msg) {
		JLabel label = new JLabel(msg);
		label.setFont(new Font("sanSerif", 0, 12));
		label.setForeground(new Color(255, 0, 0));
		return JOptionPane.showConfirmDialog(this, label, "메세지", JOptionPane.YES_NO_OPTION);
	}// end getConfirmMessage

	// 확인 메서드(입력값 있는 것)
	public void confirm() {
		int rows[] = table.getSelectedRows();
		ReservationDAO rdao = ReservationDAO.getInstance();
		ArrayList<ReservationDTO> aList = rdao.listMethod(tfd_search.getText());

		for (ReservationDTO rdto : aList) {
			Vector<Object> ob = new Vector<Object>();

			// "번호", "이름", "주민", "담당의사", "진료과", "예약일", "예약시간"
			ob.addElement(rdto.getNum());
			ob.addElement(rdto.getName());
			ob.addElement(rdto.getJumin());
			ob.addElement(rdto.getM_code());
			ob.addElement(rdto.getDisease());
			ob.addElement(rdto.getDates());
			ob.addElement(rdto.getTime());
			model.addRow(ob);
		}

	}
	// confirm end

	// 확인 메서드(입력값 없는 것)
	public void confirm2() {
		int rows[] = table.getSelectedRows();
		ReservationDAO rdao = ReservationDAO.getInstance();
		ArrayList<ReservationDTO> aList = rdao.listMethod();

		for (ReservationDTO rdto : aList) {
			Vector<Object> ob = new Vector<Object>();

			// "번호", "이름", "주민", "담당의사", "진료과", "예약일", "예약시간"
			ob.addElement(rdto.getNum());
			ob.addElement(rdto.getName());
			ob.addElement(rdto.getJumin());
			ob.addElement(rdto.getM_code());
			ob.addElement(rdto.getDisease());
			ob.addElement(rdto.getDates());
			ob.addElement(rdto.getTime());

			model.addRow(ob);
		}

	}
	// confirm end

	// 수정 메서드
	public void setModify() {

		String dates = tfd_dates.getText();
		String time = tfd_dates.getText();
		String disease = tfd_dates.getText();
		String jumin = tfd_dates.getText();
		String m_code = tfd_dates.getText();

		int rows[] = table.getSelectedRows();
		ReservationDAO dao = ReservationDAO.getInstance();
		ArrayList<ReservationDTO> aList = dao.modifyMethod(dates, time, disease, jumin, m_code);

		if (rows.length < 1) {
			setMessage("수정할 항목을 선택하세요 :)");
			return;
		}

		String msg = "선택된 항목을 모두 수정하시겠습니까?";
		if (getConfirmMessage(msg) != 0) {
			return;
		}

	}
	// modify end

	// 삭제 메서드
	public void delete() {

		int rows[] = table.getSelectedRows();
		int row = table.getSelectedRow();
		ReservationDAO dao = ReservationDAO.getInstance();
		ArrayList<ReservationDTO> aList = dao.deleteMethod(row);

		// getSelectedRows()는 선택된 행이 없을 경우 empty array발생함
		// 선택된 행이 있는지 체크함
		if (rows.length < 1) {
			setMessage("삭제할 레코드를 선택하세요.");
			return;
		}
		String msg = "선택된 항목을 모두 삭제하시겠습니까?";
		if (getConfirmMessage(msg) != 0) {
			return;
		}
		for (int i = rows.length - 1; i >= 0; i--) {
			// 빈레드인지 체크함
			if (table.getValueAt(i, 0) == null)
				continue;

			model.removeRow(rows[i]);
		}

	}
	// delete end

	// 초기화 메서드
	public void format() {
		// int rows[] = table.getSelectedRows();
		ReservationDAO rdao = ReservationDAO.getInstance();
		ArrayList<ReservationDTO> aList = rdao.formatMethod();

		String msg = "초기화 하시겠습니까?";
		if (getConfirmMessage(msg) != 0) {
			return;
		}

		setTableClear();
	}
	// format end

	// 표(모델)지우기
	public void setTableClear() {

		model.setNumRows(0);
		// model.setNumRows(50);
	}

	// 두 번 클릭할 때 실행되는 창 메서드
	private void setInputRecord() {
		int row = table.getSelectedRow();
		int chan = JOptionPane.showConfirmDialog(this, "수정 하시겠습니까?", "취소", JOptionPane.OK_OPTION);
		if (chan == JOptionPane.YES_OPTION) {
			ModifySub m_sub = new ModifySub();
			m_sub.setVisible(true);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Object obj = e.getSource();
		String search = tfd_search.getText();

		if (obj == modify_btn)
			setModify();
		else if (obj == delete_btn)
			delete();
		else if (obj == confirm_btn) {
			if (search.length() == 0) {

				confirm2();
			} else
				confirm();
		}

		else if (obj == format_btn)
			format();

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}
}

public class LoginSub extends JFrame implements ActionListener, MouseListener {

	JMenuBar menubar;
	JMenu m_manager, m_members;
	JMenuItem mi_manager, mi_members;
	JTabbedPane tab_members;

	public Members_join m_join;
	public Members_edit m_edit;

	public LoginSub() {

		// 메뉴
		menubar = new JMenuBar();

		m_manager = new JMenu("직원관리");
		m_members = new JMenu("환자관리");
		mi_manager = new JMenuItem("수정/현황");
		mi_members = new JMenuItem("예약 등록/수정/현황");
		m_manager.add(mi_manager);
		m_members.add(mi_members);

		menubar.add(m_manager);
		menubar.add(m_members);
		this.setJMenuBar(menubar);

		// 탭, 패널
		tab_members = new JTabbedPane();

		m_join = new Members_join();
		m_edit = new Members_edit();

		tab_members.addTab("예약등록", m_join);
		tab_members.addTab("예약현황", m_edit);

		// getContentPane().add(tab_members, BorderLayout.CENTER);
		this.add(tab_members);

		mi_manager.addMouseListener(this);
		mi_members.addMouseListener(this);

		setTitle("HMP : Hosipital Manager Program");
		setSize(600, 600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {

		if (e.getSource() == mi_manager) {
			// manager_panel.setBounds(0, 0, 700, 650);

		} else if (e.getSource() == mi_members) {
			// tab_members.setBounds(0, 0, 700, 550);

		}

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		LoginSub ls = new LoginSub();

	}

}
