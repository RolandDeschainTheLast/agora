package com.example.rina.agora_app.activities;

import io.reactivex.Flowable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.DynamicBytes;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.abi.datatypes.generated.Int256;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple3;
import org.web3j.tuples.generated.Tuple9;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.2.0.
 */
public class Congress extends Contract {
    private static final String BINARY = "608060405260405160608062001f82833981018060405260608110156200002557600080fd5b508051602080830151604090930151600080546001600160a01b03191633179055919291906200005f90849084908490620000e5811b901c565b620000816000604051806020016040528060008152506200015160201b60201c565b620000dc6000809054906101000a90046001600160a01b03166040518060400160405280600781526020017f666f756e646572000000000000000000000000000000000000000000000000008152506200015160201b60201c565b505050620003f1565b6000546001600160a01b03163314620000fd57600080fd5b600183905560028290556003819055604080518481526020810184905280820183905290517fa439d3fa452be5e0e1e24a8145e715f4fd8b9c08c96a42fd82a855a85e5d57de9181900360600190a1505050565b6000546001600160a01b031633146200016957600080fd5b6001600160a01b03821660009081526006602052604090205480620001ba57600780546001600160a01b038516600090815260066020526040902081905590620001b790600183016200028d565b90505b6040518060600160405280846001600160a01b031681526020018381526020014281525060078281548110620001ec57fe5b600091825260209182902083516003929092020180546001600160a01b0319166001600160a01b0390921691909117815582820151805191926200023992600185019290910190620002c1565b5060409182015160029091015580516001600160a01b03851681526001602082015281517f27b022af4a8347100c7a041ce5ccf8e14d644ff05de696315196faae8cd50c9b929181900390910190a1505050565b815481835581811115620002bc57600302816003028360005260206000209182019101620002bc919062000346565b505050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106200030457805160ff191683800117855562000334565b8280016001018555821562000334579182015b828111156200033457825182559160200191906001019062000317565b506200034292915062000389565b5090565b6200038691905b80821115620003425780546001600160a01b03191681556000620003756001830182620003a6565b50600060028201556003016200034d565b90565b6200038691905b8082111562000342576000815560010162000390565b50805460018160011615610100020316600290046000825580601f10620003ce5750620003ee565b601f016020900490600052602060002090810190620003ee919062000389565b50565b611b8180620004016000396000f3fe6080604052600436106101095760003560e01c80638f4ffcb111610095578063bcca1fd311610064578063bcca1fd31461080e578063c127c24714610844578063d3c0715b14610905578063eceb2945146109c4578063f2fde38b14610aa557610109565b80638f4ffcb114610493578063aa02a90f14610563578063b1050da514610578578063b9f256cd146106c357610109565b8063400e3949116100dc578063400e39491461036b5780635daf08ca1461038057806369bd3436146104385780638160f0b51461044d5780638da5cb5b1461046257610109565b8063013cf08b146101455780630b1ca49a14610239578063237e94921461026e5780633910682114610326575b6040805133815234602082015281517fa398b89ba344a0b23a0b9de53db298b2a1a868b396c1878b7e9dcbafecd49b13929181900390910190a1005b34801561015157600080fd5b5061016f6004803603602081101561016857600080fd5b5035610ad8565b604051808a6001600160a01b03166001600160a01b03168152602001898152602001806020018881526020018715151515815260200186151515158152602001858152602001848152602001838152602001828103825289818151815260200191508051906020019080838360005b838110156101f65781810151838201526020016101de565b50505050905090810190601f1680156102235780820380516001836020036101000a031916815260200191505b509a505050505050505050505060405180910390f35b34801561024557600080fd5b5061026c6004803603602081101561025c57600080fd5b50356001600160a01b0316610bce565b005b34801561027a57600080fd5b5061026c6004803603604081101561029157600080fd5b81359190810190604081016020820135600160201b8111156102b257600080fd5b8201836020820111156102c457600080fd5b803590602001918460018302840111600160201b831117156102e557600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600092019190915250929550610d7b945050505050565b34801561033257600080fd5b506103596004803603602081101561034957600080fd5b50356001600160a01b0316610fd7565b60408051918252519081900360200190f35b34801561037757600080fd5b50610359610fe9565b34801561038c57600080fd5b506103aa600480360360208110156103a357600080fd5b5035610fef565b604080516001600160a01b0385168152908101829052606060208083018281528551928401929092528451608084019186019080838360005b838110156103fb5781810151838201526020016103e3565b50505050905090810190601f1680156104285780820380516001836020036101000a031916815260200191505b5094505050505060405180910390f35b34801561044457600080fd5b506103596110b9565b34801561045957600080fd5b506103596110bf565b34801561046e57600080fd5b506104776110c5565b604080516001600160a01b039092168252519081900360200190f35b34801561049f57600080fd5b5061026c600480360360808110156104b657600080fd5b6001600160a01b038235811692602081013592604082013590921691810190608081016060820135600160201b8111156104ef57600080fd5b82018360208201111561050157600080fd5b803590602001918460018302840111600160201b8311171561052257600080fd5b91908080601f0160208091040260200160405190810160405280939291908181526020018383808284376000920191909152509295506110d4945050505050565b34801561056f57600080fd5b50610359611241565b34801561058457600080fd5b506103596004803603608081101561059b57600080fd5b6001600160a01b0382351691602081013591810190606081016040820135600160201b8111156105ca57600080fd5b8201836020820111156105dc57600080fd5b803590602001918460018302840111600160201b831117156105fd57600080fd5b91908080601f0160208091040260200160405190810160405280939291908181526020018383808284376000920191909152509295949360208101935035915050600160201b81111561064f57600080fd5b82018360208201111561066157600080fd5b803590602001918460018302840111600160201b8311171561068257600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600092019190915250929550611247945050505050565b3480156106cf57600080fd5b50610359600480360360808110156106e657600080fd5b6001600160a01b0382351691602081013591810190606081016040820135600160201b81111561071557600080fd5b82018360208201111561072757600080fd5b803590602001918460018302840111600160201b8311171561074857600080fd5b91908080601f0160208091040260200160405190810160405280939291908181526020018383808284376000920191909152509295949360208101935035915050600160201b81111561079a57600080fd5b8201836020820111156107ac57600080fd5b803590602001918460018302840111600160201b831117156107cd57600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600092019190915250929550611455945050505050565b34801561081a57600080fd5b5061026c6004803603606081101561083157600080fd5b508035906020810135906040013561148d565b34801561085057600080fd5b5061026c6004803603604081101561086757600080fd5b6001600160a01b038235169190810190604081016020820135600160201b81111561089157600080fd5b8201836020820111156108a357600080fd5b803590602001918460018302840111600160201b831117156108c457600080fd5b91908080601f0160208091040260200160405190810160405280939291908181526020018383808284376000920191909152509295506114f8945050505050565b34801561091157600080fd5b506103596004803603606081101561092857600080fd5b8135916020810135151591810190606081016040820135600160201b81111561095057600080fd5b82018360208201111561096257600080fd5b803590602001918460018302840111600160201b8311171561098357600080fd5b91908080601f01602080910402602001604051908101604052809392919081815260200183838082843760009201919091525092955061162d945050505050565b3480156109d057600080fd5b50610a91600480360360808110156109e757600080fd5b8135916001600160a01b036020820135169160408201359190810190608081016060820135600160201b811115610a1d57600080fd5b820183602082011115610a2f57600080fd5b803590602001918460018302840111600160201b83111715610a5057600080fd5b91908080601f0160208091040260200160405190810160405280939291908181526020018383808284376000920191909152509295506117a5945050505050565b604080519115158252519081900360200190f35b348015610ab157600080fd5b5061026c60048036036020811015610ac857600080fd5b50356001600160a01b0316611869565b60048181548110610ae557fe5b6000918252602091829020600a91909102018054600180830154600280850180546040805161010096831615969096026000190190911692909204601f81018890048802850188019092528184526001600160a01b0390941696509094919291830182828015610b965780601f10610b6b57610100808354040283529160200191610b96565b820191906000526020600020905b815481529060010190602001808311610b7957829003601f168201915b50505060038401546004850154600586015460068701546007909701549596929560ff80841696506101009093049092169350919089565b6000546001600160a01b03163314610be557600080fd5b6001600160a01b038116600090815260066020526040902054610c0757600080fd5b6001600160a01b0381166000908152600660205260409020545b60075460001901811015610d035760078160010181548110610c3f57fe5b906000526020600020906003020160078281548110610c5a57fe5b60009182526020909120825460039092020180546001600160a01b0319166001600160a01b0390921691909117815560018083018054610cb1928085019291600260001992821615610100029290920116046118a2565b5060028201548160020155905050806006600060078481548110610cd157fe5b600091825260208083206003909202909101546001600160a01b03168352820192909252604001902055600101610c21565b506001600160a01b038116600090815260066020526040812055600780546000198101908110610d2f57fe5b60009182526020822060039091020180546001600160a01b031916815590610d5a6001830182611927565b506000600291909101556007805490610d7790600019830161196e565b5050565b600060048381548110610d8a57fe5b90600052602060002090600a02019050806003015442118015610db25750600481015460ff16155b8015610e585750805460018201546040516001600160a01b03909216606081901b6020808501918252603485018490528651929487936054909101918401908083835b60208310610e145780518252601f199092019160209182019101610df5565b6001836020036101000a0380198251168184511680821785525050505050509050019350505050604051602081830303815290604052805190602001208160070154145b8015610e6a5750600154816005015410155b610e7357600080fd5b60035481600601541315610f645760048101805460ff1916600190811790915581549082015460405184516000936001600160a01b031692918691819060208401908083835b60208310610ed85780518252601f199092019160209182019101610eb9565b6001836020036101000a03801982511681845116808217855250505050505090500191505060006040518083038185875af1925050503d8060008114610f3a576040519150601f19603f3d011682016040523d82523d6000602084013e610f3f565b606091505b5050905080610f4d57600080fd5b5060048101805461ff001916610100179055610f72565b60048101805461ff00191690555b6006810154600582015460048301546040805187815260208101949094528381019290925260ff6101009091041615156060830152517fd220b7272a8b6d0d7d6bcdace67b936a8f175e6d5c1b3ee438b72256b32ab3af9181900360800190a1505050565b60066020526000908152604090205481565b60055481565b60078181548110610ffc57fe5b600091825260209182902060039091020180546001808301805460408051601f60026000199685161561010002969096019093169490940491820187900487028401870190528083526001600160a01b0390931695509293909291908301828280156110a95780601f1061107e576101008083540402835291602001916110a9565b820191906000526020600020905b81548152906001019060200180831161108c57829003601f168201915b5050505050908060020154905083565b60025481565b60015481565b6000546001600160a01b031681565b60408051600160e01b6323b872dd0281526001600160a01b03868116600483015230602483015260448201869052915184928316916323b872dd9160648083019260209291908290030181600087803b15801561113057600080fd5b505af1158015611144573d6000803e3d6000fd5b505050506040513d602081101561115a57600080fd5b505161116557600080fd5b7f0eeb71b8926d7ed8f47a2cedf6b9b204e2001344c7fa20c696c9f06ea7c413c68585858560405180856001600160a01b03166001600160a01b03168152602001848152602001836001600160a01b03166001600160a01b0316815260200180602001828103825283818151815260200191508051906020019080838360005b838110156111fd5781810151838201526020016111e5565b50505050905090810190601f16801561122a5780820380516001836020036101000a031916815260200191505b509550505050505060405180910390a15050505050565b60035481565b3360009081526006602052604081205461126057600080fd5b6004805490611272906001830161199f565b905060006004828154811061128357fe5b6000918252602091829020600a919091020180546001600160a01b0319166001600160a01b0389161781556001810187905585519092506112cc916002840191908701906119cb565b5085858460405160200180846001600160a01b03166001600160a01b031660601b815260140183815260200182805190602001908083835b602083106113235780518252601f199092019160209182019101611304565b51815160209384036101000a60001901801990921691161790526040805192909401828103601f1901835280855282519282019290922060078a0155600254603c02420160038a015560048901805461ffff19169055600060058a018190558a83526001600160a01b038f16838301529382018d90526080606083018181528d51918401919091528c517f646fec02522b41e7125cfc859a64fd4f4cefd5dc3b6237ca0abe251ded1fa88199508b98508f97508e96508d95939450909260a0850192860191908190849084905b838110156114085781810151838201526020016113f0565b50505050905090810190601f1680156114355780820380516001836020036101000a031916815260200191505b509550505050505060405180910390a15060018101600555949350505050565b3360009081526006602052604081205461146e57600080fd5b6114848585670de0b6b3a7640000028585611247565b95945050505050565b6000546001600160a01b031633146114a457600080fd5b600183905560028290556003819055604080518481526020810184905280820183905290517fa439d3fa452be5e0e1e24a8145e715f4fd8b9c08c96a42fd82a855a85e5d57de9181900360600190a1505050565b6000546001600160a01b0316331461150f57600080fd5b6001600160a01b0382166000908152600660205260409020548061155d57600780546001600160a01b03851660009081526006602052604090208190559061155a906001830161196e565b90505b6040518060600160405280846001600160a01b03168152602001838152602001428152506007828154811061158e57fe5b600091825260209182902083516003929092020180546001600160a01b0319166001600160a01b0390921691909117815582820151805191926115d9926001850192909101906119cb565b5060409182015160029091015580516001600160a01b03851681526001602082015281517f27b022af4a8347100c7a041ce5ccf8e14d644ff05de696315196faae8cd50c9b929181900390910190a1505050565b3360009081526006602052604081205461164657600080fd5b60006004858154811061165557fe5b600091825260208083203384526009600a90930201918201905260409091205490915060ff161561168557600080fd5b3360009081526009820160205260409020805460ff19166001908117909155600582018054909101905583156116c55760068101805460010190556116d2565b6006810180546000190190555b7fc34f869b7ff431b034b7b9aea9822dac189a685e0b015c7d1be3add3f89128e8858533866040518085815260200184151515158152602001836001600160a01b03166001600160a01b0316815260200180602001828103825283818151815260200191508051906020019080838360005b8381101561175c578181015183820152602001611744565b50505050905090810190601f1680156117895780820380516001836020036101000a031916815260200191505b509550505050505060405180910390a160050154949350505050565b600080600486815481106117b557fe5b90600052602060002090600a0201905084848460405160200180846001600160a01b03166001600160a01b031660601b815260140183815260200182805190602001908083835b6020831061181b5780518252601f1990920191602091820191016117fc565b6001836020036101000a038019825116818451168082178552505050505050905001935050505060405160208183030381529060405280519060200120816007015414915050949350505050565b6000546001600160a01b0316331461188057600080fd5b600080546001600160a01b0319166001600160a01b0392909216919091179055565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106118db5780548555611917565b8280016001018555821561191757600052602060002091601f016020900482015b828111156119175782548255916001019190600101906118fc565b50611923929150611a39565b5090565b50805460018160011615610100020316600290046000825580601f1061194d575061196b565b601f01602090049060005260206000209081019061196b9190611a39565b50565b81548183558181111561199a5760030281600302836000526020600020918201910161199a9190611a56565b505050565b81548183558181111561199a57600a0281600a02836000526020600020918201910161199a9190611a91565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f10611a0c57805160ff1916838001178555611917565b82800160010185558215611917579182015b82811115611917578251825591602001919060010190611a1e565b611a5391905b808211156119235760008155600101611a3f565b90565b611a5391905b808211156119235780546001600160a01b03191681556000611a816001830182611927565b5060006002820155600301611a5c565b611a5391905b808211156119235780546001600160a01b0319168155600060018201819055611ac36002830182611927565b60006003830181905560048301805461ffff19169055600583018190556006830181905560078301819055611afc906008840190611b05565b50600a01611a97565b508054600082556002029060005260206000209081019061196b9190611a5391905b808211156119235780546001600160a81b03191681556000611b4c6001830182611927565b50600201611b2756fea165627a7a72305820a8bf0145a102bc34abcfa2e1e540b6b383d1d9589ee7e4f30c9a7537bd122cab0029";

