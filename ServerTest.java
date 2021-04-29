package week6day4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerTest {

	ServerSocket sskt;
	Socket skt;
	DataInputStream datain;
	DataOutputStream dataout;
	
	public ServerTest() {
		try {
			sskt = new ServerSocket(5050);
			System.out.println("Server ready" );
			skt = sskt.accept();
			datain = new DataInputStream(skt.getInputStream());
			dataout = new DataOutputStream(skt.getOutputStream());
			System.out.println("create Client Socket");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		recvData();
		sendData();
		
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
					// TODO Auto-generated catch block
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
				} catch (IOException e) {
					
					System.out.println("exit");
				}

			}
			
		}).start();
		
		
		
	}
	public static void main(String[] args) {
		new ServerTest();
	}

}
