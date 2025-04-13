package com.springboot.aop.business;

import com.springboot.aop.data.DataService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class BusinessService {
    private DataService dataService;

    BusinessService(DataService dataService){
        this.dataService = dataService;
    }
    public int calculateMax(){
        int[] data = dataService.retrieveData();
       // throw new RuntimeException("Exception Occurred");

        try {
            Thread.sleep(30);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return Arrays.stream(data).max().orElse(0);
    }
}
