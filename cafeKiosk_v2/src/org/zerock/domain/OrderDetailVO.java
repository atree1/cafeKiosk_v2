package org.zerock.domain;

import java.util.Date;

import lombok.Data;

@Data
public class OrderDetailVO {
	
	private int mno,sno,ono,qty,price;
	private String state,menu;
	private Date regdate;


}
