package com.yedam.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.dev.EmpDAO;
import com.yedam.dev.Employee;

/**
 * Servlet implementation class InsertBoardServlet
 */
@WebServlet("/InsertBoardServlet")
public class InsertBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public InsertBoardServlet() {
        super();       
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			//response.getWriter().append("Served at: ").append(request.getContextPath());
			String content = request.getParameter("content");
			String writer = request.getParameter("writer");
			String date = request.getParameter("create_date");
			System.out.println("content : "  +content +" writer : " +writer +" create_date : "+date);
			
			Board bor = new Board();
			bor.setContent(content);
			bor.setWriter(writer);
			bor.setDate(date);
			
			BoardDAO dao = new BoardDAO();
			dao.insertBoard(bor);
	}
			protected void doPost(HttpServletRequest request, HttpServletResponse response) 
					throws ServletException, IOException {
				
				doGet(request, response);
			}

		}
	