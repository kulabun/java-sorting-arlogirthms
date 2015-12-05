package algorithm;

/**
 * Created by kulabun on 03.12.15.
 */
public class BubbleSort implements InPlaceSortingAlgorithm {

    @Override
    public int[] sort(int[] data) {
        for (int i = 0; i < data.length; i++) {
            // search for local min index and make swap only once per round
            int minPos = i;
            for (int j = i + 1; j < data.length; j++) {
                if (data[minPos] > data[j]) {
                    minPos = j;
                }
            }
            ArrayUtils.swap(data, minPos, i);
        }
        return data;
    }
}
