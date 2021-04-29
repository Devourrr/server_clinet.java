package week6day4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server0 {

	ServerSocket ss;
	Socket s;
	DataInputStream di;
	DataOutputStream dos;
	
	public Server0() {
		try {
			ss = new ServerSocket(5050);
			System.out.println("Server ready");
			s = ss.accept();
			di = new DataInputStream(s.getInputStream());
			dos = new DataOutputStream(s.getOutputStream());
			System.out.println("create Client Socket");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		recv();
		send();
	}
	private void send() {
		Scanner sc = new Scanner(System.in);
		new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					while(true) {
						String send = sc.nextLine();
						dos.writeUTF(send);
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
					String recv = di.readUTF();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("exit");
				}
			}
		}).start();
	
	}
	public static void main(String[] args) {
		new Server0();
	}

}
