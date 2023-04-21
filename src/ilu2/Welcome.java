package ilu2;

public class Welcome {
	
	public static String welcome(String input) {
		if (input == null || input.trim() == "")
			return "Hello, my friend";
		if (input.equals(input.toUpperCase()))
			return "HELLO, " + input + " !";
		String[] names = input.split(",");
		if (names.length == 2) {
			String prenom1 = names[0].trim().substring(0,1).toUpperCase() 
					+ names[0].trim().substring(1);
			String prenom2 = names[1].trim().substring(0,1).toUpperCase() 
					+ names[1].trim().substring(1);
			return "Hello, " + prenom1 + ", " + prenom2;
		}
		input = input.substring(0,1).toUpperCase() 
				+ input.substring(1);
		return "Hello, " + input;
	}
}
