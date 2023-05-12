package com.coderscampus.lesson5;

public class EnumApplication {
	

	public static void main(String[] args) {
		
		User user = new User("Trevor Page", "alkdj;lkafjs");
		
		System.out.println(user);
		
		if ("A".equals(user.getStatus().getValue())) {
			System.out.println("User is active");
		}
		
		if ("ACTIVE".equals(user.getStatus().name())) {
			System.out.println("User is active");
		}
		
		System.out.println( "Ace primary value: " + Card.ACE.getCardValue());
		System.out.println("Ace seconday value: " + Card.ACE.getCardSecondaryValue());
	}
}
