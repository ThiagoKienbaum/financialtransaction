package enums.operationtype

enum OperationType {

    COMPRA_A_VISTA(1),
    COMPRA_PARCELADA(2),
    SAQUE(3),
    PAGAMENTO(4)

    private final Integer id

    OperationType(Integer id) {
        this.id = id
    }

    public Integer getId() {
        return this.id
    }

    public Boolean isPositive() {
        return [OperationType.PAGAMENTO].contains(this)
    }

    public static OperationType get(Integer id) {
        for (OperationType operationType in values()) {
            if (operationType.id == id) {
                return operationType
            }
        }

        return null
    }
}
