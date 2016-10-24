package com.debijenkorf.util;

import org.fluentlenium.core.FluentPage;
 
public class ReportingUtil {
	
	private static final String SCREENSHOT_LOCATION = "C:\\TestResults\\";
	
	public static void takeScreenShot(FluentPage page,String name){
		page.takeScreenShot(SCREENSHOT_LOCATION+name+".png");
		
	}

}
