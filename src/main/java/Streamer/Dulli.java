import java.util.Date;

import Abstracts.AbstractStream;
import interfaces.Streamable;
import interfaces.markInterface;

public class Dulli extends AbstractStream {
	@markInterface
	private String name;
	
	@markInterface
	private int age;
	
	@markInterface
	private int IQ;
	
	public Dulli() {
		
	}

	public Dulli(String name, int age, int IQ) {
		this.name = name;
		this.age = age;
		this.IQ = IQ;
	}
}
