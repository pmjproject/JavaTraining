package com.mangalyaallo.allocation.controller;


import com.mangalyaallo.allocation.model.Allocation;
import com.mangalyaallo.allocation.service.AllocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Repository
@RequestMapping("/services")
class AllocationController {

    @Autowired
    AllocationService allocationService;

    @RequestMapping(value = "/allocation", method = RequestMethod.POST)
    public Allocation save(@RequestBody Allocation allocation) {

        return allocationService.save(allocation);
    }

    @RequestMapping(value = "/allocation", method = RequestMethod.GET)
    public List<Allocation> findAll() {
        return allocationService.fetchAllAllocations();
    }

    @RequestMapping(value = "allocation/findByEmployeeId/{id}", method = RequestMethod.GET)
    public List<Allocation> getAllocationByEmployeeId(@PathVariable Integer id) {
        return allocationService.getAllocationByEmployeeId(id);
    }





}
