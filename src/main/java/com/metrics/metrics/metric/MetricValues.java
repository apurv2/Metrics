package com.metrics.metrics.metric;
import com.metrics.metrics.model.BaseEntity;
import javax.persistence.*;

@Entity
@Table(name = "MetricValues")
public class MetricValues extends BaseEntity {

    @Column(name = "name2")
    private String birthDate;

    @Column(name = "value")
    private double value;

    @ManyToOne
    @JoinColumn(name = "metrics")
    private Metric metrics;

    public String getBirthDate() {
        return birthDate;
    }

    public int getMetrics() {
        return metrics.getId();
    }

    public void setMetrics(Metric metric) {
        this.metrics = metric;
    }


    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}