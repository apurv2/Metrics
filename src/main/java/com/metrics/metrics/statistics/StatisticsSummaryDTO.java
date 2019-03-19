package com.metrics.metrics.statistics;

public class StatisticsSummaryDTO {


    public StatisticsSummaryDTO(double average, double min, double max, String name) {
        this.average = average;
        this.min = min;
        this.max = max;
        this.name = name;
    }

    private double average;
    private double min;
    private double max;
    private double median;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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
