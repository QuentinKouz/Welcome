package ilu2;

import java.util.ArrayList;
import java.util.List;

public class Welcome {
	
	public static String welcome(String input) {
		if (input == null || input.trim() == "")
			return "Hello, my friend";
		if (input.equals(input.toUpperCase()))
			return "HELLO, " + input + " !";
		String[] names = input.split(",");
		if (names.length > 1) {
			return handleMultipleNames(names);
		}
		return handleSingleName(input);
	}
	
	private static String handleSingleName(String name) {
		return "Hello, " + capitalize(name);
	}
	
	private static String handleMultipleNames(String[] names) {
		StringBuilder sb = new StringBuilder("Hello");
	    StringBuilder upperCaseNames = new StringBuilder(". AND HELLO");
	    int indexUpper = 0,compteurUpper = 0;
	    int indexLower = 0,compteurLower = 0;
	    for (int i = 0; i < names.length; i++) {
	        String name = names[i].trim();
	        if (name.equals(name.toUpperCase())) {
	        	indexUpper = upperCaseNames.length();
	        	compteurUpper++;
	            upperCaseNames.append(", " + name);
	        }else {
	        	indexLower = sb.length();
	        	compteurLower++;
	        	sb.append(", " + capitalize(name));
	        }
	    }
	    return traitementAnd(compteurUpper,compteurLower,indexUpper,indexLower,sb, upperCaseNames);
	}

	private static String traitementAnd(int compteurUpper,int compteurLower,int indexUpper,int indexLower, StringBuilder sb, StringBuilder upperCaseNames) {
		if (compteurUpper >1) 
	    	upperCaseNames.replace(indexUpper, indexUpper+2, " AND ");
	    upperCaseNames.append(" !");
	    if (compteurLower > 1) {
	    	sb.replace(indexLower, indexLower + 2, " and ");
	    }
	    if (compteurUpper > 0)
	    	sb.append(upperCaseNames);
	    return sb.toString();
	}
	private static String capitalize(String name) {
	    return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
	}
	
}
