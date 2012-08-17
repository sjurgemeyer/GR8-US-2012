class BootStrap {

    def init = { servletContext ->

        
        demo.Person.findOrSaveWhere(lastName:'Cruise', firstName:'Tom')
    }
    def destroy = {
    }
}
