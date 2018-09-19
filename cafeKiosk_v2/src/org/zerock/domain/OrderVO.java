package org.zerock.domain;

import java.util.Date;

import lombok.Data;

@Data
public class OrderVO {
	private int ono;
	private Date regdate;
	private String state;
}
