public class Solver {


	public CSP backtrack(CSP c) {
		if(isComplete(c)) {
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
			if(Consistent(c, index, values)) {
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
		if(isComplete(c,0)) {
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
			
			if(Consistent(c, index, values)) {
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
