package com.demo.dto;

import lombok.Data;

/*********************************************************************
*
*  ClassName: WorkDto
*  Implementation of the Class: WorkDto
*  Created on:      2022-06-07
*  @author: HieuNT
*
*********************************************************************/
@Data
public class WorkDto {

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
