package s1_c3_bigO;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class AddUpToN2 {

	public long addUpToN(final long n) {
		return (n * (n + 1)) / 2;
	}

	public static void main(final String[] args) {
		final AddUpToN2 addUpToN2 = new AddUpToN2();
		final LocalDateTime before = LocalDateTime.now();
		System.out.println("Result : " + addUpToN2.addUpToN(100000000)); // 5000000050000000
		final LocalDateTime after = LocalDateTime.now();
		System.out.println("Time : " + ChronoUnit.MILLIS.between(before, after)); // 9
	}
}
