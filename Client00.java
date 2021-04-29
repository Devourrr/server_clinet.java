package week6day4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client00 {
	Socket s;
	DataInputStream d1;
	DataOutputStream d2;

	public Client00() {
		try {
			s = new Socket("localhost",5050);
			d1 = new DataInputStream(s.getInputStream());
			d2 = new DataOutputStream(s.getOutputStream());
			System.out.println("request Server");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		recv();
		send();
		
	}
		
	private void send() {
		new Thread(new Runnable() {
		Scanner sc = new Scanner(System.in);

			@Override
			public void run() {

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
					while(true) {
						String recv = d1.readUTF();
						System.out.println(recv);
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("exit");
				}
			}
		}).start();	
	}

	public static void main(String[] args) {
		new Client00();

	}

}
