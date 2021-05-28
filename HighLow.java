package case1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HighLow {
  Scanner scanner = new Scanner(System.in);
  Deck deck = new Deck();

  int score = 0;

  public void highLowGame() {

    while (true) {
      // deckをシャッフル
      deck.shuffleDeck();
      printQue(drowCard());

      System.out.println("HighかLowか当ててください。High:h or Low:l");
      String ans = scanner.next();

      // 回答表示
      printAns(drowCard());

      // 成否判定
      if (judgeAns(ans) == true) {
        System.out.println("正解です。");
        score++;
      } else {
        System.out.println("残念、不正解です。");
        System.out.println("連続性回数：" + score + " です。");

        // 続ける or 辞める
        System.out.println("もう一度遊びますか？ Yes:y or No:n");
        String check = scanner.next();

        if ("y".equals(check) == true) {
          score = 0;
          System.out.println("\nGame Start");
        } else {
          break;
        }
      }
    }
  }
  
  // 問題を表示するメソッド
  public void printQue(List<Integer> drawList) {
    System.out.println("表示カード：" + deck.toDescripthion(drawList.get(0)));
    System.out.println("比較カード：???");
  }

  // 正解を表示するメソッド
  public void printAns(List<Integer> drawList) {
    System.out.println("比較カード："+deck.toDescripthion(drawList.get(1)) + " でした");
  }

  // 山札からカードを引き、Listを戻り値として返すメソッド
  public List<Integer> drowCard() {
    // DeckクラスからListを代入
    List<Integer> deckList = deck.getCards();

    // 山札から引く用のListを作成
    List<Integer> cardList = new ArrayList<>();

    // 表示カード
    cardList.add(deckList.get(0));
    // 比較カード
    cardList.add(deckList.get(1));

    return cardList;
  }

  public boolean judgeAns(String ans) {
    if ("h".equals(ans) == comparsionNum(drowCard())) {
      return true;
    } else {
      return false;
    }
  }

  // High or Lowの比較をし、boolen型で戻り値を返すメソッド
  public boolean comparsionNum(List<Integer> cardList) {
    if (deck.toNum(cardList.get(0)) < deck.toNum(cardList.get(1))) {
      // Highの場合
      return true;
    } else if (deck.toNum(cardList.get(0)) == deck.toNum(cardList.get(1))) {
      // Rankが同じ場合
      if (cardList.get(0) < cardList.get(1)) {
        return false;
      } else {
        return true;
      }
    } else {
      // Lowの場合
      return false;
    }
  }
}
