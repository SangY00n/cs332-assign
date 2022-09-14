package recfun
import common._

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    if (c==0 || c==r) 1
    else pascal(c, r-1) + pascal(c-1, r-1)
  }


  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    def counter(chars: List[Char], count: Int): Boolean = {
      if(chars.isEmpty) (count == 0)
      else {
        val h = chars.head
        val t = chars.tail
        if (h.toInt != 40 && h.toInt != 41) counter(t, count)
        else if (h.toInt == 40) counter(t, count + 1)
        else counter(t, count - 1)
      }
    }
    counter(chars, 0)
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    if (money == 0) 1
    else {
      if (coins.isEmpty) 0
      else if (money >= coins.head) countChange(money - coins.head, coins.tail) + countChange(money, coins.tail)
      else countChange(money, coins.tail)

    }
  }
}
