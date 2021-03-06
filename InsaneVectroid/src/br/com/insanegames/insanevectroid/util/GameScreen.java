package br.com.insanegames.insanevectroid.util;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import br.com.insanegames.insanevectroid.gameobjects.GameObject;

/**
 * Representa a tela. Tem a capacidade desenhar GameObjects na tela (convertendo as posicoes corretas, independente da resolucao da tela do celular).
 * @author Marcio Frayze David
 *
 */
public class GameScreen {

	private ScreenSize screenSize;
	private Paint paint;
	private static int FICTIONAL_SCREEN_WIDTH = 1024;
	private static int FICTIONAL_SCREEN_HEIGHT = 768;

	public GameScreen(int width, int height) {
		this.screenSize = new ScreenSize(width, height);
		this.paint = new Paint();
	}

	public ScreenSize getScreenSize() {
		return screenSize;
	}

	public void setScreenSize(ScreenSize screenSize) {
		this.screenSize = screenSize;
	}

	public void drawGameObject(GameObject gameObject, Canvas canvas) {
		for (Line line : gameObject.getLines()) {
			paint.setColor(gameObject.getColor());					
			canvas.drawLine( xReal(line.startPosition.getX()), yReal(line.startPosition.getY()), xReal(line.endPosition.getX()), yReal(line.endPosition.getY()), paint);
		}
	}

	// Para o programador, a tela eh como se tivesse uma resolucao 1024x768. Aqui convertemos esses valores para valores proporcionais 
	// dependendo do tamanho da tela
	public int xReal(float xRelativo) {
		return (int) (xRelativo * screenSize.getRealWidth()) / FICTIONAL_SCREEN_WIDTH;
	}
	
	public int yReal(float yRelativo) {
		return (int) (yRelativo * screenSize.getRealHeight()) / FICTIONAL_SCREEN_HEIGHT;
	}	
	
	public static int randomXPosition() {
		return (int) (Math.random() * 1024);
	}

	public static int randomYPosition() {
		return (int) (Math.random() * 768);
	}
	
	public static int randomColor() {
		return Color.argb(255, (int)Math.random() * 256, (int)Math.random() * 256, (int)Math.random() * 256);
	}
	
}