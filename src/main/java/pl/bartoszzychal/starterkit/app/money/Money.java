package pl.bartoszzychal.starterkit.app.money;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Money {

	private final RoundingMode mode = RoundingMode.DOWN;
	private final Integer scala = 2;

	private BigDecimal value;

	public Money(BigDecimal value) {
		this.value = value;
		this.value.setScale(scala, mode);
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public Money add(Money money) {
		return new Money(value.add(money.getValue()));
	}

	public Money substract(Money money) {
		return new Money(value.subtract(money.getValue()));
	}

	public Money divide(Money money) {
		return new Money(value.divide(money.getValue()));
	}

	public Money divide(Integer divisor) {
		return divide(new Money(new BigDecimal(divisor)));
	}

	public Money multiply(Money money) {
		return new Money(value.multiply(money.getValue()));
	}

	public Money multiply(Integer multiplicand) {
		return multiply(new Money(new BigDecimal(multiplicand)));
	}

	public Money max(Money money) {
		return new Money(value.max(money.getValue()));
	}

	public Money min(Money money) {
		return new Money(value.min(money.getValue()));
	}
	
	public static Money max(Money money1, Money money2){
		return money1.max(money2);
	}
	
	public static Money min(Money money1, Money money2){
		return money1.min(money2);
	}

}
