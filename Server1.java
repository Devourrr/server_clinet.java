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
			ss = new ServerSocket(5050); //서버소켓 생성, 포트번호 5000~6000
			s = ss.accept(); //소켓 연결요청수락
			datain = new DataInputStream(s.getInputStream());
			dataout = new DataOutputStream(s.getOutputStream());//보조스트림 생성
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
