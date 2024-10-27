package com.spring.task.Controller;

import com.spring.task.Dao.TasksDaoImp;
import com.spring.task.model.Tasks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TasksController {

    @Autowired
    TasksDaoImp tasksDaoImp;

    // Obtener todas las tareas
    @RequestMapping(value = "api/tasks")
    public List<Tasks> GetTasks() {
        return tasksDaoImp.GetTasks();
    }

    // Obtener una unica tarea
    @RequestMapping(value = "api/tasks/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> GetUniqueTasks(@PathVariable Long id) {
        Tasks task = tasksDaoImp.GetUniqueTasks(id);

        if (task != null) {
            return ResponseEntity.ok(task);
        } else {
            return ResponseEntity.status(404).body("Tarea no encontrada");
        }
    }

    // Eliminar una unica tarea
    @RequestMapping(value = "api/tasks/{id}", method = RequestMethod.DELETE)
    public void RemoveTasks(@PathVariable Long id) {
        tasksDaoImp.RemoveTasks(id);
    }

    // Agregar nueba tarea
    @RequestMapping(value = "api/tasks", method = RequestMethod.POST)
    public void NewTasks(@RequestBody Tasks tasks) {
        tasksDaoImp.NewTasks(tasks);
    }

    // Actualizar una tarea
    @RequestMapping(value = "api/tasks/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> UpdateTask(@PathVariable Long id, @RequestBody Tasks updatedTask) {
        Tasks existingTask = tasksDaoImp.GetUniqueTasks(id);  // Busca la tarea existente por ID
        if (existingTask != null) {
            // Actualiza los campos de la tarea existente con los datos de updatedTask
            existingTask.setTitle(updatedTask.getTitle());
            existingTask.setDescription(updatedTask.getDescription());

            tasksDaoImp.UpdateTask(existingTask);  // Guarda la tarea actualizada
            return ResponseEntity.ok("Tarea actualizada con éxito");
        } else {
            return ResponseEntity.status(404).body("Tarea no encontrada");
        }
    }

}
