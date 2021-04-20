package com.nehaspring.springmvcrest.api.v1.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class VendorDTO {

	private Long id;
	@ApiModelProperty(value = "Vendor Name", required  = true)
	private String name;
	private String vendor_url;
}
