package ilu2;

public class Welcome {
	
	public static String welcome(String input) {
		if (input == null || input.trim() == "")
			return "Hello, my friend";
		if (input.equals(input.toUpperCase()))
			return "HELLO, " + input + " !";
		String[] names = input.split(",");
		if (names.length > 1) {
			StringBuilder sb = new StringBuilder("Hello");
			for (String name : names) {
				String prenom = name.substring(0,1).toUpperCase()
						+ name.substring(1);
				sb.append(", ").append(prenom);
			}
			return sb.toString();
		}
		input = input.substring(0,1).toUpperCase() 
				+ input.substring(1);
		return "Hello, " + input;
	}
	
}
