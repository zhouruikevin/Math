package example.com.math;

import org.junit.Test;

import example.com.math.sort.heap.HeapMethodFactory;

/**
 * Created by Administrator on 2016/8/12.
 */
public class HeapMethodFactoryTest {
    private int[] mArr = {6, 2, 8, 1, 3, 4, 10};

    @Test
    public void testSort() {
        HeapMethodFactory.minHeapSort(mArr);

    }

    @Test
    public void testMinHeapUp() {
        for (int i = 0; i < mArr.length; i++) {
            HeapMethodFactory.minHeapUp(mArr, i);
        }
        printArr(mArr, mArr.length);
    }

    @Test
    public void testMinHeapDownCreate() {
        HeapMethodFactory.minHeapCreate(mArr);
        printArr(mArr, mArr.length);
    }

    public void printArr(int[] arr, int n) {
        if (arr == null) {
            System.out.println("arr is null");
        } else {
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + ",");
            }
            System.out.println();
        }
    }
}
