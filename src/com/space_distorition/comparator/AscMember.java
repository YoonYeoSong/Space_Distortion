package com.space_distorition.comparator;

import java.util.Comparator;

import com.space_distortion.model.vo.Member;

public class AscMember implements Comparator<Member> {

	
	@Override
	public int compare(Member o1, Member o2) {
		String mName1 = o1.getMemberName();
		String mName2 = o2.getMemberName();		
		if(mName2.compareTo(mName1) < 0)
		{
			return 1;
		}
		else if(mName2.compareTo(mName1) > -1)
		{
			return -1;
		}
		else
		{
			return 0;
		}
		
	}
	
	@Override
	public boolean equals(Object obj) {
		
		return super.equals(obj);
	}
}
