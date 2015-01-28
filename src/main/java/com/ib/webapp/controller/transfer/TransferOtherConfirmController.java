package com.ib.webapp.controller.transfer;

import com.ib.Constants;
import com.ib.model.Simulator;
import com.ib.model.Transfer;
import com.ib.service.SimulatorManager;
import com.ib.util.DateUtil;
import com.ib.webapp.controller.BaseFormController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by IMAM on 12/25/14.
 */
@Controller
@RequestMapping("/transfer/transferOtherConfirm*")
public class TransferOtherConfirmController extends BaseFormController {
    private SimulatorManager simulatorManager;
    private Transfer transfer;
    private String token;
    @Autowired
    public void setSimulatorManager(final SimulatorManager simulatorManager) {
        this.simulatorManager = simulatorManager;
    }

    public TransferOtherConfirmController() {
        setCancelView("/transfer/transferOtherInput");
        setSuccessView("/transfer/transferOtherResult");
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView handleRequest(
//            @ModelAttribute("transfer") final Transfer transfer)
    )
            throws Exception {
        ModelAndView model = new ModelAndView();
        DateFormat sdf = new SimpleDateFormat(DateUtil.getDatePattern());

        transfer = new Transfer();
        Simulator simulator = simulatorManager.findByType(Constants.TYPE_TRANSFER_OTHER_BANK);
        transfer.setDestinationBankCode(simulator.getData1());
        transfer.setDestinationBankName(simulator.getData2());
        transfer.setDestinationAccountNumber(simulator.getData3());
        transfer.setDestinationAccountName(simulator.getData4());
        transfer.setAmount(BigDecimal.valueOf(Double.parseDouble(simulator.getData5())));
        transfer.setNews(simulator.getData6());
        transfer.setTransferTime(sdf.parse(simulator.getData7()));

        model.addObject("transfer", transfer);
        model.addObject("token", token);

        return model;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView onSubmit(
//            final Transfer transfer,
            final RedirectAttributes redirectAttributes,
            final HttpServletRequest request)
            throws Exception
    {

        transfer.setTransactionDate(new Date());
        transfer.setStatus(Constants.STATUS_SUKSES);

        redirectAttributes.addFlashAttribute("transfer", transfer);
        return new ModelAndView(new RedirectView(getSuccessView()));
    }
}
