package com.spring.task.Dao;

import com.spring.task.model.Tasks;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class TasksDaoImp implements TasksDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Tasks> GetTasks() {
        String query = "FROM Tasks";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Tasks GetUniqueTasks(Long id) {
        return entityManager.find(Tasks.class, id);
    }

    @Override
    public void RemoveTasks(Long id) {
        Tasks tasks = entityManager.find(Tasks.class, id);
        entityManager.remove(tasks);
    }

    @Override
    public void NewTasks(Tasks tasks) {
        entityManager.merge(tasks);
    }

    @Override
    public void UpdateTask(Tasks tasks) {
        entityManager.merge(tasks);
    }
}
