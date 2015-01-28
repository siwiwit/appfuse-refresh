package com.ib.webapp.controller.transfer;

import com.ib.model.Transfer;
import com.ib.webapp.controller.BaseFormController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by IMAM on 12/25/14.
 */
@Controller
@RequestMapping("/transfer/registerAccount*")
public class RegisterAccountController extends BaseFormController {

    public RegisterAccountController() {
        setCancelView("redirect:home");
        setSuccessView("/transfer/registerAccountInput");
    }


    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView handleRequest()
            throws Exception {
        ModelAndView model = new ModelAndView();
        model.addObject("bankType", "sameBank");
        return model;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView onSubmit(
            @RequestParam(value = "bankType", required = true) final String bankType,
            final RedirectAttributes redirectAttributes,
            final HttpServletRequest request)
            throws Exception
    {
        Transfer transfer = new Transfer();
        transfer.setTransferType(bankType);
        redirectAttributes.addFlashAttribute("transfer", transfer);
        if (bankType.equals("otherBank")) {
            return new ModelAndView(new RedirectView("/transfer/registerAccountOtherInput"));
        }

        return new ModelAndView(new RedirectView(getSuccessView()));
    }
}
