public class ReversStringRec {

    StringBuilder stringBuilder = new StringBuilder();

    ReversStringRec(){
    }
    public static void main(String args[]){
        String test = "Sony music is a good company";

        System.out.println( "original String " +  test);

        System.out.println(reverseRecursively( "reverse String :" + test));

    }

    public static String reverseRecursively(String str) {

        //base case to handle one char string and empty string
        if (str.length() < 2) {
            return str;
        }

        return reverseRecursively(str.substring(1)) + str.charAt(0);

    }
}
