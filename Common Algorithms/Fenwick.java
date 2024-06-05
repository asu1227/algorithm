public class Fenwick {
    /* 树状数组 */
    private final int[] tree;

    public Fenwick(int n) {
        tree = new int[n];
    }

    // 将第i个节点加到树状数组中,即更新树状数组
    public void add(int i) {
        while (i < tree.length) {
            tree[i]++;
            // +lowbit(i)
            i += i & -i;
        }
    }

    // 计算第i个节点之前的前缀和,即查询树状数组
    public int pre(int i) {
        int res = 0;
        // 树状数组节点从1开始
        while (i > 0) {
            res += tree[i];
            // -lowbit(i)
            i &= i - 1;
        }
        return res;
    }
}
