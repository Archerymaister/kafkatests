import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;
import java.util.Random;

public class SimpleProducer2 {
    public static void main(String[] args) throws Exception{
        String topicName = "teststream2";
        String[] surname = new String[]{"Anna", "Lea", "Sarah", "Hannah", "Michelle", "Laura", "Lisa", "Lara", "Lena", "Julia"};

        Properties props = new Properties();
        props.put("bootstrap.servers", "192.168.2.112:9092");
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer","org.apache.kafka.common.serialization.IntegerSerializer");

        Producer<String, Integer> producer = new KafkaProducer<String, Integer>(props);

        for(int i = 0; i < 10; i++)
            producer.send(new ProducerRecord<String, Integer>(topicName,
                    getRandomName(surname), getRandomAge()));
        System.out.println("Message sent successfully");

        producer.close();

    }

    private static String getRandomName(String[] arr){
        return arr[new Random().nextInt(arr.length)];
    }

    private static int getRandomAge(){
        return new Random().nextInt(82)+18;
    }
}
