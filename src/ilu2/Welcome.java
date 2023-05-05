package ilu2;



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
	    String[] nameList = differentNom(names);
	    int[] occurenceNames = occurenceNom(names,nameList);
	    int indexUpper = 0, compteurUpper = 0, indexLower = 0,compteurLower = 0, i = 0;
	    while ((i < nameList.length) && (nameList[i] != null)) {
	        String name = nameList[i].trim();
	        if (name.equals(name.toUpperCase())) {
	        	indexUpper = upperCaseNames.length();
	        	compteurUpper++;
	        	salutationUpper(upperCaseNames, occurenceNames, name, i);
	        }else {
	        	indexLower = sb.length();
	        	compteurLower++;
	        	salutationLower(sb,occurenceNames,name, i);
	        }
	        i++;
	    }
	    return traitementAndEtYoda(compteurUpper,compteurLower,indexUpper,indexLower,sb, upperCaseNames, nameList);
	}

	private static String traitementAndEtYoda(int compteurUpper,int compteurLower,int indexUpper,int indexLower, StringBuilder sb, StringBuilder upperCaseNames, String[] nameList) {
		boolean yodaUpper = false, yodaLower = false;
		for (String name : nameList) {
	    	if (name != null && yodaUpper(name))
	    		yodaUpper = true;
	    	if (name != null && yodaLower(name))
	    		yodaLower = true;
	    }
		if (compteurUpper >1) 
	    	upperCaseNames.replace(indexUpper, indexUpper+2, " AND ");
	    upperCaseNames.append(" !");
	    if (compteurLower > 1) 
	    	sb.replace(indexLower, indexLower + 2, " and ");
	    if (yodaUpper) {
	    	upperCaseNames.delete(6, 13);
	    	upperCaseNames.insert(upperCaseNames.length() -2, ", HELLO");
	    }
	    if (yodaLower) {
	    	sb.delete(0, 7);
	    	sb.append(", Hello");
	    }
	    if (compteurUpper > 0)
	    	sb.append(upperCaseNames);
	    return sb.toString();
	}
	
	private static String[] differentNom(String[] names) {
		String[] nameList = new String[names.length];
		int j = 0;
		for (String name : names) {
			boolean exists = false;
			for (int i = 0 ; i < j ; i++) {
				if (nameList[i].equals(name)) {
					exists = true;
					break;
				}
			}
			if (!exists) {
				nameList[j] = name;
				j++;
			}
			
		}
		return nameList;
	}
	
	private static int[] occurenceNom(String[] names, String[] nameList) {
		int[] occurenceName = new int[nameList.length];
	    for (int i = 0; i < nameList.length; i++) {
	        for (String name : names) {
	            if (name.equals(nameList[i])) {
	                occurenceName[i]++;
	            }
	        }
	    }
	    return occurenceName;
	}
	
	private static StringBuilder salutationLower(StringBuilder sb, int[] occurence, String name, int indice) {
		if (occurence[indice] > 1)
    		sb.append(", " + capitalize(name) + " (x" + occurence[indice] + ")");
    	else
    		sb.append(", " + capitalize(name));
		return sb;
	}
	
	private static StringBuilder salutationUpper(StringBuilder upperCaseNames, int[] occurenceNames, String name, int i) {
		if (occurenceNames[i] > 1)
    		upperCaseNames.append(", " + name + " (x" + occurenceNames[i] + ")");
    	else
    		upperCaseNames.append(", " + name);
		return upperCaseNames;
	}
	
	private static boolean yodaUpper(String name) {
		return name.equals("YODA");
	}
	
	private static boolean yodaLower(String name) {
		return name.equals("yoda");
	}

	private static String capitalize(String name) {
	    return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
	}
	
}
