package br.com.valid.bio.conveniadas.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

@Document(collection="TokenCollection")
public class OauthTokenData implements Base<String>{

	@Id
	private String id; 
	
	@JsonProperty(value="access_token")
	private String accessToken; 
	
	private String idToken;
	
	@JsonProperty(value="token_type")
	private String tokenType;
	
	@JsonProperty(value="expires_in")
	private long expires;
	
	@JsonProperty(value="created_in")
	private long createdIn;
	
	
	public OauthTokenData() {}

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public OauthTokenData(String accessToken){
		this.accessToken = accessToken;
	}
	
	public OauthTokenData(String accessToken , String idToken){
		this(accessToken);
		this.idToken = idToken;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getIdToken() {
		return idToken;
	}

	public void setIdToken(String idToken) {
		this.idToken = idToken;
	}

	public String getTokenType() {
		return tokenType;
	}

	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}

	public long getExpires() {
		return expires;
	}

	public void setExpires(long expires) {
		this.expires = expires;
	}

	public long getCreatedIn() {
		return createdIn;
	}

	public void setCreatedIn(long createdIn) {
		this.createdIn = createdIn;
	}

	@Override
	public String toString() {
		return "OauthTokenData [id=" + id + ", accessToken=" + accessToken + ", idToken=" + idToken + ", tokenType="
				+ tokenType + ", expires=" + expires + ", createdIn=" + createdIn + "]";
	}
	
}
