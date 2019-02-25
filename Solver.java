public class Solver {

	//check complete (all variables are assigned a domain)
	public static boolean isComplete(CSP c) {
		
		for(int i=0; i<c.var.length; i++) {
			if(c.var[i].assimt==null) {
				return false;
			}
		}
		return true;	
		
	}
	
	//check consistent 
	public static boolean isConsistent(CSP c) {
		
		for(int i=0; i<c.cons1.size(); i++) {//go through all pairs of consistent
			String city1= c.cons1.get(i);
			String city2= c.cons2.get(i);
			
			String ass1 = " ";
			String ass2 = " ";
			
			//when variable equals name of the consistent
			//get the domain
			for(int j=0; j<c.var.length; j++ ) {
				if(c.var[j].name ==city1) {
					ass1 = c.var[j].assimt;
				}if(c.var[j].name == city2) {
					ass2 = c.var[j].assimt;
				}
			}
			
			//two adjacent cities have the same color
			if(ass1!=null && ass1 == ass2) {
				return false;
			}
			
		}
		return true;
		
	}
	
	public boolean Consistent(CSP c, int i, String value) {//c, position, domain
		c.var[i].assimt=value;//set assignment to this value (domain)
		return isConsistent(c);

	}
	
	public CSP backtrack(CSP c) {
		if(isComplete(c)) {
			return c;
		}
		
		//check if each var has a assignment
		//if does not have assignment, set index to it
		int index=0;
		for(int i=0 ; i<c.var.length; i++) {
			if(c.var[i].assimt==null) {
				index = i;
				break;
			}
		}
		
		//set value to the var's domain when the assignment is consistent
		for(String values: c.var[index].dm) {
			if(Consistent(c, index, values)) {
				c.var[index].assimt=values;
				CSP result = backtrack(c);
				if(result!=null) {
					return result;
				}
			}
			
			
		}
		
		return null;
		
	}
	
}
