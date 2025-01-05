package com.javweb.service.impl;

import com.javweb.model.BuildingDTO;
import com.javweb.repository.BuildingRepository;
import com.javweb.repository.entity.BuildingEntity;
import com.javweb.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BuildingServiceImpl implements BuildingService {
    @Autowired
    private BuildingRepository buildingRepository;

    @Override
    public List<BuildingDTO> findAll() {
        List<BuildingEntity> buildingEntities = buildingRepository.findAll();
        List<BuildingDTO> result = new ArrayList<>();
        for (BuildingEntity buildingEntity : buildingEntities) {
            BuildingDTO dto = new BuildingDTO();
            dto.setName(buildingEntity.getName());
            dto.setAddress(buildingEntity.getStreet() + " ," + buildingEntity.getWard());
            dto.setNumberOfBasement(buildingEntity.getNumberOfBasement());
            result.add(dto);
        }
    return result;
    }
}
