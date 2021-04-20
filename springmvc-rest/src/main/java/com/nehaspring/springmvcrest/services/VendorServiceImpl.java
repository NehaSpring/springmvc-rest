package com.nehaspring.springmvcrest.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.nehaspring.springmvcrest.api.v1.mapper.VendorMapper;
import com.nehaspring.springmvcrest.api.v1.model.VendorDTO;
import com.nehaspring.springmvcrest.domain.Vendor;
import com.nehaspring.springmvcrest.repositories.VendorRepository;

@Service
public class VendorServiceImpl implements VendorService {

	private static final String URL ="/api/v1/vendors/";
	private final VendorRepository vendorRepository;
	private final VendorMapper vendorMapper;
	
	public VendorServiceImpl(VendorRepository vendorRepository, VendorMapper vendorMapper) {
		super();
		this.vendorRepository = vendorRepository;
		this.vendorMapper = vendorMapper;
	}

	@Override
	public VendorDTO createNewVendor(VendorDTO vendorDTO) {
		
		Vendor vendor = vendorMapper.vendorDTOToVendor(vendorDTO);
		return vendorMapper.vendorToVendorDTO(vendorRepository.save(vendor));
	}

	@Override
	public VendorDTO getVendorById(Long id) {
		
		return vendorRepository.findById(id)
	               .map(vendorMapper::vendorToVendorDTO)
	               .orElseThrow(ResourceNotFoundException::new);
	}

	@Override
	public VendorDTO updateVendor(Long id, VendorDTO vendorDTO) {
		
		Vendor vendor = vendorMapper.vendorDTOToVendor(vendorDTO);
		vendor.setId(id);
		return saveVendor(vendor);
	}

	@Override
	public VendorDTO pactchVendor(Long id, VendorDTO vendorDTO) {
		
		return vendorRepository.findById(id)
				.map(vendor ->{
					if(vendorDTO.getName() != null) {
						vendor.setName(vendorDTO.getName());
					}
					return saveVendor(vendor);
				}).orElseThrow(ResourceNotFoundException::new);
	}

	@Override
	public void deleteVendor(Long id) {
		vendorRepository.deleteById(id);

	}

	@Override
	public List<VendorDTO> getAllVendors() {
		
		return vendorRepository.findAll()
								.stream()
								.map(vendor ->{
									VendorDTO vendorDTO = vendorMapper.vendorToVendorDTO(vendor);
									vendorDTO.setVendor_url(getVendorUrl(vendor.getId()));
									return vendorDTO;
								}).collect(Collectors.toList());
	}
	
	private VendorDTO saveVendor(Vendor vendor) {
	
		Vendor savedVendor = vendorRepository.save(vendor);
		VendorDTO returnedVendorDTO = vendorMapper.vendorToVendorDTO(savedVendor);
		returnedVendorDTO.setVendor_url(getVendorUrl(savedVendor.getId()));
		
		return returnedVendorDTO;
	}
	
	private String getVendorUrl(Long id) {
		return URL + id;
	}

}
