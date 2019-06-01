package com.space_distortion.event;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.space_distortion.controller.SpaceController;
import com.space_distortion.view.ViewIndex;

public class SpaceActionEvent implements MouseListener, ViewIndex{

	
	private int viewIndex; // ����ϴ� ���� �ε���
	private int buttonIndex;
	private SpaceController sc;
	private JFrame jf;
	private JPanel jp;
	
	public SpaceActionEvent(int viewIndex, int buttonIndex, SpaceController sc, JFrame jf ,JPanel jp) {
		super();
		this.viewIndex = viewIndex;
		this.buttonIndex = buttonIndex;
		this.sc = sc;
		this.jf = jf;
		this.jp = jp;
		System.out.println("������ : " + this.buttonIndex + " / " + buttonIndex);
	}

	public SpaceActionEvent() {
		System.out.println("�⺻ ������ :" + buttonIndex);
		// TODO Auto-generated constructor stub
	}
	
/////////  �� �̺�Ʈ �޼ҵ�  /////////////////////////////////////////////////////////////////
	
	// ���κ� ��ư �̺�Ʈ
	public void mainViewSelected() {
		System.out.println("���ι�ư Ŭ�� �̺�Ʈ");
		
		if(buttonIndex == 1) {
			System.out.println("1���� ����");
			jf.remove(jp);
			//jp.revalidate();
			//jp.repaint();
			sc.subRoomView();
			// ���� �α��� ��
		}
		else if(buttonIndex == 2) {
			System.out.println("2���� ����");
		}else if(buttonIndex == 3) {
			System.out.println("���� �մϴ�.");
//			System.out.println(this.buttonIndex);
			System.exit(0);
		}	
		else
			System.out.println("err....");
	}

	// ���κ� ���� �̺�Ʈ
	public void subRoomViewSelected() {
		System.out.println("���� ����� �̺�Ʈ");
		// ȸ��, ��ȸ��, ����, Ȩ����
		if(buttonIndex == 1) {
			System.out.println("ȸ�� ��ư ����");
//			System.out.println(this.buttonIndex);
			jf.remove(jp);
			sc.loginView();
		}
		System.out.println(buttonIndex);
		if(buttonIndex == 2) {
			System.out.println("�� ȸ�� ����");
//			System.out.println(this.buttonIndex);
			jf.remove(jp);
			//jp.revalidate();
			//jp.repaint();
			sc.paymentView();
			
		}else if(buttonIndex == 3) {
			System.out.println("���� ����");
//			System.out.println(this.buttonIndex);
			// ���� view load
		}else if(buttonIndex == 4) {
			System.out.println("�ڷ� ���� ����");
//			System.out.println(this.buttonIndex);
			jf.remove(jp);
			sc.mainView();
		}else
			System.out.println("err....");
		
		
		
	}
	
	// �α� ��ư �̺�Ʈ
	public void loginViewSelected() {
		System.out.println("�α��ư Ŭ�� �̺�Ʈ");
		// ȸ�� ����, �α�, ID & PW ã��
		
		if(buttonIndex == 1) {
			System.out.println("ȸ�� ���� ����");
			jf.remove(jp);
			sc.accoutView();
		}else if(buttonIndex == 2) {
			System.out.println("ȸ�� �α� ����");
			
			// �α� ���� ��/�� �Ŀ� ���� ���̷� �̵�
			
			jf.remove(jp);
			sc.paymentView();
		}else if(buttonIndex == 3) {
			System.out.println("ID & PW ã��");
			// ã�� �������� �̵�
		}else
			System.out.println("err....");

	}
	
	// ȸ�� ���� �̺�Ʈ
	public void accountViewSelected() {
		System.out.println("ȸ�� ���� ��ư Ŭ�� �̺�Ʈ");
		
		if(buttonIndex == 1) {
			System.out.println("Ȩ����");
			jf.remove(jp);
			sc.mainView();
		}else if(buttonIndex == 2) {
			System.out.println("��������");
			jf.remove(jp);
			sc.accoutView2();
		}
		
	}
	
	// ȸ�� ���� ���� �̺�Ʈ
	public void subAccountViewSelected() {
		System.out.println("���� ȸ�� ���� ��ư Ŭ�� �̺�Ʈ");
		
		if(buttonIndex == 1) {
			System.out.println("Ȩ����");
			jf.remove(jp);
			sc.mainView();
		}else if(buttonIndex == 2) {
			System.out.println("ȸ�� ���� Ȯ��");
			jf.remove(jp);
			sc.paymentView();
		}
		
	}
	
	// �߰��ð� �̺�Ʈ
	public void addTimeRoomViewSelected() {
		System.out.println("�߰� �ð� ��ư Ŭ�� �̺�Ʈ");
		
	}
	
	// ������ �̺�Ʈ
	public void adminViewSelected() {
		System.out.println("������ ��ư Ŭ�� �̺�Ʈ");
		
	}
	
	// �������� �̺�Ʈ
	public void paymentViewSelected() {
		System.out.println("�������� ��ư Ŭ�� �̺�Ʈ");
		
		if(buttonIndex == 1) {
			System.out.println("ȸ�� ���� ����");
			jf.remove(jp);
			sc.accoutView();
		}else if(buttonIndex == 2) {
			System.out.println("���� �ϱ�");
			// ���� ����
		}else if(buttonIndex == 3) {
			System.out.println("Ȩ����");
			jf.remove(jp);
			sc.mainView();
		}else
			System.out.println("err....");

		
		
		
		
	}
	
	// ���� �� �̺�Ʈ
	public void snackViewSelected() {
		System.out.println("���� ��ư Ŭ�� �̺�Ʈ");
		
	}

	
///////// �� �̺�Ʈ          /////////////////////////////////////////////////////////////////
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		switch (viewIndex) {
		case MAIN_ROOM_VIEW_NUM:
			this.mainViewSelected();
			break;
		case SUB_ROOM_VIEW_NUM:
			this.subRoomViewSelected();
			break;
		case LOGIN_VIEW:
			this.loginViewSelected();
			break;
		case ACCOUNT_VIEW_NUM:
			this.accountViewSelected();
			break;
		case ACCOUNT_SUB_LOGIN_VIEW:
			this.subAccountViewSelected();
			break;
		case ADD_TIME_ROOM_VIEW_NUM:
			this.addTimeRoomViewSelected();
			break;
		case ADMIN_VIEW_NUM:
			this.adminViewSelected();
			break;
		case PAYMENT_VIEW_NUM:
			this.paymentViewSelected();
			break;
		case SNACK_BAR_VIEW_NUM:
			this.snackViewSelected();
			break;

		default:
			break;
		}

			
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		lvRegister = (JButton)e.getSource();
//		if(lvRegister ==lv.getBtn_Register() )
//		{
//			//ȸ�����Ժ��
//			av.showThisView();
//		}		
//	}
	
	
	
	
}
