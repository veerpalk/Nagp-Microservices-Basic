package com.nagarro.nagp.account.restclients.errorhandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.DefaultResponseErrorHandler;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nagarro.nagp.account.exceptions.RestClientException;

public class RestClientErrorHandler extends DefaultResponseErrorHandler {
	@Override
	  public void handleError(ClientHttpResponse response) throws IOException {
	    if (response.getStatusCode().is4xxClientError() || response.getStatusCode().is5xxServerError()) {
	      try (BufferedReader reader = new BufferedReader(new InputStreamReader(response.getBody()))) {
	        String httpBodyResponse = reader.lines().collect(Collectors.joining(""));
	        ObjectMapper mapper = new ObjectMapper();
	        JsonNode data = mapper.readTree(httpBodyResponse);
	        String errorMessage=data.get("message").asText();
	        throw new RestClientException(response.getStatusCode(), errorMessage);
	      }
	    }
	  }
}
