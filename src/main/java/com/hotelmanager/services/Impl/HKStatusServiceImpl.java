package com.hotelmanager.services.Impl;

import com.hotelmanager.models.room.HKStatus;
import com.hotelmanager.repositories.HKStatusRepository;
import com.hotelmanager.services.intface.HKStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HKStatusServiceImpl implements HKStatusService {
    @Autowired
    private HKStatusRepository hkStatusRepository;

    @Override
    public List<HKStatus> findAll() {
        return (List<HKStatus>) hkStatusRepository.findAll();
    }

    @Override
    public HKStatus findOne(Long id) {
        return hkStatusRepository.findById(id).orElse(null);
    }

    @Override
    public HKStatus save(HKStatus model) {
        return hkStatusRepository.save(model);
    }

    @Override
    public HKStatus delete(Long id) {
        HKStatus hkStatus = this.findOne(id);
        hkStatusRepository.delete(hkStatus);
        return hkStatus;
    }
}
