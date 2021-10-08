package za.ac.nwu.ac.translator.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.MemberAccountDto;
import za.ac.nwu.ac.domain.persistence.MemberAccount;
import za.ac.nwu.ac.repo.persistence.MemberAccountRepository;
import za.ac.nwu.ac.translator.MemberAccountTranslator;

import java.util.ArrayList;
import java.util.List;

@Component
public class MemberAccountTranslatorImpl implements MemberAccountTranslator
{
    private final MemberAccountRepository memberAccountRepository;

    @Autowired
    public MemberAccountTranslatorImpl(MemberAccountRepository memberAccountRepository)
    {
        this.memberAccountRepository = memberAccountRepository;
    }

    @Override
    public List<MemberAccountDto> getAllMemberAccounts()
    {
        List<MemberAccountDto> memberAccountDtos = new ArrayList<>();

        try
        {
            for (MemberAccount memberAccount : memberAccountRepository.findAll())
            {
                memberAccountDtos.add(new MemberAccountDto(memberAccount));
            }
        }
        catch (Exception e)
        {
            throw new RuntimeException("Unable to read from the DB", e);
        }

        return memberAccountDtos;
    }

    @Override
    public MemberAccountDto create (MemberAccountDto memberAccountDto)
    {
        try
        {
            MemberAccount memberAccount = memberAccountRepository.save(memberAccountDto.getMemberAccount());
            return new MemberAccountDto(memberAccount);
        }
        catch (Exception e)
        {
            throw new RuntimeException("Unable to save to the DB", e);
        }
    }
}
