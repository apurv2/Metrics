package com.metrics.metrics.statistics;

import java.util.List;

public interface AbstractStatisticsService {

    StatisticsSummaryDTO getSummaryStatistics(int metricValue);

    double calculateMedian(List<Double> values);

}
