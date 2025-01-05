package com.javweb.repository;

import com.javweb.repository.entity.BuildingEntity;

import java.util.List;

public interface BuildingRepository {
    List<BuildingEntity> findAll();
}
