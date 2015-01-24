package com.ib.webapp.controller.account;

import com.ib.Constants;
import com.ib.model.Account;
import com.ib.model.Simulator;
import com.ib.service.SimulatorManager;
import com.ib.webapp.controller.BaseFormController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;

/**
 * Created by IMAM on 12/16/14.
 */
@Controller
@RequestMapping("/account/balanceInquiry*")
public class BalanceInquiryController extends BaseFormController {
    private SimulatorManager simulatorManager;
    private Account account;

    @Autowired
    public void setSimulatorManager(final SimulatorManager simulatorManager) {
        this.simulatorManager = simulatorManager;
    }

    public BalanceInquiryController() {
        setCancelView("home");
        setSuccessView("home");

    }


    @ModelAttribute
    @RequestMapping(method = RequestMethod.GET)
    protected Account showForm(HttpServletRequest request)
            throws Exception {

        return getAccountInJSON("Imam");
    }

    @RequestMapping(value="{name}", method = RequestMethod.GET)
    public @ResponseBody Account getAccountInJSON(@PathVariable String name) {

        Simulator simulator = simulatorManager.findByType(Constants.TYPE_BALANCE_INQUIRY);
        Account account = new Account();
        account.setAccountNumber(simulator.getData1());
        account.setAccountType(simulator.getData2());
        account.setCurrency(simulator.getData3());
        account.setBalance(BigDecimal.valueOf(Double.valueOf(simulator.getData4())));
        account.setResponseCode(simulator.getResponseCode());
        account.setDescription(simulator.getDescription());
        return account;

    }
/*
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView handleRequest()
            throws Exception {
        return new ModelAndView();
    }*/
}
