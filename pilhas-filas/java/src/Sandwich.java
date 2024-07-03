import java.util.LinkedList;
import java.util.Queue;

public class Sandwich {

	public static int countStudents(int[] students, int[] sandwiches) {

		Queue<Integer> queue = new LinkedList<>();
		for (int student : students) {
			queue.add(student);
		}

		for (int sandwich : sandwiches) {

			boolean eat = false;
			int count = queue.size();

			while (!eat && count > 0) {
				int student = queue.poll();
				if (student == sandwich) {
					eat = true;
				} else {
					queue.add(student);
					count--;
				}
			}
			
			if (count == 0) {
				return queue.size();
			}
		}

		return 0;
    }    

	public static void main(String[] args) {
		System.out.println(countStudents(new int[] { 1, 1, 0, 0 }, new int[] { 0, 1, 0, 1 }));
		System.out.println(countStudents(new int[] { 1, 1, 1, 0, 0, 1 }, new int[] { 1, 0, 0, 0, 1, 1 }));
	}
}
