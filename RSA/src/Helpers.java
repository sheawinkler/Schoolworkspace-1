import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;


public class Helpers {
    BigInteger oneVal = BigInteger.ONE;
    BigInteger zeroVal = BigInteger.ZERO;
    

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

		while(PerfectSquare(bSquared).compareTo(oneVal)==1||PerfectSquare(bSquared).compareTo(oneVal)==-1){
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

	
	BigInteger PerfectSquare(BigInteger number) 
	{ 
		BigInteger high = number.divide(oneVal.add(oneVal)); 
		BigInteger low = zeroVal; 
		while(high.compareTo(low)==0||high.compareTo(low) ==1){
			BigInteger mid = low.add(high).divide(oneVal.add(oneVal));
			BigInteger square = mid.multiply(mid);
			if(square.compareTo(number)==0){
				return mid;
			}
			if(square.compareTo(number) ==1){
				high = mid.subtract(oneVal);
			}
		}
		return oneVal; 
	} 
	
	int PerfectSquareOrNot(int number) 
	{ 
	int high = number/2; 
	int low = 0; 
	while(high>=low) 
	{ 
	int mid = (low + high)/2; 
	int square = mid * mid; 
	if(square==number) 
	{ 
	return mid; 
	} 
	if(square > number) 
	{ 
	high = mid-1; 
	} 
	else 
	{ 
	low = mid+1; 
	} 
	} 
	return 0; 
	} 
	
   
	
}
