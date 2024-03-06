package org.example.service;

import org.example.Models.Task;
import org.example.exception.RecordNotFoundException;
import org.example.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    //Logica para buscar una tarea
    public Task getTaskById(int id) {
        Optional<Task> task = taskRepository.findById(id);
        if (task.isPresent()) {
            return task.get();
        } else {
            throw new RecordNotFoundException("No task found with id: " + id);
        }
    }

    //Logica para crear o actualizar una tarea
    public Task createOrUpdateTask(Task task) {
        Task result;
        if (task.getId() != 0) {
            Optional<Task> resultOptional = taskRepository.findById(task.getId());
            if (resultOptional.isPresent()) {
                Task fromDB = resultOptional.get();
                fromDB.setName(task.getName());
                fromDB.setDescription(task.getDescription());
                fromDB.setCompleted(task.isCompleted());
                fromDB.setApartmentId(task.getApartmentId());
                fromDB.setUserId(task.getUserId());
                result = taskRepository.save(fromDB);
            } else {
                throw new RecordNotFoundException("No task found with id: " + task.getId());
            }
        } else {  //insert
            result = taskRepository.save(task);
        }
        return result;
    }



   //Logica para borrar una tarea
   public void deleteTask(int id){
       Optional<Task> resultOptional = taskRepository.findById(id);
       if(resultOptional.isPresent()){
           taskRepository.deleteById(id);
       }else{
           throw new RecordNotFoundException("No task found with id: " + id);
       }
   }

   //Devuelve todas las tareas de un apartamento
   public List<Task> getTasksByApartmentId(int id){
       return taskRepository.getTasksByApartmentId(id);
   }

   //Devuelve todas las tareas de un usuario por id
   public List<Task> getTasksByUserId(int id){
       return taskRepository.getTasksByUserId(id);
   }

   //Devuelve todas las tareas de un apartamento y un usuario
   public List<Task> getTasksByApartmentIdAndUserId(int id1, int id2){
       return taskRepository.getTasksByApartmentIdAndUserId(id1, id2);
   }

   //Devuelve todas las tareas de un usuario por nombre
   public List<Task> getTasksByUserName(String name){
       return taskRepository.getTasksByUserName(name);
   }
}