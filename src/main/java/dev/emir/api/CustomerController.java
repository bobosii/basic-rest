package dev.emir.api;

import dev.emir.business.abstracts.ICustomerService;
import dev.emir.dto.CustomerDto;
import dev.emir.dto.CustomerDtoConverter;
import dev.emir.entities.Customer;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
    public List<CustomerDto> findAll(){
        /*

        Custom model mapper

        List<CustomerDto> customerDtoList = this.customerService.findAll().stream().map(
                customer ->
        this.converter.convertDto(customer)).collect(Collectors.toList());
        */
        List<CustomerDto> customerDtoList = this.customerService.findAll().stream().map(
                customer -> modelMapper.map(customer,CustomerDto.class)
        ).collect(Collectors.toList());
        return customerDtoList;
    }

    @PostMapping("/customers")
    @ResponseStatus(HttpStatus.CREATED)
    public Customer save(@RequestBody Customer customer){
        return this.customerService.save(customer);
    }

    @PutMapping("/customers")
    @ResponseStatus(HttpStatus.OK)
    public Customer update(@RequestBody Customer customer){
        return this.customerService.update(customer);
    }

    @DeleteMapping("/customers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") int id){
        this.customerService.delete(id);
    }

    @GetMapping("/customers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerDto getById(@PathVariable("id") int id){

        /* Custom model mapper,
        Customer customer = this.customerService.getById(id);
        CustomerDto customerDto = this.converter.convertDto(customer);
         */

        // Usage with modelMapper
        return this.modelMapper.map(this.customerService.getById(id),CustomerDto.class);
    }
}
