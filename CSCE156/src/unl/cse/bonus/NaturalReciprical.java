package unl.cse.bonus;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Solve the following problem: Given n, k determine all solutions that satisfy the following:
 * x_1 + ... + x_k = n AND
 * 1 / x_1 + ... 1 / x_k = 1
 * @author cbourke
 *
 */
public class NaturalReciprical {

	private static final Map<Integer, Boolean> hasSolution = new HashMap<Integer, Boolean>();
	private static final Set<List<Integer>> solutions = new HashSet<List<Integer>>();
	private final Integer n;
	private final Integer k;
	
	public NaturalReciprical(Integer n, Integer k) {
		this.n = n;
		this.k = k;
	}
	
	public void solve() {
		solve(n);
	}
	
	private void solve(int n) {
		
	}
	
	public static void main(String args[]) {
		NaturalReciprical nr = new NaturalReciprical(100, 10);
		nr.solve();
	}
}
