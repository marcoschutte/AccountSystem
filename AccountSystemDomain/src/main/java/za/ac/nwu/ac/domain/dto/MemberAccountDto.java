package za.ac.nwu.ac.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.ac.domain.persistence.MemberAccount;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@ApiModel(value = "MemberAccount",
        description = "A DTO that represents the MemberAccount")

public class MemberAccountDto implements Serializable
{
    private static final long serialVersionUID = 7007032079510324081L;

    private String memberFirstName;
    private String memberLastName;
    private Long accountBalance;
    private LocalDate creationDate;

    public MemberAccountDto() {
    }

    public MemberAccountDto(String memberFirstName, String memberLastName, Long accountBalance, LocalDate creationDate) {
        this.memberFirstName = memberFirstName;
        this.memberLastName = memberLastName;
        this.accountBalance = accountBalance;
        this.creationDate = creationDate;
    }

    public MemberAccountDto(MemberAccount memberAccount)
    {
        this.setMemberFirstName(memberAccount.getMemberFirstName());
        this.setMemberLastName(memberAccount.getMemberLastName());
        this.setAccountBalance(memberAccount.getAccountBalance());
        this.setCreationDate(memberAccount.getCreationDate());
    }

    @ApiModelProperty(position = 1,
            value = "MemberAccount Member First Name",
            name = "memberFirstName",
            notes = "Member's first name",
            dataType = "java.lang.String",
            example = "Josh",
            required = true)
    public String getMemberFirstName()
    {
        return memberFirstName;
    }
    public void setMemberFirstName(String memberFirstName)
    {
        this.memberFirstName = memberFirstName;
    }

    @ApiModelProperty(position = 2,
            value = "MemberAccount Member Last Name",
            name = "memberLastName",
            notes = "Member's last name",
            dataType = "java.lang.String",
            example = "Jacobs",
            required = true)
    public String getMemberLastName()
    {
        return memberLastName;
    }
    public void setMemberLastName(String memberLastName)
    {
        this.memberLastName = memberLastName;
    }

    @ApiModelProperty(position = 3,
            value = "MemberAccount Account Balance",
            name = "accountBalance",
            notes = "Account's balance",
            dataType = "java.lang.String",
            example = "1000",
            required = true)
    public Long getAccountBalance()
    {
        return accountBalance;
    }
    public void setAccountBalance(Long accountBalance)
    {
        this.accountBalance = accountBalance;
    }

    @ApiModelProperty(position = 4,
            value = "MemberAccount Creation Date",
            name = "creationDate",
            notes = "Account's date of creation",
            dataType = "java.lang.String",
            example = "2020-01-01",
            required = true)
    public LocalDate getCreationDate()
    {
        return creationDate;
    }
    public void setCreationDate(LocalDate creationDate)
    {
        this.creationDate = creationDate;
    }

    @JsonIgnore
    public MemberAccount getMemberAccount()
    {
        return new MemberAccount(getMemberFirstName(), getMemberLastName(), getAccountBalance(), getCreationDate());
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemberAccountDto that = (MemberAccountDto) o;
        return Objects.equals(memberFirstName, that.memberFirstName) && Objects.equals(memberLastName, that.memberLastName) && Objects.equals(accountBalance, that.accountBalance) && Objects.equals(creationDate, that.creationDate);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(memberFirstName, memberLastName, accountBalance, creationDate);
    }

    @Override
    public String toString()
    {
        return "MemberAccountDto{" +
                "memberFirstName='" + memberFirstName + '\'' +
                ", memberLastName='" + memberLastName + '\'' +
                ", accountBalance=" + accountBalance +
                ", creationDate=" + creationDate +
                '}';
    }
}
