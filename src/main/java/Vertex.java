import java.util.HashSet;
/**
 * @author Krasyuk Vladimir Andreevich Cheliabins 2020
 */
public class Vertex {
    public int vertexValue;
    public HashSet<Integer> vertexConnectedIndex;

    public Vertex(int vertexValue, HashSet<Integer> vertexConnectedIndex){
        this.vertexValue = vertexValue;
        this.vertexConnectedIndex = vertexConnectedIndex;
    }
}
