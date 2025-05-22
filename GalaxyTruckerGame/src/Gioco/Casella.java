package Gioco;

public class Casella {
	private int x;
	private int y;
	private Tessera tessera;
	
	public Casella(int x, int y) {
		this.x=x;
		this.y=y;
		this.tessera = null;
	}
	
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public Tessera getTessera() {
        return tessera;
    }

	public void setTessera(Tessera tessera) {
        this.tessera = tessera;
    }
}
