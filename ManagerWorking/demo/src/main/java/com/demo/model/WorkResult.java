package com.demo.model;

import lombok.Data;

/*********************************************************************
*
*  ClassName: WorkResult
*  Implementation of the Class: WorkResult
*  Created on:      2022-06-07
*  @author: HieuNT
*
*********************************************************************/
@Data
public class WorkResult {

    /**
     * id
     */
    private int id;

    /**
     * work name
     */
    private String workName;

    /**
     * start date
     */
    private String startDate;

    /**
     * end date
     */
    private String endDate;

    /**
     * status
     */
    private String status;
}
