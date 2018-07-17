package com.bang.services;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketDemo extends Thread {
	private static Socket socket = null;
	private static ServerSocket serverSocket = null;
	private static int SERVER_PORT = 2013;
	

	
	public void closeServer(){
		if(serverSocket != null && !serverSocket.isClosed()){
			try {
				serverSocket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void run() {
		try {
			serverSocket = new ServerSocket(SERVER_PORT);
			System.out.println("serverSocket="+serverSocket);
			while(true){
				socket = serverSocket.accept();
				System.out.println("socket="+socket);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	static public Socket getSocket() {
		return socket;
	}

}
