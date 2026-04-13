package core.basesyntax.model;

public class FruitTransaction {
    private Operation operation;
    private String fruit;
    private int quantity;

    public FruitTransaction(Operation operation, String fruit, int quantity) {
        this.operation = operation;
        this.fruit = fruit;
        this.quantity = quantity;

    }

    public FruitTransaction() {
    }

    public Operation getOperation() {
        return operation;
    }

    public String getFruit() {
        return fruit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit;
    }

    public void setQuantity(int quantity) {
        if (quantity >= 0) {
            this.quantity = quantity;
        } else {
            throw new RuntimeException("Quantity must be greater than or equal to 0");
        }
    }

    public enum Operation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private String code;

        Operation(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }

        public static Operation fromCode(String code) {
            if (code == null || code.isEmpty()) {
                throw new RuntimeException("Operation code is null or empty");
            }

            for (Operation operation : Operation.values()) {
                if (operation.getCode().equals(code)) {
                    return operation;
                }
            }
            throw new IllegalArgumentException("No such operation: " + code);
        }
    }
}
