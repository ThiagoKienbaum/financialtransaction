package api

import enums.operationtype.OperationType
import exception.BusinessException
import financialtransaction.account.Account
import financialtransaction.transactions.Transaction
import financialtransaction.transactions.TransactionService
import org.codehaus.groovy.grails.web.json.JSONObject
import org.springframework.http.HttpStatus

class TransactionController {

    TransactionService transactionService

    def save() {
        try {
            JSONObject requestJson = request.JSON
            Account account = Account.get(requestJson."account_id")
            OperationType operationType = OperationType.get(Integer.valueOf(requestJson."operation_type_id"))
            BigDecimal amount = BigDecimal.valueOf(requestJson.amount)

            Transaction transaction = transactionService.save(account, operationType, amount)

            render(status: HttpStatus.CREATED, contentType: "text/json") {
                ["transaction_id": transaction.id,
                 "account_id": transaction.account.id,
                 "operation_type_id": transaction.operationType.getId(),
                 "amount": transaction.amount,
                 "event_date": transaction.eventDate]
            }
        } catch (BusinessException businessException) {
            render(status: HttpStatus.FORBIDDEN, text: businessException.getMessage())
        } catch (Exception exception) {
            render(status: HttpStatus.INTERNAL_SERVER_ERROR, text: exception.getMessage())
        }
    }
}
