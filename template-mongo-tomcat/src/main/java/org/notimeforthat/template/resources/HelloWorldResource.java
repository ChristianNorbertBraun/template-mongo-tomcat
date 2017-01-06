package org.notimeforthat.template.resources;

import org.bson.types.ObjectId;
import org.notimeforthat.template.models.Entry;
import org.notimeforthat.template.persistence.DaoFactory;
import org.notimeforthat.template.persistence.EntryDao;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 * Created by christianbraun on 06/01/17.
 */
@Path("/")
public class HelloWorldResource {

	@Context
	UriInfo uriInfo;

	private static EntryDao entryDao = DaoFactory.createEntryDao();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response sayHelloWorld() {
		return Response.ok(entryDao.find().asList()).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{entryId}")
	public Response findById(@PathParam("entryId") ObjectId entryId) {
		return Response.ok(entryDao.get(entryId)).build();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(Entry entry) {
		entryDao.save(entry);

		return Response.created(
				uriInfo.getAbsolutePathBuilder().path(
						entry.getId().toString())
						.build())
				.entity(entry)
				.build();
	}
}
