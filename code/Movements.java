import lejos.nxt.Motor;
import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;

public class Movements
{
	
	int zeroPos = 0;
	public int[] possitions = new int[]{170, 195, 215, 245, 265, 290, 315, 336}; 

	
	public Movements() {}
  
	public void makeSound()
	{
		Motor.B.rotate(-180, true);
	}
	
	public void calibrate()
	{

		Motor.A.setSpeed(120);
		TouchSensor touch = new TouchSensor(SensorPort.S1);
		Motor.A.backward();
		while (true) {
    	  if(touch.isPressed())
		  {
			  Motor.A.stop();
			  break;
		  }
		}
		zeroPos = Motor.A.getTachoCount();
		moveTo(0);
		Motor.A.setSpeed(200);
	}
	
	public void moveTo(int number)
	{
			
		Motor.A.rotateTo(zeroPos + possitions[number]);
	}
	
	public void sleep(int time_ms)
	{
		try
		{
			Thread.sleep(time_ms);
		}
		catch(InterruptedException e){}
	}
	
	public void playOneNode(int number)
	{
		moveTo(number);
		makeSound();
		sleep(300);
	}
}