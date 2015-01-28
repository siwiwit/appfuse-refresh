package com.ib.webapp.controller.transfer;

import com.ib.model.Transfer;
import com.ib.webapp.controller.BaseFormController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
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
@RequestMapping("/transfer/registerAccountInput*")
public class RegisterAccountInputController extends BaseFormController {

    public RegisterAccountInputController() {
        setCancelView("/transfer/registerAccount");
        setSuccessView("/transfer/registerAccountConfirm");
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView handleRequest(
            @ModelAttribute("transfer") final Transfer transfer)
            throws Exception {
        ModelAndView model = new ModelAndView();

        model.addObject("transfer", transfer);
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
