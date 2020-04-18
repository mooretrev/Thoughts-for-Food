package set;

import java.util.List;
import java.util.Set;

public class SetUnion{
	
	public static <T> List<T> union(List<T> l1, List<T> l2){
		Set<T> s1 = (Set<T>) l1;
		Set<T> s2 = (Set<T>) l2;
		
		s1.addAll(s2);
		
		return (List<T>) s1;
	}

}
