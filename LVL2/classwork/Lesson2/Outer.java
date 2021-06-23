package Lesson2;


public class Outer {

    private int outerVar;

    public Outer(int outerVar) {
        this.outerVar = outerVar;
    }

    public void outerVarTest() {
           //System.out.println("innerVar " +  innerVar);
        System.out.println("outerVar " +  outerVar);
    }

    class Inner {
        private int innerVar;

        public Inner(int innerVar) {
            this.innerVar = innerVar;
        }

        void innerTest() {
            System.out.println("innerVar " +  innerVar);
            System.out.println("outerVar " +  outerVar);
        }
    }
}

class OuterInnerMain {
    public static void main(String[] args) {

        Outer.Inner inner = new Outer(1).new Inner(2);
    }
}
