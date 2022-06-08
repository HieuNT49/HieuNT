package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.model.entity.Work;

/*********************************************************************
*
*  ClassName: WorkRepository
*  Implementation of the Class: WorkRepository
*  Created on:      2022-06-07
*  @author: HieuNT
*
*********************************************************************/
@Repository
public interface WorkRepository extends JpaRepository<Work, Integer> {

}
