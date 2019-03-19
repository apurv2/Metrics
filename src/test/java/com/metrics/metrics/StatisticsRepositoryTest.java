package com.metrics.metrics;


import com.metrics.metrics.metric.Metric;
import com.metrics.metrics.metric.MetricRepository;
import com.metrics.metrics.metric.MetricValues;
import com.metrics.metrics.statistics.StatisticsRepository;
import com.metrics.metrics.statistics.StatisticsSummaryDTO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class StatisticsRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private MetricRepository metricRepository;

    @Autowired
    private StatisticsRepository statisticsRepository;

    Metric mainMetric;

    @Before
    public void setup() {

        mainMetric = new Metric();
        mainMetric.setName("metric1");
        Metric savedMetric = entityManager.persist(mainMetric);

        MetricValues metricValue1 = new MetricValues();
        MetricValues metricValue2 = new MetricValues();
        MetricValues metricValue3 = new MetricValues();


        metricValue1.setMetrics(savedMetric);
        metricValue1.setValue(10);
        entityManager.persist(metricValue1);
        entityManager.flush();


        metricValue2.setMetrics(savedMetric);
        metricValue2.setValue(20);
        entityManager.persist(metricValue2);
        entityManager.flush();

        metricValue3.setMetrics(savedMetric);
        metricValue3.setValue(30);
        entityManager.persist(metricValue3);
        entityManager.flush();


    }

    @Test
    public void whenGetMetricStatistics_GetAvgMinMax() {
        StatisticsSummaryDTO statistics = statisticsRepository.getMetricStatistics(mainMetric.getId().intValue());
        Assert.assertEquals(20, statistics.getAverage(), 0);
        Assert.assertEquals(30, statistics.getMax(), 0);
        Assert.assertEquals(10, statistics.getMin(), 0);
    }
}
