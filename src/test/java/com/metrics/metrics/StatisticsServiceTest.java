package com.metrics.metrics;


import com.metrics.metrics.metric.MetricValues;
import com.metrics.metrics.statistics.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class StatisticsServiceTest {

    @InjectMocks
    StatisticsServiceImpl statisticsService;

    @Mock
    StatisticsRepository statisticsRepository;

    StatisticsSummaryDTO statisticsSummaryDTO;

    @Before
    public void setup() {

        statisticsSummaryDTO = new StatisticsSummaryDTO() {{
            setAverage(20);
            setMax(30);
            setMin(10);
            setMedian(20);
        }};

        List<MetricValues> metricValuesList = new ArrayList<>();
        metricValuesList.add(new MetricValues() {{
            setValue(10);
        }});
        metricValuesList.add(new MetricValues() {{
            setValue(20);
        }});
        metricValuesList.add(new MetricValues() {{
            setValue(30);
        }});

        given(this.statisticsRepository.getMetricStatistics(1)).willReturn(statisticsSummaryDTO);
        given(statisticsRepository.getByMetricId(1)).willReturn(metricValuesList);
    }

    @Test
    public void verifyStatistics() throws Exception {
        StatisticsSummaryDTO responseStatistics = statisticsService.getSummaryStatistics(1);
        Assert.assertEquals(responseStatistics.getMin(), statisticsSummaryDTO.getMin(), 0);
        Assert.assertEquals(responseStatistics.getMax(), statisticsSummaryDTO.getMax(), 0);
        Assert.assertEquals(responseStatistics.getAverage(), statisticsSummaryDTO.getAverage(), 0);
        Assert.assertEquals(responseStatistics.getMedian(), statisticsSummaryDTO.getMedian(), 0);
    }

    @Test
    public void testMedian() {
        double median = statisticsService.calculateMedian(Arrays.asList(1.0, 2.0, 3.0));
        Assert.assertEquals(2, median, 0);
    }
}
