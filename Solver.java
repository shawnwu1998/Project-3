public class Solver {


	public CSP backtrack(CSP c) {
		if(Assignment.isComplete(c)) {
			return c;
		}

		//check if each var has a assignment
		//if does not have assignment, set index to it
		int index=0;
		for(int i=0 ; i<c.var.length; i++) {
			if(c.var[i].assign==null) {
				index = i;
				break;
			}
		}

		//set value to the var's domain when the assignment is consistent
		for(String values: c.var[index].dm) {
			if(Assignment.Consistent(c, index, values,1)) {
				c.var[index].assign=values;
				CSP result = backtrack(c);
				if(result!=null) {
					return result;
				}
			}else if(Assignment.Consistent(c, index, values,0)) {
				c.var[index].assign=values;
				CSP result = backtrack(c);
				if(result!=null) {
					return result;
				}
			}
		}
		
	
		

		return null;

	}
	
	public CSP backtrackn(CSP c) {
		if(Assignment.isComplete(c)) {
			return c;
		}

		//check if each var has a assignment
		//if does not have assignment, set index to it
		int index=0;
		for(int i=0 ; i<c.var.length; i++) {
			if(c.var[i].assign==null) {
				index = i;
				break;
			}
		}

		//set value to the var's domain when the assignment is consistent
		for(String values: c.var[index].dm) {
			if(Assignment.ConsistentQueens(c, index, values)) {
				c.var[index].assign=values;
				CSP result = backtrack(c);
				if(result!=null) {
					return result;
				}
			}
		}
		
		return null;

	}

	public CSP backtrack(CSP c, int value) {
		if(Assignment.isComplete(c,0)) {
			return c;
		}
		int index=0;
		for(int i=0 ; i<c.var.length; i++) {
			if(c.var[i].value == 0) {
				index = i;
				break;
			}
		}

		for(Integer values: c.var[index].dmj) {
			
			if(Assignment.ConsistentJob(c, index, values)) {
				c.var[index].value=values;
				CSP result = backtrack(c,0);
				if(result!=null) {
					return result;
				}
			}
		}
		return null;

	}

}
