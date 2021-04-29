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
			ss = new ServerSocket(5050); //서버소켓 생성, 포트번호 5000~6000
			s = ss.accept(); //소켓 연결요청수락
			datain = new DataInputStream(s.getInputStream());
			dataout = new DataOutputStream(s.getOutputStream());//보조스트림 생성
			System.out.println("server ready" + "\ncreate client socket");
			} catch (IOException e) {
			
			e.printStackTrace();
		} 
		recvData();//받기
		sendData();//보내기
	}
	private void sendData() {
		Scanner sc = new Scanner(System.in);
		String sendData = sc.nextLine();
		try {
			dataout.writeUTF(sendData); //UTF-8 형식으로 코딩된 문자열을 출력한다.
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
