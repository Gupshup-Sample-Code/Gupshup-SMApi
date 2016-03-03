Overview:
This custom API will help you demonstrate that how by just passing 3 parameters mobile,message and smID you are able to send your smart message to multiple recepitent and capture their feedback regarding the quality of customer support.

Prerequisite before using APIs:
1.  You need to have a API Key.
2.  To send an SMS you will need to have gupshup sms account or any other 3rd party cloud telephone provider.
3.  Create a SM message say a survey SM using Create Survey API for a use case like capturing customer’s feedback regarding the quality of customer support.

Java file description:
1.  Handler.java - is a servlet that takes the required parameters mobile, message and smID.
    mobile - mobile number to whom sms is to be sent.
    message - sms message body.
    smID - smart message ID.(poll,survey,data capture form)
    Note: You need to provide your API key here String apiKey = "YOUR API KEY";

2.  SMAPIOperations.java - is the operational class which is used to generate a signed link for each of the user/mobile number and give     us an embedlink that can we send with the sms message.
    Note: if you are using Gupshup sms account you can use our SaveSMSAccount API and save your credential againts the API key you are using. if you are using 3rd party telephony provider for sending sms use their SMS API. 

** Html File is used to create custom form.
