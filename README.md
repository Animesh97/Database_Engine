# Database_Engine
This is a Java based project which reads a CSV file and generates a Database which can execute normal SQL Queries. The query is first tokenised and all the operators, fields, aggregate functions, conditions etc. are extracted. Then by splitting csv file by the position of commas the headers are matched with the corresponding tokens so that query extraction can be accomplished.
It also implements build functionality using maven and can be also configured for Continous Integration and Continous Delivery using Jenkins.
