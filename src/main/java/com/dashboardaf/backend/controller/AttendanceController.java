package com.dashboardaf.backend.controller;

import com.dashboardaf.backend.dto.AttendanceDTO;
import com.dashboardaf.backend.dto.RecentAttendanceDTO;
import com.dashboardaf.backend.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/attendances")
@CrossOrigin(origins = "http://localhost:5173")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @GetMapping("/recent")
    public List<RecentAttendanceDTO> getMaxQuantitiesForToday() {
        return attendanceService.getMaxQuantitiesForToday();
    }
}
