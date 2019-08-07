package com.featurespace.model;
import com.google.gson.annotations.SerializedName;

public class Result
{
    @SerializedName("parliamentary_constituency") private String parliamentaryConstituency;
    @SerializedName("admin_district") private String adminDistrict;
    @SerializedName("admin_county") private String adminCounty;
    @SerializedName("admin_ward") private String adminWard;
    @SerializedName("nhs_ha") private String nhsHa;
    @SerializedName("european_electoral_region") private String europeanElectoralRegion;
    @SerializedName("primary_care_trust") private String primaryCareTrust;
	private String postcode;
	private Integer quality;
	private Integer eastings;
	private Integer northings;
	private String country;
	private Float longitude;
	private Float latitude;
	private String region;
	private String lsoa;
	private String msoa;
	private String incode;
	private String outcode;
	private String parish;
	private String ced;
	private String ccg;
	private String nuts;
	private Codes codes;

	public String getPostcode()
	{
		return postcode;
	}

	public void setPostcode(String postcode)
	{
		this.postcode = postcode;
	}

	public Integer getQuality()
	{
		return quality;
	}

	public void setQuality(Integer quality)
	{
		this.quality = quality;
	}

	public Integer getEastings()
	{
		return eastings;
	}

	public void setEastings(Integer eastings)
	{
		this.eastings = eastings;
	}

	public Integer getNorthings()
	{
		return northings;
	}

	public void setNorthings(Integer northings)
	{
		this.northings = northings;
	}

	public String getCountry()
	{
		return country;
	}

	public void setCountry(String country)
	{
		this.country = country;
	}

	public String getNhsHa()
	{
		return nhsHa;
	}

	public void setNhsHa(String nhsHa)
	{
		this.nhsHa = nhsHa;
	}

	public Float getLongitude()
	{
		return longitude;
	}

	public void setLongitude(Float longitude)
	{
		this.longitude = longitude;
	}

	public Float getLatitude()
	{
		return latitude;
	}

	public void setLatitude(Float latitude)
	{
		this.latitude = latitude;
	}

	public String getEuropeanElectoralRegion()
	{
		return europeanElectoralRegion;
	}

	public void setEuropeanElectoralRegion(String europeanElectoralRegion)
	{
		this.europeanElectoralRegion = europeanElectoralRegion;
	}

	public String getPrimaryCareTrust()
	{
		return primaryCareTrust;
	}

	public void setPrimaryCareTrust(String primaryCareTrust)
	{
		this.primaryCareTrust = primaryCareTrust;
	}

	public String getRegion()
	{
		return region;
	}

	public void setRegion(String region)
	{
		this.region = region;
	}

	public String getLsoa()
	{
		return lsoa;
	}

	public void setLsoa(String lsoa)
	{
		this.lsoa = lsoa;
	}

	public String getMsoa()
	{
		return msoa;
	}

	public void setMsoa(String msoa)
	{
		this.msoa = msoa;
	}

	public String getIncode()
	{
		return incode;
	}

	public void setIncode(String incode)
	{
		this.incode = incode;
	}

	public String getOutcode()
	{
		return outcode;
	}

	public void setOutcode(String outcode)
	{
		this.outcode = outcode;
	}

	public String getParliamentaryConstituency()
	{
		return parliamentaryConstituency;
	}

	public void setParliamentaryConstituency(String parliamentaryConstituency)
	{
		this.parliamentaryConstituency = parliamentaryConstituency;
	}

	public String getAdminDistrict()
	{
		return adminDistrict;
	}

	public void setAdminDistrict(String adminDistrict)
	{
		this.adminDistrict = adminDistrict;
	}

	public String getParish()
	{
		return parish;
	}

	public void setParish(String parish)
	{
		this.parish = parish;
	}

	public String getAdminCounty()
	{
		return adminCounty;
	}

	public void setAdminCounty(String adminCounty)
	{
		this.adminCounty = adminCounty;
	}

	public String getAdminWard()
	{
		return adminWard;
	}

	public void setAdminWard(String adminWard)
	{
		this.adminWard = adminWard;
	}

	public String getCed()
	{
		return ced;
	}

	public void setCed(String ced)
	{
		this.ced = ced;
	}

	public String getCcg()
	{
		return ccg;
	}

	public void setCcg(String ccg)
	{
		this.ccg = ccg;
	}

	public String getNuts()
	{
		return nuts;
	}

	public void setNuts(String nuts)
	{
		this.nuts = nuts;
	}

	public Codes getCodes()
	{
		return codes;
	}

	public void setCodes(Codes codes)
	{
		this.codes = codes;
	}

}
