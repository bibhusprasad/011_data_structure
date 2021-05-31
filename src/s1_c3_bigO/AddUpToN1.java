package s1_c3_bigO;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class AddUpToN1 {

	public long addUpToN(final long n) {
		long sum = 0;
		for (int i = 1; i <= n; i++) {
			sum = sum + i;
		}
		return sum;
	}

	public static void main(final String[] args) {
		final AddUpToN1 addUpToN1 = new AddUpToN1();
		final LocalDateTime before = LocalDateTime.now();
		System.out.println("Result : " + addUpToN1.addUpToN(100000000)); // 5000000050000000
		final LocalDateTime after = LocalDateTime.now();
		System.out.println("Time : " + ChronoUnit.MILLIS.between(before, after)); // 64
	}
}
