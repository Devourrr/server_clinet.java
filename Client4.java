package week6day4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client4 {

	Socket skt;
	DataInputStream datain;
	DataOutputStream dataout;
	
	public Client4() {
		try {
			skt = new Socket("localhost",5050);
			System.out.println("request server");
			datain = new DataInputStream(skt.getInputStream());
			dataout = new DataOutputStream(skt.getOutputStream());
		} catch (UnknownHostException e) {
			
			e.printStackTrace();
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
					while(true) {
						String recvData = datain.readUTF();
						System.out.println(recvData);
					}
				} catch (IOException e) {
					System.out.println("exit");
				}
				
			}
			}).start();
		
		
	}
	public static void main(String[] args) {
		new Client4();

	}

}
