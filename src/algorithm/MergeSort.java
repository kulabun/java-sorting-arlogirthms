package algorithm;

import java.util.Arrays;

/**
 * Created by kulabun on 02.12.15.
 */
public class MergeSort implements CopingSortingAlgorithm {
    @Override
    public int[] sort(int[] data) {
        // only one element
        if (data.length == 1) {
            return data;
        }
        // two elements
        if (data.length == 2) {
            if (data[0] > data[1]) {
                ArrayUtils.swap(data, 0, 1);
            }
            return data;
        }

        // divide array in two parts and sort it sequentially
        int half = data.length >> 1;
        int[] left = sort(Arrays.copyOfRange(data, 0, half));
        int[] right = sort(Arrays.copyOfRange(data, half, data.length));

        // and merge two sorted array into one
        return merge(left, right);
    }

    private int[] merge(int[] left, int[] right) {
        int leftPos = 0, rightPos = 0;
        int leftSize = left.length, rightSize = right.length;
        int[] result = new int[leftSize + rightSize];
        int resultPos = 0;
        while (resultPos < result.length) {
            if (rightPos == rightSize) result[resultPos++] = left[leftPos++];
            else if (leftPos == leftSize) result[resultPos++] = right[rightPos++];
            else if (left[leftPos] < right[rightPos]) result[resultPos++] = left[leftPos++];
            else result[resultPos++] = right[rightPos++];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {9912,0,33,55,32,1,3,4,5,1,4,2,8,9,4,0,7,2,526,7,7,4,63,73,735,3453,39,0};
        int[] sorted = new MergeSort().sort(arr);
        System.out.println(Arrays.toString(sorted));
    }
}
