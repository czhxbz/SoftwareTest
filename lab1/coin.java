public class coin {

	int[] coins;
	
	 public coin(int[] a){
		 coins = a;
	 }

	 public boolean takeout(int[] a,int n) {
		 
		 	if(n < 0) {
		 		return false;
		 	}

	        boolean[] dp = new boolean[n+1];
	        
	        dp[0] = true;

	        for (int i = 1; i < a.length; i++) {

	            for (int j = n; j >= a[i]; j--) {

	                if (dp[j - a[i]]) {

	                    dp[j] = true;

	                }

	            }

	            if (dp[n]) {

	                return true;

	            }

	        }

	        return false;

	    }

	 
	    public static void main(String[] args){
	    	int[] a = {1,1,1,5,5,20,50};
	    	coin test = new coin(a);
	    	System.out.println(test.takeout(test.coins,4));
	    }
}