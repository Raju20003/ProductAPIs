package com.productdto.example.demo.controller;


import com.productdto.example.demo.dto.productdto;
import com.productdto.example.demo.dto.productdto1;
import com.productdto.example.demo.services.productser;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name="Product APIs",description = "Perform POST,GET,PUT,DELETE methods using APIs")
@RestController
@RequestMapping("/product")
public class javacontroller {

    @Autowired
    private productser service;

    @Operation(summary = "Select all data from table",responses = {
            @ApiResponse(responseCode = "200", description = "Return Product details"),
            @ApiResponse(responseCode = "404", description = "Not found")
    })
    @GetMapping("/selectall")
    public ResponseEntity<?> selectall() {
        List<productdto> pro2 = service.selectall();
        if(pro2 != null)
        {
            return new ResponseEntity(pro2,HttpStatus.OK);
        }
        return new ResponseEntity("Data not found!",HttpStatus.NOT_FOUND);
    }


    @Operation(summary = "Select 1 data from table using id",responses = {
            @ApiResponse(responseCode = "200", description = "Return 1 Product detail"),
            @ApiResponse(responseCode = "404", description = "Not found")
    })
    @GetMapping("/select/{id}")
    public ResponseEntity<?> select1(@Valid @Parameter(description = "Enter user Id") @PathVariable int id){
        productdto pro1 = service.select(id);
        if(pro1 !=null)
        {
            return new ResponseEntity(pro1,HttpStatus.OK);
        }
        return new ResponseEntity("Data not found!",HttpStatus.NOT_FOUND);
    }


    @Operation(summary = "Insert data in JSON format in table",responses = {
            @ApiResponse(responseCode = "201", description = "Return Inserted Record"),
            @ApiResponse(responseCode = "400", description = "Record not inserted successfully")
    })
    @PostMapping("/insert")
    public ResponseEntity<?> insert(@Valid @RequestBody productdto1 prodto){
       if(service.insert(prodto)){
           return new ResponseEntity(prodto,HttpStatus.CREATED);
       }
       return new ResponseEntity("Something went wrong!",HttpStatus.BAD_REQUEST);
    }


    @Operation(summary = "Insert many data in table using List object",responses = {
            @ApiResponse(responseCode = "201", description = "Return Inserted Record List"),
            @ApiResponse(responseCode = "400", description = "Record not inserted successfully")
    })
    @PostMapping("/insertall")
    public ResponseEntity<?> insertall(@Valid @RequestBody List<productdto1> prodto){
        if(service.insertall(prodto)){
            return new ResponseEntity(prodto,HttpStatus.CREATED);
        }
        return new ResponseEntity("Something Wrong!",HttpStatus.BAD_REQUEST);
    }


    @Operation(summary = "Update reacord using Id",responses = {
            @ApiResponse(responseCode = "200", description = "Return Updated Record"),
            @ApiResponse(responseCode = "404", description = "Not found")
    })
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updatebyid(@Valid @Parameter(description = "Enter user Id") @PathVariable int id, @RequestBody productdto1 productdto1)
    {
      if(service.updatedata(id,productdto1))
      {
          return new ResponseEntity(productdto1,HttpStatus.OK);
      }
      return new ResponseEntity("Id not found",HttpStatus.NOT_FOUND);
    }


    @Operation(summary = "Delete record using Id",responses = {
            @ApiResponse(responseCode = "204", description = "Return No content"),
            @ApiResponse(responseCode = "404", description = "Not found")
    })
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletebyid(@Valid @Parameter(description = "Enter user Id") @PathVariable int id){
        if(service.delete(id)){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity("Id not found",HttpStatus.NOT_FOUND);
    }


    @Operation(summary = "Delete all record from table",responses = {
            @ApiResponse(responseCode = "204", description = "Return No content"),
            @ApiResponse(responseCode = "404", description = "Not found")
    })
    @DeleteMapping("/deleteall")
    public ResponseEntity<?> deleteall(){
        if(service.deleteall()){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity("No record in database",HttpStatus.NOT_FOUND);
    }

}

