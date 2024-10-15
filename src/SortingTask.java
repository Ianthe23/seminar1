public class SortingTask extends Task{
    int[] toSort;
    SortingStrategy strategy;
    AbstractSorter taskSorter;

    public SortingTask(String id, String description, int[] toSort, SortingStrategy strategy) {
        super(id, description);
        this.toSort = toSort;
        this.strategy = strategy;
        SortingFactory factory = SortingFactory.getInstance();
        this.taskSorter = factory.makeSorter(strategy);
    }

    @Override
    public void execute() {
        taskSorter.sort(toSort);
    }
}
