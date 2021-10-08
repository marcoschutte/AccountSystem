package za.ac.nwu.ac.translator;

import za.ac.nwu.ac.domain.dto.MemberAccountDto;

import java.util.List;

public interface MemberAccountTranslator
{
    List<MemberAccountDto> getAllMemberAccounts();

    MemberAccountDto create(MemberAccountDto memberAccount);
}
