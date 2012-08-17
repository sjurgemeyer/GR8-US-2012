package demo

import static org.grails.jaxrs.response.Responses.*

import javax.ws.rs.Consumes
import javax.ws.rs.GET
import javax.ws.rs.Produces
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.POST
import javax.ws.rs.core.Response

@Path('/api/person')
@Consumes(['application/xml','application/json'])
@Produces(['application/xml','application/json'])
class PersonCollectionResource {

    def personResourceService
    
    @POST
    Response create(Person dto) {
        created personResourceService.create(dto)
    }

    @GET
    Response readAll() {
        ok personResourceService.readAll()
    }
    
    @Path('/{id}')
    PersonResource getResource(@PathParam('id') Long id) {
        new PersonResource(personResourceService: personResourceService, id:id)
    }
        
}
