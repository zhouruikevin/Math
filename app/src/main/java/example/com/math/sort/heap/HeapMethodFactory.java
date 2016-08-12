package example.com.math.sort.heap;

/**
 * Created by Administrator on 2016/8/12.
 */
public class HeapMethodFactory {

    /**
     * insert value
     *
     * @param arr
     * @param i
     */
    public static void minHeapUp(int arr[], int i) {
        if (arr == null || i == 0) {
            return;
        }
        int j = (i - 1) / 2;
        while (j >= 0 && i > 0) {
            if (arr[i] < arr[j]) {
                swap(arr, i, j);
            }
            i = j;
            j = (i - 1) / 2;
        }
    }

    public static void minHeapDown(int arr[], int i, int n) {

        int left = 2 * i + 1;
        while (left < n) {
            if (left + 1 < n && arr[left] > arr[left + 1]) {
                ++left;
            }

            if (arr[left] >= arr[i]) {
                break;
            }
            swap(arr, left, i);
            i = left;
            left = 2 * i + 1;
        }
    }

    public static void minHeapCreate(int arr[]) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            minHeapDown(arr, i, n);
        }
    }

    public static void minHeapSort(int arr[]) {
        int length = arr.length;

        minHeapCreate(arr);
        for (int i = length - 1; i >= 1; i--) {
            swap(arr, 0, i);
            minHeapDown(arr, 0, i);
            printArr(arr, length);
        }
    }

    public static void printArr(int[] arr, int n) {
        if (arr == null) {
            System.out.println("arr is null");
        } else {
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + ",");
            }
            System.out.println();
        }
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
