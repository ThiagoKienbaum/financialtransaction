package financialtransaction.account

class Account {

    String documentNumber

    BigDecimal availableCreditLimit = 500

    Boolean deleted = false

    Date dateCreated = new Date()

    Date lastUpdated = new Date()

    static constraints = {
        documentNumber unique: true
    }
}
