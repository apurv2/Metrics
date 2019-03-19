package com.metrics.metrics.metric;

import com.metrics.metrics.model.BaseEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Metric")
public class Metric extends BaseEntity {

    @Column(name = "name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "metrics")
    private List<MetricValues> metrics;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MetricValues> getMetrics() {
        return metrics;
    }

    public void setMetrics(List<MetricValues> metrics) {
        this.metrics = metrics;
    }
}