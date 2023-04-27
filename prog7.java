//hospital.java



import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

/**
 * Servlet implementation class hospital
 */
@WebServlet("/hospital")
public class hospital extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor. 
	 */
	public hospital() {

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("Id"));
		String name = request.getParameter("name");
		int age = Integer.parseInt((request.getParameter("age")));
		String doa = request.getParameter("doa");
		String coa = request.getParameter("coa");
		String doctor = request.getParameter("doctor");
		String treatment = request.getParameter("treatment");
		
		PrintWriter out = response.getWriter();
		out.print("<html><body><p>" + id + "</p><p>" + name + "</p>");
		out.print("<p>" + age + "</p><p>" + doa + "</p><p>"+ coa + "</p><p>"+
				doctor + "</p><p>"+ treatment +"</p></body></html>");
		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root","msrit");
			Statement s = (Statement) c.createStatement();
			
			String insertQuery = String.format("insert into patient (id, name, age, doa,coa, doctor, treatment)values (%d, '%s', %d, '%s', '%s', '%s', '%s')",id, name, age, doa, coa, doctor, treatment);
			int update = s.executeUpdate(insertQuery);
			System.out.println("Inserted Successfully!!!" + update);
			String retrieveQuery = String.format("select * from patient");
			ResultSet rs = s.executeQuery(retrieveQuery);
			while(rs.next()){
				System.out.print("ID: " + rs.getInt("id"));
				System.out.print(", Name: " + rs.getString("name"));
				System.out.print(", age: " + rs.getInt("age"));
				System.out.print(", doa: " + rs.getString("doa"));
				System.out.print(", coa: " + rs.getString("coa"));
				System.out.print(", doctor: " + rs.getString("doctor"));
				System.out.print(", treatment: " +
						rs.getString("treatment")); }
			s.close();
			c.close();
		}catch(Exception err){
			System.out.println("Error while storing in db " + err);
		}

	}


}


//jspFile

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="hospital" method="get">
Patient Id : <input type="text" name="Id"/>
Patient Name : <input type="text" name="name" />
Age : <input type="text" name="age" />
Date of Admission : <input type="text" name="doa" />
Cause of Admission : <input type="text" name="coa" />
Doctor Diagnosed : <input type="text" name="doctor" />
Treatment Proposed : <input type="text" name="treatment" />
<input type="submit"/>
	</form>
</body>
</html>
