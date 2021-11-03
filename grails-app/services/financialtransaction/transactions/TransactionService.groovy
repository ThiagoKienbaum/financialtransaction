package financialtransaction.transactions

import enums.operationtype.OperationType
import exception.BusinessException
import financialtransaction.account.Account
import grails.transaction.Transactional

@Transactional
class TransactionService {

    public Transaction save(Account account, OperationType operationType, BigDecimal amount) {
        validateSave(account, operationType)

        BigDecimal parsedAmount = operationType.isPositive() ? amount.abs() : amount.abs() * -1

        Transaction transaction = new Transaction()
        transaction.account = account
        transaction.operationType = operationType
        transaction.amount = parsedAmount
        transaction.save(failOnError: true)

        return transaction
    }

    private void validateSave(Account account, OperationType operationType) {
        if (!account) throw new BusinessException("Conta não encontrada.")

        if (!operationType) throw new BusinessException("Tipo de transação não encontrada.")
    }
}
