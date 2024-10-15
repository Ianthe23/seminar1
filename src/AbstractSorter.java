public abstract class AbstractSorter {
    //metoda abstracta
    public abstract void sort(int... toSort);

    static void swap(int[] toSort, int i, int j) {
        int temp = toSort[i];
        toSort[i] = toSort[j];
        toSort[j] = temp;
    }
}
