package com.yedam.dev;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GetEmpListServlet")
public class GetEmpListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public GetEmpListServlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
	//	response.getWriter().append("Served at: ").append(request.getContextPath()).append("  A-RA");
		EmpDAO dao = new EmpDAO();
		List<Employee> empList = dao.getEmpList(); 
		//"empId: 101, "firstName":"scott","lastName":"tiger"}
		String empJson ="[";
		int rCnt = 0;
		int totalCnt = empList.size();
		for(Employee e : empList) {
			empJson += "{\"empId\":"+e.getEmployeeId()
					    +",\"firstName\":\""+e.getFirstName()
					    +"\",\"lastName\":\""+e.getLastName()
					    +"\",\"email\":\""+e.getEmail()
					    +"\",\"salary\":"+e.getSalary()+"}"; 
			if(++rCnt != totalCnt)
			empJson += ",";
		}
		empJson += "]";
		PrintWriter out = response.getWriter();
		out.print(empJson.toString());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
