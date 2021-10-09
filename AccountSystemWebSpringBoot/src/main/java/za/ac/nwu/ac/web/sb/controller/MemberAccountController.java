package za.ac.nwu.ac.web.sb.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.domain.dto.MemberAccountDto;
import za.ac.nwu.ac.domain.service.GeneralResponse;
import za.ac.nwu.ac.logic.flow.CreateMemberAccountFlow;
import za.ac.nwu.ac.logic.flow.FetchMemberAccountFlow;

import java.util.List;

@RestController
@RequestMapping("member-account")
public class MemberAccountController
{
    private final FetchMemberAccountFlow fetchMemberAccountFlow;
    private final CreateMemberAccountFlow createMemberAccountFlow;

    @Autowired
    public MemberAccountController(FetchMemberAccountFlow fetchMemberAccountFlow,
                                   @Qualifier("createMemberAccountFlowName") CreateMemberAccountFlow createMemberAccountFlow)
    {
        this.fetchMemberAccountFlow = fetchMemberAccountFlow;
        this.createMemberAccountFlow = createMemberAccountFlow;
    }

    @GetMapping("/all")
    @ApiOperation(value = "Gets all the Member Accounts.", notes = "Returns a list of member accounts")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Member accounts returned", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)
    })

    public ResponseEntity<GeneralResponse<List<MemberAccountDto>>> getAll()
    {
        List<MemberAccountDto> memberAccounts = fetchMemberAccountFlow.getAllMemberAccounts();
        GeneralResponse<List<MemberAccountDto>> response = new GeneralResponse<>(true, memberAccounts);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("")
    @ApiOperation(value = "Creates a new MemberAccount.", notes = "Creates a new MemberAccount in the DB.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "The MemberAccount was created successfully", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<MemberAccountDto>> create(
            @ApiParam(value = "Request body to create a new MemberAccount.",
                    required = true)
            @RequestBody MemberAccountDto memberAccount) {
        MemberAccountDto memberAccountResponse = createMemberAccountFlow.create(memberAccount);
        GeneralResponse<MemberAccountDto> response = new GeneralResponse<>(true, memberAccountResponse);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
