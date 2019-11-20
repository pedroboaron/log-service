package com.pedro.logservice.service;

import com.pedro.logservice.model.Log;
import com.pedro.logservice.repository.LogRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class LogService implements ILogService {

    @Autowired
    private LogRepository logRepository;

    @Override
    public List<Log> findAll() {
        return logRepository.findAll();
    }

    @Override
    public Page<Log> findAll(Pageable pageable) {
        return logRepository.findAll(pageable);
    }


    @Override
    public Log save(Log log) {
        return logRepository.save(log);
    }

    @Transactional
    @Override
    public Log update(Integer id, Log log) throws Exception {
       Optional<Log> retorno = this.logRepository.findById(id);

        if (!retorno.isPresent()) {
            throw new Exception("Log não existe no banco de dados" + id);
        }

        BeanUtils.copyProperties(retorno, log, "id");

        return logRepository.save(log);
    }
}
