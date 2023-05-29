package com.academia.fikefino.controller;

import com.academia.fikefino.entities.Admin;
import com.academia.fikefino.services.AdminService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/cadastro")
    public ResponseEntity<Admin> save(@RequestBody Admin admin) {
        return ResponseEntity.status(HttpStatus.CREATED).body(adminService.save(admin));
    }

    @GetMapping("/todos-admin")
    public ResponseEntity<List<Admin>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(adminService.findAll());
    }

}
