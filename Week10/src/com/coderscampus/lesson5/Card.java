package com.coderscampus.lesson5;

public enum Card {

	ACE(14, 1),
	TWO(2, 2),
	THREE(3, 3),
	FOUR (4, 4),
	FIVE(5, 5),
	SIX(6, 6),
	SEVEN(7, 7), 
	EIGHT(8, 8),
	NINE(9, 9),
	TEN(10, 10),
	JACK(11, 11),
	QUEEN(12, 12), 
	KING(13, 13);
	
	
	private Integer cardValue;
	private Integer cardSecondaryValue;
	
	private Card (Integer cardValue, Integer cardSecondaryValue) {
		this.cardValue = cardValue;
		this.cardSecondaryValue = cardSecondaryValue;
	}
	
	public Integer getCardValue() {
		return cardValue;
	}

	public void setCardValue(Integer cardValue) {
		this.cardValue = cardValue;
	}

	public Integer getCardSecondaryValue() {
		return cardSecondaryValue;
	}

	public void setCardSecondaryValue(Integer cardSecondaryValue) {
		this.cardSecondaryValue = cardSecondaryValue;
	}

}
