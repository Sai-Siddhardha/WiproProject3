package com.wipro.eb.entity;

public class Domestic extends Connection {
	
	public Domestic(int currentReading, int previousReading, float[] slabs) {
		super(currentReading, previousReading, slabs);
		// TODO Auto-generated constructor stub
	}
	public float computeBill()
	{
		int r=currentReading-previousReading;
		float x=0;
		if((r>0)&&(r<50))
		{
			x=r*slabs[0];
		}
		else if((r>=50)&&(r<100))
		{
			x=(r-50)*slabs[1]+(50)*slabs[0];
		}
		else
		{
			x=(r-100)*slabs[2]+(50)*slabs[1]+(50)*slabs[0];
		}
		return x;
		
	}
}
