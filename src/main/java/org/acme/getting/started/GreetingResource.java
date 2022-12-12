package org.acme.getting.started;

import org.acme.getting.started.entity.People;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.MediaType.TEXT_PLAIN;

@Path("/hello")
public class GreetingResource {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/{id}")
    @Operation(summary = "Возвращает формы сервиса уведомлений")
    @APIResponse(
            responseCode = "200",
            description = "Возвращает формы сервиса уведомлений",
            content = @Content(
                    mediaType = TEXT_PLAIN,
                    schema = @Schema(implementation = People.class, type = SchemaType.STRING)
            )
    )
    public String greeting(Long id) {
        return "Hello, " + People.findById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    @Operation(summary = "Добавляет нового человека в базу данных")
    @APIResponse(responseCode = "204")
    public void addPeople(People people) {
        People.persist(people);
    }
}