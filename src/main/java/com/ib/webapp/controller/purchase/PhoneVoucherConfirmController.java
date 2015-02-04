package com.ib.webapp.controller.purchase;

import com.ib.Constants;
import com.ib.model.Simulator;
import com.ib.model.Transfer;
import com.ib.model.VoucherPurchase;
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
@RequestMapping("/purchase/phoneVoucherConfirm*")
public class PhoneVoucherConfirmController extends BaseFormController {
    private SimulatorManager simulatorManager;
    private VoucherPurchase voucherPurchase;
    private String token;
    @Autowired
    public void setSimulatorManager(final SimulatorManager simulatorManager) {
        this.simulatorManager = simulatorManager;
    }

    public PhoneVoucherConfirmController() {
        setCancelView("/purchase/phoneVoucherInput");
        setSuccessView("/purchase/phoneVoucherResult");
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView handleRequest(
//            @ModelAttribute("voucherPurchase") final Transfer voucherPurchase)
    )
            throws Exception {
        ModelAndView model = new ModelAndView();
        DateFormat sdf = new SimpleDateFormat(DateUtil.getDatePattern());

        voucherPurchase = new VoucherPurchase();
        Simulator simulator = simulatorManager.findByType(Constants.TYPE_PURCHASE_VOUCHER_PHONE);
        voucherPurchase.setPhoneNumber(simulator.getData1());
        voucherPurchase.setOperator(simulator.getData2());
        voucherPurchase.setDenomination(simulator.getData3());
        voucherPurchase.setAmount(BigDecimal.valueOf(Double.parseDouble(simulator.getData4())));


        model.addObject("voucherPurchase", voucherPurchase);
        model.addObject("token", token);

        return model;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView onSubmit(
//            final Transfer voucherPurchase,
            final RedirectAttributes redirectAttributes,
            final HttpServletRequest request)
            throws Exception
    {

        voucherPurchase.setTransactionDate(new Date());
        voucherPurchase.setStatus(Constants.STATUS_SUKSES);

        redirectAttributes.addFlashAttribute("voucherPurchase", voucherPurchase);
        return new ModelAndView(new RedirectView(getSuccessView()));
    }
}
