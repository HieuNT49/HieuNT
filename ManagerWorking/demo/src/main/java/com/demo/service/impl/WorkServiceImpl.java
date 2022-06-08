package com.demo.service.impl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.demo.constant.Constants;
import com.demo.dto.WorkDto;
import com.demo.exception.ResourceNotFoundException;
import com.demo.model.entity.Work;
import com.demo.repository.WorkRepository;
import com.demo.service.WorkService;

/*********************************************************************
*
*  ClassName: WorkServiceImpl
*  Implementation of the Class: Add, Edit, Delete Work
*  Created on:      2022-06-07
*  @author: HieuNT
*
*********************************************************************/
@Service
public class WorkServiceImpl implements WorkService {

    /**
     * WorkRepository
     */
    private WorkRepository workRepository;

    public WorkServiceImpl(WorkRepository workRepository) {
        super();
        this.workRepository = workRepository;
    }

    /**
     * get all works logic
     * 
     * @param page:   index of page
     * @param sortBy: item sort
     * @return list works
     */
    @Override
    public Page<Work> getWorksList(Optional<Integer> page, Optional<String> sortBy) {

        // Get all work
        Page<Work> worksListResult = workRepository
                .findAll(PageRequest.of(page.orElse(0), 5, Sort.Direction.ASC, sortBy.orElse(Constants.ID)));

        return worksListResult;
    }

    /**
     * add new work logic
     * 
     * @param workDto: detail of work
     * @return
     */
    @Override
    public Work addWork(WorkDto workdto) {

        // init entity work
        Work work = new Work();
        BeanUtils.copyProperties(workdto, work);

        // add new work
        return workRepository.save(work);
    }

    /**
     * edit work logic
     * 
     * @param id: id of work
     * @param workDto: detail of work need for update
     * @return
     */
    @Override
    public Work editWork(WorkDto workDto, int id) {

        // Check work is existing in Database or not
        Work existingWork = workRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Constants.WORK, Constants.ID, id));

        // setting data
        existingWork.setWorkName(workDto.getWorkName());
        existingWork.setStartDate(workDto.getStartDate());
        existingWork.setEndDate(workDto.getEndDate());
        existingWork.setStatus(workDto.getStatus());

        // save existing work to Database
        workRepository.save(existingWork);
        return existingWork;
    }

    /**
     * delete work logic
     * 
     * @param id: id of work
     * @return
     */
    @Override
    public void deleteWork(int id) {

        // check work exist in a Database or not
        workRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(Constants.WORK, Constants.ID, id));

        // delete work
        workRepository.deleteById(id);

    }
}
