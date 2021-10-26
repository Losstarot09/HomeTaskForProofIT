package policy;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Builder
@Getter
public class PremiumCalculator {

	public BigDecimal calculate(Policy policy) {
		if (policy.getPolicyObjects().isEmpty()) {
			return BigDecimal.ZERO;
		} else {
			BigDecimal sum = BigDecimal.ZERO;
			for (int i = 0; i < policy.getPolicyObjects().size(); i++) {
				sum = sum.add(policy.getPolicyObjects().get(i).getSumInsured());
			}
			return sum;
		}
	}

}
