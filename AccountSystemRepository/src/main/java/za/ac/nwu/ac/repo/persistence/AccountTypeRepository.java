package za.ac.nwu.ac.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.domain.persistence.AccountType;

public interface AccountTypeRepository extends JpaRepository<AccountType, Long> {

    @Query(value = "SELECT " +
            "       ACCOUNT_TYPE_ID," +
            "       MNEMONIC," +
            "       ACCOUNT_TYPE_NAME," +
            "       CREATION_DATE" +
            "   FROM " +
            "       HR.ACCOUNT_TYPE " +
            "   WHERE MNEMONIC = :mnemonic ", nativeQuery = true)
    AccountType getAccountTypeByMnemonicNativeQuery(String mnemonic);
/*
    @Query(value = "SELECT " +
            "       at" +
            "   FROM " +
            "       AccountType at" +
            "   WHERE at.mnemonic = :mnemonic ")
    AccountType getAccountTypeByMnemonic(String mnemonic);

    @Query(value = "SELECT new za.ac.nwu.ac.domain.dto.AccountTypeDto( " +
            "       at.mnemonic," +
            "       at.accountTypeName," +
            "       at.creation )" +
            "   FROM " +
            "       AccountType at" +
            "   WHERE at.mnemonic = :mnemonic ")
    AccountTypeDto getAccountTypeDtoByMnemonic(String mnemonic);

*/
}
