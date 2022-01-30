# Exchange Rate Converter

### Given certain exchange rate quotes, the application is able to determine asked for quotes.

**Input**
- A string containing the given quotes separated by a semicolon and the sought after quote separated by a vertical bar.
- The quotes are provided following the ISO currency code. E.g, in the pair EURUSD:1.20, EUR is referred to as the base currency and USD is regarded as the quote currency. The cited quote, implies that 1 EUR buys 1.20 USD.

**Output**
The output of the program should be one of the following:
- The exchange rate quote sought after rounded up to 2 decimal points.
- If the exchange rate cannot be determined based on the given quotes, return 'Unable to determine'

# Approach taken

* After parsing the provided quotes a graph is build.
  * The vertices of the graph represent each of the currencies in the given exchange rate quotes.
  * The edges of the graph represent the exchange rates between them.
* Breadth First Search is used to traverse the graph calculating the exchange rates on the path between the two sought after currencies.
* If no edge connecting the two currencies exists, the exchange rate cannot be determined.