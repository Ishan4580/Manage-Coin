package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CoinDAO;
import com.model.Coin;

/**
 * Servlet implementation class FetchToUpdate
 */
@WebServlet("/FetchToUpdate")
public class FetchToUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FetchToUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		
		try {
			int coinId=Integer.parseInt(request.getParameter("coinId"));
			CoinDAO coinDAO=new CoinDAO();
			Coin coinToUpdate=coinDAO.getById(coinId);
			
			out.println("<html><head><title>FetchToUpdate Coin</title></head><body>");
		    out.println("<h2 style='color:blue'>Update Coin Details </h2>");

			if(coinToUpdate!=null)
			
			{
			   //Success
				
				out.println("<form action='UpdateCoinServlet' method='post'>");
				out.println("<table>");
				out.println("<tr>");
				out.println("<td><label>Coin ID : </label></td>");
				out.println("<td><input type='hidden' name='id' value="+coinToUpdate.getId()+" ></td>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<td><label>Country : </label></td>");
				out.println("<td><input type='text' name='country' value="+coinToUpdate.getCountry()+" required></td>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<td><label>Denomination : </label></td>");
				out.println("<td><input type='text' name='denomination' value="+coinToUpdate.getDenomination()+" required></td>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<td><label>Year of Minting : </label></td>");
				out.println("<td><input type='number' name='yearOfMinting' value="+coinToUpdate.getYearOfMinting()+" required></td>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<td><label>Current Value : </label></td>");
				out.println("<td><input type='text' name='currentValue' value="+coinToUpdate.getCurrentValue()+" required></td>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<td><label>Aquired Date : </label></td>");
				out.println("<td><input type='date' name='acquiredDate' value="+coinToUpdate.getAcquiredDate()+" required></td>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<td><input type='submit' value='Update Coin'></td>");
				out.println("<td><a href='index.html'>Back To Home </a></td>");
				out.println("</tr>");
				out.println("</table>");
				out.println("</form>");
	
			}
			else
			{
				   out.println("<h1 style='color:red'>Error while Fetching to Update</h1>");
				  
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			
			//Error
			   out.println("<h1 style='color:red'>Error while Fetching to Update</h1>");
			    out.println("<p> ERROR :"+ e.getMessage()+"</p>");
		}
		 out.println("<a href='index.html'>Back To Home</a>");
		    out.println("<a href='/ManageCoinCollection/DisplayAllCoins'>See Coin Collection</a>");
		   out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
