package it.gdg.controllers;

import it.gdg.models.Todo;
import it.gdg.tools.OfyService;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.googlecode.objectify.Key;
import com.sun.jersey.api.core.InjectParam;
import com.sun.jersey.api.view.Viewable;

// TODO:(:D) Gestione errori
@Path("/todos")
public class TodoController {

	/*
	 * Implementazione dei metodi rest standard
	 */

	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response list() {
		List<Todo> todoList = OfyService.ofy().load().type(Todo.class).list();
		return Response.ok(todoList).build();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response get(@PathParam("id") Long id) {
		Todo todo = OfyService.ofy().load().type(Todo.class).id(id).now();
		if (todo != null) {
			return Response.ok(todo).build();
		} else {
			return Response.status(Status.NOT_FOUND).build();
		}
	}

	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Response add(@InjectParam Todo todo) {
		OfyService.ofy().save().entities(todo).now();
		return Response.status(Status.CREATED).entity(todo).build();
	}

	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addFromJsonds(Todo todo) {
		return this.add(todo);
	}

	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response update(List<Todo> todos) {
		OfyService.ofy().save().entities(todos).now();
		return Response.ok().entity(todos).build();
	}

	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Response update(@InjectParam Todo todo, @PathParam("id") long id) {
		todo.setId(id);
		return this.add(todo);
	}

	@DELETE
	@Path("/")
	public Response deleteAll() {
		List<Key<Todo>> keys = OfyService.ofy().load().type(Todo.class).keys().list();
		OfyService.ofy().delete().keys(keys).now();
		return Response.ok().build();
	}

	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam("id") Long id) {
		OfyService.ofy().delete().type(Todo.class).id(id).now();
		return Response.ok().build();
	}

	/*
	 * Implementazione di metodi per utilità
	 */

	@PUT
	@Path("/setcompleted/{id}/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Response setCompleted(@PathParam("id") Long id, @FormParam("completed") boolean completed) {
		Todo todo = OfyService.ofy().load().type(Todo.class).id(id).now();
		if (todo != null) {
			todo.setCompleted(completed);
			OfyService.ofy().save().entities(todo).now();
			return Response.ok().entity(todo).build();
		} else {
			return Response.status(Status.NOT_FOUND).build();
		}
	}

	/*
	 * Metodo per una vista
	 */
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public Response listView() {
		List<Todo> todoList = OfyService.ofy().load().type(Todo.class).list();
		return Response.ok(new Viewable("/todos.jsp", todoList)).build();
	}
}
