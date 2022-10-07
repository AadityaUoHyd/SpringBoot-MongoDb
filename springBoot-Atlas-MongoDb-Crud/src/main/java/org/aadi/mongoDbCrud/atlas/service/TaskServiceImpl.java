package org.aadi.mongoDbCrud.atlas.service;

import lombok.RequiredArgsConstructor;
import org.aadi.mongoDbCrud.atlas.model.Task;
import org.aadi.mongoDbCrud.atlas.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService{

    private final TaskRepository taskRepository;

    @Override
    public Task createTask(Task task) {
        task.setTaskId(UUID.randomUUID().toString().split("-")[0]);
        return taskRepository.save(task);
    }

    @Override
    public List<Task> getAllTask() {
        return taskRepository.findAll();
    }

    @Override
    public Task getTaskWithId(String id) {
        return taskRepository.findById(id).get();
    }

    @Override
    public List<Task> getTaskWithAssignee(String assignee) {
        return taskRepository.findByAssignee(assignee);
    }

    @Override
    public List<Task> getTaskWithOurStoryPoint(int storyPoint) {
        return taskRepository.getTaskByOurStoryPoint(storyPoint);
    }

    @Override
    public Task updateTask(Task taskRequest) {
        //get erstwhile saved document from DB with same id,then set the new value from requestTask to the existing one.
        Task erstWhileSavedTask = taskRepository.findById(taskRequest.getTaskId()).get();
        erstWhileSavedTask.setTaskName(taskRequest.getTaskName());
        erstWhileSavedTask.setDescription(taskRequest.getDescription());
        erstWhileSavedTask.setSeverity(taskRequest.getSeverity());
        erstWhileSavedTask.setAssignee(taskRequest.getAssignee());
        erstWhileSavedTask.setStoryPoint(taskRequest.getStoryPoint());
        return taskRepository.save(erstWhileSavedTask);
    }

    @Override
    public String deleteTask(String id) {
        taskRepository.deleteById(id);
        return ("The task with id = "+ id +", got successfully deleted.");
    }

}