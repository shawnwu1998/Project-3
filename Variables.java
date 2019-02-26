import java.util.HashSet;

public class Variables {

	public String name;
	public String assign=null;
	public HashSet<String> dm = null;
	public int value=0;
	public HashSet<Integer> dmj=null;
	
	public Variables(String name, String assignment, HashSet<String> domain) {
		this.name=name;
		this.assign=assignment;
		this.dm=domain;
	}
	
	public Variables(String name, int value, HashSet<Integer> domain) {
		this.name=name;
		this.value=value;
		this.dmj=domain;
		
		
	}
	
	
}
