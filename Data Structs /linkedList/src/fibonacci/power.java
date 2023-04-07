package fibonacci;

public class power {
public int createPower(int a,int n) {
	if(n==0) {
		return 1;
	}
	else
		return n*createPower(a,n-1);
	}
}

