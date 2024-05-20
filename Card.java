import javax.swing.JButton;
import javax.swing.ImageIcon;

public class Card extends JButton {
  private boolean flippedToFront;
  private ImageIcon front;
  private ImageIcon back;
  private String name;
  private String pair;

  public Card(ImageIcon front, String name, String pair) {
    super(new ImageIcon("images.png"));
    this.front = front;
    this.name = name;
    this.pair = pair;
    this.setPressedIcon(front);
    back = new ImageIcon("images.png");
    flippedToFront = false;
  }

  public boolean getFlippedToFront() {
    return flippedToFront;
  }

  public String getName() {
    return name;
  }

  public String getPair() {
    return pair;
  }

  public void flipToFront() {
    setIcon(front);
    flippedToFront = true;
  }

  public void flipToBack() {
    setIcon(back);
    flippedToFront = false;
  }
}