package case1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
  private List<Integer> cards;

  // 山札をシャッフルするメソッド
  public void shuffleDeck() {
    // 各スートの1〜13のListを準備
    List<Integer> deck = new ArrayList<>(52);

    // リストに1〜52の連番を代入
    for (int i = 1; i <= 52; i++) {
      deck.add(i);
    }

    // 山札をシャッフル
    Collections.shuffle(deck);

    // // リストの中身を確認(デバック用)
    // for (int i = 0; i < deck.size(); i++) {
    //   System.out.println(deck.get(i));
    // }

    cards = deck;
  }

  // 山札の数を[スート][ランク]に置き換えるメソッド
  public String toDescripthion(int cardNum) {
    String suit = toSuit(cardNum);
    String rank = toRank(toNum(cardNum));

    return (suit + rank);
  }

  // 山札の数をカードの数に置き換えるメソッド
  public int toNum(int cardNum) {
    int num = cardNum % 13;
    if (num == 0) {
      num = 13;
    }
    return num;
  }

  // カードの番号をランク(A,J,Q,K)に置き換えるメソッド
  public String toRank(int num) {
    switch (num) {
      case 1:
        return "A";
      case 11:
        return "J";
      case 12:
        return "Q";
      case 13:
        return "K";
      default:
        String str = String.valueOf(num);
        return str;
    }
  }

  // 山札の数をスート(♠︎,❤︎,♦︎,♣️)に置き換えるメソッド
  public  String toSuit(int cardNum) {
    switch ((cardNum - 1) / 13) {
      case 0:
        return "♠︎";
      case 1:
        return "❤︎";
      case 2:
        return "♦︎";
      case 3:
        return "♣︎";
      default:
        return "例外です";
    }
  }

  // 数字を比較するメソッド
  public boolean comparsionNum(int targetNum, int cardNum) {
    if (targetNum < cardNum) {
      // Highの場合
      return true;
    } else {
      // Lowの場合
      return false;
    }
  }

  public List<Integer> getCards() {
    return cards;
  }
}
