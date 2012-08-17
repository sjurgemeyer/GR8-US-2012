import org.grails.plugins.rest.*
import grails.converters.*  

class BootStrap {

    def init = { servletContext ->

      def person = new Person(firstName:"Tom", lastName:"Cruise")
        person.save(flush:true)
        //System.out.println "Person $person"


        def phone1 = new Phone(person:person, phoneType:"Business", phoneNumber:"646-555-5555")
        phone1.save(flush:true)
        //System.out.println "Phone1 $phone1"

        def phone2 = new Phone(person:person, phoneType:"Mobile", phoneNumber:"646-666-555")
        phone2.save(flush:true)
        //System.out.println "Phone2 $phone2"

        person.addToPhones(phone1)
        person.save(flush:true)

        person.addToPhones(phone2)
        person.save(flush:true)

        new Person(firstName:"Brad", lastName:"Pitt").save(flush:true)
        new Person(firstName:"Clint", lastName:"Eastwood").save(flush:true)
        new Person(firstName:"Jon", lastName:"Turturo").save(flush:true)
        new Person(firstName:"Jason", lastName:"Bateman").save(flush:true)


        /*

JSON.registerObjectMarshaller(Phone) {
        return [street:'Default Phone']
}
*/


JSON.registerObjectMarshaller(Person) {
        return [name:'Default person']
}


JSON.createNamedConfig('summary') { namedConfig ->
  namedConfig.registerObjectMarshaller(Phone) {
        return [street:'Phone Summary']
  }
}
       

/*
JSON.createNamedConfig('summary') { namedConfig ->
  namedConfig.registerObjectMarshaller(Person) { p ->
        return [name:p.firstName, type: 'Summary', 
               phones: JSON.use('summary') { p.phones as JSON }.toString()
            ]
  }

}
*/


JSON.createNamedConfig('detail') { namedConfig ->
  namedConfig.registerObjectMarshaller(Person) {
        return [first:it.firstName,
                last:it.lastName, 
                phones: it.phones]
  }
}
        

    }
    def destroy = {
    }
}
