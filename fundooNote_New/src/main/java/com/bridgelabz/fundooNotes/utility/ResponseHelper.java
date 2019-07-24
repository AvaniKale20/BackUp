package com.bridgelabz.fundooNotes.utility;

import com.bridgelabz.fundooNotes.response.Response;

public class ResponseHelper {
	public static Response statusResponse(int code, String message) {
		Response statusResponse = new Response();
		statusResponse.setStatusMsg(message);
		statusResponse.setStatusCode(code);
		return statusResponse;
	}

	
}
