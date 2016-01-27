
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
			String apiKey = "e3248e67af1f40ebc02390d114508706";// TODO:
			SMAPIOperatios smApi = new SMAPIOperatios(apiKey);
			String mobile = req.getParameter("mobile");
			String message = req.getParameter("message");
			int pollId = Integer.parseInt(req.getParameter("chatletid"));//smApi.createPoll();
			if(mobile.contains(","))
			{
				mobileArray = mobile.split(",");
				for(int i=0;i<mobileArray.length;i++)
				{
//					writer.write("Array "+mobileArray[i]);
					String sLink = smApi.generateSignedLink(pollId, mobileArray[i]);
					smApi.sendSMS(mobileArray[i],message,sLink);
				}
			}else
			{
//				writer.write("mobile"+mobile);
				String sLink = smApi.generateSignedLink(pollId, mobile);
				smApi.sendSMS(mobile,message,sLink);
			}
			writer.write("Success.");//(sLink);
			// String tlink = smApi.createTinyUrl(sLink);
			// String mobile = req.getParameter("user");
			// String response = req.getParameter("response");
			 //Utility.getMessageBody(response, mobile));
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
