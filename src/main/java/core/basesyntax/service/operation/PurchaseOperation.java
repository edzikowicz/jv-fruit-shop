package core.basesyntax.service.operation;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void handleOperation(FruitTransaction transaction, Map<String, Integer> storage) {
        storage.computeIfPresent(
                transaction.getFruit(),
                (fruit, qty) -> qty - transaction.getQuantity());
    }
}
