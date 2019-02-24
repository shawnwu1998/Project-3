
public class Solver {

	public static boolean isComplete(CSP c) {
		for(int i=0; i<c.var.length; i++) {
			if(c.var[i].assignemnt==null) {
				return false;
			}
		}
		return true;
		
	}
	
	public static boolean isConsistent(CSP c) {
		
		for(int i=0; i<c.cons1.size(); i++) {
			String city1= c.cons1.get(i);
			String city2= c.cons2.get(i);
			
			String ass1 = " ";
			String ass2 = " ";
			
			for(int j=0; j<c.var.length; j++ ) {
				if(c.var[j].name ==city1) {
					ass1 = c.var[j].assignemnt;
				}if(c.var[j].name == city2) {
					ass2 = c.var[j].assignemnt;
				}
			}
			
			if(ass1!=null && ass1 == ass2) {
				return false;
			}
			
		}
		return true;
		
	}
	
	public boolean Consistent(CSP c, int i, String value) {
		c.var[i].assignemnt=value;
		return isConsistent(c);
				
	}
	
	public CSP backtrack(CSP c) {
		if(isComplete(c)) {
			return c;
		}
		int index=0;
		for(int i=0 ; i<c.var.length; i++) {
			if(c.var[i].assignemnt==null) {
				index = i;
				break;
			}
		}
		
		for(String values: c.var[index].dm) {
			if(Consistent(c, index, values)) {
				c.var[index].assignemnt=values;
				CSP result = backtrack(c);
				if(result!=null) {
					return result;
				}
			}
			
			
		}
		
		return null;
		
	}
	
}
