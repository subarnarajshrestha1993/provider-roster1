# Provider Visits

This is a Spark project used to generate reports that deliver data about providers.

## Requirements
* Language: Scala
* Framework: Spark
* Output: json file/files 

## Data

Within the `data` subfolder, you'll find two sets of data:

1. `providers.csv` - A CSV containing data about providers and their respective specialties. 
2. `visits.csv` - A CSV with the unique visit ID, the provider ID (the ID of the provider who was visited), and the date of service of the visit. 

## Problems

Feel free to use this repository as a basis for solving these problems. You can also supply your own code.

1. Given the two data datasets, calculate the total number of visits per provider. The resulting set should contain the provider's ID, name, specialty, along with the number of visits. Output the report in json, partitioned by the provider's specialty. 

2. Given the two datasets, calculate the total number of visits per provider per month. The resulting set should contain the provider's ID, the month, and total number of visits. Output the result set in json.

Please provide your code in some format so we can attempt to run it during evaluation. Examples include github/gitlab links, .scala files, zipped folders containing the modified source project.
