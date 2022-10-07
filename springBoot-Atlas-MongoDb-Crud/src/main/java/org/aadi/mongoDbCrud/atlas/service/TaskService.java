package org.aadi.mongoDbCrud.atlas.service;

import org.aadi.mongoDbCrud.atlas.model.Task;

import java.util.List;

public interface TaskService {

    Task createTask(Task task);

    List<Task> getAllTask();

    Task getTaskWithId(String id);

    List<Task> getTaskWithAssignee(String assignee);

    List<Task> getTaskWithOurStoryPoint(int storyPoint);

    Task updateTask(Task taskRequest);

    String deleteTask(String id);
}
