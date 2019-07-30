package com.ia.restfulstudentservices.statsdclient;

/***
 * using System;

namespace StatsDClient
{
    class MainClass
    {
        public static void Main(string[] args)
        {
            Console.WriteLine("Sending metrics to StatsD");

            while(true)
            {
                for (int i = 0; i < 10; i++)
                {
                    var statsDClient = new StatsD("graphite.learngraphana.com");
           
                    statsDClient.Send("SqlServer.Orders.LastMinute:1|g");
}
                System.Threading.Thread.Sleep(500);
                Console.WriteLine("Metric was sent!");
            }
        }
    }
}

 */

import java.util.Scanner;

public class StatsDClient {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String input = sc.nextLine();
		
		System.out.println("Input Data read: " + input);
		
		StatsD statsDClient = new StatsD("graphite.learngraphana.com");
		
		statsDClient.send("SqlServer.Orders.LastMinute:1|g");
		
		Thread thread = new Thread();
		try {
			thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Metric was sent!");
		
	}

}
