package demo

import org.grails.jaxrs.provider.DomainObjectNotFoundException

class PersonResourceService {
    
    def create(Person dto) {
        dto.save()
    }

    def read(def id) {
        def obj = Person.get(id)
        if (!obj) {
            throw new DomainObjectNotFoundException(Person.class, id)
        }
        obj
    }
    
    def readAll() {
        Person.findAll()
    }
    
    def update(Person dto) {
        def obj = Person.get(dto.id)
        if (!obj) {
            throw new DomainObjectNotFoundException(Person.class, dto.id)
        }
        obj.properties = dto.properties 
        obj
    }
    
    void delete(def id) {
        def obj = Person.get(id)
        if (obj) { 
            obj.delete()
        }
    }
    
}

