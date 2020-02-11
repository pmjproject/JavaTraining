package com.mangalyaallo.allocation.service;

import com.mangalyaallo.allocation.model.Allocation;

import java.util.List;

public interface AllocationService {
    Allocation save(Allocation allocation);

    List<Integer> fetchAllAllocations();

    List<Allocation> getAllocationByEmployeeId(Integer id);
}
