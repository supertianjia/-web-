package com.bang.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bang.services.SocketDemo;

/**
 * Servlet implementation class SocketServlet
 */
@WebServlet("/SocketServlet")
public class SocketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static SocketDemo  server = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SocketServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	public void init(ServletConfig config) throws ServletException {
		if(server == null){
			server = new SocketDemo();
			server.start();
		}
	}

	@Override
	public void destroy() {
		if(server != null && !server.isInterrupted()){
			server.closeServer();
			server.interrupt();
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
