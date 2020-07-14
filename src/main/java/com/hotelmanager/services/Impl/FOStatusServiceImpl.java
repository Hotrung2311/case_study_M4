package com.hotelmanager.services.Impl;

import com.hotelmanager.models.room.FOStatus;
import com.hotelmanager.repositories.FOStatusRepository;
import com.hotelmanager.services.intface.FOStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FOStatusServiceImpl implements FOStatusService {

    @Autowired
    private FOStatusRepository foStatusRepository;

    @Override
    public List<FOStatus> findAll() {
        return (List<FOStatus>) foStatusRepository.findAll();
    }

    @Override
    public FOStatus findOne(Long id) {
        return foStatusRepository.findById(id).orElse(null);
    }

    @Override
    public FOStatus save(FOStatus model) {
        return foStatusRepository.save(model);
    }

    @Override
    public FOStatus delete(Long id) {
        FOStatus foStatus = this.findOne(id);
        foStatusRepository.delete(foStatus);
        return foStatus;
    }
}
