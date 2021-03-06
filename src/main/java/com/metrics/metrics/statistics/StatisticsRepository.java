package com.metrics.metrics.statistics;

import com.metrics.metrics.metric.MetricValues;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface StatisticsRepository extends JpaRepository<MetricValues, Integer> {

    @Query("SELECT new com.metrics.metrics.statistics.StatisticsSummaryDTO(AVG(value) as average, MIN(value) as min, MAX(value) as max, metrics.name as name)from MetricValues  WHERE metrics.id=:metricId group by metrics.name")
    @Transactional(readOnly = true)
    StatisticsSummaryDTO getMetricStatistics(@Param("metricId") int metricId);

    @Query("SELECT metricValue from MetricValues metricValue WHERE metrics.id=:metricId")
    @Transactional(readOnly = true)
        List<MetricValues> getByMetricId(@Param("metricId") int metricId);

}
