package com.ia.restfulstudentservices.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import javax.persistence.Id;

@Entity
@Table(name = "PAYMENT_INFO")
public class Payment {
	
	@Id
	@Column(name = "PAYMENT_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "created_on")
    private Date createdOn;
	
	@Column(name = "updated_on")
    private Date updatedOn;
	
	private BigDecimal paymentOpeningPayment;
	
	private BigDecimal paymentReceivedAmount;
	
	private BigDecimal paymentOutstandingBalanceAmount;
	
	private String payment_method;
	
	private String paymentCreditCardNumber;
	
	private String paymentCreditCardExp;
	
	private int paymentCreditCardCecurityCode;

	public Payment() {
	}

	public Payment(BigDecimal paymentOpeningPayment, BigDecimal paymentReceivedAmount,
			BigDecimal paymentOutstandingBalanceAmount, String payment_method, String paymentCreditCardNumber,
			String paymentCreditCardExp, int paymentCreditCardCecurityCode) {
		this.createdOn = new Date();
		this.paymentOpeningPayment = paymentOpeningPayment;
		this.paymentReceivedAmount = paymentReceivedAmount;
		this.paymentOutstandingBalanceAmount = paymentOutstandingBalanceAmount;
		this.payment_method = payment_method;
		this.paymentCreditCardNumber = paymentCreditCardNumber;
		this.paymentCreditCardExp = paymentCreditCardExp;
		this.paymentCreditCardCecurityCode = paymentCreditCardCecurityCode;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public BigDecimal getPaymentOpeningPayment() {
		return paymentOpeningPayment;
	}

	public void setPaymentOpeningPayment(BigDecimal paymentOpeningPayment) {
		this.paymentOpeningPayment = paymentOpeningPayment;
	}

	public BigDecimal getPaymentReceivedAmount() {
		return paymentReceivedAmount;
	}

	public void setPaymentReceivedAmount(BigDecimal paymentReceivedAmount) {
		this.paymentReceivedAmount = paymentReceivedAmount;
	}

	public BigDecimal getPaymentOutstandingBalanceAmount() {
		return paymentOutstandingBalanceAmount;
	}

	public void setPaymentOutstandingBalanceAmount(BigDecimal paymentOutstandingBalanceAmount) {
		this.paymentOutstandingBalanceAmount = paymentOutstandingBalanceAmount;
	}

	public String getPayment_method() {
		return payment_method;
	}

	public void setPayment_method(String payment_method) {
		this.payment_method = payment_method;
	}

	public String getPaymentCreditCardNumber() {
		return paymentCreditCardNumber;
	}

	public void setPaymentCreditCardNumber(String paymentCreditCardNumber) {
		this.paymentCreditCardNumber = paymentCreditCardNumber;
	}

	public String getPaymentCreditCardExp() {
		return paymentCreditCardExp;
	}

	public void setPaymentCreditCardExp(String paymentCreditCardExp) {
		this.paymentCreditCardExp = paymentCreditCardExp;
	}

	public int getPaymentCreditCardCecurityCode() {
		return paymentCreditCardCecurityCode;
	}

	public void setPaymentCreditCardCecurityCode(int paymentCreditCardCecurityCode) {
		this.paymentCreditCardCecurityCode = paymentCreditCardCecurityCode;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Payment [id=");
		builder.append(id);
		builder.append(", createdOn=");
		builder.append(createdOn);
		builder.append(", updatedOn=");
		builder.append(updatedOn);
		builder.append(", paymentOpeningPayment=");
		builder.append(paymentOpeningPayment);
		builder.append(", paymentReceivedAmount=");
		builder.append(paymentReceivedAmount);
		builder.append(", paymentOutstandingBalanceAmount=");
		builder.append(paymentOutstandingBalanceAmount);
		builder.append(", payment_method=");
		builder.append(payment_method);
		builder.append(", paymentCreditCardNumber=");
		builder.append(paymentCreditCardNumber);
		builder.append(", paymentCreditCardExp=");
		builder.append(paymentCreditCardExp);
		builder.append(", paymentCreditCardCecurityCode=");
		builder.append(paymentCreditCardCecurityCode);
		builder.append("]");
		return builder.toString();
	}

}
