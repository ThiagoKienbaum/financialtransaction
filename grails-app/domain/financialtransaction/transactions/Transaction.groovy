package financialtransaction.transactions

import enums.operationtype.OperationType
import financialtransaction.account.Account

class Transaction {

    Account account

    OperationType operationType

    BigDecimal amount

    Date eventDate = new Date()
}
