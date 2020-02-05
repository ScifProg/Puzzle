import java.util.*;
/**
 * @author Krasyuk Vladimir Andreevich Cheliabins 2020
 */
public class ConundrumFreeCell implements MainVertexMove {

    private ArrayList<Vertex> ConundrumGraphField;
    private int mainVertexIndex;
    public int lastVertexMainIndex;

    public ConundrumFreeCell(int[] initialState) {
        ConundrumGraphField = new ArrayList<Vertex>();
        SetVertexValues(initialState);

    }
    private void SetVertexValues(int[] initialState) {
        AddNewVertex(initialState[0], 1, 2);
        FindMainVertex(initialState, 0);

        AddNewVertex(initialState[1], 0, 2, 3);
        FindMainVertex(initialState, 1);

        AddNewVertex(initialState[2], 0, 1, 5);
        FindMainVertex(initialState, 2);

        AddNewVertex(initialState[3], 1, 4, 6);
        FindMainVertex(initialState, 3);

        AddNewVertex(initialState[4], 3, 5);
        FindMainVertex(initialState, 4);

        AddNewVertex(initialState[5], 2, 4, 7);
        FindMainVertex(initialState, 5);

        AddNewVertex(initialState[6], 3);
        FindMainVertex(initialState, 6);

        AddNewVertex(initialState[7], 5);
        FindMainVertex(initialState, 7);
    }
    private void FindMainVertex(int[] initialState,
                                int indexVertex) {
        if (initialState[indexVertex] == 0)
            mainVertexIndex = indexVertex;
    }
    private void AddNewVertex(int vertexValue,
                              int... indexes) {
        HashSet<Integer> ConnectedIndexes = new HashSet<>();
        for(int index:indexes){
            ConnectedIndexes.add(index);
        }
        ConundrumGraphField.add(new Vertex(vertexValue,ConnectedIndexes));
    }


    @Override
    public HashMap<Integer,Integer> GetConnectedVertexesWithMain() {
        HashMap<Integer,Integer> ConnectedVertexes = new HashMap<Integer,Integer>();
        for(int index: ConundrumGraphField.get(mainVertexIndex).vertexConnectedIndex){
            ConnectedVertexes.put(index,GetVertexValue(index));
        }
        return ConnectedVertexes;
    }
    @Override
    public void SwapVertex(int nextVertexIndex) {
        CheckCurrent(nextVertexIndex);
        SwapValues(nextVertexIndex);
    }
    private void SwapValues(int nextVertexIndex) {

        SetVertexValue(mainVertexIndex, GetVertexValue(nextVertexIndex));
        SetVertexValue(nextVertexIndex, 0);
        lastVertexMainIndex = mainVertexIndex;
        mainVertexIndex = nextVertexIndex;
    }
    private void CheckCurrent(int nextVertexIndex) throws IllegalArgumentException {
        if(!ConundrumGraphField.get(mainVertexIndex).vertexConnectedIndex.contains(nextVertexIndex))
            throw new IllegalArgumentException("The specified index is not associated with this vertex.");
    }
    @Override
    public int[] GetCurrentFieldState() {
        int[] currentState = new int[ConundrumGraphField.size()];
        int index = 0;
        for (Vertex vertex : ConundrumGraphField)
        {
            currentState[index] = vertex.vertexValue;
            index += 1;
        }
        return currentState;
    }
    public int GetNumberOfEntryCurrentFieldWithArray(int[] externalArray){
        int numberOfEntry = 0;
        for(int i =0;i<ConundrumGraphField.size();i++){
            if(externalArray[i] == ConundrumGraphField.get(i).vertexValue)
                numberOfEntry += 1;
        }
        return numberOfEntry;
    }

    private int GetVertexValue(int VertexIndex) {
        return ConundrumGraphField
                .get(VertexIndex)
                .vertexValue;
    }
    private void SetVertexValue(int vertexIndex,int vertexValue) {
        ConundrumGraphField
                .get(vertexIndex)
                .vertexValue = vertexValue;
    }
}
