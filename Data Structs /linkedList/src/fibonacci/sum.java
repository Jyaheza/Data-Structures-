package fibonacci;

public class sum {
public int sumNumbers(int n) {
	if(n==0) {
		return 0;
	}
	else {
		return sumNumbers(n)+sumNumbers(n+1);
	}
}
}
