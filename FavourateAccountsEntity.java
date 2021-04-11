package com.hcl.account.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TBL_FAVOURATE_ACCOUNTS")
public class FavourateAccountsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="payee_account_number")
    private Long payeeAcctNumber;
    
    @Column(name="account_holder_name")
    private String accHolderName ;
    
    @Column(name="bank_name")
    private String bankName;
    
    @Column(name="account_id")
    private Long accountId;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the payeeAcctNumber
	 */
	public Long getPayeeAcctNumber() {
		return payeeAcctNumber;
	}

	/**
	 * @param payeeAcctNumber the payeeAcctNumber to set
	 */
	public void setPayeeAcctNumber(Long payeeAcctNumber) {
		this.payeeAcctNumber = payeeAcctNumber;
	}

	/**
	 * @return the accHolderName
	 */
	public String getAccHolderName() {
		return accHolderName;
	}

	/**
	 * @param accHolderName the accHolderName to set
	 */
	public void setAccHolderName(String accHolderName) {
		this.accHolderName = accHolderName;
	}

	/**
	 * @return the bankName
	 */
	public String getBankName() {
		return bankName;
	}

	/**
	 * @param bankName the bankName to set
	 */
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	/**
	 * @return the accountId
	 */
	public Long getAccountId() {
		return accountId;
	}

	/**
	 * @param accountId the accountId to set
	 */
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	
   
}