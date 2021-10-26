package policy.object;

import java.math.BigDecimal;

public class PolicyObject {

	private BigDecimal sumInsured;
	private PolicyObjectType policyObject;

	public PolicyObject(BigDecimal sumInsured, PolicyObjectType policyObject) {
		this.sumInsured = sumInsured;
		this.policyObject = policyObject;
	}

	public BigDecimal getSumInsured() {
		return sumInsured;
	}

	public void setSumInsured(BigDecimal sumInsured) {
		this.sumInsured = sumInsured;
	}

	public PolicyObjectType getPolicyObject() {
		return policyObject;
	}

	public void setPolicyObject(PolicyObjectType policyObject) {
		this.policyObject = policyObject;
	}
}
