public class StringManipulation {
    public String trimConcat (String strA, String strB){
        String con = strA.trim() + strB.trim();
        return con;
    }
    public Integer indexOrNull(String str, char letter){
        Integer charmander = str.indexOf(letter);
        return charmander;
    }
    public String concatSubstring(String strA, Integer a, Integer b, String strB){
        String concatted = (strA.substring(a, b)) + strB;
        return concatted;
    }
}