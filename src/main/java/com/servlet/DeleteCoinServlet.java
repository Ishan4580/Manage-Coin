package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CoinDAO;

/**
 * Servlet implementation class DeleteCoinServlet
 */
@WebServlet("/DeleteCoinServlet")
public class DeleteCoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public DeleteCoinServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		try {
			int coinId=Integer.parseInt(request.getParameter("coinId"));
			CoinDAO coinDAO=new CoinDAO();
			if(coinDAO.deleteCoin(coinId)>0)
			{
				out.println("<html><head><title>Deleting Coin</title></head><body>");
			    out.println("<h1 style='color:green'>Coin Delete Successfully </h1>");
//			    out.println("<p> Coin ID :"+ coin.getId()+"</p>");
			    out.println("<a href='index.html'>Add Another Coin</a>");
			    out.println("<a href='/ManageCoinCollection/DisplayAllCoins'>See Coin Collection</a>");

			    out.println("</body></html>");
				
				
//				response.sendRedirect("/ManageCoinCollection/DisplayAllCoins");
			}
			else
			{
				out.println("<html><head><title>Deleting Coin</title></head><body>");
				   out.println("<h1 style='color:red'>Error while Deleting a Coin</h1>");
				   out.println("<a href='index.html'>Back To Home</a>");
				    out.println("<a href='/ManageCoinCollection/DisplayAllCoins'>See Coin Collection</a>");
				   out.println("</body></html>");
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			
			//Error
			out.println("<html><head><title>Adding coin</title></head><body>");
			   out.println("<h1 style='color:red'>Error while Deleting a Coin</h1>");
			   out.println("<a href='index.html'>Back To Home</a>");
			    out.println("<a href='/ManageCoinCollection/DisplayAllCoins'>See Coin Collection</a>");
			   out.println("<p> ERROR :"+ e.getMessage()+"</p>");
			   out.println("</body></html>");
		}
	
	
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
