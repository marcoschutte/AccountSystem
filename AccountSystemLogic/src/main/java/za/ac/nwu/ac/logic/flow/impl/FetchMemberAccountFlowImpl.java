package za.ac.nwu.ac.logic.flow.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.MemberAccountDto;
import za.ac.nwu.ac.logic.flow.FetchMemberAccountFlow;
import za.ac.nwu.ac.translator.MemberAccountTranslator;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Component
public class FetchMemberAccountFlowImpl implements FetchMemberAccountFlow
{
    private final MemberAccountTranslator memberAccountTranslator;

    @Autowired
    public FetchMemberAccountFlowImpl(MemberAccountTranslator memberAccountTranslator)
    {
        this.memberAccountTranslator = memberAccountTranslator;
    }

    @Override
    public List<MemberAccountDto> getAllMemberAccounts()
    {
        return memberAccountTranslator.getAllMemberAccounts();
    }
}
