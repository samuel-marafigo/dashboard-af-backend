package com.dashboardaf.backend.repository;

import com.dashboardaf.backend.entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

    @Query("SELECT a.id AS id, MAX(a.quantity) AS quantity FROM Attendance a WHERE a.timestamp BETWEEN :startOfDay AND :endOfDay GROUP BY a.id")
    List<Object[]> findMaxQuantitiesForToday(LocalDateTime startOfDay, LocalDateTime endOfDay);
}