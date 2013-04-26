import org.scalatest.FunSuite

import BetterCodeExample._

class BetterCodeExampleUnitTests extends FunSuite {

    test("Burrow wheelers transform of ^BANANA|") {        
        assert(BetterCodeExample.burrowsWheelersTransform("^BANANA|") === """BNN^AA|A""")
    }
    
    test("Burrow wheelers transform of a empty string") {             
        intercept[IllegalArgumentException] {
                (BetterCodeExample.burrowsWheelersTransform(""))
        }        
    }
}