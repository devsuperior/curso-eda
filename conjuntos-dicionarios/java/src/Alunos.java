import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Alunos {

	public static int studentsCount(List<List<Integer>> courses) {
		
		var allStudents = new HashSet<>();
		
		for (List<Integer> course : courses) {
			Set<Integer> courseStudents = new HashSet<>(course);
			allStudents.addAll(courseStudents);
		}
		
		return allStudents.size();
	}
	
	public static void main(String[] args) {
		List<List<Integer>> courseList = new ArrayList<List<Integer>>(Arrays.asList(
	            new ArrayList<Integer>(Arrays.asList(15, 21, 80, 42)),
	            new ArrayList<Integer>(Arrays.asList(21, 80, 47)),
	            new ArrayList<Integer>(Arrays.asList(12, 21, 47, 35))
	        ));
		
		int result = studentsCount(courseList);
		System.out.println("Total students = " + result);
	}
}
