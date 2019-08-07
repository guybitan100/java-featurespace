package com.featurespace.app;

import java.util.Scanner;

class FTT
{

	public FTT(String a[])
	{
        Scanner sc = new Scanner(System.in);
		while (sc.hasNext())
		{
			
		}
	}

	public static void main(String args[])
	{

		FTT application = new FTT(args);
	}

	private void showHelp()
	{
		System.out.println("FTT (featurespace test tool) - Show details by given UK postcode");
		System.out.println("");
		System.out.println("");
		System.out.println("Usage:");
		System.out.println("\t-v <postcode>, --validte <postcode>");
		System.out.println("\t\tValidate the postcode parameter");
		System.out.println("");
		System.out.println("");
		System.out.println("\t-p <postcode>, --print <postcode>");
		System.out.println("\t\tPrint the country and region for given postcode");
		System.out.println("");
		System.out.println("");
		System.out.println("\t-a <postcode>, --all <postcode>");
		System.out.println("\t\tPrint a list of the nearest postcodes, and their countries and regions");
		System.out.println("");
		System.out.println("");
		System.exit(1); //Exit and fail if you had to show this help
	}
}
