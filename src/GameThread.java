
public class GameThread extends Thread {
	GameFrame frame;
	boolean visible;
	String name,input;
	public GameThread(boolean visible)
	{
		this.visible = visible;
	}
	public void run()
	{
		name = Validator.ValidateName(input, "Enter your username: ");
		frame = new GameFrame(name, visible);
		
		
	}
	public void closeThis()
	{
		frame.closeThis();
	}

}
