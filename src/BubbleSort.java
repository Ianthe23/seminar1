public class BubbleSort extends AbstractSorter{
    @Override
    public void sort(int... toSort) {
        int i, j;
        boolean swapped;

        for (i = 0; i < toSort.length - 1; i++) {
            swapped = false;
            for (j = i + 1; j < toSort.length; j++) {
                if (toSort[j] < toSort[j - 1]) {
                    swap(toSort, j, j-1);
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }
    }
}
