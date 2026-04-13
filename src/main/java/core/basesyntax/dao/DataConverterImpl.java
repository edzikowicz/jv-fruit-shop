package core.basesyntax.dao;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    @Override
    public List<FruitTransaction> convertToTransaction(List<String> input) {
        if (input == null || input.isEmpty()) {
            return null;
        }
        return input.stream()
                .skip(1)
                .map(this::getFromCsvFile)
                .toList();
    }

    public FruitTransaction getFromCsvFile(String input) {
        String[] fields = input.split(",");
        if (fields.length != 3) {
            throw new IllegalArgumentException("Invalid CSV File: " + input);
        }
        FruitTransaction fruitTransaction = new FruitTransaction();
        fruitTransaction.setOperation(FruitTransaction.Operation.fromCode(fields[0]));
        fruitTransaction.setFruit(fields[1]);

        if (Integer.parseInt(fields[2]) < 0) {
            throw new RuntimeException("Quantity must be a positive: " + fields[2]);
        }
        fruitTransaction.setQuantity(Integer.parseInt(fields[2]));
        return fruitTransaction;
    }
}
