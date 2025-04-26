package com.nga.structura.repository;

import com.nga.structura.model.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {

    Page<Task> findByTaskStatusIdAndAssignedUserIdAndTaskTypeId(Long taskStatusId, Long userId, Long taskTypeId, Pageable pageable);

    Page<Task> findByTaskStatusIdAndAssignedUserId(Long taskStatusId, Long userId, Pageable pageable);

    Page<Task> findByTaskStatusIdAndTaskTypeId(Long taskStatusId, Long taskTypeId, Pageable pageable);

    Page<Task> findByAssignedUserIdAndTaskTypeId(Long userId, Long taskTypeId, Pageable pageable);

    Page<Task> findByTaskStatusId(Long taskStatusId, Pageable pageable);

    Page<Task> findByAssignedUserId(Long userId, Pageable pageable);

    Page<Task> findByTaskTypeId(Long taskTypeId, Pageable pageable);

}