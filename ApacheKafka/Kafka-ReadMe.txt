kafks question:

how do we decide the number of partition?
in kafka when is offset update after message is read or before message is read?
what if the consumer reads the message and goes down during processing. how do we make sure message is picked up again by another consumer


-> kafka headers : https://www.redpanda.com/guides/kafka-cloud-kafka-headers, https://www.baeldung.com/java-kafka-view-headers
-> why happens to message in topic if i restart my kakfa cluster/broker?
->how are compaies using kafka
->kafka scenario based interview questions for experienced : https://www.youtube.com/watch?v=niYW81iV0q4&t=5s
-> kafka is publishing to topic /partition
https://www.perplexity.ai/search/5f177d8b-22f5-47fd-84dd-dff1a6bafd4f-> kafka headers : https://www.redpanda.com/guides/kafka-cloud-kafka-headers, https://www.baeldung.com/java-kafka-view-headers
-> why happens to message in topic if i restart my kakfa cluster/broker?
->how are compaies using kafka
->kafka scenario based interview questions for experienced : https://www.youtube.com/watch?v=niYW81iV0q4&t=5s
-> kafka is publishing to topic /partition
https://www.perplexity.ai/search/5f177d8b-22f5-47fd-84dd-dff1a6bafd4f


topic: logical group
partition: physical gruping. There are actually different files for each partition.



durability and repability






------------------------------------------------------------------------------------------------------  
				                           Key points 
------------------------------------------------------------------------------------------------------ 

Producer produces data to a topic. The message can go to any partition of the topic(different algo like round robin, etc).
Producer doesnt know which consumer will read data
Producer can also produce to a specific partition(by giving partition key)  of a topic.
consumers of a consumer group consumes from a topic. 
each cosumer from a consumer group can listen to only only 1 partition of the topic -> refer FAQ
1 consumer can read/listen from 2 partiton present in 2 different topic.
two consumer from same consumer group cannot listen from same partition
two consumer from 2 different consumer group can listen from same partition
1 consumer group is like 1 service.
--------------------------------------------

Before 2.8 → ZooKeeper required.
2.8 → KRaft introduced (optional, early access).
3.x → KRaft stabilized, ZooKeeper still supported.
4.0 → ZooKeeper removed, KRaft is the only option

--------------------------------------------

--------------------------------------------

--------------------------------------------
--------------------------------------------



------------------------------------------------------------------------------------------------------  
				                           FAQ's 
------------------------------------------------------------------------------------------------------

"Each consumer can get connected to only one partition of a topic"-- Is this right?
A single Kafka consumer within a group can process multiple partitions simultaneously to handle parallel processing. While a specific partition is assigned to at most one consumer in a group.
Means a consumer can be connected to multiple partitions of a topic.
Kafka tracks progress per partition, not per consumer. Even if a consumer is assigned Partitions A and B, it maintains two separate "bookmarks" (offsets): 
Medium
Medium
Partition A Offset: 105
Partition B Offset: 42
If the consumer crashes, Kafka knows exactly where it left off in each individual partition. When a new consumer takes over, it won't miss or duplicate data because it resumes from those specific per-partition markers.

--------------------------------------------



------------------------------------------------------------------------------------------------------  
				                           KAFKA docker Installation
------------------------------------------------------------------------------------------------------ 

docker network create kafka-net

docker run -d \
  --name zookeeper \
  --network kafka-net \
  -p 2181:2181 \
  -e ZOOKEEPER_CLIENT_PORT=2181 \
  -e ZOOKEEPER_TICK_TIME=2000 \
  confluentinc/cp-zookeeper:7.5.0
  
  
docker run -d \
  --name kafka \
  --network kafka-net \
  -p 9092:9092 \
  -e KAFKA_BROKER_ID=1 \
  -e KAFKA_ZOOKEEPER_CONNECT=zookeeper:2181 \
  -e KAFKA_LISTENERS=PLAINTEXT://0.0.0.0:9092 \
  -e KAFKA_ADVERTISED_LISTENERS=PLAINTEXT://localhost:9092 \
  -e KAFKA_OFFSETS_TOPIC_REPLICATION_FACTOR=1 \
  confluentinc/cp-kafka:7.5.0
  
------------------------------------------------------------------------------------------------------------------------
												Kafka and zookeeper installation
------------------------------------------------------------------------------------------------------------------------

