package week6day4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server1 {

	ServerSocket ss;
	Socket s;
	DataInputStream datain;
	DataOutputStream dataout;
	
	public Server1() {
		try {
			ss = new ServerSocket(5050); //�������� ����, ��Ʈ��ȣ 5000~6000
			s = ss.accept(); //���� �����û����
			datain = new DataInputStream(s.getInputStream());
			dataout = new DataOutputStream(s.getOutputStream());//������Ʈ�� ����
			System.out.println("server ready" + "\ncreate client socket");
			
		
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	public static void main(String[] args) {

		new Server1();

	}

}
