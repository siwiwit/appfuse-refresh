package com.ib.webapp.controller.purchase;

import com.ib.Constants;
import com.ib.model.ElectricityPurchase;
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
@RequestMapping("/purchase/electricityPurchaseResult*")
public class ElectricityPurchaseResultController extends BaseFormController {

    public ElectricityPurchaseResultController() {
        setCancelView("/purchase/electricityPurchaseConfirm");
        setSuccessView("redirect:home");
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView handleRequest(
            @ModelAttribute("electricityPurchase") final ElectricityPurchase electricityPurchase)
            throws Exception {
        ModelAndView model = new ModelAndView();
        electricityPurchase.setTransactionDate(new Date());
        electricityPurchase.setStatus(Constants.STATUS_SUKSES);
        model.addObject("electricityPurchase", electricityPurchase);

        return model;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView onSubmit(
            @RequestParam(value = "electricityPurchase", required = true) final ElectricityPurchase electricityPurchase,
            final RedirectAttributes redirectAttributes,
            final HttpServletRequest request)
            throws Exception
    {
        redirectAttributes.addFlashAttribute("electricityPurchase", electricityPurchase);

        return new ModelAndView(new RedirectView(getSuccessView()));
    }
}
