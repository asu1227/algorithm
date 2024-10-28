import java.util.Arrays;

public class KMP {
    /*使用KMP算法解决寻找字符串中相匹配的模式串 */
    public int maxRepeating(String sequence, String word) {
        int n = sequence.length(), m = word.length();
        if (n < m) {
            return 0;
        }
        // KMP数组，回退数组
        int[] pi = new int[m];
        for (int i = 1, j = 0; i < m; i++) {
            while (j > 0 && word.charAt(j) != word.charAt(i)) {
                // 回退
                j = pi[j-1];
            }
            if (word.charAt(j) == word.charAt(i)) {
                j++;
            }
            pi[i] = j;
        }
        // 动态规划
        // f[i]表示以i为末尾的字符串中含有连续子字符串的数量
        int[] f = new int[n];
        for (int i = 0, j = 0; i < n; i++) {
            while (j > 0 && word.charAt(j) != sequence.charAt(i)) {
                j = pi[j-1];
            }
            if (sequence.charAt(i) == word.charAt(j+1)) {
                j++;
                if (j == m) {
                    f[i] = (i >= m ? f[i-m] : 0) + 1;
                    // 完整匹配后回退
                    j = pi[j-1];
                }
            }
        }
        return Arrays.stream(f).max().getAsInt();
    }
}
