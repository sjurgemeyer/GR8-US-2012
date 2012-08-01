import groovy.transform.TypeChecked
import static groovy.transform.TypeCheckingMode.*

@TypeChecked
class Skip {
    @TypeChecked(SKIP)
    int foo() { 'foo' }
}
new Skip()