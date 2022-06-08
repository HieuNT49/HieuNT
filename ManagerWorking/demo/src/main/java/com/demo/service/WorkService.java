package com.demo.service;

import java.util.Optional;

import org.springframework.data.domain.Page;

import com.demo.dto.WorkDto;
import com.demo.model.entity.Work;

/*********************************************************************
*
*  ClassName: WorkService
*  Implementation of the Class: Add, Edit, Delete Work
*  Created on:      2022-06-07
*  @author: HieuNT
*
*********************************************************************/
public interface WorkService {

    Page<Work> getWorksList( Optional<Integer> page, Optional<String> sortBy);

    Work addWork(WorkDto work);

    Work editWork(WorkDto work, int id);

    void deleteWork(int id);

}
