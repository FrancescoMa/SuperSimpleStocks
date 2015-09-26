
# Super Simple Stocks requirements document.
###1. Purpose 
The purpose of this document is to summarise the functional requirements of Super Simpe Stocks. It is not a system solution, but a guideline of the required system functionality.
The document sets out detail of 
* Functionality requirements
* The modules 

###2. Functional requirements
The Requirements for the functionality of the system are follow:
* *calculate the dividend yield* provided by Operation module
* *calculate the P/E Ratio* provided by Operation module
* *record a trade, with timestamp, quantity of shares, buy or sell indicator and price* provided by Model module
* *Calculate Stock Price based on trades recorded in past 15 minutes* provided by Operation module 
* *Calculate the GBCE All Share Index using the geometric mean of prices for all stocks* provided by Operation module

###3. The Modules
The modules who implement the requirements are:
* **Model:** composed by 3 class:
  * **Stock** the class that represent the single Stock and its information
  * **Trade** the class that represent the selling or buying ok a determinate Stock
  * **InizializeIstance** this class provide the initialization of the Stock for testing, and the  record of Trade refer to a Stock. So it provide the 3th point of requirements above.
* **Operation:** that provide the other functional requirements above. This module is in the “mainStock” package with the SuperSimpleStocks class. 
*	**SuperSimpleStocks:** this is the main java class that start system and permit to use it interacting with the other module for manage the functionalities provided.
