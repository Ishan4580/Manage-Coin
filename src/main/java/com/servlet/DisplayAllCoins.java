package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CoinDAO;
import com.model.Coin;

/**
 * Servlet implementation class DisplayAllCoins
 */
@WebServlet("/DisplayAllCoins")
public class DisplayAllCoins extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayAllCoins() {
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
			
			//retrieve all coins from the database
			CoinDAO coinDAO=new CoinDAO();
			List<Coin>allCoins=coinDAO.getAllCoins();
			
			//HTML Response
			out.println("<html><head><title>Display coins</title></head><body>");
		    out.println("<h1>All Coin Collection Data</h1>");
			out.print("<table border='1'>");
			out.print("<thead><tr><th>COIN ID</th><th>COUNTRY</th><th>DENOMINATION</th><th>YEAR OF MINTING</th><th>CURRENT VALUE</th><th>ACQUIRED DATE</th><th>UPDATE</th><th>REMOVE</th></tr></thead>");
			
			for(Coin coin:allCoins)
			{
			out.print("<tr>");
			out.print("<td>"+coin.getId()+"</td>");
			out.print("<td>"+coin.getCountry()+"</td>");
			out.print("<td>"+coin.getDenomination()+"</td>");
			out.print("<td>"+coin.getYearOfMinting()+"</td>");
			out.print("<td>"+coin.getCurrentValue()+"</td>");
			out.print("<td>"+coin.getAcquiredDate()+"</td>");
			out.print("<td><a href='FetchToUpdate?coinId="+coin.getId()+"'>EDIT</a></td>");
			out.print("<td><a href='DeleteCoinServlet?coinId="+coin.getId()+"'>DELETE</a></td>");

			out.print("</tr>");
			}

			out.print("</table>");
			out.print("<br><br>");
			 out.println("<a href='index.html'>Back To Home </a>");
		   out.println("</body></html>");
			
			
		} catch (Exception e) {
			//Error
			out.println("<html><head><title>Adding coin</title></head><body>");
			   out.println("<h1 style='color:red'>Error while Retrieving the Coins List</h1>");
			   out.println("<a href='index.html'>Back To Home</a>");
			    out.println("<a href='/ManageCoinCollection/DisplayAllCoins'>See Coin Collection</a>");
			   out.println("<p> ERROR :"+ e.getMessage()+"</p>");
			   out.println("</body></html>");
			
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
