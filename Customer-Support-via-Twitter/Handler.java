protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		JSONObject context = new JSONObject(request.getParameter("context"));
		String sender = request.getParameter("sender");
		String channel = request.getParameter("channel");
		String msg = request.getParameter("message");
		userContext.put(sender, context.toString());
		
		System.out.println("\n\nTime - " + new Date());
		System.out.println("Do Get - " + context);
		System.out.println("Msg - " + msg);
		System.out.println("Sender - " + sender);
		System.out.println("Channel - " + channel);
		
		String keyWord = "";
		if (msg.contains(" "))
		{
			keyWord = msg.substring(0, msg.indexOf(" ")).toLowerCase();
		}
		else
			keyWord = msg.toLowerCase();
		
		try
		{
			switch (keyWord)
			{
			case "hi":
			case "hello":
			case "help":
				userLevel.put(sender, "start");
				api.sendMsgToChannel(detailsProps.getProperty("help"), botName, userContext.get(sender));
				break;
			case "a":
				if (userLevel.containsKey(sender))
					sendResponse(sender, "a");
				else
				{
					userLevel.put(sender, "start");
					api.sendMsgToChannel(detailsProps.getProperty("help"), botName, userContext.get(sender));
				}
				break;
			case "b":
				if (userLevel.containsKey(sender))
					sendResponse(sender, "b");
				else
				{
					userLevel.put(sender, "start");
					api.sendMsgToChannel(detailsProps.getProperty("help"), botName, userContext.get(sender));
				}
				break;
			case "c":
				if (userLevel.containsKey(sender))
					sendResponse(sender, "c");
				else
				{
					userLevel.put(sender, "start");
					api.sendMsgToChannel(detailsProps.getProperty("help"), botName, userContext.get(sender));
				}
				break;
			default:
				if  (userLevel.containsKey(sender) && (userLevel.get(sender).equals("start" + "a") || userLevel.get(sender).equals("start" + "b") || userLevel.get(sender).equals("start" + "c")))
				{
					api.sendMsgToChannel(detailsProps.getProperty("wronginput"), botName, userContext.get(sender));
				}
				else
				{
					userLevel.put(sender, "start");
					api.sendMsgToChannel(detailsProps.getProperty("help"), botName, userContext.get(sender));
				}
				break;
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	private void sendResponse (String sender, String option)
	{
		String lastKey = userLevel.get(sender);
		if (lastKey.equals("start"))
		{
			userLevel.put(sender, lastKey + option);
			api.sendMsgToChannel(detailsProps.getProperty(lastKey + option), botName, userContext.get(sender));
		}
		else if (lastKey.equals("starta"))
		{
			userLevel.put(sender, "start");
			api.sendMsgToChannel(detailsProps.getProperty("a"), botName, userContext.get(sender));
		}
		else if (lastKey.equals("startb"))
		{
			userLevel.put(sender, "start");
			api.sendMsgToChannel(detailsProps.getProperty("b"), botName, userContext.get(sender));
		}
		else if (lastKey.equals("startc"))
		{
			userLevel.put(sender, "start");
			api.sendMsgToChannel(detailsProps.getProperty("c"), botName, userContext.get(sender));
		}
		else
		{
			userLevel.put(sender, "start");
			api.sendMsgToChannel(detailsProps.getProperty("help"), botName, userContext.get(sender));
		}
	}
