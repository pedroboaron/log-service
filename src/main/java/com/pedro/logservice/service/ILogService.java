package com.pedro.logservice.service;

import com.pedro.logservice.model.Log;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ILogService {

    List<Log> findAll();

    Page<Log> findAll(Pageable pageable);

    Log save(Log log);

    Log update(Integer id, Log log) throws Exception;

}
