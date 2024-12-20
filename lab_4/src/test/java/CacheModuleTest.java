import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

// Unit tests for CacheModule
public class CacheModuleTest {

    private CacheModule cacheModule;
    private ConnectionManager connectionManager;

    @BeforeEach
    public void setUp() {
        connectionManager = mock(ConnectionManager.class);
        cacheModule = new CacheModule(connectionManager);
    }

    @Test
    public void testCacheData() {
        cacheModule.cacheData("key1", "data1");
        assertEquals("data1", cacheModule.retrieveData("key1"), "Cache data should be retrieved correctly");
    }

    @Test
    public void testRetrieveNonExistentKey() {
        assertNull(cacheModule.retrieveData("nonexistent"), "Retrieving non-existent key should return null");
    }
}
