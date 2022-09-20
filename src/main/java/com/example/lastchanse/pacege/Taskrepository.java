package com.example.lastchanse.pacege;

import com.example.lastchanse.models.Task;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface Taskrepository extends CrudRepository<Task,Long> {

    public List<Task> findByCourses1_id(Long id);

}
