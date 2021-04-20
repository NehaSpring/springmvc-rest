package com.nehaspring.springmvcrest.controllers.v1;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.nehaspring.springmvcrest.api.v1.model.VendorDTO;
import com.nehaspring.springmvcrest.api.v1.model.VendorListDTO;
import com.nehaspring.springmvcrest.services.VendorService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("Vendors")
@RestController
@RequestMapping("/api/v1/vendors")
public class Vendors {

	private final VendorService vendorService;
	
	public Vendors(VendorService vendorService) {
		super();
		this.vendorService = vendorService;
	}

	@ApiOperation(value = "Returns list of Vendors ")
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public VendorListDTO getAllVendors() {
		return new VendorListDTO(vendorService.getAllVendors());
	}
	
	@ApiOperation(value = "Returns Vendor for Specific Id", notes = "Suply Vendor Id to retrive Vendor")
	@GetMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public VendorDTO getVendorById(@PathVariable String id) {
		
		return vendorService.getVendorById(Long.valueOf(id));
	}
	
	@ApiOperation(value = "Will Create new Vendor")
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public VendorDTO createNewVendor(@RequestBody VendorDTO vendorDTO) {
		return vendorService.createNewVendor(vendorDTO);
	}
	
	@ApiOperation(value = "Update existing Vendor based on Id", notes = "Update vendor Data all fields are required")
	@PutMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public VendorDTO updateVendor(@PathVariable String id, @RequestBody VendorDTO vendorDTO) {
		return vendorService.updateVendor(Long.valueOf(id), vendorDTO);
	}
	
	@ApiOperation(value = "Update existing Vendor property")
	@PatchMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public VendorDTO patchVendor(@PathVariable String id, @RequestBody VendorDTO vendorDTO) {
		return vendorService.pactchVendor(Long.valueOf(id), vendorDTO);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public void deleteVendorById(@PathVariable String id) {
		 vendorService.deleteVendor(Long.valueOf(id));
	}
	
	
	
	
	
	
}
