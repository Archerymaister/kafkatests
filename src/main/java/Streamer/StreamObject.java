import java.util.Date;

import Abstracts.AbstractStream;
import interfaces.markInterface;

public class StreamObject extends AbstractStream {
	
	@markInterface
	private String name;
	
	@markInterface
	private int age;

	public StreamObject(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
}
