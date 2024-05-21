package com.dashboardaf.backend.dto;

public class RecentAttendanceDTO {
    private Integer id;
    private Double quantity;

    public RecentAttendanceDTO() {}

    public RecentAttendanceDTO(Integer id, Double quantity) {
        this.id = id;
        this.quantity = quantity;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }
}
