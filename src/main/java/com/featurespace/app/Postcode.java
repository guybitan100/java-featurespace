package com.featurespace.app;

import com.featurespace.model.PostcodeStatus;
import com.google.common.net.UrlEscapers;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import org.apache.commons.codec.binary.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class PostcodeRetriever
{
	private final String baseUrl = "http://api.postcodes.io/postcodes/";
	private final String postcode;
	private CloseableHttpClient httpclient;

	public PostcodeRetriever(String postcode)
	{
		this.postcode = postcode;
		this.httpclient = HttpClients.createDefault();
	}

	public PostcodeStatus getPostCodeDetails()
	{
		String output = String.format(baseUrl + "%s", postcode);

		return executeGet(baseUrl + postcode);
	}

	public PostcodeStatus validatePostCode()
	{
		String output = String.format(baseUrl + "%s\\validate", postcode);
		return executeGet(baseUrl + postcode);
	}

	private PostcodeStatus executeGet(String url)
	{
		PostcodeStatus postcodeStatus = null;
		try
		{
			HttpGet httpGet = new HttpGet(url);
			CloseableHttpResponse response = httpclient.execute(httpGet);
			try
			{
				HttpEntity entity = response.getEntity();
				String jsonString = EntityUtils.toString(entity);
				Gson gson = new GsonBuilder().create();
				postcodeStatus = gson.fromJson(jsonString, PostcodeStatus.class);
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
		return postcodeStatus;
	}
}