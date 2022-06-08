package com.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.constant.Constants;
import com.demo.dto.WorkDto;
import com.demo.model.entity.Work;
import com.demo.service.WorkService;

/*********************************************************************
*
*  ClassName: WorkController
*  Implementation of the Class: Work Controller
*  Created on:      2022-06-07
*  @author: HieuNT
*
*********************************************************************/
@RestController
@RequestMapping("api/works")
public class WorkController {

    /**
     * work service
     */
    @Autowired
    private WorkService workService;

    /**
     * get all works REST API
     * @param page: index of page
     * @param sortBy: item sort
     * @return list works
     */
    @GetMapping("/getWorksList")
    public Page<Work> getWorksList(@RequestParam Optional<Integer> page, @RequestParam Optional<String> sortBy) {
        
        // get all works
        Page<Work> worksList = workService.getWorksList(page, sortBy);
        return worksList;
    }

    /**
     * add new work REST API
     * @param workDto: detail of work
     * @return
     */
    @PostMapping("/addWork")
    public ResponseEntity<Work> addWork(@RequestBody WorkDto workDto) {
        return new ResponseEntity<Work>(workService.addWork(workDto), HttpStatus.CREATED);
    }

    /**
     * edit work REST API
     * @param id: id of work
     * @param workDto: detail of work need for update
     * @return
     */
    @PutMapping("/editWork/{id}")
    public ResponseEntity<Work> editWork(@PathVariable("id") int id, @RequestBody WorkDto workDto) {
        
        // edit 
        return new ResponseEntity<Work>(workService.editWork(workDto, id), HttpStatus.OK);
    }

    /**
     * delete work REST API
     * @param id: id of work
     * @return
     */
    @DeleteMapping("deleteWork/{id}")
    public ResponseEntity<String> deleteWork(@PathVariable("id") int id) {

        // delete work from Database
        workService.deleteWork(id);

        return new ResponseEntity<String>(Constants.SUCCESS_MMSG, HttpStatus.OK);
    }

}
