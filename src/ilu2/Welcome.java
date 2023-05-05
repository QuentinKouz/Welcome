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
	    StringBuilder upperCaseNames = new StringBuilder();
	    for (String name : names) {
	        String trimmedName = name.trim();
	        if (trimmedName.equals(trimmedName.toUpperCase())) {
	            if (upperCaseNames.length() > 0) {
	                upperCaseNames.append(", ");
	            }
	            upperCaseNames.append(trimmedName);
	        } else {
	            sb.append(", ").append(trimmedName.substring(0, 1).toUpperCase()).append(trimmedName.substring(1));
	        }
	    }
	    if (upperCaseNames.length() > 0) {
	        sb.append(". AND HELLO, ").append(upperCaseNames).append(" !");
	    }
	    return sb.toString();
	}
	
	private static String capitalize(String name) {
	    return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
	}
	
}
