package dto;

import java.sql.Timestamp;

public class Account {
	//アカウント用の変数宣言
	private Integer accountId;

	private String accountLoginId;

	private String accountPassword;

	private String accountMail;

	private String accountName;

	private Timestamp accountAddDate;

	private String accountRoll;

	private Integer count;

	//ゲッター・セッター
	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public String getAccountLoginId() {
		return accountLoginId;
	}

	public void setAccountLoginId(String accountLoginId) {
		this.accountLoginId = accountLoginId;
	}

	public String getAccountPassword() {
		return accountPassword;
	}

	public void setAccountPassword(String accountPassword) {
		this.accountPassword = accountPassword;
	}

	public String getAccountMail() {
		return accountMail;
	}

	public void setAccountMail(String accountMail) {
		this.accountMail = accountMail;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public Timestamp getAccountAddDate() {
		return accountAddDate;
	}

	public void setAccountAddDate(Timestamp accountAddDate) {
		this.accountAddDate = accountAddDate;
	}

	public String getAccountRoll() {
		return accountRoll;
	}

	public void setAccountRoll(String accountRoll) {
		this.accountRoll = accountRoll;
	}

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
