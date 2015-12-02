package algorithm;

import java.util.Random;

/**
 * Created by kulabun on 01.12.15.
 */
public class AbstractSortingBenchmark {
    public static final int ARRAY_SIZE = 1 << 16;
    public static final int ITERATIONS = 3;
    private Random rand = new Random();
    private int[][] arrays;

    public AbstractSortingBenchmark() {
        arrays = createTestData();
    }

    private int[][] createTestData() {
        int[][] arrays = new int[ITERATIONS][];
        for (int i = 0; i < ITERATIONS; i++) {
            arrays[i] = createArray(ARRAY_SIZE);
        }
        return arrays;
    }

    private int[] createArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt();
        }
        return array;
    }

    public long benchSorting(SortingAlgorithm algorithm, int[] data) {
        long start = System.currentTimeMillis();
        algorithm.sort(data);
        long duration = System.currentTimeMillis() - start;

        for (int i = 1; i < data.length; i++) {
            if(data[i-1] > data[i]) {
                throw new BadSortingException();
            }
        }
        return duration;
    }

    public long benchSorting(SortingAlgorithm algorithm) {
        long sum = 0;
        for (int[] array : arrays) {
            sum += benchSorting(algorithm, array);
        }
        return sum / arrays.length;
    }
}
