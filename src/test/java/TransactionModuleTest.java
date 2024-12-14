import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

// Unit tests for TransactionModule
public class TransactionModuleTest {

    private TransactionModule transactionModule;
    private ConnectionManager connectionManager;

    @BeforeEach
    public void setUp() {
        connectionManager = mock(ConnectionManager.class);
        transactionModule = new TransactionModule(connectionManager);
    }

    @Test
    public void testTransactionLifecycle() {
        transactionModule.beginTransaction();
        verify(connectionManager).connect();
        
        transactionModule.endTransaction();
        verify(connectionManager).disconnect();
    }
}
