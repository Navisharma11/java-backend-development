package com.navisharma.TouristManagementAPI.rest;

import com.navisharma.TouristManagementAPI.exception.TouristNotFoundException;
import com.navisharma.TouristManagementAPI.model.Tourist;
import com.navisharma.TouristManagementAPI.service.ITouristService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@Scope("request")
@Scope("session")
public class TouristRestApi
{
    @Autowired
    private ITouristService service;

    public TouristRestApi()
    {
        System.out.println("TouristRestApi Bean Created");
    }

    @PostMapping("/regTourist")
    public ResponseEntity<String> registerTourist(@RequestBody Tourist tourist)
    {
        String response = service.registerTourist(tourist);
        return new ResponseEntity<String>(response, HttpStatus.CREATED);
    }


    @GetMapping("/getTourist/{id}")
    public ResponseEntity<?> getTourist(@PathVariable("id") Integer id)
    {
        try
        {
            Tourist tourist = service.fetchTouristById(id);
            return new ResponseEntity<Tourist>(tourist, HttpStatus.OK);
        }
        catch(TouristNotFoundException e)
        {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/getalltourist")
    public ResponseEntity<?> getAllTourist()
    {
        try
        {
            List<Tourist> tourists = service.fetchAllTouristInfo();
            return new ResponseEntity<List>(tourists, HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity<String>("Some problem in fetch", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping("/updatetourist")
    public ResponseEntity<String> updateTheTourist(@RequestBody Tourist tourist)
    {
        try
        {
            String status = service.updateTheTouristInfo(tourist);
            return new ResponseEntity<String>(status,HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


    @PatchMapping("/updatetouristbudget/{id}/{budget}")
    public ResponseEntity<String> updateTheTouristBudget(@PathVariable("id") Integer id,@PathVariable("budget") Double budget)
    {
        try
        {
            String status =  service.updateTheTouristBudget(id, budget);
            return new ResponseEntity<String>(status,HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


    @DeleteMapping("/deletetourist/{id}")
    public ResponseEntity<String> deleteTheTourist(@PathVariable("id") Integer id)
    {
        try
        {
            String status =  service.deleteTouristInfoById(id);
            return new ResponseEntity<String>(status,HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


}