1. download kafka from web
2. extract it
3. copy the server.properties, zookeeper.properties from <Kafka_home>/config to <kafka_home>/bin/windows
4. start zookeeepr using the command >.\zookeeper-server-start.bat .\zookeeper.properties
5. start kakfa broker using the command > kafka-server-start.bat server2.properties
6. in order to create a new broker in same machine, create a copy of server.properties in same <Kafka_home>/bin/windows folder 
7. after the rename the new server.properties as server2.properties
8. in server2.properties change the brokerid, port and log file location
9. start the second kakfa broker using the command > kafka-server-start.bat server.properties

-------------------------------

create topic using 
>> cd <kakfa_home>/bin/windows
>>.\kafka-topics.bat --create --topic telusko --bootstrap-server localhost:9092 --partitions 4 --replication-factor 2

Get all Topics
>>kafka-topics.bat --list --bootstrap-server localhost:9092

Get info about a particular topic
>>kafka-topics.bat --describe --topic telusko --bootstrap-server localhost:9092
  
  
------------------------------------------------------------------------------------------------------  
				                           KAFKA CLI
------------------------------------------------------------------------------------------------------  
get in CLI mode of kafka container
>docker exec -it kafka bash

Create a topic inside a kafka container
>kafka-topics --create --topic my-topic --bootstrap-server localhost:9092 --partitions 3 --replication-factor 1
>kafka-topics --list --bootstrap-server localhost:9092
>kafka-topics --describe --topic my-topic --bootstrap-server localhost:9092

Produce a message
>kafka-console-producer --topic my-topic --bootstrap-server localhost:9092

Consume the message
from another terimal , go inside the kafka container
>kafka-console-consumer --topic my-topic --bootstrap-server localhost:9092 --from-beginning
(running above command from different terimal implies multiple consumers are created and these consumers do not belong to same consumer group.
Hence message will be consumed by both of these consumers)

Create a consumer group
>kafka-console-consumer --topic my-topic --bootstrap-server localhost:9092 --group my-group --from-beginning


create 2 consumer in a consumer group.
Now send messages, we notice that all the message are consumed by only1 consumer.
It is because all message are going to only 1 partition and that partiiton is being read by only 1 consumer.
inorder to distribute messages to different consumers 

>kafka-console-producer --topic my-topic --bootstrap-server localhost:9092 --property "parse.key=true" --property "key.separator=:"
send message  -> hello1:user1    
=> key:value  , key is hashed and assigned to different partition of the topic
routing key = hello1 value user1
parse.key=true enables key parsing.

(kafka-console-consumer is a tool which can create a consumer )

See the consumer offset, lag in a consumer group
>kafka-consumer-groups --bootstrap-server localhost:9092 --describe --group my-group

stop all consumer, send message to topic and observe that lag value increases when we describe the consumer group. 
lag means messages that are yet to be consumed.


>[appuser@597269c5916b ~]$ kafka-topics --list --bootstrap-server localhost:9092
__consumer_offsets
my-newtopic
my-topic

__consumer_offsets : is an internal topic created by kakfa to manage  offsets



To print the complete Kafka message—including keys, values, timestamps, headers, and metadata
>kafka-console-consumer --topic my-topic-new --bootstrap-server localhost:9092 --group mygroup --from-beginning --property print.key=true --property print.value=true --property print.timestamp=true --property print.partition=true  --property print.offset=true --property print.headers=true 




------------------------------------------------------------------------------------------------------  
				                           Kafka GUI
------------------------------------------------------------------------------------------------------ 

>>java -jar kafka-ui-api-v0.7.2.jar
 localhost:8080
 
 
 

------------------------------------------------------------------------------------------------------------------------
												Kakfa Interview Questions
------------------------------------------------------------------------------------------------------------------------

🚀 Kafka Interview Question (Consumer Offsets)

One of the most frequently asked questions in Data Engineering interviews.

consumer.subscribe(["orders"])
while True:
    records = consumer.poll(timeout_ms=1000)
    for record in records:
        process(record)
    consumer.commit()

❓ Your Task:

1. If the consumer crashes after process(record) but before commit(), what happens?
2. Is this at-most-once, at-least-once, or exactly-once processing?
3. How would you modify this design to avoid duplicate processing?


------------------------------------------------------------------------------------------------------------------------
https://codefarm0.medium.com/top-scenario-based-kafka-interview-questions-with-code-examples-ca0f075dcfdf

------------------------------------------------------------------------------------------------------------------------
https://www.youtube.com/playlist?list=PLq5K56cErWDCDTcgrSpqH64OmlI0TeKGY :Apache Kafka Interview Scenarios (Real Production Problems) by Satyverse(Satyam Parmar)

------------------------------------------------------------------------------------------------------------------------


------------------------------------------------------------------------------------------------------------------------


------------------------------------------------------------------------------------------------------------------------