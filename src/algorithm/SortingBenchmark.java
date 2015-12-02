package algorithm;

/**
 * Created by kulabun on 01.12.15.
 */
public class SortingBenchmark extends AbstractSortingBenchmark {
    public static void main(String[] args) {
        SortingBenchmark bench = new SortingBenchmark();
        SortingAlgorithm[] sortingAlgorithms = new SortingAlgorithm[]{
                new QuickSort()
        };
        for (SortingAlgorithm sortingAlgorithm : sortingAlgorithms) {
            long avgRunTime = bench.benchSorting(sortingAlgorithm);
            System.out.printf(sortingAlgorithm.getClass().getCanonicalName() + " : " + avgRunTime);
        }
    }
}
