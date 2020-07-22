package com.wipro.eb.entity;

public class Commercial extends Connection {

	public Commercial(int currentReading, int previousReading, float[] slabs) {
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
		float x1=0;
		if(x>=10000)
			x1=x*0.09f;
		else if(x>=5000)
			x1=x*0.06f;
		else
			x1=x*0.02f;
		x=x+x1;
		return x;
	}
}
