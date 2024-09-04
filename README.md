# Baby Births Project

## Overview

The Baby Births Project is a Java-based application designed to analyze historical baby name data from the United States. The project performs various statistical operations on baby names, such as determining the rank of a name in a specific year, finding the year a name was most popular, calculating the average rank over multiple years, and more. This project utilizes CSV files containing baby name data, with each file representing data from a different year.

## Features

### Data Reading and Processing
- **FileResource**: Utilizes the `FileResource` class from the Duke University library to read and process CSV files. Each CSV file contains baby names, gender information, and the number of births for each name in a given year.

### Core Methods

- **printNames()**: Prints all the names in the file where the number of births is less than or equal to 100.
- **totalBirths(FileResource fr)**: Calculates and returns the total number of births, as well as the number of births for boys and girls separately in the provided file.
- **getRank(String name, int year, String gender)**: Returns the rank of a given name and gender in a specified year. If the name is not found, it returns `-1`.
- **getName(int year, int rank, String gender)**: Returns the name with the given rank and gender for a specified year. If the rank does not exist, it returns `"NO Name"`.
- **whatIsNameInYear(String name, int year, int newyear, String gender)**: Determines what a given name's rank in one year would correspond to if it were born in another year.
- **yearOfHighestRank(String name, String gender)**: Finds and returns the year in which the specified name and gender had the highest rank across multiple years.
- **getAverageRank(String name, String gender)**: Calculates and returns the average rank of a name over a range of years.
- **getTotalBirthsRankedHigher(int year, String name, String gender)**: Calculates the total number of births for names that are ranked higher than the specified name in a particular year.

### Testing

The project includes a suite of test methods to validate the functionality of the core methods:

- `testTotalBirths()`
- `testGetRank()`
- `testGetName()`
- `testWhatIsNameInYear()`
- `testYearOfHighestRank()`
- `testGetAverageRank()`
- `testGetTotalBirthsRankedHigher()`

## Project Workflow

1. **Data Input**: The program reads baby name data from CSV files, with each file representing a specific year.
2. **Data Processing**: The core methods process the data to answer questions like the rank of a name, the year it was most popular, or its average rank over time.
3. **Output**: Results are printed to the console, providing insights into trends and patterns in baby names.

## Applications

- **Historical Analysis**: Analyze the popularity of specific names over time to understand naming trends and cultural shifts.
- **Name Prediction**: Predict the popularity of names in future years by analyzing historical data.
- **Demographic Studies**: Provide insights into gender-specific naming trends, contributing to demographic and sociological studies.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- Apache Commons CSV library
- Duke University library for file processing

### Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/baby-births-project.git
