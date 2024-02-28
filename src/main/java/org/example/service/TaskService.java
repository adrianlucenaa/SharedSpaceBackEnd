package org.example.service;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

   public List<Task> getAllTasks(){
       return taskRepository.findAll();
   }

    //Logica para buscar una tarea
   public Task getTaskById(int id){
       Optional<Task> task = taskRepository.findById(id);
       if(task.isPresent()){
           return task.get();
       }else{
           throw new RecordNotFoundException("No task found with id: " + id);
       }
   }

   //Logica para crear o actualizar una tarea
   public Task createOrUpdateTask(Task task){
       Task result;
       if(task.getId() > 0){
           Optional<Task> resultOptional = taskRepository.findById(task.getId());
           if(resultOptional.isPresent()){
               Task fromDB = resultOptional.get();
               fromDB.setApartment(task.getApartment());
               fromDB.setUser(task.getUser());
               fromDB.setName(task.getName());
               fromDB.setDescription(task.getDescription());
               fromDB.setCompleted(task.isCompleted());
               result = taskRepository.save(fromDB);
           }else{
               throw new RecordNotFoundException("No task found with id: " + task.getId());
           }
       }
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

   //Devuelve todas las tareas de un usuario
   public List<Task> getTasksByUserId(int id){
       return taskRepository.getTasksByUserId(id);
   }

   //Devuelve todas las tareas de un apartamento y un usuario
   public List<Task> getTasksByApartmentIdAndUserId(int id1, int id2){
       return taskRepository.getTasksByApartmentIdAndUserId(id1, id2);
   }
}