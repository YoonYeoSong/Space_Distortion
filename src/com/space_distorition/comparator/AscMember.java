package com.space_distorition.comparator;

import java.util.Comparator;

import com.space_distortion.model.vo.Coupon;
import com.space_distortion.model.vo.Member;
import com.space_distortion.model.vo.SnackBar;

public class AscMember implements Comparator<Object> {

	
	@Override
	public int compare(Object o1, Object o2) {
		
		if(o1 instanceof Member)
		{
			String mName1 = ((Member)o1).getMemberName();
			String mName2 = ((Member)o2).getMemberName();					
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
		else if(o1 instanceof SnackBar)
		{
			String mName1 = ((SnackBar)o1).getSnack();
			String mName2 = ((SnackBar)o2).getSnack();					
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
		else if(o1 instanceof Coupon)
		{
			String c1 = ((Coupon)o1).getCoupontNumber();
			String c2 = ((Coupon)o2).getCoupontNumber();
			if(c2.compareTo(c1) < 0)
			{
				return 1;
			}
			else if(c2.compareTo(c1) > -1)
			{
				return -1;
			}
			else
			{
				return 0;
			}
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
