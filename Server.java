package week6day4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

	ServerSocket ss;
	Socket s;
	DataInputStream in;
	DataOutputStream out;
	
	public Server() {
		try {
			ss =new ServerSocket(5050);
			System.out.println("server ready");
			s = ss.accept();
			System.out.println("create client socket");
			in = new DataInputStream(s.getInputStream());
			out = new DataOutputStream(s.getOutputStream());
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		dataSend();
		dataRecv();

	}
	
	private void dataRecv() {
		new Thread (new Runnable() {

			@Override
			public void run() {
				
				try { 
					String data = "";
					while(true) {
						
					data = in.readUTF();
					System.out.println(data);
				}
				} catch (IOException e) {
					System.out.println("exit");
				}
			}
		}).start();	
	}

	private void dataSend() {
		Scanner sc = new Scanner(System.in);
		new Thread (new Runnable() {

			@Override
			public void run() {
				
				try {
					while(true) {
						String sendData = sc.nextLine();
						out.writeUTF(sendData);
					}
					
				} catch (IOException e) {
					System.out.println("exit");
				}
				
			}
			
		}).start();
		
	}

	public static void main(String[] args) {
		new Server();

	}

}
