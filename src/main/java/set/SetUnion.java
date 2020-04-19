package set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetUnion{
	
	public static <T> List<T> union(List<T> l1, List<T> l2){
		Set<T> s1 = new HashSet<T>(l1);
		Set<T> s2 = new HashSet<T>(l2);
		
		s1.addAll(s2);
		
		return (List<T>) new ArrayList<T>(s1);
	}

}
