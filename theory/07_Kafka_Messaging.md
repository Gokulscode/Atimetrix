# Kafka & Messaging - Interview Questions

## 1. What is Kafka?
Distributed event streaming platform for high-throughput, fault-tolerant messaging.

**Components:**
- **Producer** - Publishes messages to topics
- **Consumer** - Reads messages from topics
- **Broker** - Kafka server that stores messages
- **Topic** - Category/feed name for messages
- **Partition** - Subdivision of topic for parallelism
- **Consumer Group** - Set of consumers sharing load

## 2. What is a Kafka Partition?
Division of a topic into smaller ordered parts.
- Enables **parallel processing** - multiple consumers read different partitions
- Each partition has an **offset** (sequential ID)
- Messages within a partition are **ordered**
- Partitions distributed across **brokers**

## 3. Kafka vs RabbitMQ
| Kafka | RabbitMQ |
|-------|----------|
| Event streaming / log | Message broker |
| Messages persist (configurable retention) | Messages deleted after consumption |
| Pull-based (consumer polls) | Push-based (broker pushes) |
| High throughput (millions/sec) | Lower throughput |
| Replay messages possible | No replay |
| Better for event sourcing | Better for task queues |

## 4. What happens if Kafka consumer goes down?
- Messages are **NOT lost** - they remain in the partition
- Kafka tracks **consumer offset** (last read position)
- When consumer comes back, it resumes from last committed offset
- If consumer group has other members, partitions get **rebalanced**

## 5. Idempotent in Kafka
- **Idempotent Producer**: Ensures no duplicate messages even on retry
- Set `enable.idempotence=true`
- Kafka assigns sequence number per partition to detect duplicates

## 6. How partitions are defined?
- Set at topic creation: `--partitions 3`
- Based on: expected throughput, number of consumers, data distribution
- Key-based partitioning: messages with same key go to same partition

## 7. What is RabbitMQ?
Message broker implementing AMQP protocol.
- **Exchange** routes messages to **Queues**
- Types: Direct, Fanout, Topic, Headers
- Supports acknowledgments, routing, dead-letter queues

## 8. If IBM MQ server crashes, are messages preserved?
- **Persistent messages**: Yes, stored on disk, survive crash
- **Non-persistent messages**: Lost on crash
- Queue manager recovery restores persistent messages

## 9. Kafka Producer/Consumer Configuration
```properties
# Producer
spring.kafka.producer.bootstrap-servers=localhost:9092
spring.kafka.producer.key-serializer=StringSerializer
spring.kafka.producer.value-serializer=StringSerializer

# Consumer
spring.kafka.consumer.bootstrap-servers=localhost:9092
spring.kafka.consumer.group-id=my-group
spring.kafka.consumer.auto-offset-reset=earliest
spring.kafka.consumer.key-deserializer=StringDeserializer
spring.kafka.consumer.value-deserializer=StringDeserializer
```

