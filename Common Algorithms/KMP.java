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
        Arrays.fill(pi, -1);
        for (int i = 1; i < m; i++) {
            int j = pi[i-1];
            while (j != -1 && word.charAt(i) != word.charAt(j+1)) {
                // 回退
                j = pi[j];
            }
            if (word.charAt(i) == word.charAt(j+1)) {
                // 更新KMP数组，即最大前缀后缀和数组
                // s[i+1] == s[pi[i]]，则更新pi[i+1] = pi[i]+1;
                // s[i+1] == s[j], 则更新pi[i+1] = j+1
                pi[i] = j+1;
            }
        }
        // 动态规划
        // k[i]表示以i为末尾的字符串中含有连续子字符串的数量
        int[] k = new int[n];
        int j = -1;
        for (int i = 0; i < n; i++) {
            while (j != -1 && sequence.charAt(i) != word.charAt(j+1)) {
                j = pi[j];
            }
            if (sequence.charAt(i) == word.charAt(j+1)) {
                j++;
                if (j == m - 1) {
                    k[i] = (i == m - 1 ? 0 : k[i-m]) + 1;
                    // 找到后还应该回退一次
                    j = pi[j];
                }
            }
        }
        return Arrays.stream(k).max().getAsInt();
    }
}
