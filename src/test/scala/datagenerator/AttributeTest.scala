package datagenerator

import datagenerator.model.Attribute._
import org.scalatest.FlatSpec


class AttributeTest extends FlatSpec {

  "For random number 0.5, a byte attribute" should "return 4 for range [1,6]" in {
    val byteTest = new ByteAttribute("testAttribute", 1.toByte, 6.toByte)
    val value = byteTest.transform(0.5)
    assert(value.isInstanceOf[Byte])
    assert(value === 4)
  }

  "For random number 0.5, a short attribute" should "return 501 for range [1,1000]" in {
    val shortTest = new ShortAttribute("testAttribute", 1.toShort, 1000.toShort)
    val value = shortTest.transform(0.5)
    assert(value.isInstanceOf[Short])
    assert(value === 501)
  }

  "For random number 0.5, an integer attribute" should "return 500001 for range [1,1000000]" in {
    val intTest = new IntAttribute("testAttribute", 1, 1000000)
    val value = intTest.transform(0.5)
    assert(value.isInstanceOf[Int])
    assert(value === 500001)
  }

  "For random number 0.5, a long attribute" should "return 5000000001L for range [1,10000000000]" in {
    val longTest = new LongAttribute("testAttribute", 1L, 10000000000L)
    val value = longTest.transform(0.5)
    assert(value.isInstanceOf[Long])
    assert(value === 5000000001L)
  }

  "For random number 0.5, a double attribute" should "return 500.5 for range [1,999]" in {
    val doubleTest = new DoubleAttribute("testAttribute", 1.0, 1000.0)
    val value = doubleTest.transform(0.5)
    assert(value.isInstanceOf[Double])
    assert(value === 500.5)
  }

  "For random number 0.5, a string attribute" should "return a string value" in {
    val stringTest = new StringAttribute("testAttribute", 10)
    val value = stringTest.transform(0.5)
    assert(value.isInstanceOf[String])
    assert(value.size === 10)
  }
}
