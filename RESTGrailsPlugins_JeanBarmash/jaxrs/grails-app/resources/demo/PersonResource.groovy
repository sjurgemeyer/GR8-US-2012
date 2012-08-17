package demo

import static org.grails.jaxrs.response.Responses.*

import javax.ws.rs.Consumes
import javax.ws.rs.DELETE
import javax.ws.rs.GET
import javax.ws.rs.Produces
import javax.ws.rs.PUT
import javax.ws.rs.core.Response

import org.grails.jaxrs.provider.DomainObjectNotFoundException

@Consumes(['application/xml','application/json'])
@Produces(['application/xml','application/json'])
class PersonResource {
    
    def personResourceService
    def id
    
    @GET
    Response read() {
        ok personResourceService.read(id)
    }
    
    @PUT
    Response update(Person dto) {
        dto.id = id
        ok personResourceService.update(dto)
    }
    
    @DELETE
    void delete() {
        personResourceService.delete(id)
    }
    
}

