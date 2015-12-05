package algorithm;

/**
 * Created by kulabun on 05.12.15.
 */
public class ArrayUtils {
    private ArrayUtils(){}

    static void swap(int[] data, int i, int j) {
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }
}
