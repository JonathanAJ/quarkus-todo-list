package br.example.quarkus

import br.example.quarkus.model.TodoItem
import java.lang.Exception
import java.util.UUID
import javax.ws.rs.DELETE
import javax.ws.rs.GET
import javax.ws.rs.POST
import javax.ws.rs.PUT
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/todo")
class TodoResource {

    private var todoList = ArrayList<TodoItem>();

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    fun listTodoItem() = todoList;

    @POST
    @Path("/create")
    fun createTodoItem(todoItem: TodoItem): TodoItem {
        todoItem.id = UUID.randomUUID().toString();
        todoList.add(todoItem)
        return todoItem
    }

    @DELETE
    @Path("/remove/{id}")
    fun removeTodoItem(id: String) =
        todoList.removeIf { it.id == id }

    @PUT
    @Path("/update")
    fun updateTodoItem(todoItem: TodoItem): TodoItem {
        var index: Int = todoList.indexOfFirst { it.id == todoItem.id }
        if (index == -1) throw Exception("TodoItem não encontrado!")
        todoList[index] = todoItem
        return todoItem
    }
}