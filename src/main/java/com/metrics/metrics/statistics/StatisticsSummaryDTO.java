package com.metrics.metrics.statistics;

public class StatisticsSummaryDTO {

    public StatisticsSummaryDTO(double average, double max, double min) {
        this.average = average;
        this.min = min;
        this.max = max;
    }

    private double average;
    private double min;
    private double max;
    private double median;

    public StatisticsSummaryDTO() {

    }

    public double getMedian() {
        return median;
    }

    public void setMedian(double median) {
        this.median = median;
    }

    public double getMin() {
        return min;
    }

    public double getMax() {
        return max;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public void setMax(double max) {
        this.max = max;
    }
}
