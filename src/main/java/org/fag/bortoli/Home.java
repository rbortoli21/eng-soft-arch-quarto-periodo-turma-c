package org.fag.bortoli;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.io.InputStream;

@Path("/home")
public class Home {

    @GET
    @Produces(MediaType.TEXT_HTML)
    public Response hello() {
        // Carrega o arquivo HTML como um InputStream
        InputStream htmlStream = getClass().getClassLoader().getResourceAsStream("META-INF/resources/index.html");

        if (htmlStream != null) {
            // Retorna uma resposta com o arquivo HTML e o tipo de mídia correto
            return Response.ok(htmlStream, MediaType.TEXT_HTML).build();
        } else {
            // Lida com o caso em que o arquivo não pode ser encontrado
            return Response.status(Response.Status.NOT_FOUND).entity("Arquivo HTML não encontrado").build();
        }
    }
}
