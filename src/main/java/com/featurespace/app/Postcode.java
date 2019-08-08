package com.featurespace.app;

import com.featurespace.model.PostcodeStatus;
import com.featurespace.model.PostcodeStatusNearest;
import com.featurespace.model.PostcodeStatusValidate;
import com.google.common.net.UrlEscapers;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class Postcode
{
	private static final String baseUrl = "http://api.postcodes.io/postcodes/";
	private String postcode;
	private CloseableHttpClient httpclient;
	private Gson gson;

	public Postcode(String postcode)
	{
		String postCodeEncoded = UrlEscapers.urlFragmentEscaper().escape(postcode);
		this.postcode = postCodeEncoded;
		this.gson = new GsonBuilder().create();
		this.httpclient = HttpClients.createDefault();
	}

	public PostcodeStatus getDetails()
	{
		String jsonStr = executeGet(baseUrl + postcode);
		return gson.fromJson(jsonStr, PostcodeStatus.class);
	}

	public PostcodeStatusValidate validate()
	{
		String url = String.format(baseUrl + "%s/validate", postcode);
		String jsonStr = executeGet(url);
		return gson.fromJson(jsonStr, PostcodeStatusValidate.class);
	}

	public PostcodeStatusNearest getNearest()
	{
		String url = String.format(baseUrl + "%s/nearest", postcode);
		String jsonStr = executeGet(url);
		return gson.fromJson(jsonStr, PostcodeStatusNearest.class);
	}

	private String executeGet(String url)
	{
		String jsonStr = "";
		try
		{
			HttpGet httpGet = new HttpGet(url);
			CloseableHttpResponse response = httpclient.execute(httpGet);
			try
			{
				HttpEntity entity = response.getEntity();
				jsonStr = EntityUtils.toString(entity);

			}

			finally
			{
				response.close();
			}
		}

		catch (Exception e)
		{
			System.out.println("Couldn't connect to: " + baseUrl);
		}
		return jsonStr;
	}
}