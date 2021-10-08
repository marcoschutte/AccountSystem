package za.ac.nwu.ac.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "MEMBER_ACCOUNT", schema = "hr")
public class MemberAccount implements Serializable
{
    private static final long serialVersionUID = 8969055249868984671L;

    private Long memberId;
    private String memberFirstName;
    private String memberLastName;
    private Long accountBalance;
    private LocalDate creationDate;

    private Set<AccountTransaction> accountTransactions;

    public MemberAccount() {}

    public MemberAccount(Long memberId, String memberFirstName, String memberLastName, Long accountBalance, LocalDate creationDate)
    {
        this.memberId = memberId;
        this.memberFirstName = memberFirstName;
        this.memberLastName = memberLastName;
        this.accountBalance = accountBalance;
        this.creationDate = creationDate;
    }

    public MemberAccount(String memberFirstName, String memberLastName, Long accountBalance, LocalDate creationDate)
    {
        this.memberFirstName = memberFirstName;
        this.memberLastName = memberLastName;
        this.accountBalance = accountBalance;
        this.creationDate = creationDate;
    }

    @Id
    @SequenceGenerator(name = "MEMBER_ACCOUNT_SEQ",sequenceName = "HR.MEMBER_ACCOUNT_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MEMBER_ACCOUNT_SEQ")

    @Column(name = "MEMBER_ID")
    public Long getMemberId()
    {
        return memberId;
    }
    public void setMemberId(Long memberId)
    {
        this.memberId = memberId;
    }

    @Column(name = "MEMBER_FIRST_NAME")
    public String getMemberFirstName()
    {
        return memberFirstName;
    }
    public void setMemberFirstName(String memberFirstName)
    {
        this.memberFirstName = memberFirstName;
    }

    @Column(name = "MEMBER_LAST_NAME")
    public String getMemberLastName()
    {
        return memberLastName;
    }
    public void setMemberLastName(String memberLastName)
    {
        this.memberLastName = memberLastName;
    }

    @Column(name = "ACCOUNT_BALANCE")
    public Long getAccountBalance()
    {
        return accountBalance;
    }
    public void setAccountBalance(Long accountBalance)
    {
        this.accountBalance = accountBalance;
    }

    @Column(name = "CREATION_DATE")
    public LocalDate getCreationDate()
    {
        return creationDate;
    }
    public void setCreationDate(LocalDate creationDate)
    {
        this.creationDate = creationDate;
    }

    @OneToMany(targetEntity = AccountTransaction.class, fetch = FetchType.LAZY, mappedBy = "memberId", orphanRemoval = true, cascade = CascadeType.PERSIST)
    public Set<AccountTransaction> getAccountTransactions()
    {
        return accountTransactions;
    }

    public void setAccountTransactions(Set<AccountTransaction> accountTransactions)
    {
        this.accountTransactions = accountTransactions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemberAccount that = (MemberAccount) o;
        return Objects.equals(memberId, that.memberId) && Objects.equals(memberFirstName, that.memberFirstName) && Objects.equals(memberLastName, that.memberLastName) && Objects.equals(accountBalance, that.accountBalance) && Objects.equals(creationDate, that.creationDate) && Objects.equals(accountTransactions, that.accountTransactions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberId, memberFirstName, memberLastName, accountBalance, creationDate, accountTransactions);
    }

    @Override
    public String toString() {
        return "MemberAccount{" +
                "memberId=" + memberId +
                ", memberFirstName='" + memberFirstName + '\'' +
                ", memberLastName='" + memberLastName + '\'' +
                ", accountBalance=" + accountBalance +
                ", creationDate=" + creationDate +
                ", accountTransactions=" + accountTransactions +
                '}';
    }
}


