package Members;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import Members.dao.MembersDAO;
import Members.dao.SortDAO;
import Members.dto.MembersDTO;
import Members.dto.MembersDTO2;

public class Hospital_model extends JFrame implements ActionListener {

	JComboBox sortC;
	JTextField searchF;
	JTable table;
	JScrollPane scroll;
	JButton searchB, closeB, mainB;
	DefaultTableModel tableModel;
	Object[] ob = new Object[5];
	int cnt = 0;

	ArrayList<MembersDTO> aList;
	ArrayList<MembersDTO2> cList;

	MembersDTO dto = MembersDTO.getInstance();

	public Hospital_model() {
		super("HRP : Hospital Reservation Progam");

		// 필드
		searchF = new JTextField(20);

		// 검색버튼 이미지경로
		String path = "src/Members/icon/";
		searchB = new JButton(new ImageIcon(path + "sear.png"));
		searchB.setBorderPainted(false);
		searchB.setContentAreaFilled(false);

		// 콤보박스
		String[] sort = { "------정렬------", "날짜순", "과목별", "시간순", "진료 완료" };
		sortC = new JComboBox(sort);

		// 테이블헤드
		Object[] cols = { "날짜", "시간", "병명", "담당의사", "진료여부" };
		tableModel = new DefaultTableModel(cols, 0) {

			// 셀 편집 불가능
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
		// 테이블
		table = new JTable(tableModel);
		scroll = new JScrollPane(table);

		table.setRowHeight(20); // 라인의 높이
		table.getColumnModel().getColumn(0).setPreferredWidth(98);
		table.getColumnModel().getColumn(1).setPreferredWidth(98);
		table.getColumnModel().getColumn(2).setPreferredWidth(78);
		table.getColumnModel().getColumn(3).setPreferredWidth(68);
		table.getColumnModel().getColumn(4).setPreferredWidth(48);
		table.getTableHeader().setReorderingAllowed(false);
		table.setRowSelectionAllowed(false);
		table.setColumnSelectionAllowed(false);

		table.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {

				if (e.getClickCount() == 2) {

					setInputRecord();

				}

			}
		});

		JPanel south = new JPanel();
		closeB = new JButton("닫   기");
		mainB = new JButton("메   인");

		south.add(closeB);
		south.add(mainB);

		JPanel north = new JPanel(new FlowLayout(FlowLayout.LEFT));
		north.add(sortC);
		north.add(new Label("     "));
		north.add(searchF);
		north.add(searchB);
		north.add("North", new JLabel("   진료여부(T/F)"));

		JPanel no = new JPanel(new BorderLayout());

		MembersDTO dto = MembersDTO.getInstance();
		no.setBorder(new TitledBorder(dto.getName() + "님의 예약현황"));
		no.add("North", north);
		no.add("Center", scroll);
		no.add("South", south);

		setLayout(new BorderLayout());
		add("Center", no);

