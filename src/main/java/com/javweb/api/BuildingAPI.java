package com.javweb.api;

import com.javweb.model.BuildingDTO;
import com.javweb.customException.FieldRequiredException;
import com.javweb.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller
@RestController
public class BuildingAPI {
    @Autowired
    private BuildingService buildingService;

    @GetMapping(value="/api/building/")
    public List<BuildingDTO> getBuildings() {
        List<BuildingDTO> results = buildingService.findAll();
        return results;
    }

//    @GetMapping(value="/api/building/")
//    public List<BuildingDTO> getBuilding(@RequestParam String name) {
//        List<BuildingDTO> buildings = new ArrayList<>();
//        String sql = "select * from building where name like '%" + name + "%'";
//        try(Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery(sql)) {
//            while (resultSet.next()) {
//                BuildingDTO buildingDTO = new BuildingDTO();
//                buildingDTO.setName(resultSet.getString("name"));
//                buildingDTO.setStreet(resultSet.getString("street"));
//                buildingDTO.setWard(resultSet.getString("ward"));
//                buildingDTO.setNumberOfBasement(resultSet.getInt("numberofbasement"));
//                buildings.add(buildingDTO);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//            System.out.println("Connection database failed!");
//        }
//        return buildings;
//    }

    public void valiDate(BuildingDTO buildingDTO) {
        if(buildingDTO.getName() == null || buildingDTO.getName().equals("") || buildingDTO.getNumberOfBasement() == null) {
            throw new FieldRequiredException("name or numberofbasement is null!");
        }
    }

//    @RequestMapping(value = "/api/building/", method = RequestMethod.POST)
//    public void postBuiding(@RequestParam Map<String, String> params) {
//        System.out.println("ok");
//    }

//    @RequestMapping(value = "/api/building/", method = RequestMethod.POST)
//    public void postBuilding(@RequestBody BuildingDTO buildingDTO) {
//        System.out.println("ok");
//    }

//    @DeleteMapping(value = "/api/building/{id}")
//    public void deleteBuilding(@PathVariable Integer id) {
//        System.out.println("delete data with " + id + " success!");
//    }
}
