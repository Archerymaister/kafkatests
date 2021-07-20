

public class StreamerTester {

	public static void main(String[] args) {
		StreamObject obj = new StreamObject("Lukas", 21);
		Dulli claudi = new Dulli("Claudius", 21, 3);
		
		String objString = KafkaStreamer.toString(obj);
		//System.out.println(objString);
		
		String claudiString = KafkaStreamer.toString(claudi);
		//System.out.println(claudiString);
		
		try {
			KafkaStreamer.fromString(claudiString, new Dulli());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
