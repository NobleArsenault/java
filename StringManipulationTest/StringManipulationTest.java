public class StringManipulationTest {
    public static void main(String[] args){
        // StringManipulation iD = new StringManipulation();
        // iD.TrimConcat("Hello ", " World");
        // System.out.println(iD);

        StringManipulation trimmer = new StringManipulation();

        String str = trimmer.trimConcat("    I'm     ","     Sorry    ");
        System.out.println(str);

        StringManipulation indexfinder = new StringManipulation();

        char letter = 'o';
        String answer1 = "At index ";
        String answer2 = "Not there";
        Integer idx = indexfinder.indexOrNull("Hey Noble", letter);
            if (idx >= 0)
        System.out.println(answer1 + idx);
            else
        System.out.println(answer2);

        StringManipulation concatter = new StringManipulation();

        String strr = concatter.concatSubstring("hellooooo", 0, 5, " world");
        System.out.println(strr);
    }


}


