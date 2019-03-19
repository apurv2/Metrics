
package com.metrics.metrics.metric;

import javassist.tools.web.BadHttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@RestController
class MetricResource {
    @Autowired
    AbstractMetricService metricService;

    //time Complexity - O(1)
    //space complexity - constant
    @CrossOrigin
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, value = "/metrics/new")
    public Metric createNewMetric(@RequestBody Metric metric) {
        return metricService.createNewMetric(metric);
    }

    //time Complexity - O(n)
    //space complexity - constant
    @CrossOrigin
    @GetMapping(value = "/metrics/{metricId}")
    public Collection<Metric> getMetricById(@PathVariable int metricId) {
        return metricService.getMetricById(metricId);
    }

    //time Complexity - O(1)
    //space complexity - constant
    @CrossOrigin
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, value = "/metrics/{metricId}/value/new")
    public MetricValues addMetricValue(@RequestBody MetricValues metricValue, @PathVariable int metricId) throws BadHttpRequest {
        return metricService.addValueToMetric(metricId, metricValue);
    }
}
