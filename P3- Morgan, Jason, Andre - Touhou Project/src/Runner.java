public class Runner {
	public static void main(String[] args) {
		Driver driver = new Driver();

		try {
			while (true) {
				driver.repaint();
				Thread.sleep(30);
			}
		} catch (Exception e) {
			System.out.println("");
		}
		
		 
	}
	

}
