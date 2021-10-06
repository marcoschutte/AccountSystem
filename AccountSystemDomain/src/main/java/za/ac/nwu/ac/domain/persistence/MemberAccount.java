package za.ac.nwu.ac.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "MEMBER_ACCOUNT", schema = "HR")
public class MemberAccount implements Serializable {

    private Long accountId;
    private Long memberId;
    private Long accountTypeId;
    private Long accountBalance;
    private LocalDate creationDate;

    public MemberAccount() {
    }

    public MemberAccount(Long memberId, Long accountTypeId, Long accountBalance, LocalDate creationDate) {
        this.memberId = memberId;
        this.accountTypeId = accountTypeId;
        this.accountBalance = accountBalance;
        this.creationDate = creationDate;
    }

    public MemberAccount(Long accountId, Long memberId, Long accountTypeId, Long accountBalance, LocalDate creationDate) {
        this.accountId = accountId;
        this.memberId = memberId;
        this.accountTypeId = accountTypeId;
        this.accountBalance = accountBalance;
        this.creationDate = creationDate;
    }

    @Id
    @SequenceGenerator(name = "MEMBER_ACCOUNT_SEQ",sequenceName = "HR.MEMBER_ACCOUNT_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MEMBER_ACCOUNT_SEQ")

    @Column(name = "ACCOUNT_ID")
    public Long getAccountId() { return accountId; }

    @Column(name = "MEMBER_ID")
    public Long getMemberId() { return memberId; }

    @Column(name = "ACCOUNT_TYPE_ID")
    public Long getAccountTypeId() { return accountTypeId; }

    @Column(name = "ACCOUNT_BALANCE")
    public Long getAccountBalance() { return accountBalance; }

    @Column(name = "CREATION_DATE")
    public LocalDate getCreationDate() { return creationDate; }

    public void setAccountId(Long accountId) { this.accountId = accountId; }
    public void setMemberId(Long memberId) { this.memberId = memberId; }
    public void setAccountTypeId(Long accountTypeId) { this.accountTypeId = accountTypeId; }
    public void setAccountBalance(Long accountBalance) { this.accountBalance = accountBalance; }
    public void setCreationDate(LocalDate creationDate) { this.creationDate = creationDate; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemberAccount that = (MemberAccount) o;
        return Objects.equals(accountId, that.accountId) && Objects.equals(memberId, that.memberId) && Objects.equals(accountTypeId, that.accountTypeId) && Objects.equals(accountBalance, that.accountBalance) && Objects.equals(creationDate, that.creationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, memberId, accountTypeId, accountBalance, creationDate);
    }

    @Override
    public String toString() {
        return "MemberAccount{" +
                "accountId=" + accountId +
                ", memberId=" + memberId +
                ", accountTypeId=" + accountTypeId +
                ", accountBalance=" + accountBalance +
                ", creationDate=" + creationDate +
                '}';
    }
}
