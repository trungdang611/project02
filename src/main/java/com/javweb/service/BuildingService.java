package com.javweb.service;

import com.javweb.model.BuildingDTO;
import java.util.List;

public interface BuildingService {
    List<BuildingDTO> findAll();
}
