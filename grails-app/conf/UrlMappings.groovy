class UrlMappings {

	static mappings = {
        "/api/account/$id?" {
            controller = "account"
            action = [GET:"show", POST:"save", PUT:"updateAvailableCreditLimit", DELETE:"delete"]
            format = "json"
        }

        "/api/transaction/$id?" {
            controller = "transaction"
            action = [GET:"show", POST:"save", PUT:"update", DELETE:"delete"]
            format = "json"
        }

        "/"(controller: 'application', action:'index')
        "500"(view: '/error')
        "404"(view: '/notFound')
	}
}
