package algorithm;

/**
 * Created by kulabun on 02.12.15.
 */
public class InPlaceMergeSort implements InPlaceSortingAlgorithm {

    @Override
    public int[] sort(int[] data) {
        return sort(data, 0, data.length - 1);
    }

    private int[] sort(int[] data, int start, int end) {
        // only one element
        if (end == start) {
            return data;
        }
        // two elements
        if (end - start == 1) {
            if (data[start] > data[end]) {
                ArrayUtils.swap(data, start, end);
            }
            return data;
        }

        // divide array in two parts and sort it sequentially
        int half = start + ((end - start) >> 1);
        sort(data, start, half);
        sort(data, half, end);

        // and merge two sorted array into one
        merge(data, start, half, end);
        return data;
    }

    private void merge(int[] data, int start, int half, int end) {
        int ptr = start;
        while (ptr < half) {
            if (data[ptr] > data[half]) {
                ArrayUtils.swap(data, ptr, half);
                push(data, half, end);
            }
            ptr++;
        }
    }

    private int push(int[] data, int ptr, int end) {
        while (ptr < end && data[ptr] > data[ptr + 1]) {
            ArrayUtils.swap(data, ptr, ptr + 1);
            ptr++;
        }
        return ptr;
    }
}
