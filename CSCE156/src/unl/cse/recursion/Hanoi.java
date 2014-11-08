package unl.cse.recursion;

public class Hanoi {

	public void hanoi(int n, String from, String tmp, String to) {
		if(n == 0)
			return;
		hanoi(n-1, from, to, tmp);
		System.out.println("Move disc " + n + " from " + from + " to " + to);
		hanoi(n-1, tmp, from, to);
	}
	
	public static void main(String args[]) {
		int n = 10;
		Hanoi h = new Hanoi();
		h.hanoi(n, "A", "B", "C");
	}
}
