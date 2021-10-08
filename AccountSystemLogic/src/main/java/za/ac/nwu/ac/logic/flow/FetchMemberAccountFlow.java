package za.ac.nwu.ac.logic.flow;

import za.ac.nwu.ac.domain.dto.MemberAccountDto;

import java.util.List;

public interface FetchMemberAccountFlow
{
    List<MemberAccountDto> getAllMemberAccounts();
}
