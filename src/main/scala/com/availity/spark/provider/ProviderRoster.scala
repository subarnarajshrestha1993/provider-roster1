package com.availity.spark.provider

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.{StructType, DateType, StringType, IntegerType}

import org.apache.spark.sql.functions.{count, lit, array, collect_list, col, month, avg, concat}

object ProviderRoster  {

  def main(args: Array[String]): Unit = {

    val spark = SparkSession.builder()
      .master("local[1]")
      .appName("AvailityChallenge")
      .getOrCreate();


    val providers_df = spark.read.options(Map("inferSchema"->"true","delimiter"->"|","header"->"true")).csv("data\\providers.csv")

    val providers = providers_df.withColumn("name", concat(col("first_name"),lit(' '),col("middle_name"),lit(' '),col("last_name")))

    providers.printSchema()
    providers.show()
    val schema = new StructType()
      .add("visit_id",IntegerType,true)
      .add("provider_id",IntegerType,true)
      .add("visit_date",StringType,true)
    val visits = spark.read.options(Map("inferSchema"->"true","delimiter"->",","header"->"false")).schema(schema).csv("data\\visits.csv")

    visits.printSchema()
    visits.show()

    // Joining datasets on provider ID
    val joinedData = visits.join(providers, "provider_id")

    // Grouping by provider's specialty and aggregating the number of visits
    val result = joinedData.groupBy("provider_specialty", "provider_id", "name").agg(count("visit_id").alias("num_visits")).coalesce(1)

    result.write
      .partitionBy("provider_specialty")
      .json("output\\per_provider_output")


    // Extracting the month from the visit date
    val resultData = joinedData.withColumn("month", month(joinedData("visit_date")))

    // Grouping by provider ID and month, and calculating the total number of visits
    val aggregatedData = resultData.groupBy("provider_id", "month")
      .agg(count("visit_id").alias("total_visits")).coalesce(1)

    aggregatedData.write
      .json("output\\per_month_output")

    // Stop Spark session
    spark.stop()
  }

}
