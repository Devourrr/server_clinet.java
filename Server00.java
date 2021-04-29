package week6day4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server00 {
	
	ServerSocket ss;
	Socket s;
	DataInputStream d1;
	DataOutputStream d2;
	
	public Server00() {
		try {
			ss = new ServerSocket(5050);
			System.out.println("Server ready");
			s = ss.accept();
			d1 = new DataInputStream(s.getInputStream());
			d2 = new DataOutputStream(s.getOutputStream());
			System.out.println("create Client Socket");
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		recv();
		send();
		
	}
	

	private void send() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				Scanner sc = new Scanner(System.in);
				
				try {
					while(true) {
						String send = sc.nextLine();
						d2.writeUTF(send);
					}	
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("exit");
				}
			}
		}).start();
	}


	private void recv() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					String recv = d1.readUTF();
				} catch (IOException e) {
					System.out.println("exit");
				}
			}
		}).start();
	}


	public static void main(String[] args) {
		new Server00();

	}

}
