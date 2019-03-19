package com.metrics.metrics.statistics;

import com.metrics.metrics.metric.MetricValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StatisticsServiceImpl implements AbstractStatisticsService {
    @Autowired
    StatisticsRepository statisticsRepository;

    @Override
    public StatisticsSummaryDTO getSummaryStatistics(int metricValue) {

        double median = calculateMedian(statisticsRepository.getByMetricId(metricValue).stream().map(MetricValues::getValue).sorted().collect(Collectors.toList()));
        StatisticsSummaryDTO statisticsSummaryDTO = statisticsRepository.getMetricStatistics(metricValue);
        statisticsSummaryDTO.setMedian(median);
        return statisticsSummaryDTO;
    }

    public double calculateMedian(List<Double> metricValues) {

        int middle = metricValues.size() / 2;
        if (metricValues.size() % 2 == 0) {
            return 0.5 * (metricValues.get(middle).doubleValue() + metricValues.get(middle - 1).doubleValue());
        } else {
            return metricValues.get(middle).doubleValue();
        }
    }

}
