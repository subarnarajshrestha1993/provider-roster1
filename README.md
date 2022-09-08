# Provider Visits

The is a spark project used to generate various reports that deliver data about providers. 

## Data

Within the `data` subfolder, you'll find two sets of data provided:

1. `providers.csv` - A CSV containing data about various providers and their respective specialty. 
2. `visits.csv` - A CSV with the unique visit ID, the provider ID who the visit was for, and the date of service of the visit. 

## Problems

For the following, you are more than welcome to use this repository as a basis or supplement your own code.

1. Given the two data datasets, calulate the total number of visits per provider. The resulting set should contain the providerd's ID, name, specialty, along with the number of visits. Output the report in json, partitioned by the provider's specialty. 

2. Given the two datasets, calculate the total number of visits per provider per month. The result set should contain the provider's ID, the month, and total number of visits. Output the result set in json.

