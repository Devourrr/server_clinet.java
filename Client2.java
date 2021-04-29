package week6day4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client2 {

	Socket s;
	DataInputStream datain; //DataOutputStream �ڹ� �⺻ ������ Ÿ�� �����͸� �о�� �� ����
	DataOutputStream dataout;// �ڹ� �⺻������ Ÿ�Ժ��� ����ϴ� �޼ҵ���̺귯��
	//https://apphappy.tistory.com/69
	
	public Client2() {
		
		try {
			s= new Socket("localhost",5050);
			System.out.println("request server");
			datain = new DataInputStream(s.getInputStream()); //������ ������� ����
			dataout = new DataOutputStream(s.getOutputStream()); // ������ �۽���� ����
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sendData(); // ������ ������
		recvData(); // ������ �ޱ�
		
		
	}
	private void sendData() {
		Scanner sc = new Scanner(System.in);
		String sendData = sc.nextLine();
		try {
			dataout.writeUTF(sendData);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	private void recvData() {
		try {
			String recvData = datain.readUTF(); //UTF-8 �������� �ڵ��� ���ڿ��� �д´�.
			System.out.println(recvData);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		new Client2();

	}

}
