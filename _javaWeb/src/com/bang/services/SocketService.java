package com.bang.services;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketService {
	private Socket socket = null;
	private PrintWriter printWriter = null;
	public int lightControl(boolean bType) throws IOException{
		
		socket = SocketDemo.getSocket();
		if (socket==null) {
			System.out.println("socketµÈÓÚ¿Õ");
			return 0;
		}else {
			String sendStr = null;
			if (bType==true) {
				sendStr = "11";
			}else {
				sendStr = "12";
			}
			printWriter = new PrintWriter(socket.getOutputStream());
			printWriter.write(sendStr);
			printWriter.flush();
			return 1;
		}
	}
	
	public void changeBrightness(int lev) throws IOException{
		
		socket = SocketDemo.getSocket();
		printWriter = new PrintWriter(socket.getOutputStream());
		
		switch (lev) {
		case 1:
			printWriter.write("2000");
			printWriter.flush();
			break;
		case 2:
			printWriter.write("2060");
			printWriter.flush();
			break;
		case 3:
			printWriter.write("2120");
			printWriter.flush();
			break;
		case 4:
			printWriter.write("2180");
			printWriter.flush();
			break;
		case 5:
			printWriter.write("2250");
			printWriter.flush();
			break;
		}
	}
}
