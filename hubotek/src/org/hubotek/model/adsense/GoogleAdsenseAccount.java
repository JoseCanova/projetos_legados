package org.hubotek.model.adsense;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import org.hubotek.model.AccountStatusEnum;
import org.nanotek.Base;


/**
 * 
 * @author JoseCanova
 *
 */
@Entity
@SuppressWarnings("serial")
public class GoogleAdsenseAccount implements Base<String>{

	//Editor ID.
	@Id
	private String id;

	@Column(name="client_id" , length=20 , insertable=true , updatable=true)
	private String clientId; 
	
	@Enumerated(EnumType.STRING)
	private AccountStatusEnum accountStatus;
	
	public GoogleAdsenseAccount(){}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public AccountStatusEnum getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(AccountStatusEnum accountStatus) {
		this.accountStatus = accountStatus;
	} 
	
	
}
