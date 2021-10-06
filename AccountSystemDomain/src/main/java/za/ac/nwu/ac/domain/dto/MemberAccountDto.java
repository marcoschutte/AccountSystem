package za.ac.nwu.ac.domain.dto;

import io.swagger.annotations.ApiModel;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@ApiModel(value = "MemberAccount",
        description = "A DTO that represents the MemberAccount")

public class MemberAccountDto implements Serializable {

    private Long memberId;
    private Long accountTypeId;
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

    public MemberAccountDto(Long memberId, Long accountTypeId, String memberFirstName, String memberLastName, Long accountBalance, LocalDate creationDate) {
        this.memberId = memberId;
        this.accountTypeId = accountTypeId;
        this.memberFirstName = memberFirstName;
        this.memberLastName = memberLastName;
        this.accountBalance = accountBalance;
        this.creationDate = creationDate;
    }

    public Long getMemberId() { return memberId; }
    public void setMemberId(Long memberId) { this.memberId = memberId; }

    public Long getAccountTypeId() { return accountTypeId; }
    public void setAccountTypeId(Long accountTypeId) { this.accountTypeId = accountTypeId; }

    public String getMemberFirstName() { return memberFirstName; }
    public void setMemberFirstName(String memberFirstName) { this.memberFirstName = memberFirstName; }

    public String getMemberLastName() { return memberLastName; }
    public void setMemberLastName(String memberLastName) { this.memberLastName = memberLastName; }

    public Long getAccountBalance() { return accountBalance; }
    public void setAccountBalance(Long accountBalance) { this.accountBalance = accountBalance; }

    public LocalDate getCreationDate() { return creationDate; }
    public void setCreationDate(LocalDate creationDate) { this.creationDate = creationDate; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemberAccountDto that = (MemberAccountDto) o;
        return Objects.equals(memberId, that.memberId) && Objects.equals(accountTypeId, that.accountTypeId) && Objects.equals(memberFirstName, that.memberFirstName) && Objects.equals(memberLastName, that.memberLastName) && Objects.equals(accountBalance, that.accountBalance) && Objects.equals(creationDate, that.creationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberId, accountTypeId, memberFirstName, memberLastName, accountBalance, creationDate);
    }

    @Override
    public String toString() {
        return "MemberAccountDto{" +
                "memberId=" + memberId +
                ", accountTypeId=" + accountTypeId +
                ", memberFirstName='" + memberFirstName + '\'' +
                ", memberLastName='" + memberLastName + '\'' +
                ", accountBalance=" + accountBalance +
                ", creationDate=" + creationDate +
                '}';
    }
}
