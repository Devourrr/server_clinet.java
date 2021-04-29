package week6day4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client1 {

	Socket s;
	DataInputStream datain;
	DataOutputStream dataout;
	
	public Client1() {
		
		try {
			s= new Socket("localhost",5050);
			System.out.println("request server");
			datain = new DataInputStream(s.getInputStream());
			dataout = new DataOutputStream(s.getOutputStream());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public static void main(String[] args) {
		new Client1();

	}

}
