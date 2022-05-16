package day00_GroupClass;

public class SameLetters {
    public static void main(String[] args) {

        System.out.println(same("java", "aavj"));
        System.out.println(same("world", "place"));
        System.out.println(same("ABCD", "DABC"));
    }

    public static boolean same(String word1, String word2) {

        boolean result = true;

        if (word1.length() == word2.length()) {

            for (int j = 0; j < word1.length(); j++) {

                if (!word1.contains(word2.charAt(j) + "") || !word2.contains(word1.charAt(j) + "")) {
                    result = false;
                }
            }
        }else {
            return false;
        }
        return result;
    }

}