package com.navisharma.TouristManagementAPIGlobalExceptionHandling.rest;

import com.navisharma.TouristManagementAPIGlobalExceptionHandling.exception.TouristNotFoundException;
import com.navisharma.TouristManagementAPIGlobalExceptionHandling.model.Tourist;
import com.navisharma.TouristManagementAPIGlobalExceptionHandling.service.ITouristService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TouristRestApi
{
    @Autowired
    private ITouristService service;

    @PostMapping("/regTourist")
    public ResponseEntity<String> registerTourist(@RequestBody Tourist tourist)
    {
        String response = service.registerTourist(tourist);
        return new ResponseEntity<String>(response, HttpStatus.CREATED);
    }


    @GetMapping("/getTourist/{id}")
    public ResponseEntity<Tourist> getTourist(@PathVariable("id") Integer id)
    {
            Tourist tourist = service.fetchTouristById(id);
            return new ResponseEntity<Tourist>(tourist, HttpStatus.OK);
    }


    @GetMapping("/getalltourist")
    public ResponseEntity<List> getAllTourist()
    {
            List<Tourist> tourists = service.fetchAllTouristInfo();
            return new ResponseEntity<List>(tourists, HttpStatus.OK);
    }


    @PutMapping("/updatetourist")
    public ResponseEntity<String> updateTheTourist(@RequestBody Tourist tourist)
    {
            String status = service.updateTheTouristInfo(tourist);
            return new ResponseEntity<String>(status,HttpStatus.OK);
    }


    @PatchMapping("/updatetouristbudget/{id}/{budget}")
    public ResponseEntity<String> updateTheTouristBudget(@PathVariable("id") Integer id,@PathVariable("budget") Double budget)
    {
            String status =  service.updateTheTouristBudget(id, budget);
            return new ResponseEntity<String>(status,HttpStatus.OK);

    }


    @DeleteMapping("/deletetourist/{id}")
    public ResponseEntity<String> deleteTheTourist(@PathVariable("id") Integer id)
    {
            String status =  service.deleteTouristInfoById(id);
            return new ResponseEntity<String>(status,HttpStatus.OK);

    }
}
