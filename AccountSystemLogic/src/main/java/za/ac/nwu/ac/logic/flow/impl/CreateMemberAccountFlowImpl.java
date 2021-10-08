package za.ac.nwu.ac.logic.flow.impl;

import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.MemberAccountDto;
import za.ac.nwu.ac.logic.flow.CreateMemberAccountFlow;
import za.ac.nwu.ac.translator.MemberAccountTranslator;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Transactional
@Component("createMemberAccountFlowName")
public class CreateMemberAccountFlowImpl implements CreateMemberAccountFlow
{
    private final MemberAccountTranslator memberAccountTranslator;

    public CreateMemberAccountFlowImpl(MemberAccountTranslator memberAccountTranslator)
    {
        this.memberAccountTranslator = memberAccountTranslator;
    }

    @Override
    public MemberAccountDto create(MemberAccountDto memberAccount)
    {
        if(null== memberAccount.getCreationDate())
        {
            memberAccount.setCreationDate(LocalDate.now());
        }
        return memberAccountTranslator.create(memberAccount);
    }
}

