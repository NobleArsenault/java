public class Pythagorean{
    public double calculateHypotenuse (int legA, int legB){
        double legC = Math.sqrt(legA * legA + legB * legB);
        System.out.println(legC);
        return legC;
    }
}