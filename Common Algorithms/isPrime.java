public class isPrime {
    /*Sieve of Eratosthenes（埃拉托色尼筛法），一种高效地找出某个给定数n的所有质数的算法 */
    private static final int MX = 101;
    private static final boolean[] notPrime = new boolean[MX];
    static {
        notPrime[1] = true;
        for (int i = 2; i * i < MX; i++) {
            if (notPrime[i]) {
                continue;
            }
            for (int j = i * i; j < MX; j += i) {
                notPrime[j] = true;
            }
        }
    }
}
