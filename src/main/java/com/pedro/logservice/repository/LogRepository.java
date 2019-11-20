package com.pedro.logservice.repository;

import com.pedro.logservice.model.Log;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface LogRepository extends JpaRepository<Log, Integer> {

    List<Log> findAll();

    Page<Log> findAll(Pageable pageable);

}
