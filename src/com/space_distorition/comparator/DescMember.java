package com.space_distorition.comparator;

import java.util.Comparator;

import com.space_distortion.model.vo.Member;

public class DescMember implements Comparator<Member>{
	
	
	@Override
	public int compare(Member o1, Member o2) {
		String mName1 = o1.getMemberName();
		String mName2 = o2.getMemberName();
		
		if(mName1.compareTo(mName2) < 0)
		{
			return 1;
		}
		else if(mName1.compareTo(mName2) > -1)
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
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	
}
