public class Main {

    public static void main(String[] args) {
        int m = 2;
        int trueCount = 0;
        int primes[] = {17,31,191,607,727,524287};
        int composites[] = {20,100,585,657,100096};

        System.out.println("Prueba números primos");


        for (int i = 0; i < primes.length; i++) {
            trueCount = Main.test(primes[i], m);
            System.out.println("Acierto " + trueCount + "% para " + primes[i]);
        }

        System.out.println("Prueba números compuestos");
        for (int i = 0; i < composites.length; i++) {
            trueCount = Main.test(composites[i], m);
            System.out.println("Acierto " + (100-trueCount) + "% para " + composites[i]);
        }


    }

    private static int test (int n, int m){
        int trueCount= 0;
        for (int i = 0; i < 100; i++) {
            if(PrimeNumbers.isPrime(n, m))
                trueCount++;
        }
        return trueCount;
    }


}