    public static final String FUNC_PROPOSALS = "proposals";

    public static final String FUNC_REMOVEMEMBER = "removeMember";

    public static final String FUNC_EXECUTEPROPOSAL = "executeProposal";

    public static final String FUNC_MEMBERID = "memberId";

    public static final String FUNC_NUMPROPOSALS = "numProposals";

    public static final String FUNC_MEMBERS = "members";

    public static final String FUNC_DEBATINGPERIODINMINUTES = "debatingPeriodInMinutes";

    public static final String FUNC_MINIMUMQUORUM = "minimumQuorum";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_RECEIVEAPPROVAL = "receiveApproval";

    public static final String FUNC_MAJORITYMARGIN = "majorityMargin";

    public static final String FUNC_NEWPROPOSAL = "newProposal";

    public static final String FUNC_NEWPROPOSALINETHER = "newProposalInEther";

    public static final String FUNC_CHANGEVOTINGRULES = "changeVotingRules";

    public static final String FUNC_ADDMEMBER = "addMember";

    public static final String FUNC_VOTE = "vote";

    public static final String FUNC_CHECKPROPOSALCODE = "checkProposalCode";

    public static final String FUNC_TRANSFEROWNERSHIP = "transferOwnership";

    public static final Event PROPOSALADDED_EVENT = new Event("ProposalAdded", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Address>() {}, new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}));
    ;

    public static final Event VOTED_EVENT = new Event("Voted", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Bool>() {}, new TypeReference<Address>() {}, new TypeReference<Utf8String>() {}));
    ;

    public static final Event PROPOSALTALLIED_EVENT = new Event("ProposalTallied", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Int256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Bool>() {}));
    ;

    public static final Event MEMBERSHIPCHANGED_EVENT = new Event("MembershipChanged", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Bool>() {}));
    ;

    public static final Event CHANGEOFRULES_EVENT = new Event("ChangeOfRules", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Int256>() {}));
    ;

    public static final Event RECEIVEDETHER_EVENT = new Event("receivedEther", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event RECEIVEDTOKENS_EVENT = new Event("receivedTokens", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}, new TypeReference<Address>() {}, new TypeReference<DynamicBytes>() {}));
    ;

    @Deprecated
    protected Congress(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Congress(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Congress(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Congress(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteCall<Tuple9<String, BigInteger, String, BigInteger, Boolean, Boolean, BigInteger, BigInteger, byte[]>> proposals(BigInteger param0) {
        final Function function = new Function(FUNC_PROPOSALS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}, new TypeReference<Bool>() {}, new TypeReference<Bool>() {}, new TypeReference<Uint256>() {}, new TypeReference<Int256>() {}, new TypeReference<Bytes32>() {}));
        return new RemoteCall<Tuple9<String, BigInteger, String, BigInteger, Boolean, Boolean, BigInteger, BigInteger, byte[]>>(
                new Callable<Tuple9<String, BigInteger, String, BigInteger, Boolean, Boolean, BigInteger, BigInteger, byte[]>>() {
                    @Override
                    public Tuple9<String, BigInteger, String, BigInteger, Boolean, Boolean, BigInteger, BigInteger, byte[]> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple9<String, BigInteger, String, BigInteger, Boolean, Boolean, BigInteger, BigInteger, byte[]>(
                                (String) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue(), 
                                (String) results.get(2).getValue(), 
                                (BigInteger) results.get(3).getValue(), 
                                (Boolean) results.get(4).getValue(), 
                                (Boolean) results.get(5).getValue(), 
                                (BigInteger) results.get(6).getValue(), 
                                (BigInteger) results.get(7).getValue(), 
                                (byte[]) results.get(8).getValue());
                    }
                });
    }

    public RemoteCall<TransactionReceipt> removeMember(String targetMember) {
        final Function function = new Function(
                FUNC_REMOVEMEMBER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(targetMember)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> executeProposal(BigInteger proposalNumber, byte[] transactionBytecode) {
        final Function function = new Function(
                FUNC_EXECUTEPROPOSAL, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(proposalNumber), 
                new org.web3j.abi.datatypes.DynamicBytes(transactionBytecode)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> memberId(String param0) {
        final Function function = new Function(FUNC_MEMBERID, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> numProposals() {
        final Function function = new Function(FUNC_NUMPROPOSALS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<Tuple3<String, String, BigInteger>> members(BigInteger param0) {
        final Function function = new Function(FUNC_MEMBERS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}));
        return new RemoteCall<Tuple3<String, String, BigInteger>>(
                new Callable<Tuple3<String, String, BigInteger>>() {
                    @Override
                    public Tuple3<String, String, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple3<String, String, BigInteger>(
                                (String) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (BigInteger) results.get(2).getValue());
                    }
                });
    }

    public RemoteCall<BigInteger> debatingPeriodInMinutes() {
        final Function function = new Function(FUNC_DEBATINGPERIODINMINUTES, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> minimumQuorum() {
        final Function function = new Function(FUNC_MINIMUMQUORUM, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<String> owner() {
        final Function function = new Function(FUNC_OWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> receiveApproval(String _from, BigInteger _value, String _token, byte[] _extraData) {
        final Function function = new Function(
                FUNC_RECEIVEAPPROVAL, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_from), 
                new org.web3j.abi.datatypes.generated.Uint256(_value), 
                new org.web3j.abi.datatypes.Address(_token), 
                new org.web3j.abi.datatypes.DynamicBytes(_extraData)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> majorityMargin() {
        final Function function = new Function(FUNC_MAJORITYMARGIN, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> newProposal(String beneficiary, BigInteger weiAmount, String jobDescription, byte[] transactionBytecode) {
        final Function function = new Function(
                FUNC_NEWPROPOSAL, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(beneficiary), 
                new org.web3j.abi.datatypes.generated.Uint256(weiAmount), 
                new org.web3j.abi.datatypes.Utf8String(jobDescription), 
                new org.web3j.abi.datatypes.DynamicBytes(transactionBytecode)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> newProposalInEther(String beneficiary, BigInteger etherAmount, String jobDescription, byte[] transactionBytecode) {
        final Function function = new Function(
                FUNC_NEWPROPOSALINETHER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(beneficiary), 
                new org.web3j.abi.datatypes.generated.Uint256(etherAmount), 
                new org.web3j.abi.datatypes.Utf8String(jobDescription), 
                new org.web3j.abi.datatypes.DynamicBytes(transactionBytecode)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> changeVotingRules(BigInteger minimumQuorumForProposals, BigInteger minutesForDebate, BigInteger marginOfVotesForMajority) {
        final Function function = new Function(
                FUNC_CHANGEVOTINGRULES, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(minimumQuorumForProposals), 
                new org.web3j.abi.datatypes.generated.Uint256(minutesForDebate), 
                new org.web3j.abi.datatypes.generated.Int256(marginOfVotesForMajority)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> addMember(String targetMember, String memberName) {
        final Function function = new Function(
                FUNC_ADDMEMBER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(targetMember), 
                new org.web3j.abi.datatypes.Utf8String(memberName)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> vote(BigInteger proposalNumber, Boolean supportsProposal, String justificationText) {
        final Function function = new Function(
                FUNC_VOTE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(proposalNumber), 
                new org.web3j.abi.datatypes.Bool(supportsProposal), 
                new org.web3j.abi.datatypes.Utf8String(justificationText)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Boolean> checkProposalCode(BigInteger proposalNumber, String beneficiary, BigInteger weiAmount, byte[] transactionBytecode) {
        final Function function = new Function(FUNC_CHECKPROPOSALCODE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(proposalNumber), 
                new org.web3j.abi.datatypes.Address(beneficiary), 
                new org.web3j.abi.datatypes.generated.Uint256(weiAmount), 
                new org.web3j.abi.datatypes.DynamicBytes(transactionBytecode)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<TransactionReceipt> transferOwnership(String newOwner) {
        final Function function = new Function(
                FUNC_TRANSFEROWNERSHIP, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(newOwner)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public List<ProposalAddedEventResponse> getProposalAddedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(PROPOSALADDED_EVENT, transactionReceipt);
        ArrayList<ProposalAddedEventResponse> responses = new ArrayList<ProposalAddedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ProposalAddedEventResponse typedResponse = new ProposalAddedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.proposalID = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.recipient = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse.description = (String) eventValues.getNonIndexedValues().get(3).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<ProposalAddedEventResponse> proposalAddedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, ProposalAddedEventResponse>() {
            @Override
            public ProposalAddedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(PROPOSALADDED_EVENT, log);
                ProposalAddedEventResponse typedResponse = new ProposalAddedEventResponse();
                typedResponse.log = log;
                typedResponse.proposalID = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.recipient = (String) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
                typedResponse.description = (String) eventValues.getNonIndexedValues().get(3).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<ProposalAddedEventResponse> proposalAddedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(PROPOSALADDED_EVENT));
        return proposalAddedEventFlowable(filter);
    }

    public List<VotedEventResponse> getVotedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(VOTED_EVENT, transactionReceipt);
        ArrayList<VotedEventResponse> responses = new ArrayList<VotedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            VotedEventResponse typedResponse = new VotedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.proposalID = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.position = (Boolean) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.voter = (String) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse.justification = (String) eventValues.getNonIndexedValues().get(3).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<VotedEventResponse> votedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, VotedEventResponse>() {
            @Override
            public VotedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(VOTED_EVENT, log);
                VotedEventResponse typedResponse = new VotedEventResponse();
                typedResponse.log = log;
                typedResponse.proposalID = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.position = (Boolean) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.voter = (String) eventValues.getNonIndexedValues().get(2).getValue();
                typedResponse.justification = (String) eventValues.getNonIndexedValues().get(3).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<VotedEventResponse> votedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(VOTED_EVENT));
        return votedEventFlowable(filter);
    }

    public List<ProposalTalliedEventResponse> getProposalTalliedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(PROPOSALTALLIED_EVENT, transactionReceipt);
        ArrayList<ProposalTalliedEventResponse> responses = new ArrayList<ProposalTalliedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ProposalTalliedEventResponse typedResponse = new ProposalTalliedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.proposalID = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.result = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.quorum = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse.active = (Boolean) eventValues.getNonIndexedValues().get(3).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<ProposalTalliedEventResponse> proposalTalliedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, ProposalTalliedEventResponse>() {
            @Override
            public ProposalTalliedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(PROPOSALTALLIED_EVENT, log);
                ProposalTalliedEventResponse typedResponse = new ProposalTalliedEventResponse();
                typedResponse.log = log;
                typedResponse.proposalID = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.result = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.quorum = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
                typedResponse.active = (Boolean) eventValues.getNonIndexedValues().get(3).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<ProposalTalliedEventResponse> proposalTalliedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(PROPOSALTALLIED_EVENT));
        return proposalTalliedEventFlowable(filter);
    }

    public List<MembershipChangedEventResponse> getMembershipChangedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(MEMBERSHIPCHANGED_EVENT, transactionReceipt);
        ArrayList<MembershipChangedEventResponse> responses = new ArrayList<MembershipChangedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            MembershipChangedEventResponse typedResponse = new MembershipChangedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.member = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.isMember = (Boolean) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<MembershipChangedEventResponse> membershipChangedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, MembershipChangedEventResponse>() {
            @Override
            public MembershipChangedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(MEMBERSHIPCHANGED_EVENT, log);
                MembershipChangedEventResponse typedResponse = new MembershipChangedEventResponse();
                typedResponse.log = log;
                typedResponse.member = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.isMember = (Boolean) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<MembershipChangedEventResponse> membershipChangedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(MEMBERSHIPCHANGED_EVENT));
        return membershipChangedEventFlowable(filter);
    }

    public List<ChangeOfRulesEventResponse> getChangeOfRulesEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(CHANGEOFRULES_EVENT, transactionReceipt);
        ArrayList<ChangeOfRulesEventResponse> responses = new ArrayList<ChangeOfRulesEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ChangeOfRulesEventResponse typedResponse = new ChangeOfRulesEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.newMinimumQuorum = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.newDebatingPeriodInMinutes = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.newMajorityMargin = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<ChangeOfRulesEventResponse> changeOfRulesEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, ChangeOfRulesEventResponse>() {
            @Override
            public ChangeOfRulesEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(CHANGEOFRULES_EVENT, log);
                ChangeOfRulesEventResponse typedResponse = new ChangeOfRulesEventResponse();
                typedResponse.log = log;
                typedResponse.newMinimumQuorum = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.newDebatingPeriodInMinutes = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.newMajorityMargin = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<ChangeOfRulesEventResponse> changeOfRulesEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(CHANGEOFRULES_EVENT));
        return changeOfRulesEventFlowable(filter);
    }

    public List<ReceivedEtherEventResponse> getReceivedEtherEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(RECEIVEDETHER_EVENT, transactionReceipt);
        ArrayList<ReceivedEtherEventResponse> responses = new ArrayList<ReceivedEtherEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ReceivedEtherEventResponse typedResponse = new ReceivedEtherEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.sender = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<ReceivedEtherEventResponse> receivedEtherEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, ReceivedEtherEventResponse>() {
            @Override
            public ReceivedEtherEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(RECEIVEDETHER_EVENT, log);
                ReceivedEtherEventResponse typedResponse = new ReceivedEtherEventResponse();
                typedResponse.log = log;
                typedResponse.sender = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<ReceivedEtherEventResponse> receivedEtherEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(RECEIVEDETHER_EVENT));
        return receivedEtherEventFlowable(filter);
    }

    public List<ReceivedTokensEventResponse> getReceivedTokensEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(RECEIVEDTOKENS_EVENT, transactionReceipt);
        ArrayList<ReceivedTokensEventResponse> responses = new ArrayList<ReceivedTokensEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ReceivedTokensEventResponse typedResponse = new ReceivedTokensEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._from = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse._value = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse._token = (String) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse._extraData = (byte[]) eventValues.getNonIndexedValues().get(3).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<ReceivedTokensEventResponse> receivedTokensEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, ReceivedTokensEventResponse>() {
            @Override
            public ReceivedTokensEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(RECEIVEDTOKENS_EVENT, log);
                ReceivedTokensEventResponse typedResponse = new ReceivedTokensEventResponse();
                typedResponse.log = log;
                typedResponse._from = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse._value = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse._token = (String) eventValues.getNonIndexedValues().get(2).getValue();
                typedResponse._extraData = (byte[]) eventValues.getNonIndexedValues().get(3).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<ReceivedTokensEventResponse> receivedTokensEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(RECEIVEDTOKENS_EVENT));
        return receivedTokensEventFlowable(filter);
    }

    @Deprecated
    public static Congress load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Congress(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Congress load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Congress(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Congress load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Congress(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Congress load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Congress(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Congress> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, BigInteger initialWeiValue, BigInteger minimumQuorumForProposals, BigInteger minutesForDebate, BigInteger marginOfVotesForMajority) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(minimumQuorumForProposals), 
                new org.web3j.abi.datatypes.generated.Uint256(minutesForDebate), 
                new org.web3j.abi.datatypes.generated.Int256(marginOfVotesForMajority)));
        return deployRemoteCall(Congress.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor, initialWeiValue);
    }

    public static RemoteCall<Congress> deploy(Web3j web3j, Credentials transactionManager, BigInteger contractGasProvider, BigInteger initialWeiValue, BigInteger minimumQuorumForProposals, BigInteger minutesForDebate, BigInteger marginOfVotesForMajority) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(minimumQuorumForProposals), 
                new org.web3j.abi.datatypes.generated.Uint256(minutesForDebate), 
                new org.web3j.abi.datatypes.generated.Int256(marginOfVotesForMajority)));
        return deployRemoteCall(Congress.class, web3j, transactionManager, (ContractGasProvider) contractGasProvider, BINARY, encodedConstructor, initialWeiValue);
    }

    @Deprecated
    public static RemoteCall<Congress> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialWeiValue, BigInteger minimumQuorumForProposals, BigInteger minutesForDebate, BigInteger marginOfVotesForMajority) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(minimumQuorumForProposals), 
                new org.web3j.abi.datatypes.generated.Uint256(minutesForDebate), 
                new org.web3j.abi.datatypes.generated.Int256(marginOfVotesForMajority)));
        return deployRemoteCall(Congress.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor, initialWeiValue);
    }

    @Deprecated
    public static RemoteCall<Congress> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialWeiValue, BigInteger minimumQuorumForProposals, BigInteger minutesForDebate, BigInteger marginOfVotesForMajority) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(minimumQuorumForProposals), 
                new org.web3j.abi.datatypes.generated.Uint256(minutesForDebate), 
                new org.web3j.abi.datatypes.generated.Int256(marginOfVotesForMajority)));
        return deployRemoteCall(Congress.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor, initialWeiValue);
    }

    public static class ProposalAddedEventResponse {
        public Log log;

        public BigInteger proposalID;

        public String recipient;

        public BigInteger amount;

        public String description;
    }

    public static class VotedEventResponse {
        public Log log;

        public BigInteger proposalID;

        public Boolean position;

        public String voter;

        public String justification;
    }

    public static class ProposalTalliedEventResponse {
        public Log log;

        public BigInteger proposalID;

        public BigInteger result;

        public BigInteger quorum;

        public Boolean active;
    }

    public static class MembershipChangedEventResponse {
        public Log log;

        public String member;

        public Boolean isMember;
    }

    public static class ChangeOfRulesEventResponse {
        public Log log;

        public BigInteger newMinimumQuorum;

        public BigInteger newDebatingPeriodInMinutes;

        public BigInteger newMajorityMargin;
    }

    public static class ReceivedEtherEventResponse {
        public Log log;

        public String sender;

        public BigInteger amount;
    }

    public static class ReceivedTokensEventResponse {
        public Log log;

        public String _from;

        public BigInteger _value;

        public String _token;

        public byte[] _extraData;
    }
}
