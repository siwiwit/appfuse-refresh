package com.ib.webapp.controller.purchase;

import com.ib.Constants;
import com.ib.model.Simulator;
import com.ib.model.ElectricityPurchase;
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
@RequestMapping("/purchase/electricityPurchaseConfirm*")
public class ElectricityPurchaseConfirmController extends BaseFormController {
    private SimulatorManager simulatorManager;
    private ElectricityPurchase electricityPurchase;
    private String token;
    @Autowired
    public void setSimulatorManager(final SimulatorManager simulatorManager) {
        this.simulatorManager = simulatorManager;
    }

    public ElectricityPurchaseConfirmController() {
        setCancelView("/purchase/electricityPurchaseInput");
        setSuccessView("/purchase/electricityPurchaseResult");
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView handleRequest(
//            @ModelAttribute("electricityPurchase") final Transfer electricityPurchase)
    )
            throws Exception {
        ModelAndView model = new ModelAndView();
        DateFormat sdf = new SimpleDateFormat(DateUtil.getDatePattern());

        electricityPurchase = new ElectricityPurchase();
        Simulator simulator = simulatorManager.findByType(Constants.TYPE_PURCHASE_VOUCHER_ELECTRICITY);

        String data1 = simulator.getData1();
        String[] parsedData1 = data1.split("\\|");
        electricityPurchase.setMeterNumber(parsedData1[0]);
        electricityPurchase.setIdPel(parsedData1[1]);
        electricityPurchase.setCustomerName(parsedData1[2]);
        electricityPurchase.setTarifDaya(parsedData1[3]);

        electricityPurchase.setMlpo(simulator.getData2());
        String data3 = simulator.getData3();
        String[] parsedData3 = data3.split("\\|");
        electricityPurchase.setAmount(BigDecimal.valueOf(Double.parseDouble(parsedData3[0])));
        electricityPurchase.setRpStroomToken(BigDecimal.valueOf(Double.parseDouble(parsedData3[1])));

        //adminBank|materai|ppn|ppj|angsuran
        String data4 = simulator.getData4();
        String[] parsedData4 = data4.split("\\|");
        electricityPurchase.setAdminBank(BigDecimal.valueOf(Double.parseDouble(parsedData4[0])));
        electricityPurchase.setMaterai(BigDecimal.valueOf(Double.parseDouble(parsedData4[1])));
        electricityPurchase.setPpn(BigDecimal.valueOf(Double.parseDouble(parsedData4[2])));
        electricityPurchase.setPpj(BigDecimal.valueOf(Double.parseDouble(parsedData4[3])));
        electricityPurchase.setAngsuran(BigDecimal.valueOf(Double.parseDouble(parsedData4[4])));

        electricityPurchase.setJumlahKwh(Double.parseDouble(simulator.getData5()));
        electricityPurchase.setStroomToken(simulator.getData6());

        model.addObject("electricityPurchase", electricityPurchase);
        model.addObject("token", token);

        return model;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView onSubmit(
//            final Transfer electricityPurchase,
            final RedirectAttributes redirectAttributes,
            final HttpServletRequest request)
            throws Exception
    {

        electricityPurchase.setTransactionDate(new Date());
        electricityPurchase.setStatus(Constants.STATUS_SUKSES);

        redirectAttributes.addFlashAttribute("electricityPurchase", electricityPurchase);
        return new ModelAndView(new RedirectView(getSuccessView()));
    }
}
