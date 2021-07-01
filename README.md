# SPRING BOOT ELASTICSEARCH EXAMPLE

## Synopsis

The project is a Spring Boot Application with Elasticsearch.

## Motivation

I wanted to do a Spring Boot Application that uses Elasticsearch.

## PRE REQUIERMENTS

- Elasticsearch version 7.13.2 (must be running)
- Kibana version 7.13.2 (Optional)
- Postman

## POSTMAN REQUESTS

<pre><code>
If the index does not exist, it will be created.
If the index already exists, it will be updated.

POST
http://localhost:8085/elasticsearch/index

BODY
{"index": "myindex", "id": "1", "jsonString": "{\"name\":\"PETER\",\"surname\":\"TABLE\",\"age\":56,\"birthdate\":\"1950-01-10\",\"hour\":\"15:30\"}"}

RESPONSE
myindex: CREATED

or

myindex: UPDATED

Get the information from the index and id:

GET
http://localhost:8085/elasticsearch/get

BODY
{"index": "myindex", "id": "1"}

RESPONSE
{
    "fields": {},
    "id": "1",
    "type": "_doc",
    "source": {
        "birthdate": "1950-01-10",
        "hour": "15:30",
        "surname": "TABLE",
        "name": "PETER",
        "age": 56
    },
    "index": "myindex",
    "version": 1,
    "sourceAsString": "{\"name\":\"PETER\",\"surname\":\"TABLE\",\"age\":56,\"birthdate\":\"1950-01-10\",\"hour\":\"15:30\"}",
    "sourceInternal": {
        "fragment": true
    },
    "sourceAsBytesRef": {
        "fragment": true
    },
    "sourceAsMap": {
        "birthdate": "1950-01-10",
        "hour": "15:30",
        "surname": "TABLE",
        "name": "PETER",
        "age": 56
    },
    "seqNo": 0,
    "sourceEmpty": false,
    "primaryTerm": 1,
    "exists": true,
    "sourceAsBytes": "eyJuYW1lIjoiUEVURVIiLCJzdXJuYW1lIjoiVEFCTEUiLCJhZ2UiOjU2LCJiaXJ0aGRhdGUiOiIxOTUwLTAxLTEwIiwiaG91ciI6IjE1OjMwIn0=",
    "fragment": false
}

</code></pre>

## License

All work is under Apache 2.0 license