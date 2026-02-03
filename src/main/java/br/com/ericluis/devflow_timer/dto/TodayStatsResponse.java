package br.com.ericluis.devflow_timer.dto;

public record TodayStatsResponse(
        int totalMinutes,
        int sessions,
        String classification
) {}
