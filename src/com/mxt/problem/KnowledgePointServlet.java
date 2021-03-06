package com.mxt.problem;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mxt.problem.load.KnowledgePoint;

/**
 * Servlet implementation class KnowledgePointServlet
 */
@WebServlet("/kp")
public class KnowledgePointServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KnowledgePointServlet() {
        super();
        // TODO Auto-generated constructor stub
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
		long kp_id 		= Long.parseLong(request.getParameter("kp_id")		== null? "0":request.getParameter("kp_id")		);
		long parent_id 	= Long.parseLong(request.getParameter("parent_id")	== null? "0":request.getParameter("parent_id")	);
		int  start 		= Integer.parseInt(request.getParameter("start"));
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().append(KnowledgePoint.getKnowledgePoint(kp_id, parent_id, start).toString());
	}

}
