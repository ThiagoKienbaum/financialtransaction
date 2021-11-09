package financialtransaction.account

import exception.BusinessException
import grails.transaction.Transactional

@Transactional
class AccountService {

    public Account save(String documentNumber) {
        if (!documentNumber) throw new BusinessException("O número do documento é obrigatório.")

        Account account = new Account()
        account.documentNumber = documentNumber
        account.save(failOnError: true)

        return account
    }

    public Account updateAvailableCreditLimit(Account account, BigDecimal availableCreditLimit) {
        if (!account) throw new BusinessException("Conta não encontrada.")

        account.availableCreditLimit = availableCreditLimit.abs()
        account.save(failOnError: true)

        return account
    }
}
