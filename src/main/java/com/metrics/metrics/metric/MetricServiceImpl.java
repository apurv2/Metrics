package com.metrics.metrics.metric;

import javassist.tools.web.BadHttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class MetricServiceImpl implements AbstractMetricService {
    @Autowired
    MetricRepository metricRepository;

    public Metric createNewMetric(Metric metric) {
        return metricRepository.save(metric);
    }

    @Override
    public List<Metric> getMetricById(int metricId) {
        return metricRepository.findById(metricId);
    }

    @Override
    public MetricValues addValueToMetric(int metricId, MetricValues metricValue) throws BadHttpRequest {

        List<Metric> metricColl = getMetricById(metricId);

        if (!CollectionUtils.isEmpty(metricColl)) {
            MetricValues value = new MetricValues();
            value.setMetrics(metricColl.get(0));
            value.setValue(metricValue.getValue());
            return metricRepository.save(value);
        } else throw new BadHttpRequest();
    }

}
