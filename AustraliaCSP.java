import java.util.HashSet;

public class AustraliaCSP {

	public static void amaptraliaMap() {
		
		CSP amap = new CSP();
		
		//domain
		HashSet<String> domain = new HashSet();
		domain.add("RED");
		domain.add("GREEN");
		domain.add("BLUE");
		
		//variables
		Variables WA = new Variables("WA", null, domain);
		Variables Q = new Variables("Q", null, domain);
		Variables NSW = new Variables("NSW", null, domain);
		Variables T = new Variables("T", null, domain);
		Variables V = new Variables("V", null, domain);
		Variables NT = new Variables("NT", null, domain);
		Variables SA = new Variables("SA", null, domain);
		
		Variables [] list = {WA, NT, Q, NSW, V, SA, T};
		
		//constraints
		amap.var=list;
		amap.cons1.add("WA");
		amap.cons2.add("NT");
		amap.cons1.add("WA");
		amap.cons2.add("SA");
		
		amap.cons1.add("NT");
		amap.cons2.add("Q");
		amap.cons1.add("NT");
		amap.cons2.add("SA");
		
		amap.cons1.add("Q");
		amap.cons2.add("SA");
		amap.cons1.add("Q");
		amap.cons2.add("NSW");
		
		amap.cons1.add("NSW");
		amap.cons2.add("SA");
		amap.cons1.add("NSW");
		amap.cons2.add("V");
		
		amap.cons1.add("SA");
		amap.cons2.add("V");
		
		Solver solve= new Solver();
		amap=solve.backtrack(amap);
		for(int i=0; i<amap.var.length; i++){//print result
			System.out.println(amap.var[i].name + "=" + amap.var[i].assimt);
		}
		
	}
	
}
