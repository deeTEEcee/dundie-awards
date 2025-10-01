package com.ninjaone.dundie_awards.controller;

import com.ninjaone.dundie_awards.model.Activity;
import com.ninjaone.dundie_awards.model.DundieAward;
import com.ninjaone.dundie_awards.repository.DundieAwardRepository;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.ninjaone.dundie_awards.model.Employee;
import com.ninjaone.dundie_awards.repository.ActivityRepository;
import com.ninjaone.dundie_awards.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("dundie_awards")
public class DundieAwardController {

  @Autowired
  private DundieAwardRepository awardRepository;


  // get all employees
  @GetMapping("")
  @ResponseBody
  public List<DundieAward> getAllDundieAwards() {
    return awardRepository.findAll();
  }

  // create employee rest api
  @PostMapping("")
  @ResponseBody
  public DundieAward createDundieAward(@RequestBody DundieAward award) {
    return awardRepository.save(award);
  }

  // update employee rest api
//  @PutMapping("/{id}")
//  @ResponseBody
//  public ResponseEntity<DundieAward> updateDundieAward(@PathVariable Long id,
//      @RequestBody DundieAward awardDetails) {
//    Optional<DundieAward> optionalDundieAward = awardRepository.findById(id);
//    if (!optionalDundieAward.isPresent()) {
//      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
//
//    DundieAward award = optionalDundieAward.get();
//    if (awardDetails.getName() != null) {
//      awardDetails.setName(awardDetails.getName());
//    }
//    if (awardDetails.getDescription() != null) {
//      awardDetails.setDescription(awardDetails.getDescription());
//    }
//    Employee updatedEmployee = employeeRepository.save(employee);
//    return ResponseEntity.ok(updatedEmployee);
//  }
}
