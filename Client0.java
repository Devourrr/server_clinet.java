package week6day4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client0 {

	Socket s;
	DataInputStream di;
	DataOutputStream dos;
	
	public Client0() {
		try {
			s = new Socket("localhost",5050);
			di = new DataInputStream(s.getInputStream());
			dos = new DataOutputStream(s.getOutputStream());
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
					while(true) {
						String recv = di.readUTF();
						System.out.println(recv);
					}
				} catch (IOException e) {
					System.out.println("exit");
				}
			}
		}).start();
	
	}
	
	public static void main(String[] args) {
		new Client0();
	}

}
