package com.demo.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/*********************************************************************
*
*  ClassName: WorkResult
*  Implementation of the Class: WorkResult
*  Created on:      2022-06-07
*  @author: HieuNT
*
*********************************************************************/
@Entity
@Table(name = "work")
@Data
public class Work {

    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    /**
     * work name
     */
    @Column(name = "work_name")
    private String workName;

    /**
     * start date
     */
    @Column(name = "start_date")
    private String startDate;

    /**
     * end date
     */
    @Column(name = "end_date")
    private String endDate;

    /**
     * status
     */
    @Column(name = "status")
    private String status;

}
