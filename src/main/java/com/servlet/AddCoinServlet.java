package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.constants.GenericConstants;
import com.dao.CoinDAO;
import com.model.Coin;

/**
 * Servlet implementation class AddCoinServlet
 */
@WebServlet("/AddCoinServlet")
public class AddCoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCoinServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//IO stream create
		 PrintWriter out=response.getWriter(); 
		  try {
		   //response html type
		   response.setContentType("text/html");
		   
		   String country=request.getParameter("country");
		   String denomination=request.getParameter("denomination");
		   int yearOfMinting=Integer.parseInt(request.getParameter("yearOfMinting")) ;
		 
		   BigDecimal currentvalue= new BigDecimal(request.getParameter("currentValue"));
		   Date acquiredDate=new Date(); 
		    acquiredDate=new SimpleDateFormat(GenericConstants.requiredDateFormat).parse(request.getParameter("acquiredDate"));
		   Coin coin=new Coin(country, denomination, yearOfMinting, currentvalue, acquiredDate); 
		  
		   CoinDAO coinDAO =new CoinDAO();
		   
		    if(coinDAO.addCoin(coin)>0)
		   {
		    	
		out.println("<html><head><title>Adding coin</title></head><body>");
	    out.println("<h1 style='color:green'>Coin Added Successfully </h1>");
//	    out.println("<p> Coin ID :"+ coin.getId()+"</p>");
	    out.println("<p> Coin Country :"+ coin.getCountry()+"</p>");
	    out.println("<p> Coin Denomination :"+ coin.getDenomination()+"</p>");
	    out.println("<p> Coin Current Value :"+ coin.getCurrentValue()+"</p>");
	    out.println("<p> Coin Acquired Date :"+ coin.getAcquiredDate()+"</p>");
	    out.println("<a href='index.html'>Add Another Coin</a>");
	    out.println("<a href='/ManageCoinCollection/DisplayAllCoins'>See Coin Collection</a>");

	    out.println("</body></html>");
	   }
		    else 
		    {
	    //failed
	    out.println("<html><head><title>Adding coin</title></head><body>");
	    out.println("<h1 style='color:red'>Coin NOT Added Successfully </h1>");
	    out.println("<a href='index.html'>try Adding Coin</a>");
	    out.println("</body></html>");
	   }
		    
	  } catch (ParseException | NumberFormatException e)
		  {
	   
	   e.printStackTrace();
	   out.println("<html><head><title>Adding coin</title></head><body>");
	   out.println("<h1 style='color:red'>Error while Adding Coin</h1>");
	   out.println("<a href='index.html'>try Adding Coin</a>");
	   out.println("<p> ERROR :"+ e.getMessage()+"</p>");
	   out.println("</body></html>");
	  }
	  
	}

}
