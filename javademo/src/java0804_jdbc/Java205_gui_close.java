package java0804_jdbc;

import javax.swing.JFrame;

class SwingClose extends JFrame{
	public SwingClose(){
		setSize(300,300);
		setVisible(true);
		//시스템 종료
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//초기화 상태(아무것도 하지 않음)
		//setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		//화면을 숨김(setVisible(false))
		//setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		//JFrame을 메모리에서 제거(그 창만 메모리에서 삭제됨, 메인은 그대로)
		//setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}
}


public class Java205_gui_close {

	public static void main(String[] args) {
		new SwingClose();

	}

}
