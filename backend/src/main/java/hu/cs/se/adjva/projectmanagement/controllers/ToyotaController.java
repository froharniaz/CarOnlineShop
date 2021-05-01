
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

import hu.cs.se.adjva.projectmanagement.model.Toyota;
import hu.cs.se.adjva.projectmanagement.service.ToyotaService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ToyotaController {
    @Autowired
        private ToyotaService toyotaService;
         @GetMapping("/Toyota/allToyota")
             public ResponseEntity<List<Toyota>> getToyota(){
          
            List<Toyota> toyotas = toyotaService.getAllToyotas();
            return new ResponseEntity<>(toyotas , HttpStatus.OK);

         }
         //save in db
         @PostMapping("/Toyota/add")
         public ResponseEntity<Toyota> addToyota(@RequestBody Toyota toyota){
            Toyota savedToyota= toyotaService.addToyota(toyota);
             return new ResponseEntity<>(savedToyota, HttpStatus.CREATED);
         }

         @GetMapping("/toyota/{id}")
         public ResponseEntity<Toyota> getToyota(@PathVariable("id") Integer id){
           Toyota toyota =  toyotaService.getToyotaById(id);
           return new ResponseEntity<>(toyota,HttpStatus.OK);
     
     }

        @PutMapping("/Toyota/update")
        public ResponseEntity<Toyota> updateToyota(@RequestBody  Toyota toyota){
            Toyota savedToyota = toyotaService.addToyota(toyota);
             return new ResponseEntity<>(savedToyota, HttpStatus.OK);
         }
         @DeleteMapping("/Toyota/{id}/delete")
         public ResponseEntity<String> deleteToyota(@PathVariable("id") Integer id){
            toyotaService.deleteToyotaById(id);
            return new ResponseEntity<>("Toyota" + id + "deleted" , HttpStatus.OK);
         }


}


        

