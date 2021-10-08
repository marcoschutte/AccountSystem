package za.ac.nwu.ac.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.ac.domain.persistence.AccountTransaction;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@ApiModel(value = "AccountTransaction",
        description = "A DTO that represents the AccountTransaction")
public class AccountTransactionDto implements Serializable
{
    private static final long serialVersionUID = 3451690854380907957L;

    private Long amount;
    private LocalDate txDate;

    public AccountTransactionDto() {}

    public AccountTransactionDto( Long amount, LocalDate txDate)
    {
        this.amount = amount;
        this.txDate = txDate;
    }

    public AccountTransactionDto(AccountTransaction accountTransaction)
    {
        this.setAmount(accountTransaction.getAmount());
        this.setTxDate(accountTransaction.getTransactionDate());
    }

    @ApiModelProperty(position = 1,
            value = "AccountTransaction Amount",
            name = "amount",
            notes = "Transaction amount",
            dataType = "java.lang.String",
            example = "1000",
            required = true)
    public Long getAmount()
    {
        return amount;
    }
    public void setAmount(Long amount)
    {
        this.amount = amount;
    }

    @ApiModelProperty(position = 2,
            value = "AccountTransaction TX Date",
            name = "txDate",
            notes = "This is the date on which the Transaction occurred",
            dataType = "java.lang.String",
            example = "2020-01-01",
            required = true)
    public LocalDate getTxDate()
    {
        return txDate;
    }
    public void setTxDate(LocalDate txDate)
    {
        this.txDate = txDate;
    }

    @JsonIgnore
    public AccountTransaction getAccountTransaction()
    {
        return new AccountTransaction(getAmount(), getTxDate());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountTransactionDto that = (AccountTransactionDto) o;
        return Objects.equals(amount, that.amount) && Objects.equals(txDate, that.txDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, txDate);
    }

    @Override
    public String toString() {
        return "AccountTransactionDto{" +
                "amount=" + amount +
                ", txDate=" + txDate +
                '}';
    }
}
