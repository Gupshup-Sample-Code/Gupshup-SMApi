
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Handler
 */
@WebServlet("/handler")
public class Handler extends HttpServlet
{

	protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter writer = response.getWriter();

		try
		{
			String[] mobileArray = null;
			String apiKey = "YOUR API KEY";// TODO:
			SMAPIOperatios smApi = new SMAPIOperatios(apiKey);
			String mobile = req.getParameter("mobile");
			String message = req.getParameter("message");
			int surveyId = Integer.parseInt(req.getParameter("chatletid"));
			
			String sLink = smApi.generateSignedLink(surveyId, mobile);
			smApi.sendSMS(mobileArray[i],message,sLink);
			
			writer.write("Success.");
			
		} catch (Exception e)
		{
			writer.write(""+e);
		}

		finally
		{
			if (writer != null)
			{
				writer.flush();
				writer.close();
			}
		}

	}

}
