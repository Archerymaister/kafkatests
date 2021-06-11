package Consumer;

import java.util.Properties;
import java.util.Arrays;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.ConsumerRecord;

public class SimpleConsumer1 {
    public static void main(String[] args) throws Exception {

        String topicName = "teststream1";
        Properties props = new Properties();

        props.put("bootstrap.servers", "192.168.2.112:9092");
        props.put("group.id", "consumer1");
        props.put("enable.auto.commit", "true");
        props.put("auto.commit.interval.ms", "1000");
        props.put("session.timeout.ms", "30000");
        props.put("key.deserializer",
                "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer",
                "org.apache.kafka.common.serialization.IntegerDeserializer");
        KafkaConsumer<String, Integer> consumer = new KafkaConsumer
                <String, Integer>(props);

        consumer.subscribe(Arrays.asList(topicName));

        //print the topic name
        System.out.println("Subscribed to topic " + topicName);
        int i = 0;

        while (true) {
            ConsumerRecords<String, Integer> records = consumer.poll(100);
            for (ConsumerRecord<String, Integer> record : records)

                System.out.printf("offset = %d, key = %s, value = %s\n",
                        record.offset(), record.key(), record.value());
        }
    }
}