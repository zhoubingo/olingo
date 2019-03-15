package com.penninkhof.odata.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.penninkhof.odata.entities.Company;
import com.penninkhof.odata.service.CompanyService;

@Controller
@RequestMapping(value = "/company")
public class CompanyController {
	
	@Autowired
	private CompanyService service;
	
    @RequestMapping(value = "/show",method = RequestMethod.GET)
    @ResponseBody
    public JsonObject show(@RequestParam(value = "id")int id){
        //List<Company> list = service.findCompany();
    	
    	JsonObject jo = new JsonObject();
    	//List<Company> list1 = service.findAllcompany();
    	List<Company> list2 = service.findCompany();
    	
    	jo.add("data", (JsonElement) list2);
    	
    	Company company  = service.findCompanyById(id);
    	
    	//System.out.println("list1="+ list1);
    	System.out.println("list1="+ list2);
    	System.out.println("id="+ id + company);
    
        return jo;
    }

}
