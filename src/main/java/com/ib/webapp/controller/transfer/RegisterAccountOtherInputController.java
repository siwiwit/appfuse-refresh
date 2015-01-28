package com.ib.webapp.controller.transfer;

import com.ib.model.Transfer;
import com.ib.webapp.controller.BaseFormController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by IMAM on 12/25/14.
 */
@Controller
@RequestMapping("/transfer/registerAccountOtherInput*")
public class RegisterAccountOtherInputController extends BaseFormController {

    private Transfer transfer;
    private Map<String,String> bankList;

    public RegisterAccountOtherInputController() {
        setCancelView("/transfer/registerAccount");
        setSuccessView("/transfer/registerAccountOtherConfirm");
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView handleRequest(
            @ModelAttribute("bankType") final String bankType)
            throws Exception {
        ModelAndView model = new ModelAndView();

        bankList = new LinkedHashMap<>();
        bankList.put("001", "BCA");
        bankList.put("002", "BNI");
        bankList.put("003", "BRI");
        bankList.put("004", "Mandiri");

        transfer = new Transfer();
        transfer.setTransferType(bankType);

        model.addObject("transfer", transfer);
        model.addObject("bankList", bankList);
        return model;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView onSubmit(
            final RedirectAttributes redirectAttributes,
            final HttpServletRequest request)
            throws Exception
    {
        String bankName = bankList.get(transfer.getDestinationBankCode());
        transfer.setDestinationBankName(bankName);
        redirectAttributes.addFlashAttribute("transfer", transfer);

        return new ModelAndView(new RedirectView(getSuccessView()));
    }
}
