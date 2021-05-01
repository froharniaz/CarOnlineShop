package hu.cs.se.adjva.projectmanagement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hu.cs.se.adjva.projectmanagement.model.Jeep;
import hu.cs.se.adjva.projectmanagement.service.JeepService;

/**
 * Jeepcontrollers
 */
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class JeepController {

    @Autowired
    private JeepService jeepService;
   
    @GetMapping("/jeep/allJeep")
    public ResponseEntity<List<Jeep>> getAllJeep(){
        
        List<Jeep> jeeps = jeepService.getAllJeeps();
        return new ResponseEntity<>(jeeps, HttpStatus.OK);
    }

    @PostMapping("/Jeep/add")
    public ResponseEntity<Jeep> addJeep(@RequestBody Jeep jeep) {
        Jeep savedJeep = jeepService.addJeeps(jeep);

        return new ResponseEntity<>(savedJeep, HttpStatus.CREATED);
    }

    @GetMapping("/Jeep/{id}")
    public ResponseEntity<Jeep> getJeep(@PathVariable("id") Integer id) {
        Jeep jeep =  jeepService.getJeepById(id);

       return new ResponseEntity<>(jeep, HttpStatus.OK);
    }

    @PutMapping("/Jeep/update")
    public ResponseEntity<Jeep> updateJeep(@RequestBody Jeep Jeep) {
        Jeep savedJeep = jeepService.addJeeps(Jeep);

        return new ResponseEntity<>(savedJeep, HttpStatus.OK);
    }

    @DeleteMapping("/Jeep/{id}/delete")
    public ResponseEntity<String> deleteJeep(@PathVariable("id") Integer id){
        jeepService.deleteJeepById(id);

        return new ResponseEntity<>("Jeep" + id + "deleted", HttpStatus.OK);
    }

}