package Adidas.AdidasTest;

public class Payload {
	
	public static String AddApi()
	{
		return " {\r\n" + 
				"    \"id\": 0,\r\n" + 
				"    \"category\": {\r\n" + 
				"      \"id\": 0,\r\n" + 
				"      \"name\": \"string\"\r\n" + 
				"    },\r\n" + 
				"    \"name\": \"doggie\",\r\n" + 
				"    \"photoUrls\": [\r\n" + 
				"      \"string\"\r\n" + 
				"    ],\r\n" + 
				"    \"tags\": [\r\n" + 
				"      {\r\n" + 
				"        \"id\": 0,\r\n" + 
				"        \"name\": \"string\"\r\n" + 
				"      }\r\n" + 
				"    ],\r\n" + 
				"    \"status\": \"available\"\r\n" + 
				"  }";
	}
	public static String UpdateApi()
	{
		return "{\r\n" + 
				"   \"id\":9222968140496980712,\r\n" + 
				"   \"category\":{\r\n" + 
				"      \"id\":0,\r\n" + 
				"      \"name\":\"string\"\r\n" + 
				"   },\r\n" + 
				"   \"name\":\"doggie\",\r\n" + 
				"   \"photoUrls\":[\r\n" + 
				"      \"string\"\r\n" + 
				"   ],\r\n" + 
				"   \"tags\":[\r\n" + 
				"      {\r\n" + 
				"         \"id\":0,\r\n" + 
				"         \"name\":\"string\"\r\n" + 
				"      }\r\n" + 
				"   ],\r\n" + 
				"   \"status\":\"sold\"\r\n" + 
				"}";
	}

}
