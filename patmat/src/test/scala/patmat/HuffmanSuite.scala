package patmat

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import patmat.Huffman._

@RunWith(classOf[JUnitRunner])
class HuffmanSuite extends FunSuite {
  trait TestTrees {
    val t1 = Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5)
    val t2 = Fork(Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5), Leaf('d',4), List('a','b','d'), 9)
    val t3 = Fork(Leaf('d',4), Fork(Leaf('b',3), Leaf('a',2), List('a','b'), 5),  List('a','b','d'), 9)
    //val t4 = Fork(Leaf())
  }

  test("weight of a larger tree") {
    new TestTrees {
      assert(weight(t1) === 5)
    }
  }

  test("chars of a larger tree") {
    new TestTrees {
      assert(chars(t2) === List('a','b','d'))
    }
  }

  test("string2chars(\"hello, world\")") {
    assert(string2Chars("hello, world") === List('h', 'e', 'l', 'l', 'o', ',', ' ', 'w', 'o', 'r', 'l', 'd'))
  }

  test("times(string2Chars(\"aabbbdddd\"))") {
    assert(times(string2Chars("aabbbdddd")) == List(('a', 2), ('b', 3), ('d', 4)))
  }

  test("makeOrderedLeafList for some frequency table") {
    assert(makeOrderedLeafList(List(('t', 2), ('e', 1), ('x', 3))) === List(Leaf('e',1), Leaf('t',2), Leaf('x',3)))
  }

  test("singleton for a list of multiple trees") {
    new TestTrees {
      assert(!singleton(List(t1, t2)))
      assert(singleton(List(t1)))
    }
  }

  test("combine of some leaf list") {
    val leaflist = List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 4))
    assert(combine(leaflist) === List(Fork(Leaf('e',1),Leaf('t',2),List('e', 't'),3), Leaf('x',4)))
  }

  /**
  test("createCodeTree from a list of chars") {
    new TestTrees {
      assert(createCodeTree(string2Chars("aabbbdddd")) == t3)

    }
  }
  */

  // 깨달은 점: 문장 내 동일한 수로 들어가는 알파벳들이
  // 어느쪽 subtree의 leaf가 될지가 구현에 따라 다름...
  // 따라서 아래의 test는 의미 없다.
  /**
  test("only decode test") {
    new TestTrees {
      val codeTreeForTest = createCodeTree(string2Chars("AAAAAAAABBBCDEFGH"))
      assert(codeTreeForTest==t3)
      assert(decode(codeTreeForTest, List(1,0,1,1))==List('D'))
    }
  }
  */

  test("decode and encode a very short text should be identity") {
    new TestTrees {
      assert(decode(t1, encode(t1)("ab".toList)) === "ab".toList)
    }
  }

  test("quickEncode test by comparing with normal encode") {
    new TestTrees {
      assert(encode(t1)("ab".toList) === quickEncode(t1)("ab".toList))
    }
  }
}

