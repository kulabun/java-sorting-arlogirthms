package algorithm;

/**
 * Created by kulabun on 05.12.15.
 */
public class HeapSort implements InPlaceSortingAlgorithm {
    @Override
    public int[] sort(int[] data) {
        // build sorted heap only once. this is O(n*lgN) operation
        makeHeap(data);
        // every round we search for subarray max element and move to the end of this subarray
        for (int i = data.length - 1; i != 0; i--) {
            normalizeHeap(data, i + 1, 0); // normalize heap. This Operation complexity is O(lgN)
            ArrayUtils.swap(data, 0, i);
        }
        return data;
    }

    private void makeHeap(int[] data) {
        // apply normalization for each node from down to up (N)
        for (int i = data.length - 1; i != 0; i--) {
            normalizeHeap(data, data.length, i);
        }
    }

    private void normalizeHeap(int[] data, int n, int parent) {
        // push updated root from up to down (lgN)
        while (parent < n) {
            int child = parent * 2 + 1;
            if (child >= n) {
                return;
            }
            if (child < n && child + 1 < n && data[child + 1] > data[child]) {
                child = child + 1;
            }
            if (data[child] > data[parent]) {
                ArrayUtils.swap(data, child, parent);
                parent = child;
            } else {
                break;
            }
        }
    }
}
