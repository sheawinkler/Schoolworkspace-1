package unl.cse.hw;

public class Encrypt {

	public static void main(String args[]) {
		
		if(args.length != 2) {
			System.err.println("Usage: m phrase");
			System.exit(1);
		}
		
		int m = Integer.parseInt(args[0]);
		StringBuilder s = new StringBuilder(args[1]);

		int n = s.length();
		StringBuilder result = new StringBuilder();

		int index = 0;
		for(int i=0; i<n; i++) {
			index = (index + m) % s.length();
			char c = s.charAt(index);
			for(int j=index; j<s.length()-1; j++) {
				s.setCharAt(j, s.charAt(j+1));
			}
			String tmp = s.toString();
			s = new StringBuilder(tmp.substring(0, tmp.length()-1));
			result.append(c);			
		}
		System.out.println(result.toString());
	}
}
