package com.spring.task.Dao;

import com.spring.task.model.Tasks;

import java.util.List;

public interface TasksDao {
    List<Tasks> GetTasks();

    Tasks GetUniqueTasks(Long id);

    void RemoveTasks(Long id);

    void NewTasks(Tasks tasks);

    void UpdateTask(Tasks tasks);
}
