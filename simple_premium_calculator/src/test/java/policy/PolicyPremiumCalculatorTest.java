package policy;

import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


import policy.object.PolicyObject;
import policy.object.PolicyObjectType;

@RunWith(MockitoJUnitRunner.class)
public class PolicyPremiumCalculatorTest {

	@Mock
	private Policy policy;
	@Mock
	private PolicyObject policyObject;

	@InjectMocks
	public PremiumCalculator premiumCalculatorTest;
	@InjectMocks
	private Policy policyTest;

	@Test
	public void calculatesZeroPremiumWhenNoObjectsExist() {
		given(policy.getPolicyObjects()).willReturn(emptyList());

		BigDecimal premium = premiumCalculatorTest.calculate(policy);

		assertThat(premium).isZero();
	}

	@Test
	public void calculatesPolicyPremium() {
		given(policy.getPolicyObjects()).willReturn(singletonList(policyObject));
		given(policyObject.getSumInsured()).willReturn(BigDecimal.TEN);

		BigDecimal premium = premiumCalculatorTest.calculate(policy);

		assertThat(premium).isEqualTo(BigDecimal.TEN);
	}

	@Test
	public void checkObjectIsVehicle() {
		given(policy.getPolicyObjects()).willReturn(singletonList(policyObject));
		given(policyObject.getPolicyObject()).willReturn(PolicyObjectType.VEHICLE);

		policyTest = policy;
		PolicyObjectType object = policyTest.getPolicyObjects().get(0).getPolicyObject();

		assertThat(object).isEqualTo(PolicyObjectType.VEHICLE);
	}

	@Test
	public void checkObjectIsRealEstate() {
		given(policy.getPolicyObjects()).willReturn(singletonList(policyObject));
		given(policyObject.getPolicyObject()).willReturn(PolicyObjectType.REAL_ESTATE);

		policyTest = policy;

		PolicyObjectType object = policyTest.getPolicyObjects().get(0).getPolicyObject();

		assertThat(object).isEqualTo(PolicyObjectType.REAL_ESTATE);
	}

}