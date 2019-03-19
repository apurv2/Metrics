package com.metrics.metrics.metric;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MetricRepository extends JpaRepository<Metric, Integer> {

    Metric save(Metric consumer);

    MetricValues save(MetricValues metricValue);

    List<Metric> findById(int id);

}
