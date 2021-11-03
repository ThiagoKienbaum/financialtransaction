package financialtransaction.transactions

import enums.operationtype.OperationType
import financialtransaction.account.Account

class Transaction {

    Account account

    OperationType operationType

    BigDecimal amount

    Date eventDate = new Date()

    static constraints = { }

    static namedQueries = {
        query { Map search ->
            if (search.containsKey("id")) {
                eq("id", search.id)
            }

            if (search.containsKey("operationType")) {
                eq("operationType", search.operationType)
            }
        }
    }
}
