import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

// Unit tests for QueryModule
public class QueryModuleTest {

    private QueryModule queryModule;
    private ConnectionManager connectionManager;

    @BeforeEach
    public void setUp() {
        connectionManager = mock(ConnectionManager.class);
        queryModule = new QueryModule(connectionManager);
    }

    @Test
    public void testRunQuery() {
        queryModule.runQuery("SELECT * FROM Users");
        verify(connectionManager).connect();
        verify(connectionManager).disconnect();
    }
}
