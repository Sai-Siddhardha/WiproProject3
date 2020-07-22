package com.wipro.eb.service;

import com.wipro.eb.entity.Commercial;
import com.wipro.eb.entity.Connection;
import com.wipro.eb.entity.Domestic;
import com.wipro.eb.exception.InvalidConnectionException;
import com.wipro.eb.exception.InvalidReadingException;

public class ConnectionService {
	public boolean validate(int currentReading, int previousReading, String type) throws InvalidReadingException, InvalidConnectionException
	{
		if((currentReading<previousReading)||(currentReading<0)||(previousReading<0))
		{
			throw new InvalidReadingException("Reading is wrong");
		}
		else if( (type.compareTo("Commercial")==0)||(type.compareTo("Domestic")==0) )
		{
			return true;
		}
		else
		{
			throw new InvalidConnectionException("Invalid Connection Specified");
		}
	}
	public float calculateBillAmt(int currentReading, int previousReading, String type) 
	{
		float BillAmt = 0;
		try 
		{
			if(validate(currentReading, previousReading, type))
			{
				//System.out.println( validate(currentReading, previousReading, type) );
				Connection c;
				if(type.compareTo("Domestic")==0)
				{
					float[] slabs={2.3f,4.2f,5.5f};
					c=new Domestic(currentReading, previousReading, slabs);
					BillAmt=c.computeBill();
				}
				else if(type.compareTo("Commercial")==0)
				{
					float[] slabs={5.2f,6.8f,8.3f};
					c=new Commercial(currentReading, previousReading, slabs);
					BillAmt=c.computeBill();
				}
			}
		} 
		catch (InvalidConnectionException ec) {
			// TODO Auto-generated catch block
			BillAmt = -2;
			//ec.toString();
		}
		catch (InvalidReadingException er) {
			// TODO Auto-generated catch block
			BillAmt = -1;
			//er.toString();
		}
		return BillAmt;
	}
	public String generateBill(int currentReading, int previousReading, String type)
	{
		ConnectionService cs=new ConnectionService();
		float BillAmt=cs.calculateBillAmt(currentReading, previousReading, type);
		if(BillAmt==-1)
			return "Incorrect Reading";
		else if(BillAmt==-2)
			return "Invalid ConnectionType";
		else
			return "Amount to be paid:"+BillAmt;
	}

}
