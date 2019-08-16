
public class Prime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = { 2, 3, 19, 23, 13, 7, 22 ,11};
		
		
		for (int i = 0; i < array.length; i++) {
			int number = array[i];
				int temp = number;
				int sum = 0;
				
				while (temp != 0) {
					sum = sum + temp % 10;
					temp = temp / 10;
				}
				
				int flag = isPrime(sum);
				
				if (flag == 0) {
					System.out.println(number);
				}
		}
	}

	public static int isPrime(int num) {
		int flag = 0;
		for (int j = 2; j <= num / 2; j++) {
			if (num % j == 0) {
				flag++;
			}
		}
		return flag;
	}
}
