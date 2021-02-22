# event-processor
Publishing events to kafka through a Restful Spring application.

# Running
In order to run this project locally, you need to run a kafka server at port 9092. To do so, you can follow these steps:

Go to Apache Kafka web page and download the source files. In my case, I used the version 2.7.0 and you can download this version clicking [here](https://downloads.apache.org/kafka/2.7.0/kafka_2.13-2.7.0.tgz)

After download, we should extract the tar file downloaded:

```
$ tar -xzf kafka_2.13-2.7.0.tgz
$ cd kafka_2.13-2.7.0
```

Great! So lets start! In order to run kafka, we need to run two servers. The first one, [zookeepper server](https://zookeeper.apache.org/) and the second one, the kafka server:

```
$ bin/zookeeper-server-start.sh config/zookeeper.properties
$ bin/kafka-server-start.sh config/server.properties
```

After that, we need to create our topic:

```
// Create my-topic topic
$ bin/kafka-topics.sh --create --topic my-topic --bootstrap-server localhost:9092

```

Thanks for [Apache Kafka Quick Start page](https://kafka.apache.org/quickstart).

Now, we can start our spring application and start publish events to kafka through a http request.

So, first of all, start the web server:

```
./mvnw spring-boot:run
```

And, send a POST request to our /messages endpoint. If you want a personalized response, just put a query string called name with a specific value:

```
curl -d "" localhost:8080/messages?name=Rafael
```

To read the messages in a better format, take a look at this project: https://github.com/RafaelFerraro/event-collector
