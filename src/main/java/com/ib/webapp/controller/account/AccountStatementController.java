package com.ib.webapp.controller.account;

import com.ib.Constants;
import com.ib.model.Account;
import com.ib.model.Simulator;
import com.ib.service.SimulatorManager;
import com.ib.util.DateUtil;
import com.ib.webapp.controller.BaseFormController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Controller to signup new users.
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
@Controller
@RequestMapping(Constants.APPLICATION_PATH + "/account/accountStatement")
public class AccountStatementController extends BaseFormController {
    private SimulatorManager simulatorManager;

    @Autowired
    public void setSimulatorManager(final SimulatorManager simulatorManager) {
        this.simulatorManager = simulatorManager;
    }

    public AccountStatementController() {
        setCancelView("redirect:home");
        setSuccessView("redirect:" + Constants.APPLICATION_PATH  +"/account/accountStatementResult");
    }

    @RequestMapping(method = RequestMethod.GET)
    public String controlMapping(
            @ModelAttribute("period") final String period,
            final Model model) {
        Simulator simulator = simulatorManager.findByType(Constants.TYPE_BALANCE_INQUIRY);
        Account account = new Account();
        account.setAccountNumber(simulator.getData1());
        account.setAccountType(simulator.getData2());
        account.setCurrency(simulator.getData3());
        account.setBalance(BigDecimal.valueOf(Double.valueOf(simulator.getData4())));
        account.setResponseCode(simulator.getResponseCode());
        account.setDescription(simulator.getDescription());

        model.addAttribute("account", account);
        model.addAttribute("periodType", "daily");
        model.addAttribute("applPath", Constants.APPLICATION_PATH);
        model.addAttribute("newDate", DateUtil.convertDateToString(new Date()));

        return Constants.APPLICATION_PATH + "/account/accountStatement";
    }

    @RequestMapping(method=RequestMethod.POST)
    public String onSubmit(
            @RequestParam(value = "periodType", required = false) final String periodType,
            @RequestParam(value = "datepickerFrom", required = false) final String datepickerFrom,
            @RequestParam(value = "datepickerUntil", required = false) final String datepickerUntil,
            @RequestParam(value = "months", required = false) final String months, final RedirectAttributes redirectAttributes,
            final HttpServletRequest request)
            throws Exception
    {
        //saveMessage(request, getText("user.saved", user.getFullName(), locale));

        // place the data into the request for retrieval on next page
        String period = datepickerFrom + " - " + datepickerUntil;
        if (periodType.equals("monthly")) {
            period = months;
        }
//        request.setAttribute("period", period);

        redirectAttributes.addFlashAttribute("period", period);


        return getSuccessView();
    }

}
