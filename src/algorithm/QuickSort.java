package algorithm;

/**
 * Created by kulabun on 01.12.15.
 */
public class QuickSort implements InPlaceSortingAlgorithm {
    @Override
    public int[] sort(int[] data) {
        return sort(data, 0, data.length - 1);
    }

    public int[] sort(int[] data, int first, int last) {
        if (last - first < 1) {
            return data;
        }

        // set midPos to middle between first and last
        int midPos = first + ((last - first) >> 1);
        int mid = data[(midPos)];

        // init element markers
        int left = first;
        int right = last;

        do {
            // looking for elements to swap
            while (mid > data[left]) left++;
            while (mid < data[right]) right--;

            if (left < right) {
                ArrayUtils.swap(data, left, right);
                // if one of swapped element index is same to midPos
                // we have to update midPos with swapped element index;
                if (left == midPos) {
                    // switch midPos with right
                    midPos = right;
                    left++;
                } else if (right == midPos) {
                    // switch midPos with left
                    midPos = left;
                    right--;
                } else {
                    // midPos remain unchanged
                    left++;
                    right--;
                }
            }
        } while (left < right);

        // recursive call to left and right parties
        if (last != midPos - 1) {
            sort(data, first, midPos - 1);
        }
        if (first != midPos + 1) {
            sort(data, midPos + 1, last);
        }
        return data;
    }
}
