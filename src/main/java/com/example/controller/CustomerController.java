package com.example.controller;

import java.util.List;

import com.example.entity.Customer;
import com.example.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public String listCustomers(Model theModel){
        List <Customer> theCustomers = customerService.getCustomers();
        theModel.addAttribute("customers",theCustomers);
        return "list-customers";
    }

    @GetMapping("/showForm")
    public String showFormForAdd(Model theModel){
        Customer theCustomer = new Customer();
        theModel.addAttribute("customer",theCustomer);
        return "customer-form";
    }
    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer theCustomer){
        customerService.saveCustomer(theCustomer);
        return "redirect:/customer/list"; //redirect 뜻 알기
    }

    @GetMapping("/updateForm")
    public String howFormForUpdate(@RequestParam("customerId") int theId, Model theModel){
        Customer theCustomer =  customerService.getCustomer(theId);
        theModel.addAttribute("customer",theCustomer);
        return "customer-form";
    }
    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("customerId") int theId){
        customerService.deleteCustomer(theId);
        return "redirect:/customer/list";
    }
}
