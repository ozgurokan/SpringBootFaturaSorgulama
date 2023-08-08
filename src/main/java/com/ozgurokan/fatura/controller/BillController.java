package com.ozgurokan.fatura.controller;


import com.ozgurokan.fatura.entity.Bill;
import com.ozgurokan.fatura.entity.User;
import com.ozgurokan.fatura.service.BillService;
import com.ozgurokan.fatura.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/bills")
public class BillController {

    private BillService billService;
    private UserService userService;

    @Autowired
    public BillController(BillService theBillService,UserService theUserService){
        billService = theBillService;
        userService = theUserService;
    }


    @GetMapping("/inquiry")
    public  String inquiry(Model theModel){

        String code = null;

        theModel.addAttribute("account_id", code);

        return "users/bill-search-by-code";
    }

    @GetMapping("/bill-list-by-user-code")
    public String listByUserCode(@RequestParam(value = "accountCode") String code, Model theModel){
        List<Bill> theBills = billService.findByAccountId(code);
        User theUser = userService.findUserByCode(code);

        theModel.addAttribute("bills",theBills);
        theModel.addAttribute("user",theUser);
        return "users/bill-list-by-user-code";
    }


    @GetMapping("/list")
    public String listBills(Model theModelBill){
        List<Bill> theBills = billService.findAll();

        theModelBill.addAttribute("bills",theBills);

        return "users/list-bills";
    }

    @GetMapping("/pay")
    public String pay(@RequestParam("id")int theId,
                      @RequestParam("code") String code,Model theModel){

        billService.pay(theId,code);

        return listByUserCode(code,theModel);
    }

    @GetMapping("/payCancel")
    public String payCancel(@RequestParam("id")int theId,
                            @RequestParam("code") String code,Model theModel){

        billService.payCancel(theId,code);

        return listByUserCode(code,theModel);
    }

    @PostMapping("/save")
    public String saveBill(@ModelAttribute("bill") Bill theBill) {
        // save the user
        billService.save(theBill);

        return "redirect:/bills/list";
    }

    @GetMapping("/showFormForAdd")
    public String showFromForAdd(Model theModel) {
        // create model attribute to bind form data
        Bill theBill = new Bill();

        theModel.addAttribute("bill", theBill);

        return "users/form-bill";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("billId") int theId,Model theModel){

        Bill theBill = billService.findById(theId);

        theModel.addAttribute("bill",theBill);

        return "users/form-bill";
    }


    @GetMapping("/delete")
    public String delete(@RequestParam("billId") int theId){

        billService.deleteById(theId);

        return "redirect:/bills/list";
    }
}
