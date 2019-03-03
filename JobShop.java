import java.util.HashSet;

public class JobShop {

	public static void jobshop() {
		CSP job = new CSP();
		HashSet<Integer> domain = new HashSet();
		domain.add(1);domain.add(2);domain.add(3);domain.add(4);domain.add(5);domain.add(6);domain.add(7);domain.add(8);domain.add(9);domain.add(10);
		domain.add(11);domain.add(12);domain.add(13);domain.add(14);domain.add(15);	domain.add(16);	domain.add(17);	domain.add(18);	domain.add(19);
		domain.add(20);	domain.add(21);	domain.add(22);	domain.add(23);	domain.add(24);domain.add(25);domain.add(26);domain.add(27);
		Variables AxleF = new Variables("AxleF", 0, domain);
		Variables AxleB = new Variables("AxleB", 0, domain);
		Variables WheelRF = new Variables("WheelRF", 0, domain);
		Variables WheelLF = new Variables("WheelLF", 0, domain);
		Variables WheelRB = new Variables("WheelRB", 0, domain);
		Variables WheelLB = new Variables("WheelLB", 0, domain);
		Variables NutsRF = new Variables("NutsRF", 0, domain);
		Variables NutsLF = new Variables("NutsLF", 0, domain);
		Variables NutsRB = new Variables("NutsRB", 0, domain);
		Variables NutsLB = new Variables("NutsLB", 0, domain);
		Variables CapsRF = new Variables("CapsRF", 0, domain);
		Variables CapsLF = new Variables("CapsLF", 0, domain);
		Variables CapsRB = new Variables("CapsRB", 0, domain);
		Variables CapsLB = new Variables("CapsLB", 0, domain);
		Variables Inspect = new Variables("Inspect", 0, domain);
		Variables [] list = {AxleF, AxleB, WheelRF, WheelLF, WheelRB, WheelLB, NutsRF, NutsLF, NutsRB, NutsLB, CapsRF, CapsLF, CapsRB, CapsLB, Inspect};
		
		job.var=list;
		
		job.cons1.add("AxleF");
		job.cons2.add("WheelRF"); 
		job.cons1.add("AxleB");
		job.cons2.add("WheelRB"); 
		job.cons1.add("AxleF");
		job.cons2.add("WheelLF");
		job.cons1.add("AxleB"); 
		job.cons2.add("WheelLB");
		
		job.cons1.add("WheelRF");
		job.cons2.add("NutsRF");
		job.cons1.add("WheelLF");
		job.cons2.add("NutsLF");
		job.cons1.add("WheelRB"); 
		job.cons2.add("NutsRB");
		job.cons1.add("WheelLB");
		job.cons2.add("NutsLB");
		
		job.cons1.add("NutsRF");
		job.cons2.add("CapsRF");
		job.cons1.add("NutsLF"); 
		job.cons2.add("CapsLF");
		job.cons1.add("NutsRB");
		job.cons2.add("CapsRB");
		job.cons1.add("NutsLB");
		job.cons2.add("CapsLB");
		
		job.cons3.add("AxleF");
		job.cons4.add("AxleB");
	
		
		Solver solve = new Solver();
		job=solve.backtrack(job, 0);
		
		for(int i=0; i<job.var.length; i++){
			System.out.println("Time that task starts " + job.var[i].name + " is " + job.var[i].value + " min");
		}
		
		
	}
	
	
}
