package com.featurespace.model;

public class PostcodeStatusNearest
{
	private Result [] result;
	private Integer status;

	public Integer getStatus()
	{
		return status;
	}

	public void setStatus(Integer status)
	{
		this.status = status;
	}

	public Result[] getResult()
	{
		return result;
	}

	public void setResult(Result[] result)
	{
		this.result = result;
	}
}
