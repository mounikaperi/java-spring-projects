package com.ocp17.collections;

import java.util.Objects;

public class Visitor implements Comparable<Visitor> {
	
	private int visitorId;
	private String fullName;
	private String mailId;
	private double fee;
	
	public Visitor() {
		
	}

	public Visitor(int visitorId, String fullName, String mailId, double fee) {
		super();
		this.visitorId = visitorId;
		this.fullName = fullName;
		this.mailId = mailId;
		this.fee = fee;
	}

	public int getVisitorId() {
		return visitorId;
	}

	public void setVisitorId(int visitorId) {
		this.visitorId = visitorId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	public double getFee() {
		return fee;
	}

	public void setFee(double fee) {
		this.fee = fee;
	}

	@Override
	public String toString() {
		return "Visitor [visitorId=" + visitorId + ", fullName=" + fullName + ", mailId=" + mailId + ", fee=" + fee
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(fee, fullName, mailId, visitorId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Visitor other = (Visitor) obj;
		return Double.doubleToLongBits(fee) == Double.doubleToLongBits(other.fee)
				&& Objects.equals(fullName, other.fullName) && Objects.equals(mailId, other.mailId)
				&& visitorId == other.visitorId;
	}

	public int compareTo(Visitor o) {
		return ((Integer)this.visitorId).compareTo(o.visitorId);
	}
	
}
