package com.freeinfo.mediaw.rootservice.model;

import lombok.Data;

@Data
public class Rate {

    private int limit;
    private int remaining;
    private int reset;
	
}
