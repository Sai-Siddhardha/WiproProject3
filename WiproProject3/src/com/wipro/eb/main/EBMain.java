package com.wipro.eb.main;

import com.wipro.eb.service.ConnectionService;

public class EBMain {
	public static void main(String []args)
	{
		ConnectionService cs = new ConnectionService();
		System.out.println(cs.generateBill(130, 100, "Commercial"));
	}
}
