package ilu2;

public class Welcome {
	
	public static String welcome(String input) {
		if (input == null || input.trim() == "")
			return "Hello, my friend";
		if (input.equals(input.toUpperCase()))
			return "HELLO, " + input + " !";
		input = input.substring(0,1).toUpperCase() 
				+ input.substring(1);
		return "Hello, " + input;
	}
}
