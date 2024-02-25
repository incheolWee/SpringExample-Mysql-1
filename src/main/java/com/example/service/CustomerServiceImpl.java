package com.example.service;

import com.example.dao.CustomerDAO;
import com.example.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerDAO customerDAO;

    @Override
    @Transactional //어떤어노테이션?
    public List<Customer > getCustomers(){
        return customerDAO.getCustomers();
    }

    @Override
    @Transactional
    public Customer getCustomers(int theId){
        return customerDAO.getCustomer(theId);
    }

    @Override
    @Transactional
    public void deletCustomer(int theId){
        customerDAO.deleteCustomer(theId);
    }

}
