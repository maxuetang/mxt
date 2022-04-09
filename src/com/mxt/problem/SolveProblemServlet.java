package com.mxt.problem;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mxt.problem.load.ProblemSolve;

import cn.hutool.json.JSONObject;

/**
 * Servlet implementation class SolveProblemServlet
 */
@WebServlet("/solveProblem")
public class SolveProblemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SolveProblemServlet() {
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
		int ptype = Integer.parseInt(request.getParameter("ptype"));
		int pid = Integer.parseInt(request.getParameter("pid"));
		String jsonStr = request.getParameter("ans");
		if(ptype==6 || ptype==7) {
			JSONObject json = new JSONObject();
			json.put("language", request.getParameter("language")).put("source", request.getParameter("source"));
			jsonStr = json.toString();
		}else if(ptype==8){
			JSONObject json = new JSONObject();
			json.put("ans", request.getParameter("source"));
			jsonStr = json.toString();
		}
		
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().append(ProblemSolve.solveProblem(pid, ptype, jsonStr).toString());
	}

}
