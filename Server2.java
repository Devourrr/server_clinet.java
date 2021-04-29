package week6day4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server2 {
	
	ServerSocket ss;
	Socket s;
	DataInputStream datain;
	DataOutputStream dataout;
	
	public Server2() {
		try {
			ss = new ServerSocket(5050); //�������� ����, ��Ʈ��ȣ 5000~6000
			s = ss.accept(); //���� �����û����
			datain = new DataInputStream(s.getInputStream());
			dataout = new DataOutputStream(s.getOutputStream());//������Ʈ�� ����
			System.out.println("server ready" + "\ncreate client socket");
			} catch (IOException e) {
			
			e.printStackTrace();
		} 
		recvData();//�ޱ�
		sendData();//������
	}
	private void sendData() {
		Scanner sc = new Scanner(System.in);
		String sendData = sc.nextLine();
		try {
			dataout.writeUTF(sendData); //UTF-8 �������� �ڵ��� ���ڿ��� ����Ѵ�.
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	private void recvData() {
		try {
			String recvData = datain.readUTF();
			System.out.println(recvData);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public static void main(String[] args) {

		new Server2();

	}

}
