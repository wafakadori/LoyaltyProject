package loyalty.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import loyalty.service.LoyaltyBalanceResponseType;
import loyalty.service.LoyaltyService;
import loyalty.service.LoyaltyServiceImpl;

@WebServlet(urlPatterns = { "/doLogin" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoyaltyService loyaltyservice;

	public LoginServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				System.out.println("addfirstcomit from github");
		// get card number input and code input
		String cardNumber = request.getParameter("cardNumber");
		String cardCode = request.getParameter("cardCode");
		loyaltyservice = new LoyaltyServiceImpl();
		boolean hasError = false;
		String errorString = null;

		if (cardNumber == null || cardCode == null || cardNumber.length() == 0 || cardCode.length() == 0) {
			hasError = true;
			errorString = "Card number and card code mandatory!";
		} else {
			LoyaltyBalanceResponseType result = loyaltyservice.getLoyaltyBalance(cardNumber, cardCode);

			if (result == null || result.getTotalPoint() == null) {
				hasError = true;
				errorString = "invalid Card number or card code";
			}

			else {
				request.setAttribute("totalPoints", result.getTotalPoint().toString());

			}

		}

		// If error, forward to /WEB-INF/views/login.jsp
		if (hasError) {

			// Store information in request attribute, before forward.
			request.setAttribute("errorString", errorString);
			// Forward to /WEB-INF/views/login.jsp
			RequestDispatcher dispatcher //
					= this.getServletContext().getRequestDispatcher("/loyaltyLogin.jsp");

			dispatcher.forward(request, response);
		}
		else {
			request.setAttribute("errorString", "");

			RequestDispatcher dispatcher 
			= this.getServletContext().getRequestDispatcher("/displayPoints.jsp");
	dispatcher.forward(request, response);
		}
		
		

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

		
	}

}
