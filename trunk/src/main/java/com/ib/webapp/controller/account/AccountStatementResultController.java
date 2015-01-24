package com.ib.webapp.controller.account;

import com.ib.Constants;
import com.ib.model.Account;
import com.ib.model.AccountStatement;
import com.ib.model.AccountStatementSummary;
import com.ib.model.Simulator;
import com.ib.service.SimulatorManager;
import com.ib.util.DateUtil;
import com.ib.webapp.controller.BaseFormController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * Controller to signup new users.
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
@Controller
@RequestMapping("/account/accountStatementResult*")
public class AccountStatementResultController extends BaseFormController {
    private SimulatorManager simulatorManager;

    @Autowired
    public void setSimulatorManager(final SimulatorManager simulatorManager) {
        this.simulatorManager = simulatorManager;
    }

    public AccountStatementResultController() {
        setCancelView("redirect:" + Constants.APPLICATION_PATH + "/home");
        setSuccessView("redirect:" +Constants.APPLICATION_PATH + "/account/accountStatementResult");
    }

    @RequestMapping(method = RequestMethod.GET)
    public String controlMapping(
            @ModelAttribute("period") final String period,
            final BindingResult mapping1BindingResult,
            final Model model) {

        Simulator simulator = simulatorManager.findByType(Constants.TYPE_BALANCE_INQUIRY);
        Account account = new Account();
        account.setAccountNumber(simulator.getData1());
        account.setAccountType(simulator.getData2());
        account.setCurrency(simulator.getData3());
        account.setBalance(BigDecimal.valueOf(Double.valueOf(simulator.getData4())));
        account.setResponseCode(simulator.getResponseCode());
        account.setDescription(simulator.getDescription());

        Simulator simAccountStatement = simulatorManager.findByType(Constants.TYPE_ACCOUNT_STATEMENT);
        List<AccountStatement> accountStatementList = new ArrayList<AccountStatement>();
        int i = 0;
        while (i <= Constants.SIMULATOR_DATACOUNT) {
            i += 1;
            String simData = (i == 1) ? simAccountStatement.getData1() :
                    (i == 2) ? simAccountStatement.getData2() :
                            (i == 3) ? simAccountStatement.getData3() :
                                    (i == 4) ? simAccountStatement.getData4() :
                                            (i == 5) ? simAccountStatement.getData5() :
                                                    (i == 6) ? simAccountStatement.getData6() : simAccountStatement.getData7();
            if (simData != null && !simData.equals("")) {
                AccountStatement acs = new AccountStatement();
                String[] arrData = simData.split("\\|");
                //Date|Description|Branch|Amount|DbCr|Balance

                try {
                    acs.setTransactionDate(DateUtil.convertStringToDate(arrData[0]));
                } catch (ParseException ex) {
                    log.info("ex.getMessage()=" + ex.getMessage());
                }
                acs.setDescription(arrData[1]);
                acs.setBranch(arrData[2]);
                acs.setAmount(BigDecimal.valueOf(Double.parseDouble(arrData[3])));
                acs.setDbCr(arrData[4]);
                acs.setBalance(BigDecimal.valueOf(Double.parseDouble(arrData[5])));
                accountStatementList.add(acs);
            }
        }

        Simulator simSummary = simulatorManager.findByType(Constants.TYPE_ACCOUNT_STATEMENT_SUMMARY);
        AccountStatementSummary summary = new AccountStatementSummary();
        summary.setStartingBalance(BigDecimal.valueOf(Double.parseDouble(simSummary.getData1())));
        summary.setTotalCredit(BigDecimal.valueOf(Double.parseDouble(simSummary.getData2())));
        summary.setTotalDebit(BigDecimal.valueOf(Double.parseDouble(simSummary.getData3())));
        summary.setEndingBalance(BigDecimal.valueOf(Double.parseDouble(simSummary.getData4())));

        model.addAttribute("period", period);
        model.addAttribute("account", account);
        model.addAttribute("accountStatementList", accountStatementList);
        model.addAttribute("asSummary", summary);

        return Constants.APPLICATION_PATH + "/account/accountStatementResult";
    }
}
