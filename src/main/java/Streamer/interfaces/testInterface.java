package interfaces;

public @interface testInterface {
	String myDescription();
	boolean displayed() default true;
}
