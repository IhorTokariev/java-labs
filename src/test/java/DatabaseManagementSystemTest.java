import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

// Unit tests for DatabaseManagementSystem
public class DatabaseManagementSystemTest {

    private QueryModule queryModule;
    private TransactionModule transactionModule;
    private CacheModule cacheModule;
    private DatabaseManagementSystem dbms;

    @BeforeEach
    public void setUp() {
        ConnectionManager connectionManager = ConnectionManager.getInstance();
        queryModule = mock(QueryModule.class);
        transactionModule = mock(TransactionModule.class);
        cacheModule = mock(CacheModule.class);
        dbms = new DatabaseManagementSystem();
    }

    @Test
    public void testRunQueries() {
        dbms.run();
        verify(queryModule, times(2)).runQuery(anyString());
        verify(transactionModule).beginTransaction();
        verify(transactionModule).endTransaction();
        verify(cacheModule, times(2)).cacheData(anyString(), anyString());
    }
}
