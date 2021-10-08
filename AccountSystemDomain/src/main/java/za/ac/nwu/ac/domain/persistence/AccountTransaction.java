package za.ac.nwu.ac.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name= "ACCOUNT_TX",schema = "hr")
public class AccountTransaction implements Serializable {

    private static final long serialVersionUID = 4396972763730556717L;

    private Long accountTxId;
    private Long accountTypeId;
    private Long memberId;
    private Long transactionAmount;
    private LocalDate transactionDate;

    public AccountTransaction() {}

    public AccountTransaction(Long memberId, Long amount, LocalDate txDate)
    {
        this.memberId = memberId;
        this.transactionAmount = amount;
        this.transactionDate = txDate;
    }

    public AccountTransaction(Long accountTxId, Long accountTypeId, Long memberId, Long amount, LocalDate transactionDate)
    {
        this.accountTxId = accountTxId;
        this.accountTypeId = accountTypeId;
        this.memberId = memberId;
        this.transactionAmount = amount;
        this.transactionDate = transactionDate;
    }

    @Id
    @SequenceGenerator(name = "ACCOUNT_TX_SEQ",sequenceName = "HR.ACCOUNT_TX_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACCOUNT_TX_SEQ")

    @Column(name="ACCOUNT_TX_ID")
    public Long getAccountTxId()
    {
        return accountTxId;
    }
    public void setAccountTxId(Long accountTxId)
    {
        this.accountTxId = accountTxId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ACCOUNT_TYPE_ID")
    public Long getAccountTypeId()
    {
        return accountTypeId;
    }
    public void setAccountTypeId(Long accountTypeId)
    {
        this.accountTypeId = accountTypeId;
    }

    @Column(name = "MEMBER_ID")
    public Long getMemberId()
    {
        return memberId;
    }
    public void setMemberId(Long memberId)
    {
        this.memberId = memberId;
    }

    @Column(name = "AMOUNT")
    public Long getAmount()
    {
        return transactionAmount;
    }
    public void setAmount(Long amount)
    {
        this.transactionAmount = amount;
    }

    @Column(name = "TX_DATE")
    public LocalDate getTransactionDate()
    {
        return transactionDate;
    }
    public void setTransactionDate(LocalDate transactionDate)
    {
        this.transactionDate = transactionDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountTransaction that = (AccountTransaction) o;
        return Objects.equals(accountTxId, that.accountTxId) && Objects.equals(accountTypeId, that.accountTypeId) && Objects.equals(memberId, that.memberId) && Objects.equals(transactionAmount, that.transactionAmount) && Objects.equals(transactionDate, that.transactionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountTxId, accountTypeId, memberId, transactionAmount, transactionDate);
    }

    @Override
    public String toString() {
        return "AccountTransaction{" +
                "accountTxId=" + accountTxId +
                ", accountTypeId=" + accountTypeId +
                ", memberId=" + memberId +
                ", transactionAmount=" + transactionAmount +
                ", transactionDate=" + transactionDate +
                '}';
    }
}
