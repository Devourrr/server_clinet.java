package week6day4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client3 {

	Socket s;
	DataInputStream datain;
	DataOutputStream dataout;
	
	public Client3() {
		
		try {
			s= new Socket("localhost",5050);
			System.out.println("request server");
			datain = new DataInputStream(s.getInputStream()); //������ ������� ����
			dataout = new DataOutputStream(s.getOutputStream()); // ������ �۽���� ����
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sendData(); // ������ ������
		recvData(); // ������ �ޱ�
		
		
	}
	private void sendData() {
		Scanner sc = new Scanner(System.in);
		//Thread = �� ���μ��� �� �ΰ��� �̻� ���ÿ� �� �� �ְ�����

		new Thread(new Runnable() {

			@Override
			public void run() {
				
				try {
					while(true) {
						String sendData = sc.nextLine();
						dataout.writeUTF(sendData);
					}
				} catch (IOException e) {
					System.out.println("Exit");
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
					// TODO Auto-generated catch block
					System.out.println("exit");
				}
			}
		}).start();
		
		
	}
	public static void main(String[] args) {
		new Client3();

	}

}
