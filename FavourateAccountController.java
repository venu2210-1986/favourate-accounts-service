package com.hcl.account.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.account.exception.RecordNotFoundException;
import com.hcl.account.model.FavourateAccountsEntity;
import com.hcl.account.service.FavourateAccount;
 
@RestController
@RequestMapping("/fapaccounts")
public class FavourateAccountController
{
    @Autowired
    FavourateAccount service;
 
    @GetMapping
    public ResponseEntity<List<FavourateAccountsEntity>> getAllEmployees() {
        List<FavourateAccountsEntity> list = service.getAllEmployees();
 
        return new ResponseEntity<List<FavourateAccountsEntity>>(list, new HttpHeaders(), HttpStatus.OK);
    }
 
    @GetMapping("/{id}")
    public ResponseEntity<FavourateAccountsEntity> getEmployeeById(@PathVariable("id") Long id)
                                                    throws RecordNotFoundException {
    	FavourateAccountsEntity entity = service.getEmployeeById(id);
 
        return new ResponseEntity<FavourateAccountsEntity>(entity, new HttpHeaders(), HttpStatus.OK);
    }
 
    @PostMapping
    public ResponseEntity<FavourateAccountsEntity> createOrUpdateEmployee(FavourateAccountsEntity employee)
                                                    throws RecordNotFoundException {
    	FavourateAccountsEntity updated = service.createOrUpdateEmployee(employee);
        return new ResponseEntity<FavourateAccountsEntity>(updated, new HttpHeaders(), HttpStatus.OK);
    }
 
    @DeleteMapping("/{id}")
    public HttpStatus deleteEmployeeById(@PathVariable("id") Long id)
                                                    throws RecordNotFoundException {
        service.deleteEmployeeById(id);
        return HttpStatus.FORBIDDEN;
    }
 
}