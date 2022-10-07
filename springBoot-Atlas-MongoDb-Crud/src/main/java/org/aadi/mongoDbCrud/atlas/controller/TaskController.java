package org.aadi.mongoDbCrud.atlas.controller;

import lombok.RequiredArgsConstructor;
import org.aadi.mongoDbCrud.atlas.model.Task;
import org.aadi.mongoDbCrud.atlas.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Task createTask(@RequestBody Task task){
        return taskService.createTask(task);
    }

    @GetMapping
    public List<Task> getAllTask(){
        return taskService.getAllTask();
    }

    @GetMapping("/{taskId}")
    public Task getTaskWithId(@PathVariable("taskId") String id){
        return taskService.getTaskWithId(id);
    }

    @GetMapping("/assignee/{assignee}")
    public List<Task> getTaskWithAssignee(@PathVariable("assignee") String assignee){
        return taskService.getTaskWithAssignee(assignee);
    }

    @GetMapping("/story-point/{storyPoint}")
    public  List<Task> getTaskWithOurStoryPoint(@PathVariable("storyPoint") int storyPoint){
        return taskService.getTaskWithOurStoryPoint(storyPoint);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Task updateTask(@RequestBody Task taskRequest){
        return taskService.updateTask(taskRequest);
    }

    @DeleteMapping("/{taskId}")
    @ResponseStatus(HttpStatus.OK)
    //With ResponseStatus as NO_CONTENT(204), we won't able to return any ResponseBody including String.
    public String deleteTask(@PathVariable("taskId") String id){
        return taskService.deleteTask(id);
    }

}