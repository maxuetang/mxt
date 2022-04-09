package com.mxt.problem;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mxt.problem.load.ProblemRemote;

/**
 * Servlet implementation class LoadProblemsServlet
 */
@WebServlet("/loadProblems")
public class LoadProblemsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoadProblemsServlet() {
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
		int ptype = Integer.parseInt(request.getParameter("ptype"));
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().append(request.getParameter("pid")==null?
				ProblemRemote.getProblems(ptype, Integer.parseInt(request.getParameter("start"))).toString():ProblemRemote.getProblem(ptype, Integer.parseInt(request.getParameter("pid"))).toString()
				);
	}

}
