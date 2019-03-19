# Metrics
Spring boot project API.

1. Create a Metric ​– the API will allow the user to create metrics.
2. Post Values to a Metric​ - the API will allow the user to post a decimal value to a created
metric. Please note that user will be able to create multiple metrics so you should be able to
specify the metric in this request.
3. Retrieve Statistics ​- the API will allow the user to retrieve summary statistics on ametric.
Specifically:
a. Arithmetic Mean of a values posted to metric
b. Median of a values posted to metric
c. Min value for metric
d. Max value for metric


1. To create a metric:
http://localhost:8080/metrics/new
post body : {"name": "metric1"}

2. To Add a value to the created Metric:
http://localhost:8080/metrics/1/value/new
post body : {"value" : "100" }
notice /1/  in the URL. that defines the metricId. and the value 100 is the value in the metric. You can post the
2nd API to add multiple values in order to add multiple values to the first created metric.
Likewise you can create multiple metrics.

3. http://localhost:8080/statistics/summary/1
Notice 1 at the end of the API request, this will give us the statistics related to the Metric


