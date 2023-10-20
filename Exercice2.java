public class Exercice2 {
    public static void main(String[] args) {
        checkSumSign();
    }

    private static void checkSumSign() {
        int a = 0;
        int b = 1;
        if(a + b >= 0){
            System.out.println("Сумма положительная");
        }
        else{
            System.out.println("Сумма отрицательная");
        }
    }
}