package java0804_jdbc;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

class WinView extends Frame{
	public WinView(){
		
		setSize(300,400); //300은 가로, 400은 세로
		setVisible(true); //창 보이게
		//이벤트가 발생된 컴포넌트.addWindowListener(이벤트리스터);
		this.addWindowListener(new CloseWin());
	}
}

/*
 * Window 컴포넌트에서 이벤트발생
 * WindowEvent -> WindowListener -> addWindowListener()
 * 
 * Button 컴포넌트에서 이벤트발생
 * ActioneEvent -> ActionListener -> addActionListener()
 */

class CloseWin implements WindowListener{

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		System.exit(0);
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}

public class Java201_gui {

	public static void main(String[] args) {
			WinView wn = new WinView();

	}

}
