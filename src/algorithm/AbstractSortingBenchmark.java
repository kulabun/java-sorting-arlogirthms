package algorithm;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by kulabun on 01.12.15.
 */
public class AbstractSortingBenchmark {
    private Random rand = new Random();
    private BenchData benchData = new BenchData();

    public AbstractSortingBenchmark() {
    }

    private int[] createArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(10000);
        }
        return array;
    }

    public long benchSorting(SortingAlgorithm algorithm, int[] data) {
        long start = System.currentTimeMillis();
        int[] result = sort(algorithm, data);
        long duration = System.currentTimeMillis() - start;

        if (data.length != result.length) {
            throw new BadSortingException();
        }
        for (int i = 1; i < result.length; i++) {
            if (result[i - 1] > result[i]) {
                throw new BadSortingException();
            }
        }
        return duration;
    }

    private int[] sort(SortingAlgorithm algorithm, int[] data) {
        return algorithm.sort(data);
    }

    public long benchSorting(SortingAlgorithm algorithm) {
        long sum = 0;
        int[][] arrays = benchData.get();
        for (int[] array : arrays) {
            sum += benchSorting(algorithm, array);
        }
        return sum / arrays.length;
    }

    private class BenchData {
        public static final int ARRAY_SIZE = 1 << 16;
        public static final int ITERATIONS = 3;

        private int[][] arrays;

        public BenchData() {
            arrays = createTestData();
        }

        private int[][] createTestData() {
            int[][] arrays = new int[ITERATIONS][];
            for (int i = 0; i < ITERATIONS; i++) {
                arrays[i] = createArray(ARRAY_SIZE);
            }
            return arrays;
        }

        private int[][] get() {
            return copy(arrays);
        }

        private int[][] copy(int[][] arrays) {
            int[][] result = new int[arrays.length][];
            for (int i = 0; i < result.length; i++) {
                int[] arr = arrays[i];
                result[i] = Arrays.copyOf(arr, arr.length);
            }
            return result;
        }
    }
}
