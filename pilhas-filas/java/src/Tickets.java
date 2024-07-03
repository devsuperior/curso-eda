import java.util.LinkedList;
import java.util.Queue;

class Tickets {
	public static int timeRequiredToBuy(int[] tickets, int k) {

		Queue<Integer> queue = new LinkedList<>();
		int n = tickets.length;

		for (int i = 0; i < n; i++) {
			queue.add(i);
		}

		int result = 0;
		while (true) {
			int i = queue.poll();
			tickets[i]--;
			result++;
			if (tickets[i] > 0) {
				queue.add(i);
			} else if (i == k) {
				return result;
			}
		}
	}

	public static void main(String[] args) {
		System.out.println(timeRequiredToBuy(new int[] { 2, 3, 2 }, 2));
		System.out.println(timeRequiredToBuy(new int[] { 5, 1, 1, 1 }, 0));
	}
}
