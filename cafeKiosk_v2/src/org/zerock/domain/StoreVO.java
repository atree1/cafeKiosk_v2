package org.zerock.domain;

import lombok.Data;

@Data
public class StoreVO {
	int sno, pnum;
	double lng, lat;
	String owid, sname, addr;
}
