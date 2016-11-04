package tests;

public class TestlogementDBStub {

    public static void main (String [] args) {
        System.out.print("Testing class LogementDBStub... ");
        try {
            logements.TestLogementDB.test(new logements.LogementDBStub());
        } catch (Throwable e) {
            System.out.println("\nTests failed: "+e);
            e.printStackTrace();
            System.exit(1);
        }
        System.out.print("OK");
    }

}


