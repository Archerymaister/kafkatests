package interfaces;
import java.util.Date;

public interface Streamable {
	public Object get(String field);
	public void set(String field, String value) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException;
	public void set(String field, int value) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException;
	public void set(String field, Date value) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException;
}
