package com.nehaspring.springmvcrest.services;

import java.util.List;

import com.nehaspring.springmvcrest.api.v1.model.VendorDTO;

public interface VendorService {

	VendorDTO createNewVendor(VendorDTO vendorDTO);
	List<VendorDTO> getAllVendors();
	VendorDTO getVendorById(Long id);
	VendorDTO updateVendor(Long id, VendorDTO vendorDTO);
	VendorDTO pactchVendor(Long id, VendorDTO vendorDTO);
	void deleteVendor(Long id);
}
