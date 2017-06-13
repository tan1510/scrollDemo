

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;

import densan.s.game.Scroll.Scroll;
import densan.s.game.drawing.Drawer;
import densan.s.game.input.KeyInput;
import densan.s.game.manager.GameManager;
import densan.s.game.manager.Updatable;

public class DemoScroll {

	public static void main(String args[]){
		GameManager.getInstance().createFrame(640, 480);
		GameManager.getInstance().setUpdatable(new TestScene());
	}
	
	
	
	
	public static class TestScene implements Updatable{

		Scroll sc = Scroll.getInstance();
		
		public TestScene(){
			sc.rengeSpesification(-100, -100, 100, 100);
		}
		
		@Override
		public void update() {
			// TODO 自動生成されたメソッド・スタブ
			if(KeyInput.isPressing(KeyEvent.VK_UP)){
				sc.addOffset(0, -2);
			}if(KeyInput.isPressing(KeyEvent.VK_DOWN)){
				sc.addOffset(0, 2);
			}if(KeyInput.isPressing(KeyEvent.VK_RIGHT)){
				sc.addOffset(2, 0);
			}if(KeyInput.isPressing(KeyEvent.VK_LEFT)){
				sc.addOffset(-2, 0);
			}
			
		}
		
		@Override
		public void draw(Drawer d) {
			// TODO 自動生成されたメソッド・スタブ
			d.setColor(Color.red);
			
			d.drawCircle(240-sc.getOffsetX(), 240-sc.getOffsetY(), 20);
			
			//見やすいように水平線を描画
			d.setColor(Color.BLACK);
			d.drawLine(240-sc.getOffsetX(), 580-sc.getOffsetY(), 240-sc.getOffsetX(), -100-sc.getOffsetY(), 3);
			d.drawLine(740-sc.getOffsetX(),240-sc.getOffsetY(),-100-sc.getOffsetX(),240-sc.getOffsetY(),3);
			
			d.setFontSize(20);
			//黒
			d.setColor(Color.BLACK);
			d.drawString("offsetX:"+sc.getOffsetX(), 10, 20);
			d.drawString("offsetY:"+sc.getOffsetY(), 10, 40);
		}
	}
}
