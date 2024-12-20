public class Main {
    public static void main(String[] args) {
        // Use singleton instance of ConnectionManager
        ConnectionManager connectionManager = ConnectionManager.getInstance();

        // Create instances of other modules
        QueryModule queryModule = new QueryModule(connectionManager);
        TransactionModule transactionModule = new TransactionModule(connectionManager);
        CacheModule cacheModule = new CacheModule(connectionManager);

        // Create DatabaseManagementSystem instance
        DatabaseManagementSystem dbms = new DatabaseManagementSystem(
                connectionManager,
                queryModule,
                transactionModule,
                cacheModule
        );

        // Run the system
        dbms.run();
    }
}
