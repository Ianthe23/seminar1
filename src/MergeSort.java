public class MergeSort extends AbstractSorter{
    private static void merge(int[] array, int[] leftArray, int[] rightArray, int left, int right ) {
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (leftArray[i] < rightArray[j]) {
                array[k++] = leftArray[i++];
            }
            else {
                array[k++] = rightArray[j++];
            }
        }

        while (i < left) {
            array[k++] = leftArray[i++];
        }

        while (j < right) {
            array[k++] = rightArray[j++];
        }
    }

    private static void mergeSort(int[] array, int length) {
        if (length < 2) {
            return;
        }

        int mid = length / 2;
        int[] left = new int[mid];
        int[] right = new int[length - mid];

        for (int i = 0; i < mid; i++) {
            left[i] = array[i];
        }

        for (int i = 0; i < mid; i++) {
            right[i] = array[mid+i];
        }

        mergeSort(left, mid);
        mergeSort(right, length - mid);

        merge(array, left, right, mid, length - mid);
    }

    @Override
    public void sort(int... toSort) {
        mergeSort(toSort, toSort.length);
    }
}
