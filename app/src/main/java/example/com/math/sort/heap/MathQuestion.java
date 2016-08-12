package example.com.math.sort.heap;

/**
 * <li>【编程之美】寻找最大的K个数</li> N*logK
 * <li>第K大的数</li>    N*logK+K
 * <li>查找第K到第M大的数</li> N*logK+K*log(K-M)
 * <li>网站搜索的网页权重会不断的变化，要取出其中最大的K个网页</li> N*logK
 */
public class MathQuestion {
    private static void minHeapDown(int[] arr, int i, int n) {
        int left = 2 * i + 1;
        while (left < n) {
            if ((left + 1 < n) && arr[left + 1] < arr[left]) {
                ++left;
            }
            if (arr[i] <= arr[left]) {
                break;
            }
            swap(arr, i, left);
            left = 2 * i + 1;
        }
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    private static void minHeapCreate(int[] arr, int k) {
        if (arr == null || k > arr.length || k <= 0) {
            throw new IllegalArgumentException("argument error!");
        }
        for (int i = k - 1; i >= 0; i--) {
            minHeapDown(arr, i, k);
        }
    }

    public static void findTopNumber(int[] arr, int n, int[] tops, int k) {
        for (int i = 0; i < k; i++) {
            tops[i] = arr[i];
        }
        minHeapCreate(tops, k);

        for (int i = k; i < n; i++) {
            if (arr[i] > tops[0]) {
                tops[0] = arr[i];
                minHeapCreate(tops, k);
            }
        }
    }
}
