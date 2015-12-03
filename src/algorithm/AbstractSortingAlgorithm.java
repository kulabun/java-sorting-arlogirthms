package algorithm;

/**
 * Created by kulabun on 02.12.15.
 */
public abstract class AbstractSortingAlgorithm implements SortingAlgorithm {

    protected void swap(int[] data, int i, int j) {
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }
}
