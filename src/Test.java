import java.time.LocalDateTime;
import java.util.ArrayList;

public class Test {
    private void testSorting(int[] toS, SortingStrategy strategy) {
        System.out.println("Strategie este: " + strategy.toString());
        SortingTask sortingTask = new SortingTask("1", "sa scriu tema", toS, strategy);
        sortingTask.execute();

        for (int s:toS){
            System.out.print(s + " ");
        }
        System.out.println();
    }

    private ArrayList<MessageTask> getListMessages() {
        ArrayList<MessageTask> messages = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            MessageTask messageTask = new MessageTask(Integer.toString(i), "eveniment", "spectacol la teatru", "me", "you", LocalDateTime.of(2024, 10, 11, 10, 0));
            messages.add(messageTask);
        }
        return messages;
    }

    private void testCreateStrategy (String strategy) {
        ArrayList<MessageTask> messages = this.getListMessages();
        StrategyTaskRunner strategyTaskRunner = new StrategyTaskRunner(Strategy.valueOf(strategy));
        messages.forEach(strategyTaskRunner::addTask);
        strategyTaskRunner.executeAll();
    }

    private void test13 (String strategy) {
        ArrayList<MessageTask> messages = this.getListMessages();
        StrategyTaskRunner strategyTaskRunner = new StrategyTaskRunner(Strategy.valueOf(strategy));
        TaskRunner runner = new PrinterTaskRunner(strategyTaskRunner);
        messages.forEach(runner::addTask);
        runner.executeAll();
    }

    private void test14(String strategy) {
        System.out.println("Strategie este: " + strategy + " (Strategy -> Printer -> Delay)");

        ArrayList<MessageTask> messages = this.getListMessages();
        StrategyTaskRunner strategyTaskRunner = new StrategyTaskRunner(Strategy.valueOf(strategy));
        messages.forEach(strategyTaskRunner::addTask);
        TaskRunner runner = new PrinterTaskRunner(strategyTaskRunner);

        runner = new DelayTaskRunner(runner);
        runner.executeAll();
        System.out.println("\n");
    }

    private void test14b(String strategy) {
        System.out.println("Strategie este: " + strategy + " (Strategy -> Delay -> Printer)");

        ArrayList<MessageTask> messages = this.getListMessages();
        StrategyTaskRunner strategyTaskRunner = new StrategyTaskRunner(Strategy.valueOf(strategy));
        messages.forEach(strategyTaskRunner::addTask);
        TaskRunner runner;
        runner = new DelayTaskRunner(strategyTaskRunner);
        runner = new PrinterTaskRunner(strategyTaskRunner);

        runner.executeAll();
        System.out.println("\n");
    }

    private void testSort(int []array) {
        System.out.println("Vectorul initial: ");
        for (int j : array) {
            System.out.print(j + " ");
        }
        System.out.println();

        int arraySize = array.length;
        int []array2 = new int[arraySize];
        System.arraycopy(array, 0, array2, 0, arraySize);

        testSorting(array, SortingStrategy.BubbleSort);
        testSorting(array2, SortingStrategy.MergeSort);
    }

    public void testAll(String[] args) {
        int []array = new int[] {1, 2, 5, 4, 3, 7, 6, 10};
        testSort(array);
        System.out.println("\n");

        System.out.println("Test FIFO");
        testCreateStrategy("FIFO");

        System.out.println("\nTest LIFO");
        testCreateStrategy("LIFO");

        System.out.println("\nTest Stack LIFO");
        test13("LIFO");

        System.out.println("\nTest Queue FIFO");
        test13("FIFO");

        if (args.length == 0) {
            System.out.println("Nu ai scris parametri!!");
            return;
        }

        System.out.println("\n");
        String strategy = args[0];
        try {
            System.out.println("Test 14 cu strategia: " + strategy);
            test14(strategy);
            test14b(strategy);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

