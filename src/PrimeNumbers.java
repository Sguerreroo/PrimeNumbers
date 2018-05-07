import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PrimeNumbers {

    public static boolean isPrime(int n, int m) {

        Set<Integer> mTest = selectMIntegers(n, m);

        List<Double> k = findK(n);

        for (Integer i : mTest) {
            if (new BigInteger("" + i).pow(n-1).mod(new BigInteger("" + n)).compareTo(BigInteger.ONE) != 0)
                return false;
            if (k.size() > 0 && Gcd(n, i, k))
                return false;
        }
        return true;
    }

    private static List<Double> findK(int n) {
        int j = 1;
        List<Double> k = new ArrayList<>();
        double pow = Math.pow(2, j);
        while (pow <= n-1) {
            if ((n-1)/pow % 1 == 0)
                k.add((n-1)/pow);
            pow = Math.pow(2, ++j);
        }
        return k;
    }

    private static Set<Integer> selectMIntegers(int n, int m) {
        Set<Integer> selected = new HashSet<>();
        while (selected.size() != m)
            selected.add((int) (Math.random()*n-1)+1);
        return selected;
    }

    private static boolean Gcd(int n, int mTest, List<Double> kList) {
        for (Double k : kList) {
            int gcd = gcd((int) Math.pow(mTest, k) - 1, n);
            if (1 < gcd && gcd < n)
                return true;
        }
        return false;
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

}
