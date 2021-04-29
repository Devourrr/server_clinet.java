package week6day4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client2 {

	Socket s;
	DataInputStream datain; //DataOutputStream 자바 기본 데이터 타입 데이터를 읽어올 수 있음
	DataOutputStream dataout;// 자바 기본데이터 타입별로 출력하는 메소드라이브러리
	//https://apphappy.tistory.com/69
	
	public Client2() {
		
		try {
			s= new Socket("localhost",5050);
			System.out.println("request server");
			datain = new DataInputStream(s.getInputStream()); //데이터 수신통로 생성
			dataout = new DataOutputStream(s.getOutputStream()); // 데이터 송신통로 생성
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sendData(); // 데이터 보내기
		recvData(); // 데이터 받기
		
		
	}
	private void sendData() {
		Scanner sc = new Scanner(System.in);
		String sendData = sc.nextLine();
		try {
			dataout.writeUTF(sendData);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	private void recvData() {
		try {
			String recvData = datain.readUTF(); //UTF-8 형식으로 코딩된 문자열을 읽는다.
			System.out.println(recvData);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		new Client2();

	}

}
