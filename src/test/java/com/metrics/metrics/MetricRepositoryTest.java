package com.metrics.metrics;


import com.metrics.metrics.metric.Metric;
import com.metrics.metrics.metric.MetricRepository;
import com.metrics.metrics.metric.MetricValues;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class MetricRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private MetricRepository metricRepository;


    @Test
    public void whenFindById_thenReturnMetric() {
        Metric metric = new Metric();
        metric.setName("metric1");
        Metric savedMetric = entityManager.persist(metric);
        entityManager.flush();
        List<Metric> found = metricRepository.findById(savedMetric.getId().intValue());
        Assert.assertEquals(found.get(0).getName(), metric.getName());
    }


    @Test
    public void whenMetricIsSaved_thenReturnSavedMetric() {
        Metric metric = new Metric();
        metric.setName("metric1");
        Metric savedMetric = entityManager.persist(metric);
        entityManager.flush();
        Assert.assertEquals(savedMetric.getName(), metric.getName());
    }

    @Test
    public void whenMetricValuesIsSaved_thenReturnSavedMetricValue() {
        Metric metric = new Metric();
        metric.setName("metric1");
        Metric savedMetric = entityManager.persist(metric);

        MetricValues metricValue = new MetricValues();

        Metric testMetric = new Metric();
        testMetric.setId(savedMetric.getId());
        metricValue.setMetrics(testMetric);
        metricValue.setValue(10);
        MetricValues savedMetricValue = entityManager.persist(metricValue);
        entityManager.flush();
        Assert.assertEquals(savedMetricValue.getValue(), metricValue.getValue(), 0);

    }


}
