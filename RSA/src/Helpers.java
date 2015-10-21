import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;


public class Helpers {
    BigInteger oneVal = BigInteger.ONE;
    BigInteger zeroVal = BigInteger.ZERO;
    
	public static BigInteger findInverse(BigInteger a, BigInteger b) {
		
		BigInteger temp = BigInteger.ZERO;
		BigInteger a0 = a;
		BigInteger b0 = b;
		BigInteger t0 = BigInteger.ZERO;
		BigInteger t = BigInteger.ONE;
		BigInteger s0 = BigInteger.ONE;
		BigInteger s = BigInteger.ZERO;

		BigInteger q = a0.divide(b0);
		BigInteger temp2 = q.multiply(b);
		BigInteger r = a0.subtract(temp2);

		while (r.compareTo(BigInteger.ZERO) == 1) {
			temp = t0.subtract(q.multiply(t));
			t0 = t;
			t = temp;
			temp = s0.subtract(q.multiply(s));
			s0 = s;
			s = temp;
			a0 = b0;
			b0 = r;
			q = a0.divide(b0);
			r = a0.subtract(q.multiply(b0));
		}

		return s;
	}
	
	private static BigInteger sqrt(BigInteger n) {
		  BigInteger a = BigInteger.ONE;
		  BigInteger b = new BigInteger(n.shiftRight(5).add(new BigInteger("8")).toString());
		  while(b.compareTo(a) >= 0) {
		    BigInteger mid = new BigInteger(a.add(b).shiftRight(1).toString());
		    if(mid.multiply(mid).compareTo(n) > 0) 
		    	b = mid.subtract(BigInteger.ONE);
		    else 
		    	a = mid.add(BigInteger.ONE);
		  }
		  return a.subtract(BigInteger.ONE);
	}
	
	public BigInteger[] fermat(BigInteger n){
		BigInteger a = sqrt(n);
		a = a.add(BigInteger.ONE);//Ceiling Function??
		BigInteger aSquared = a.multiply(a);
		
		BigInteger bSquared = aSquared.subtract(n);

		
		while(!isSquare(bSquared)){
            a=a.add(BigInteger.ONE);
            bSquared = a.multiply(a).subtract(n);
		}

		BigInteger root1,root2;
		root1 = a.subtract(sqrt(bSquared));
		root2 = n.divide(root1);
		BigInteger[] set = new BigInteger[2];
		System.out.println("Root1 "+root1 +"and root 2 "+root2);
		set[0]=root1;
		set[1]=root2;
		
		return set;
	}
	
	
	int PerfectSquareOrNot(int number) 
	{ 
		int high = number/2; 
		int low = 0; 
		while(high>=low) { 
				int mid = (low + high)/2; 
				int square = mid * mid; 
				if(square==number) { 
						return mid; 
				} 
				if(square > number){ 
						high = mid-1; 
				} else{ 
					low = mid+1; 
				} 
		} 
		return 1; 
	} 
	
	
    public boolean isSquare(BigInteger n)
    {
    	BigInteger sqr = zeroVal.subtract(oneVal);
 
         if (n.compareTo(BigInteger.ZERO) == -1)
         {
             return false;
         }
         else if(n.compareTo(BigInteger.ZERO)==0 || n.compareTo(BigInteger.ONE) == 0)
         {
             sqr = n;
             return true;
         }
         //Find the lower and upper limits

         BigInteger lower = BigInteger.ONE;
         BigInteger upper = lower.add(lower);
         
         
         
         while( n.compareTo(lower.multiply(lower)) == -1 || n.compareTo(upper.multiply(upper)) ==1)
         {
        	 
             lower = upper;
             upper = upper.multiply(upper);
         }
        
         //Binary search
         while (lower.add(oneVal).compareTo(upper)==-1)
         {
             BigInteger mid = (lower.add(upper)).divide(oneVal.add(oneVal));
        
             BigInteger midSq = mid.multiply(mid);
             if (midSq == n)
             {
                 sqr = mid;
                 return true;
             }
             else if (midSq.compareTo(n) ==-1)
             {
                 upper = mid;
             }
             else
             {
                 lower = mid;
             }
         }
         return false;
    }
	
}
