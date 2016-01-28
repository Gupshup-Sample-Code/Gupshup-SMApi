
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.json.JSONArray;
import org.json.JSONException;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class SMAPIOperatios
{

	String apikey;

	public SMAPIOperatios(String apikey)
	{
		this.apikey = apikey;
	}

	public int createPoll()
	{

		return 123;

	}

	public String generateSignedLink(int pollId, String destination) throws JSONException, UnirestException
	{

		String url = "http://api.webaroo.com/SMApi/api/smartmsg/msg/" + pollId + "/signedlink";
		HttpResponse<String> data = Unirest.post(url).header("apikey", this.apikey).header("Content-Type", "application/x-www-form-urlencoded").field("destination", destination).asString();
		JSONArray arr = new JSONArray(data.getBody().toString());
		return "https://smapi.teamchat.com/SMApi/api/embed/"+arr.getJSONObject(0).getString("id");

	}

	public String createTinyUrl(String url)
	{
		return url;

	}

	public void sendSMS(String mobile, String message, String link) throws UnsupportedEncodingException, UnirestException, JSONException
	{
		String messageBody = message+"\n"
				+link;
		String url = "http://api.webaroo.com/SMApi/api/sms/msg";
		HttpResponse<String> data = Unirest.put(url).header("apikey", this.apikey).header("Content-Type", "application/x-www-form-urlencoded").field("destination", mobile).field("text",messageBody).asString();
//		JSONArray arr = new JSONArray(data.getBody().toString());
//		return "https://smapi.teamchat.com/SMApi/api/embed/"+arr.getJSONObject(0).getString("id");
	}

}
