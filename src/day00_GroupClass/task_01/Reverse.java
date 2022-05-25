package day00_GroupClass.task_01;

public class Reverse {

    public static String reversedStr (String word){

        String reversed = "";
        for (int i = word.length()-1; i >= 0 ; i--) {
            reversed += word.charAt(i);
        }
        return reversed;
    }

    public static void main(String[] args) {

        System.out.println(reversedStr("Reversed"));
    }
}