		searchB.addActionListener(this);
		closeB.addActionListener(this);
		mainB.addActionListener(this);
		sortC.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {

				// 선택된 항목의 인덱스 반환
				int index = sortC.getSelectedIndex();

				// 선택된 항목의 문자열 반환
				String title = (String) sortC.getSelectedItem();
				SortDAO sdao = SortDAO.getInstance();
				MembersDAO mdao = MembersDAO.getInstance();

				tableModel.setRowCount(0);

				if (title == "날짜순") {
					cList = sdao.listMethod(dto.getName(), dto.getJumin());
					year(1);
				} // 날짜순

				if (title == "과목별") {
					cList = sdao.listMethod(dto.getJumin());
					year(1);

				} // 과목별

				if (title == "시간순") {
					cList = mdao.listMethod(dto.getJumin());
					year(1);
				}

				if (title == "진료 완료") {
					cList = sdao.listMethod(dto.getName(), dto.getJumin());
					year(2);

				} // 진료 완료

			}
		});

		setSize(550, 550);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);

	}// end Hospital_model()

	// 액션리스너
	@Override
	public void actionPerformed(ActionEvent e) {

		Object obj = e.getSource();
		String search = searchF.getText();
		String name = dto.getName();
		String jumin = dto.getJumin();

		if (obj == closeB) {
			setVisible(false);
		}

		if (obj == mainB) {
			SetLayout main = new SetLayout();
			main.setVisible(true);
			setVisible(false);

		}

		if (obj == searchB) {

			// 검색어 안썼을경우
			if (search.length() == 0) {
				int popup = JOptionPane.showConfirmDialog(this, "찾을 내용을 입력해주세요.", "오류", JOptionPane.OK_OPTION);
			}

			// 썼을경우
			else {
				tableModel.setRowCount(0);
				MembersDAO dao = MembersDAO.getInstance();
				cList = dao.listMethod(name, jumin, search);
				year(1);

			}
		}

	} // end actionPerformed

	public Object[] year(int a) {

		for (int i = 0; i < cList.size(); i++) {

			String dstr = new String(cList.get(i).getRdto().getDates());
			//String tstr = new String(cList.get(i).getRdto().getTime());

			long curr = System.currentTimeMillis();
			SimpleDateFormat aa = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String time = aa.format(curr);
			String st = new String(time);
			
			String[] s = dstr.split("-");

			// ~a:뽑아온 데이터 ~b:현재
			// 년도
			int yeara = (Integer.parseInt(s[0]));
			int yearb = Integer.valueOf(st.substring(0, 4)).intValue();
			// 월
			int montha = (Integer.parseInt(s[1]));
			int monthb = Integer.valueOf(st.substring(5, 7)).intValue();
			// 일
			int daya = (Integer.parseInt(s[2]));
			int dayb = Integer.valueOf(st.substring(8, 10)).intValue();
			// 시
			/*int hha = Integer.valueOf(tstr.substring(0, 2)).intValue();
			int hhb = Integer.valueOf(st.substring(11, 13)).intValue();
			// 분
			int mma = Integer.valueOf(tstr.substring(3, 5)).intValue();
			int mmb = Integer.valueOf(st.substring(14, 16)).intValue();*/
			// Object[] ob = new Object[5];
			ob[0] = cList.get(i).getRdto().getDates();
			ob[1] = cList.get(i).getRdto().getTime();
			ob[2] = cList.get(i).getRdto().getDisease();
			ob[3] = cList.get(i).getNdto().getM_name();

			if (yeara == yearb && montha == monthb && daya == dayb ) {
				ob[4] = "T";
				cnt++;
			} else if (yeara == yearb && montha == monthb && daya == dayb ) {
				ob[4] = "T";
				cnt++;
			} else if (yeara == yearb && montha == monthb && daya == dayb ) {
				ob[4] = "T";
				cnt++;
			} else if (yeara == yearb && montha == monthb && daya < dayb) {
				ob[4] = "T";
				cnt++;
			} else if (yeara == yearb && montha < monthb) {
				ob[4] = "T";
				cnt++;
			} else if (yeara < yearb) {
				ob[4] = "T";
				cnt++;
			} else if (yeara == yearb && montha == monthb && daya == dayb ) {
				ob[4] = "F";
			} else if (yeara == yearb && montha == monthb && daya == dayb ) {
				ob[4] = "F";
			} else if (yeara == yearb && montha == monthb && daya > dayb) {
				ob[4] = "F";
			} else if (yeara == yearb && montha > monthb) {
				ob[4] = "F";
			} else if (yeara > yearb) {
				ob[4] = "F";
			}
			// 셀 내용 가운데정렬
			DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
			dtcr.setHorizontalAlignment(SwingConstants.CENTER);
			TableColumnModel tcm = table.getColumnModel();
			for (int k = 0; k < tcm.getColumnCount(); k++) {
				tcm.getColumn(k).setCellRenderer(dtcr);
			}

			if (a == 1)
				tableModel.addRow(ob);

			else if (a == 2) {

				if (ob[4] == "T") {
					for (int j = 0; j < cnt; j++) {

						ob[0] = cList.get(i).getRdto().getDates();
						ob[1] = cList.get(i).getRdto().getTime();
						ob[2] = cList.get(i).getRdto().getDisease();
						ob[3] = cList.get(i).getNdto().getM_name();
						ob[4] = "T";

						// continue;

					}

					tableModel.addRow(ob);

				} // ob[4]=="T"

			} // else if

		}

		return ob;

	}// end year()

	private void setInputRecord() {

		int row = table.getSelectedRow();
		if (table.getValueAt(row, 4).toString() == "T") {
			int op = JOptionPane.showConfirmDialog(this, "진료가 완료된 항목은 수정 or 삭제가 불가능 합니다.", "취소", JOptionPane.OK_OPTION);
		}

		if (table.getValueAt(row, 4).toString() == "F") {
			

			int chan = JOptionPane.showConfirmDialog(this, "수정 or 삭제 하시겠습니까?", "취소", JOptionPane.OK_OPTION);
			if (chan == JOptionPane.YES_OPTION) {
				Hospital_cancel b = new Hospital_cancel(cList.get(row));
				b.setVisible(true);
			}
		}

	}// end setInputRecord()

	public static void main(String[] args) {
		new Hospital_model();

	}// end

}// end Hospital_model
