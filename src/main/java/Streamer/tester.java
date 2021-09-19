import java.lang.reflect.Field;
import java.lang.reflect.Method;

import interfaces.markInterface;
import interfaces.testInterface;

public class tester {

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
				
		Method[] methods = testClasses.test.class.getMethods();
		Field[] fields = testClasses.test.class.getDeclaredFields();
		
		System.out.println(methods.length);
		System.out.println(fields.length);
		
		System.out.println("Methods");
		for(Method method : methods) {
			if(method.isAnnotationPresent(markInterface.class)) {
				markInterface mi = method.getAnnotation(markInterface.class);
				System.out.println(" " + method.getName());
			}
		}
		
		System.out.println("Fields");
		for(Field field : fields) {
			if(field.isAnnotationPresent(markInterface.class)) {
				markInterface mi = field.getAnnotation(markInterface.class);
				field.setAccessible(true);
				System.out.println(" " + field.getName() + " " + field.get(test.class));
			}
		}

	}

}
