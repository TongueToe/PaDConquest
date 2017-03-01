public enum Element {
	FIRE(0), WATER(1), WOOD(2), LIGHT(3), DARK(4);

	private final int value;
	private Element(int value){
		this.value = value;
	}

	public int getValue(){
		return value;
	}
}
