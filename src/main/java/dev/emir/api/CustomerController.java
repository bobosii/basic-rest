package dev.emir.api;

import dev.emir.business.abstracts.ICustomerService;
import dev.emir.dto.CustomerResponse;
import dev.emir.dto.CustomerDtoConverter;
import dev.emir.dto.CustomerSaveRequest;
import dev.emir.dto.CustomerUpdateRequest;
import dev.emir.entities.Customer;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;
    @Autowired
    private CustomerDtoConverter converter;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/customers")
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerResponse> findAll(){
        /*

        Custom model mapper

        List<CustomerDto> customerDtoList = this.customerService.findAll().stream().map(
                customer ->
        this.converter.convertDto(customer)).collect(Collectors.toList());
        */
        List<CustomerResponse> customerResponseList = this.customerService.findAll().stream().map(
                customer -> modelMapper.map(customer, CustomerResponse.class)
        ).collect(Collectors.toList());
        return customerResponseList;
    }

    @PostMapping("/customers")
    @ResponseStatus(HttpStatus.CREATED)
    public Customer save(@RequestBody CustomerSaveRequest customerSaveRequest){
        Customer newCustomer = this.modelMapper.map(customerSaveRequest, Customer.class);
        newCustomer.setOnDate(LocalDate.now());
        return this.customerService.save(newCustomer);
    }

    @PutMapping("/customers")
    @ResponseStatus(HttpStatus.OK)
    public Customer update(@RequestBody CustomerUpdateRequest customerUpdateRequest){
        Customer updateCustomer = this.customerService.getById(customerUpdateRequest.getId());

        updateCustomer.setName(customerUpdateRequest.getName());
        updateCustomer.setGender(customerUpdateRequest.getGender());

        return this.customerService.update(updateCustomer);
    }

    @DeleteMapping("/customers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") int id){
        this.customerService.delete(id);
    }

    @GetMapping("/customers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerResponse getById(@PathVariable("id") int id){

        /* Custom model mapper,
        Customer customer = this.customerService.getById(id);
        CustomerDto customerDto = this.converter.convertDto(customer);
         */

        // Usage with modelMapper
        return this.modelMapper.map(this.customerService.getById(id), CustomerResponse.class);
    }
}
