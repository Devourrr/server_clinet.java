package week6day4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

	Socket s;
	DataInputStream in;
	DataOutputStream out;
	
	public Client() {
		try {
			s = new Socket("localhost",5050);
			System.out.println("request server");
			in = new DataInputStream(s.getInputStream());
			out = new DataOutputStream(s.getOutputStream());
		} catch (UnknownHostException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		dataSend();
		dataReve();
		
	}
	private void dataReve() {
		
		new Thread(new Runnable() {

			@Override
			public void run() {
				String data = "";
				while(true) {
					try {
						data = in.readUTF();
						System.out.println(data);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						System.out.println("exit");
					}
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
		new Client();
	}

}
