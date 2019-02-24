import java.util.HashSet;

public class Variables {

	public String name;
	String assignemnt=null;
	public HashSet<String> dm = null;
	
	public Variables(String name, String assignment, HashSet<String> domain) {
		this.name=name;
		this.assignemnt=assignment;
		this.dm=domain;
	}
	
	
}

