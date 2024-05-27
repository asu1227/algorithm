class GCD {
    /*GCD ,Greatest Common Divisor, 最大公约数 */
    public int gcd(int x, int y) {
        /* 欧几里得算法。这个算法的基本思想是:
            两个数的最大公约数等于较小的那个数和两数之差的最大公约数，简化到终止条件是其中一个数变成零。
            */
        return x == 0 ? y : gcd(y % x, x);
    }
}