import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DatabaseManagementSystem {

    private ConnectionManager connectionManager;
    private QueryModule queryModule;
    private TransactionModule transactionModule;
    private CacheModule cacheModule;

    // Додано конструктор із залежностями
    public DatabaseManagementSystem(ConnectionManager connectionManager,
                                    QueryModule queryModule,
                                    TransactionModule transactionModule,
                                    CacheModule cacheModule) {
        this.connectionManager = connectionManager;
        this.queryModule = queryModule;
        this.transactionModule = transactionModule;
        this.cacheModule = cacheModule;
    }

    public void run() {
        try {
            queryModule.runQuery("SELECT * FROM Customers WHERE age > 25");
            transactionModule.beginTransaction();
            cacheModule.cacheData("123", "Customer Data");
            queryModule.runQuery("UPDATE Customers SET name='John Doe' WHERE id=123");
            transactionModule.endTransaction();
            cacheModule.cacheData("cache_key_456", "Updated Customer Data");
        } catch (Exception e) {
            System.out.println("Error during DBMS operation: " + e.getMessage());
        }
    }
}


class ConnectionManager {

    private static ConnectionManager instance;
    private boolean isConnected = false;

    private ConnectionManager() {
        System.out.println("Connection Manager Initialized.");
    }

    public static ConnectionManager getInstance() {
        if (instance == null) {
            instance = new ConnectionManager();
        }
        return instance;
    }

    public void connect() {
        if (!isConnected) {
            System.out.println("Connecting to the database...");
            isConnected = true;
        }
    }

    public void disconnect() {
        if (isConnected) {
            System.out.println("Disconnected from the database.");
            isConnected = false;
        }
    }
}

class QueryModule {

    private ConnectionManager connectionManager;

    public QueryModule(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }

    public void runQuery(String query) {
        connectionManager.connect();
        System.out.println("Executing query: " + query);
        connectionManager.disconnect();
    }
}

class TransactionModule {

    private ConnectionManager connectionManager;

    public TransactionModule(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }

    public void beginTransaction() {
        connectionManager.connect();
        System.out.println("Transaction started.");
    }

    public void endTransaction() {
        System.out.println("Transaction ended.");
        connectionManager.disconnect();
    }
}

class CacheModule {

    private ConnectionManager connectionManager;
    private HashMap<String, String> cache;

    public CacheModule(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
        this.cache = new HashMap<>();
    }

    public void cacheData(String key, String data) {
        if (!cache.containsKey(key)) {
            cache.put(key, data);
            System.out.println("Cached data with key: " + key);
        } else {
            System.out.println("Key already exists in cache: " + key);
        }
    }

    public String retrieveData(String key) {
        String data = cache.get(key);
        System.out.println("Retrieved data for key: " + key + " - " + (data != null ? data : "No data found"));
        return data;
    }
}
