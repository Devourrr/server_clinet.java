package week6day4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server3 {
	
	ServerSocket ss;
	Socket s;
	DataInputStream datain;
	DataOutputStream dataout;
	
	public Server3() {
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
		new Thread(new Runnable() {

			@Override
			public void run() {
				
				try {
					while(true) {
						String sendData = sc.nextLine();
						dataout.writeUTF(sendData);
					}
				} catch (IOException e) {
					System.out.println("exit");
				}
				
			}
			
		}).start();
		
		
		
	}
	private void recvData() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					String recvData = datain.readUTF();
					System.out.println(recvData);
				} catch (IOException e) {
					System.out.println("exit");
				}

			}
		}).start();
		
		
		
	}
	public static void main(String[] args) {

		new Server3();

	}

}
