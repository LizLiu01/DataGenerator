package datagenerator

import datagenerator.model.Hierarchy.{Hierarchy, HierarchyLevel}
import org.scalatest.FlatSpec


class HierarchyTest extends FlatSpec {

  "A hierarchy of two levels and level depth size two" should "return four rows" in {
    val hierarchyDepth = 2
    val textSize = 5

    val hierarchy = new Hierarchy(
      HierarchyLevel("level1", hierarchyDepth, textSize),
      HierarchyLevel("level2", hierarchyDepth, textSize)
    )

    val df = hierarchy.toDataFrame

    assert(df.count === 4)
  }

  "A hierarchy of three levels and level depth size two" should "return eight rows" in {
    val hierarchyDepth = 2
    val textSize = 5

    val hierarchy = new Hierarchy(
      HierarchyLevel("level1", hierarchyDepth, textSize),
      HierarchyLevel("level2", hierarchyDepth, textSize),
      HierarchyLevel("level3", hierarchyDepth, textSize)
    )

    val df = hierarchy.toDataFrame

    assert(df.count === 8)
  }

}
