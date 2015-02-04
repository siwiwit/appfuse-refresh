package com.ib.webapp.controller.purchase;

import com.ib.model.ElectricityPurchase;
import com.ib.webapp.controller.BaseFormController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by IMAM on 12/25/14.
 */
@Controller
@RequestMapping("/purchase/electricityPurchaseInput*")
public class ElectricityPurchaseInputController extends BaseFormController {

    private Map<String,String> accountNumberList;

    public ElectricityPurchaseInputController() {
        setCancelView("redirect:home");
        setSuccessView("/purchase/electricityPurchaseConfirm");
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView handleRequest(
            @ModelAttribute("electricityPurchase") final ElectricityPurchase electricityPurchase)
            throws Exception {
        ModelAndView model = new ModelAndView();

        model.addObject("electricityPurchase", electricityPurchase);
        return model;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView onSubmit(
            final RedirectAttributes redirectAttributes,
            final HttpServletRequest request)
            throws Exception
    {


        return new ModelAndView(new RedirectView(getSuccessView()));
    }

}
