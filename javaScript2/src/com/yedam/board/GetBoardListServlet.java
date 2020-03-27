package com.yedam.board;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class GetBoardListServlet
 */
@WebServlet("/GetBoardListServlet")
public class GetBoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetBoardListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//      BoardDAO dao = new BoardDAO();
//      List<Board> badList = dao.getBoardList();
//      
//      int rCnt=0;
//      int totalCnt = badList.size();
//      String badJson = "[";
//      for(Board b : badList) {
//         badJson += "{\"board_no\":"+b.getBoardNo()
//                  +",\"content\":\""+b.getContent()
//                  +"\",\"writer\":\""+b.getWriter()
//                  +"\",\"create_date\":\""+b.getDate()
//                  +"}";
//         
//         if(++rCnt != totalCnt)
//         badJson += ",";
//      }
//      badJson += "]";
//      PrintWriter out = response.getWriter();
//      out.print(badJson.toString());
		
		
		BoardDAO dao = new BoardDAO();
		JSONObject obj = new JSONObject();
		JSONArray ary = new JSONArray();
		for(Board b : dao.getBoardList()) {
			obj.put("board_no", b.getBoardNo());
			obj.put("content", b.getContent());
			obj.put("writer",b.getWriter());
			obj.put("create_date", b.getDate());
			ary.add(obj);
			
		}
		
		PrintWriter out = response.getWriter();
		out.print(ary.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
