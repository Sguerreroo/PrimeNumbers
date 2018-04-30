import java.util.HashSet;
import java.util.Set;

public class PrimeNumbers {

    // todo change int to BigInteger

    public static boolean isPrime(int n, int m) {

        int[] mTest = selectMIntegers(n, m);

        System.out.println("Números que se seleccionan aleatoriamente: ");
        for (int i = 0; i < m; i++) {
            if (i != m-1)
                System.out.print(mTest[i] + ", ");
            else
                System.out.println(mTest[i]);
        }

        for (int i = 0; i < m; i++) {
//            double pow = Math.pow(mTest[i], n-1);
//            System.out.println("bi = " + mTest[i]);
//            System.out.println("n = " + n);
//            System.out.println("bi ^ n-1 = " + pow);
//            System.out.println("Resto = " + pow % n);

            if (Math.pow(mTest[i], n-1) % n != 1)
                return false;
            int mcd = mcd(mTest[i]-1, n);
            if (!findJ(n, mcd))
                return false;
        }
        return true;
    }

    private static int[] selectMIntegers(int n, int m) {
        Set<Integer> selected = new HashSet<>();
        int[] result = new int[m];
        for (int i = 0; i < m; i++) {
            int possible = (int) (Math.random()*n-1)+1;
            while (!selected.add(possible))
                possible = (int) (Math.random()*n-1)+1;
            result[i] = possible;
        }
        return result;
    }

    private static boolean findJ(int n, int mcd) {
        int j = 1;
        double pow = Math.pow(2, j);
        while (pow <= n-1) {
            if ((n-1)/pow % 1 != 0 && (1 < mcd) && (mcd < n))
                return false;
            pow = Math.pow(2, ++j);
        }
        return true;
    }

    private static int mcd(int a, int b) {
        return b == 0 ? a : mcd(b, a % b);
    }

}
