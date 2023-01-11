package org.zerock.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
public class PageDTO {
	private int startPage;
	private int endpage;
	private boolean prev, next;

	private int total;
	private Criteria cri;

	public PageDTO(Criteria cri, int total ) {
		this.total = total;
		this.cri = cri;

		this.endpage = (int) (Math.ceil(cri.getPageNum() / 10.0)) * 10;
		this.startPage = this.endpage - 9;
		
		int realEnd = (int) (Math.ceil((total*1.0)/cri.getAmount()));
		
		if(realEnd < this.endpage) {
			this.endpage=realEnd;
		}
		this.prev = this.startPage > 1;
		this.next = this.endpage <realEnd;
		
	}

}
