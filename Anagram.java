/** Functions for checking if a given string is an anagram. */
public class Anagram {
    public static void main(String args[]) {
        // Tests the isAnagram function.
        System.out.println(isAnagram("silent","listen"));  // true
        System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
        System.out.println(isAnagram("Madam Curie","Radium came")); // true
        System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

        // Tests the preProcess function.
        System.out.println(preProcess("What? No way!!!"));
        
        // Tests the randomAnagram function.
        System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
        
        // Performs a stress test of randomAnagram 
        String str = "1234567";
        Boolean pass = true;
        //// 10 can be changed to much larger values, like 1000
        for (int i = 0; i < 10; i++) {
            String randomAnagram = randomAnagram(str);
            System.out.println(randomAnagram);
            pass = pass && isAnagram(str, randomAnagram);
            if (!pass) break;
        }
        System.out.println(pass ? "test passed" : "test Failed");
    }  

    // Returns true if the two given strings are anagrams, false otherwise.
    public static boolean isAnagram(String str1, String str2) {
        String new1 = preProcess(str1);
        String new2 = preProcess(str2);
        new1 = new1.replace(" ", "");
        new2 = new2.replace(" ", "");
        int countInNew1 = 0;
        int countInNew2 = 0;
        for (int i = 0; i < new1.length(); i++) {
            countInNew1 = 0;
            countInNew2 = 0;
            for (int j = 0; j < new1.length(); j++) {
                if (new1.charAt(i) == new1.charAt(j)) {
                    countInNew1++;
                }
            }
            for (int j = 0; j < new1.length(); j++) {
                if (new1.charAt(i) == new2.charAt(j)) {
                    countInNew2++;
                }
            }
            if (countInNew1 != countInNew2) {
                return false;
            }
        }
        return true;
    }
       
    // Returns a preprocessed version of the given string: all the letter characters are converted
    // to lower-case, and all the other characters are deleted, except for spaces, which are left
    // as is. For example, the string "What? No way!" becomes "whatnoway"
    public static String preProcess(String str) {
        String newString = "";
        for (int i = 0; i < str.length(); i++) {
            char curChar = str.charAt(i);
            if (Character.isLetter(curChar) || Character.isWhitespace(curChar)){
                newString = newString + str.charAt(i);
            }
        }
        newString = newString.toLowerCase();
        return newString;
    } 
       
    // Returns a random anagram of the given string. The random anagram consists of the same
    // characters as the given string, re-arranged in a random order. 
    public static String randomAnagram(String str) {
        String temp = preProcess(str);
        String anagram = "";
		int newIndex = (int) (Math.random() * temp.length());

        while (temp.length() > 0) {
            anagram = anagram + temp.charAt(newIndex);
            temp = temp.substring(0, newIndex) + temp.substring(newIndex+1, temp.length());
			newIndex = (int) (Math.random() * temp.length());

        }

        return anagram;
        
        
        
        
        
    }
}


