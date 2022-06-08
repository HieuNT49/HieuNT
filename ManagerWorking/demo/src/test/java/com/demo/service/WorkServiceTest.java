package com.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.dto.WorkDto;
import com.demo.exception.ResourceNotFoundException;
import com.demo.model.entity.Work;
import com.demo.repository.WorkRepository;
import com.demo.service.impl.WorkServiceImpl;

/*********************************************************************
*
*  ClassName: WorkServiceTest
*  Implementation of the Class: Testing for work service
*  Created on:      2022-06-07
*  @author: HieuNT
*
*********************************************************************/
@SpringBootTest(properties = "spring.main.allow-bean-definition-overriding=true")
@ContextConfiguration(classes = { WorkServiceTest.TestConfig.class })
@RunWith(SpringRunner.class)
public class WorkServiceTest {

    /**
     * config Bean
     */
    @TestConfiguration
    public static class TestConfig {
        @Bean
        public WorkService workService(final WorkRepository workRepository) {
            return new WorkServiceImpl(workRepository);
        }

        @Bean
        public WorkRepository workRepository() {
            return mock(WorkRepository.class);
        }
    }

    /**
     * work Service
     */
    @Autowired
    private WorkService workService;

    /**
     * work Repository
     */
    @Autowired
    private WorkRepository workRepository;

    /**
     * Select list work success
     */
    @Test
    public void testGetWorksList_001() {

        //expect value
        boolean expect = true;
        Optional<Integer> page = Optional.of(5);
        Optional<String> sortBy = Optional.of("status");
        Page<Work> expWorksListResult = null;
//        Mockito.when(workRepository
//                .findAll(PageRequest.of(page.orElse(0), 5, Sort.Direction.ASC, sortBy.orElse(Constants.ID))))
//                .thenReturn(null);
        try {
            Page<Work> actual = workService.getWorksList(page, sortBy);
        } catch (Exception exception) {
            expect = false;
        }

        assertEquals(true, expect);

    }

    /**
     * Add work success
     */
    @Test
    public void testAddWork_001() {

        // input data
        WorkDto expWorkDto = new WorkDto();
        expWorkDto.setStartDate("2022-01-05");
        expWorkDto.setEndDate("2022-02-05");
        expWorkDto.setWorkName("testing HR001");
        expWorkDto.setStatus("Done");

        // actual data
        Work actualWork = workService.addWork(expWorkDto);
        
        assertEquals(expWorkDto.getStartDate(), actualWork.getStartDate());
        assertEquals(expWorkDto.getEndDate(), actualWork.getEndDate());
        assertEquals(expWorkDto.getWorkName(), actualWork.getWorkName());
        assertEquals(expWorkDto.getStatus(), actualWork.getStatus());

    }

    /**
     * edit work success
     */
    @Test
    public void testEditWork_001() {

        // input data
        WorkDto expWorkDto = new WorkDto();
        expWorkDto.setStartDate("2022-01-05");
        expWorkDto.setEndDate("2022-02-05");
        expWorkDto.setWorkName("testing HR001");
        expWorkDto.setStatus("Done");

        int id = 7;

        // actual data
        Work actualWork = workService.editWork(expWorkDto, id);

        assertEquals(expWorkDto.getStartDate(), actualWork.getStartDate());
        assertEquals(expWorkDto.getEndDate(), actualWork.getEndDate());
        assertEquals(expWorkDto.getWorkName(), actualWork.getWorkName());
        assertEquals(expWorkDto.getStatus(), actualWork.getStatus());
    }

    /**
     * Exception when edit work
     */
    @Test
    public void testEditWork_002() {
        
        //expect value
        boolean expect = false;

        // input data
        WorkDto expWorkDto = new WorkDto();
        expWorkDto.setStartDate("2022-01-05");
        expWorkDto.setEndDate("2022-02-05");
        expWorkDto.setWorkName("testing HR001");
        expWorkDto.setStatus("Done");

        int id = 1000;

        try {
            Work actualWork = workService.editWork(expWorkDto, id);
        } catch (ResourceNotFoundException exception) {
            expect = true;
        }

        assertEquals(true, expect);
    }

    /**
     * Delete work success
     */
    @Test
    public void testDeleteWork_001() {

        //expect value
        boolean expect = true;

        // input data
        int id = 10;

        try {
            workService.deleteWork(id);
        } catch (Exception exception) {
            expect = false;
        }

        assertEquals(true, expect);
    }

    /**
     * Exception when delete work
     */
    @Test
    public void testDeleteWork_002() {

        //expect value
        boolean expect = false;

        // input data
        int id = 10;

        try {
            workService.deleteWork(id);
        } catch (ResourceNotFoundException exception) {
            expect = true;
        }

        assertEquals(true, expect);
    }
}
