package sample;

/**
 * Created by blueberryninja on 4/13/17.
 */
public class Bomber {

    private int posX, posY;
    private char[][] map;

    public Bomber(int posX, int posY, char[][] map){
        this.posX = posX;
        this.posY = posY;
        this.map = map;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public void moveUp(){
        if (this.map[this.posX - 1][this.posY] != 'x'
                && this.posX - 1 > 0)
            this.posX -= 1;
    }

    public void moveRight(){
        if (this.map[this.posX][this.posY + 1] != 'x'
                && this.posY + 1 < 10)
            this.posY += 1;
    }

    public void moveDown(){
        if (this.map[this.posX + 1][this.posY] != 'x'
                && this.posX + 1 < 10)
            this.posX += 1;
    }

    public void moveLeft(){
        if (this.map[this.posX][this.posY - 1] != 'x'
                && this.posY - 1 > 0)
            this.posY -= 1;
    }

    public void setMap(char[][] map) {
        this.map = map;
    }

    public char[][] getMap() {
        return map;
    }
}
