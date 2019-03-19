package com.metrics.metrics.metric;

import javassist.tools.web.BadHttpRequest;

import java.util.Collection;

public interface AbstractMetricService {

    Metric createNewMetric(Metric consumer);

    Collection<Metric> getMetricById(int metricId);

    MetricValues addValueToMetric(int metricId, MetricValues metricValue) throws BadHttpRequest;

}
