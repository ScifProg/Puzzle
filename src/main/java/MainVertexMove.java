import java.util.HashMap;
/**
 * @author Krasyuk Vladimir Andreevich Cheliabins 2020
 */
public interface MainVertexMove {
    HashMap<Integer,Integer>  GetConnectedVertexesWithMain();
    void SwapVertex(int nextVertexIndex);
    int[] GetCurrentFieldState();
}

