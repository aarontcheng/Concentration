import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.*;
//import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class ConcentrationGui implements ActionListener{
  JPanel cardPanel;
  JFrame frame;
  JLabel timer;
  GridLayout layout;
  private Card card1;
  private Card card2;
  private Card card3;
  private Card card4;
  private Card card5;
  private Card card6;
  private Card card7;
  private Card card8;
  private Card card9;
  private Card card10;
  private Card card11;
  private Card card12;
  private ArrayList<Card> cardList;
  private boolean matching;
  private Card cardSelected;
  private int matches;
  private boolean win;

  public ConcentrationGui(){
    matching = false;
    matches = 0;
    win = false;

    

  }

  public void play() throws InterruptedException{
    frame = new JFrame("Concentration");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    cardPanel = new JPanel();

    timer = new JLabel("[0 seconds]");
    timer.setFont(new Font("Helvetica", Font.PLAIN, 30));
    

    cardList = new ArrayList<Card>();
    
    card1 = new Card(new ImageIcon("king_of_hearts2.png"), "card1", "card2");
    card1.addActionListener(this);
    cardList.add(card1);
    
    card2 = new Card(new ImageIcon("king_of_hearts2.png"), "card2", "card1");
    card2.addActionListener(this);
    cardList.add(card2);
    
    card3 = new Card(new ImageIcon("queen_of_diamonds2.png"), "card3", "card4");
    card3.addActionListener(this);
    cardList.add(card3);
    
    card4 = new Card(new ImageIcon("queen_of_diamonds2.png"), "card4", "card3");
    card4.addActionListener(this);
    cardList.add(card4);
    
    card5 = new Card(new ImageIcon("7_of_clubs.png"), "card5", "card6");
    card5.addActionListener(this);
    cardList.add(card5);
    
    card6 = new Card(new ImageIcon("7_of_clubs.png"), "card6", "card5");
    card6.addActionListener(this);
    cardList.add(card6);

    card7 = new Card(new ImageIcon("jack_of_hearts2.png"), "card7", "card8");
    card7.addActionListener(this);
    cardList.add(card7);

    card8 = new Card(new ImageIcon("jack_of_hearts2.png"), "card8", "card7");
    card8.addActionListener(this);
    cardList.add(card8);

    card9 = new Card(new ImageIcon("2_of_clubs.png"), "card9", "card10");
    card9.addActionListener(this);
    cardList.add(card9);

    card10 = new Card(new ImageIcon("2_of_clubs.png"), "card10", "card9");
    card10.addActionListener(this);
    cardList.add(card10);

    card11 = new Card(new ImageIcon("2_of_diamonds.png"), "card11", "card12");
    card11.addActionListener(this);
    cardList.add(card11);

    card12 = new Card(new ImageIcon("2_of_diamonds.png"), "card12", "card11");
    card12.addActionListener(this);
    cardList.add(card12);
  
    //maybe add these in randomly
    
   // for (int i = 0; i < cardList.size(); i++){
   //   int random = (int)(Math.random() * cardList.size());
   //   cardPanel.add(cardList.remove(random));
   //   i--;
   // }
    ArrayList<Card> tempCardList = new ArrayList<Card>();
    for (Card card: cardList){
      tempCardList.add(card);
    }

    while (tempCardList.size() > 0){
      int random = (int)(Math.random() * tempCardList.size());
      cardPanel.add(tempCardList.remove(random));
    }
    
    // cardPanel.add(card1);
    // cardPanel.add(card2);
    // cardPanel.add(card3);
    // cardPanel.add(card4);
    // cardPanel.add(card5);
    // cardPanel.add(card6);

    layout = new GridLayout(3, 4);
    layout.setHgap(5);
    layout.setVgap(10);
    cardPanel.setLayout(layout);


    frame.add(cardPanel, BorderLayout.NORTH);
    frame.add(timer, BorderLayout.CENTER);
    frame.pack();
    frame.setVisible(true);

    
    while (1 == 1){
      int x = 1;
      while (x>=0){
        Thread.sleep(1000);
        timer.setText(x + " seconds");
        if (win){
          timer.setText("You win! Final time: " + x + " seconds");
          Thread.sleep(5000);
          break;
        }
        else{
          x++;
        }
      }
      frame.remove(cardPanel); //wouldn't load cards correctly without this
      cardPanel = new JPanel();
      tempCardList = new ArrayList<Card>();
      for (Card card: cardList){
        tempCardList.add(card);
        card.flipToBack();
      }
      while (tempCardList.size() > 0){
        int random = (int)(Math.random() * tempCardList.size());
        cardPanel.add(tempCardList.remove(random));
      }
      cardPanel.setLayout(layout);
      frame.add(cardPanel, BorderLayout.NORTH);
      frame.pack();
      win = false;
      matches = 0;
    }
  }

  public void selecting(String text){
    for (Card card: cardList){
      boolean found = false;
      if (card.getName().equals(text)){
        if (card.getFlippedToFront() == false){
          card.flipToFront();
          cardSelected = card;
        }
      }
      if (found){
        break;
      }
    }
    matching = true;
  }

  //System.out.println("selecting is running");
    // if (text.equals("card1")){
      
    //   if (card1.getFlippedToFront() == false){
    //     card1.flipToFront();
    //     cardSelected = card1;
    //   }
      
      
    // } else if (text.equals("card2")){
      
    //   if (card2.getFlippedToFront() == false){
    //     card2.flipToFront();
    //     cardSelected = card2;
    //   }
      
      
    // } else if (text.equals("card3")){
      
    //   if (card3.getFlippedToFront() == false){
    //     card3.flipToFront();
    //     cardSelected = card3;
    //   }
      
      
    // } else if (text.equals("card4")){
      
    //   if (card4.getFlippedToFront() == false){
    //     card4.flipToFront();
    //     cardSelected = card4;
    //     }
      
    // } else if (text.equals("card5")){
      
    //   if (card5.getFlippedToFront() == false){
    //     card5.flipToFront();
    //     cardSelected = card5;
        
    //   }
      
      
    // } else if (text.equals("card6")){
      
    //   if (card6.getFlippedToFront() == false){
    //     card6.flipToFront();
    //     cardSelected = card6;
        
    //   }
      
      
    // }

    
    // for (int i = 0; i < cardList.size(); i++){
    //   System.out.println("popopop");
    //   boolean found = false;
    //   if (cardList.get(i).getName().equals(text)){
    //     if (cardList.get(i).getFlippedToFront() == false){
    //       cardList.get(i).flipToFront();
    //       cardSelected = cardList.get(i);
    //       System.out.println("yoyo");
    //     }
    //   }
    //   if (found){
    //     break;
    //   }
    // } 


  public void matching(String text) throws InterruptedException{
    if (text.equals(cardSelected.getPair())){
      for (Card card: cardList){
        if (text.equals(card.getName())){
          card.flipToFront();
          matches++;
          if (matches == 6){
            win = true;
          }
        }
      }
    } 
    else {
      for (Card card: cardList){
        if (text.equals(card.getName())){
          Thread.sleep(350);
          cardSelected.flipToBack();
        }
      }
    }
    matching = false;
  }

  // if (text.equals("card1")){

      //   card1.flipToFront();
        
        
      // } else if (text.equals("card2")){
      
      //   card2.flipToFront();
      
      
      // } else if (text.equals("card3")){
      
      //   card3.flipToFront();
      
      
      // } else if (text.equals("card4")){
      
      //   card4.flipToFront();
      
      
      // } else if (text.equals("card5")){
      
      //   card5.flipToFront();
      
      
      // } else if (text.equals("card6")){
      
      //   card6.flipToFront();
      

      // }

  

  // if (text.equals("card1")){

      //   System.out.println("card1");
      //   Thread.sleep(1000);
        
      //   card1.flipToBack();
        
        
        
      // } else if (text.equals("card2")){
        
      //   System.out.println("card2");
      //   Thread.sleep(1000);
      //   card2.flipToBack();
      
      
      // } else if (text.equals("card3")){

      //   System.out.println("card3");
      //   Thread.sleep(1000);
      //   card3.flipToBack();
      
      
      // } else if (text.equals("card4")){

      //   System.out.println("card4");
      //   Thread.sleep(1000);
      //   card4.flipToBack();
      
      
      // } else if (text.equals("card5")){

      //   System.out.println("card5");
      //   Thread.sleep(1000);
      //   card5.flipToBack();
      
      
      // } else if (text.equals("card6")){

      //   System.out.println("card6");
      //   Thread.sleep(1000);
      //   card6.flipToBack();
      
      // }

  public void actionPerformed(ActionEvent e) {
    Card card = (Card)(e.getSource());
    String text = card.getName();

    if (matches != 6){
      if (matching == true){
    
        try {
          matching(text);
        } catch (Exception i) { }
      }
      else {
        selecting(text);
      }

    }

    

    
  }

    
    
    

  
}
//For random cards, create array list of all available images, randomly choose one for a Card object, get rid of the image in the array list.