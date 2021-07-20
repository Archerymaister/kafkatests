package Abstracts;

import java.util.Date;

import interfaces.Streamable;

public class AbstractStream implements Streamable{
	public Object get(String field) {
		try {
			return this.getClass().getDeclaredField(field).get(this);
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void set(String field, String value) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		this.getClass().getDeclaredField(field).setAccessible(true);
		this.getClass().getDeclaredField(field).set(this, value);
	}
	
	public void set(String field, int value) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		this.getClass().getDeclaredField(field).setAccessible(true);
		this.getClass().getDeclaredField(field).set(this, value);
	}

	public void set(String field, Date value) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		this.getClass().getDeclaredField(field).setAccessible(true);
		this.getClass().getDeclaredField(field).set(this, value);
	}
}
