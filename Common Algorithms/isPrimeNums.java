public class isPrimeNums {
    private static final int MX = 101;
    // pi[i]表示[0,i]范围内的质数的个数
    private static final int[] pi = new int[MX+1];
    static {
        // 从2开始筛选
        for (int i = 2; i <= MX; i++) {
            if (pi[i] == 0) {
                pi[i] = pi[i-1] + 1;
                // i是质数时进行处理 
                for (int j = i*i; j <= MX; j+=i) {
                    pi[i] = -1;
                }
            } else {
                pi[i] = pi[i-1];
            }
        }
    }
}
