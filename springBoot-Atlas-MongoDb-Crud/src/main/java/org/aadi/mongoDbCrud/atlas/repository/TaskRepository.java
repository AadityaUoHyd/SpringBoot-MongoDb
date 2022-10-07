package org.aadi.mongoDbCrud.atlas.repository;

import org.aadi.mongoDbCrud.atlas.model.Task;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends MongoRepository<Task,String> {

    List<Task> findByAssignee(String assignee);

    @Query("{ StoryPoint : ?0 }")
    List<Task> getTaskByOurStoryPoint(int storyPoint);

}