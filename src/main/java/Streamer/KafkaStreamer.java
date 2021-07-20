import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import interfaces.Streamable;
import interfaces.markInterface;

public class KafkaStreamer {
	
	public static String toString(Streamable streamable) {
		String name = streamable.getClass().getName();
		HashMap<String, String> fieldMap = new HashMap<>();
		Field[] fields = streamable.getClass().getDeclaredFields();
		for(Field field : fields) {
			if(field.isAnnotationPresent(markInterface.class)) {
				try {
					field.setAccessible(true);
					fieldMap.put(field.getName(), field.get(streamable).toString());
				} catch (IllegalArgumentException | IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return formatString(name, fieldMap);
	}
	
	private static String formatString(String name, HashMap<String, String> entries) {
		String rtn = name + "={";
		
		for(Entry<String, String> e : entries.entrySet()) {
			rtn += "\"" + e.getKey() + "\":\"" + e.getValue() + "\",";
		}
		
		rtn = rtn.substring(0, rtn.length()-1);
		
		return rtn + "}";
	}
	
	public static Streamable fromString(String string, Streamable s) throws Exception {
		String pattern = "([a-zA-Z]+)=[{](\"[a-zA-Z0-9]+\":\".+\",?)*}";
		
		String name;
		String contents;
		HashMap<String, String> entries = new HashMap<>();
		
		Matcher stringMatcher = Pattern.compile(pattern).matcher(string);
		
		if(!stringMatcher.matches())
			throw new Exception();
		
		name = stringMatcher.group(1);
		contents = stringMatcher.group(2);
		
		
		Matcher contentMatcher = Pattern.compile("(\"[a-zA-Z0-9]+\":\"[^,:\"]+\")*,?").matcher(contents);
		while(contentMatcher.find()) {
			System.out.println(contentMatcher.group());
			s.set("name", "claudi");
		}
		
		
		
		
		
		
		return s;
	}

}
