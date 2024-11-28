// https://javaee.github.io/jsonb-spec/users-guide.html
public class Aplikacija {
    public static void main(String args[]) {
        JSONB jb = new JSONB();
        jb.defaultMapping();
        jb.collectionsMapping();
        jb.genericCollectionsMapping();
        jb.customMapping();
        //jb.adapters();
        //jb.SerializeDeserialize();
    }
}
