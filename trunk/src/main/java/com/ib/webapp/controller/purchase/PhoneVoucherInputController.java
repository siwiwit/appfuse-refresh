package com.ib.webapp.controller.purchase;

import com.ib.Constants;
import com.ib.model.Transfer;
import com.ib.util.DateUtil;
import com.ib.webapp.controller.BaseFormController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by IMAM on 12/25/14.
 */
@Controller
@RequestMapping("/purchase/phoneVoucherInput*")
public class PhoneVoucherInputController extends BaseFormController {

    private Transfer transfer;
    private Map<String,String> accountNumberList;

    public PhoneVoucherInputController() {
        setCancelView("redirect:home");
        setSuccessView("purchase/phoneVocherConfirm");
    }
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView handleRequest()
            throws Exception {
        ModelAndView model = new ModelAndView();

        transfer = new Transfer();
        transfer.setTransferType(Constants.SAME_BANK);

        model.addObject("transfer", transfer);

        accountNumberList = new LinkedHashMap<>();
        accountNumberList.put("1112223333", "1112223333");
        accountNumberList.put("3333344444", "3333344444");

        model.addObject("transfer", transfer);
        model.addObject("accountNumberList", accountNumberList);
        model.addObject("transferTime", "transferNow");
        model.addObject("newDate", DateUtil.convertDateToString(new Date()));
        return model;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView onSubmit(
            final RedirectAttributes redirectAttributes,
            final HttpServletRequest request)
            throws Exception
    {

        redirectAttributes.addFlashAttribute("transfer", transfer);

        return new ModelAndView(new RedirectView(getSuccessView()));
    }
}
