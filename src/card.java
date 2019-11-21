
public class card {
	String type;
	String value;
	
	int getValue() {
		if (this.value.equals("Boer") || this.value.equals("Vrouw") || this.value.equals("Koning")) {
			return 10;
		} else if(this.value.equals("Aas")) {
			return 11;
		}
		return Integer.parseInt(this.value);
	}
}
