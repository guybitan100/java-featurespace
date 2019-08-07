package com.featurespace.app;

import com.featurespace.model.PostcodeStatus;
import com.featurespace.model.PostcodeStatusNearest;
import com.featurespace.model.PostcodeStatusValidate;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

 class Postcode
{
	private static final String baseUrl = "http://api.postcodes.io/postcodes/";
	private final String postcode;
	private CloseableHttpClient httpclient;
	private Gson gson;

	public Postcode(String postcode)
	{
		this.postcode = postcode;
		this.gson = new GsonBuilder().create();
		this.httpclient = HttpClients.createDefault();
	}

	public PostcodeStatus getDetails()
	{
		String jsonString = executeGet(baseUrl + postcode);
		return gson.fromJson(jsonString, PostcodeStatus.class);
	}

	public PostcodeStatusValidate validate()
	{
		String url = String.format(baseUrl + "%s/validate", postcode);
		String jsonString = executeGet(url);
		return gson.fromJson(jsonString, PostcodeStatusValidate.class);
	}

	public PostcodeStatusNearest getNearest()
	{
		String url = String.format(baseUrl + "%s/nearest", postcode);
		String jsonString = executeGet(url);
		return gson.fromJson(jsonString, PostcodeStatusNearest.class);
	}

	private String executeGet(String url)
	{
		String jsonString = "";
		try
		{
			HttpGet httpGet = new HttpGet(url);
			CloseableHttpResponse response = httpclient.execute(httpGet);
			try
			{
				HttpEntity entity = response.getEntity();
				jsonString = EntityUtils.toString(entity);

			}

			finally
			{
				response.close();
			}
		}

		catch (IOException e)
		{
			System.out.println("Couldn't connect to: " + baseUrl);
		}
		return jsonString;
	}

}