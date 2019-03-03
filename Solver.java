public class Solver {

	//check complete (all variables are assigned a domain)
	public static boolean isComplete(CSP c) {

		for(int i=0; i<c.var.length; i++) {
			if(c.var[i].assign==null) {
				return false;
			}
		}
		return true;	

	}

	public static boolean isComplete(CSP c, int value) {

		for(int i=0; i<c.var.length; i++) {
			if(c.var[i].value==0) {
				return false;
			}
		}
		return true;	

	}
	
	
	public boolean Consistent(CSP c, int i, String value) {//c, position, domain
		c.var[i].assign=value;//set assignment to this value (domain)
		return isConsistentMap(c);

	}

	public boolean Consistent(CSP c, int i, int v) {//c, position, domain
		c.var[i].value=v;//set assignment to this value (domain)
		boolean consistent1 = isConsistentJob(c);
		boolean consistent2 = isConsistentJob2(c);
		if(consistent1==false) {
			return false;
		}
		if(consistent2==false) {
			return false;
		}
		else if(consistent1==true || consistent2==true){
			return true;
		}
		return false;
	}
	//check consistent for Map
	public static boolean isConsistentMap(CSP c) {

		for(int i=0; i<c.cons1.size(); i++) {//go through all pairs of consistent
			String city1= c.cons1.get(i);
			String city2= c.cons2.get(i);

			String ass1 = " ";
			String ass2 = " ";

			//when variable equals name of the consistent
			//get the domain
			for(int j=0; j<c.var.length; j++ ) {
				if(c.var[j].name ==city1) {
					ass1 = c.var[j].assign;
				}if(c.var[j].name == city2) {
					ass2 = c.var[j].assign;
				}
			}

			//two adjacent cities have the same color
			if(ass1!=null && ass1 == ass2) {
				return false;
			}

		}
		return true;

	}

	//check first consistent for job
	public boolean isConsistentJob(CSP c) {

		for(int i=0; i<c.cons1.size(); i++) {
			String leftside = c.cons1.get(i);
			String rightside = c.cons2.get(i);
			int inspection = 0;
			int val1 = 0;
			int val2 = 0;

			for(int j=0; j<c.var.length; j++) {

				if(c.var[j].name.equals("Inspect")) {
					inspection= c.var[j].value;			
				}
				if(c.var[j].name.equals(leftside)) {
					if(leftside.equals("AxleF") || leftside.equals("AxleB")) {
						val1 = c.var[j].value + 10;
					}if(leftside.equals("WheelRF") || leftside.equals("WheelLF")  || leftside.equals("WheelRB")  || leftside.equals("WheelLB") ) {
						val1 = c.var[j].value + 1;
					}if (leftside.equals("NutsRF") || leftside.equals("NutsLF")  || leftside.equals("NutsRB")  || leftside.equals("NutsLB") ) {
						val1 = c.var[j].value + 2;	
					}else if(leftside.equals("CapsRF") || leftside.equals("CapsLF")  || leftside.equals("CapsRB")  || leftside.equals("CapsLB")) {
						val1 = c.var[j].value;
					}

				}
				if(c.var[j].name.equals(rightside)) {
					val2 = c.var[j].value;
				}		

			}

			if(( (val1 > val2) && val1!=0 && val2 !=0) ||  ( (val1>inspection) && val1!=0 && inspection!=0) ) {
				return false;

			}

		}

		return true;

	}

	//check second consistent for job
	public boolean isConsistentJob2(CSP c) {
		for(int i=0; i<c.cons3.size(); i++) {
			String dis1 = c.cons3.get(i);
			String dis2 = c.cons4.get(i);
			int val1=0;
			int val2=0;
			for(int j= 0; j<c.var.length; j++) {
				if (c.var[j].name.equals(dis1)) {
					val1 = c.var[j].value;
				}if(c.var[j].name.equals(dis2)) {		
					val2 = c.var[j].value;
				}		
			}
			if(val1+10>val2 && val1!=0 && val2!=0) {
				return false;
			}
			
		}	

		return true;


	}



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
