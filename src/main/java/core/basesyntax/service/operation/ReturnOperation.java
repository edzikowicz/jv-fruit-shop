package core.basesyntax.service.operation;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class ReturnOperation implements OperationHandler {
    @Override
    public void handleOperation(FruitTransaction transaction, Map<String, Integer> storage) {
        if (transaction.getFruit() == null || transaction.getFruit().isEmpty()) {
            throw new RuntimeException("Fruit is null or empty" + transaction.getFruit());
        }
        if (transaction.getQuantity() < 0) {
            throw new RuntimeException("Quantity is negative" + transaction.getQuantity());
        }

        storage.merge(transaction.getFruit(), transaction.getQuantity(), Integer::sum);
    }
}
