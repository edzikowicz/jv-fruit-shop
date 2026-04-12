package core.basesyntax.service.operation;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class ReturnOperation implements OperationHandler {
    @Override
    public void handleOperation(FruitTransaction transaction, Map<String, Integer> storage) {
        storage.merge(transaction.getFruit(), transaction.getQuantity(), Integer::sum);
    }
}
