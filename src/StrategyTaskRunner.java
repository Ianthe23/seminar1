public class StrategyTaskRunner implements TaskRunner {
    private final Container container;
    public StrategyTaskRunner(Strategy s) {
        TaskContainerFactory taskContainerFactory = TaskContainerFactory.getInstance();
        this.container = taskContainerFactory.createContainer(s);
    }

    @Override
    public void executeOneTask() {
       if(hasTask()) {
           Task removedTask = container.remove();
           removedTask.execute();
       }
    }

    @Override
    public void executeAll() {
        while(hasTask()) {
            executeOneTask();
        }
    }

    @Override
    public void addTask(Task t) {
        container.add(t);
    }

    @Override
    public boolean hasTask() {
        return !container.isEmpty();
    }
}
