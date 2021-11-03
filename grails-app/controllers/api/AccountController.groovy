package api

import exception.BusinessException
import financialtransaction.account.Account
import financialtransaction.account.AccountService
import grails.validation.ValidationException
import org.codehaus.groovy.grails.web.json.JSONObject
import org.springframework.http.HttpStatus

class AccountController {

    AccountService accountService

    def show() {
        try {
            if (!params.id) throw new BusinessException("O número do id é obrigatório.")

            Account account = Account.get(params.long("id"))

            if (!account) {
                render(status: HttpStatus.NOT_FOUND, text: "A conta com id ${params.id} não foi encontrada")
                return
            }

            render(status: HttpStatus.OK, contentType: "text/json") {
                ["account_id": account.id,
                 "document_number": account.documentNumber]
            }
        } catch (BusinessException businessException) {
            render(status: HttpStatus.FORBIDDEN, text: businessException.getMessage())
        } catch (Exception exception) {
            render(status: HttpStatus.INTERNAL_SERVER_ERROR, text: exception.getMessage())
        }
    }

    def save() {
        try {
            JSONObject requestJson = request.JSON
            Account account = accountService.save(requestJson."document_number")

            render(status: HttpStatus.CREATED, contentType: "text/json") {
                ["account_id": account.id,
                 "document_number": account.documentNumber]
            }
        } catch (BusinessException businessException) {
            render(status: HttpStatus.FORBIDDEN, text: businessException.getMessage())
        } catch (ValidationException validationException) {
            render(status: HttpStatus.CONFLICT, text: validationException.getMessage())
        } catch (Exception exception) {
            render(status: HttpStatus.INTERNAL_SERVER_ERROR, text: exception.getMessage())
        }
    }
}
