import java.util.ArrayList;
import java.util.List;

public class QueueContainer extends AbstractContainer {
    public QueueContainer() {
        super();
    }

    @Override
    public Task remove() {
        if (isEmpty()) {
            return null;
        }
        return tasks.remove(0);
    }
}
