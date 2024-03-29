package com.ib.webapp.controller.purchase;

import com.ib.Constants;
import com.ib.model.VoucherPurchase;
import com.ib.webapp.controller.BaseFormController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by IMAM on 12/25/14.
 */
@Controller
@RequestMapping("/purchase/phoneVoucherResult*")
public class PhoneVoucherResultController extends BaseFormController {

    public PhoneVoucherResultController() {
        setCancelView("/purchase/phoneVoucherConfirm");
        setSuccessView("redirect:home");
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView handleRequest(
            @ModelAttribute("voucherPurchase") final VoucherPurchase voucherPurchase)
            throws Exception {
        ModelAndView model = new ModelAndView();
        voucherPurchase.setTransactionDate(new Date());
        voucherPurchase.setStatus(Constants.STATUS_SUKSES);
        model.addObject("voucherPurchase", voucherPurchase);

        return model;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView onSubmit(
            @RequestParam(value = "voucherPurchase", required = true) final VoucherPurchase voucherPurchase,
            final RedirectAttributes redirectAttributes,
            final HttpServletRequest request)
            throws Exception
    {
        redirectAttributes.addFlashAttribute("voucherPurchase", voucherPurchase);

        return new ModelAndView(new RedirectView(getSuccessView()));
    }
}
