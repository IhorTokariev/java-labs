import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// Unit tests for ConnectionManager
public class ConnectionManagerTest {

    @Test
    public void testSingletonInstance() {
        ConnectionManager instance1 = ConnectionManager.getInstance();
        ConnectionManager instance2 = ConnectionManager.getInstance();
        assertSame(instance1, instance2, "Instances should be the same for singleton");
    }
}
