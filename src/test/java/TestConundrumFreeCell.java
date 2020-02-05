import org.junit.Assert;
import org.junit.Test;
import java.util.HashMap;
/**
 * @author Krasyuk Vladimir Andreevich Cheliabins 2020
 */
public class TestConundrumFreeCell {

    private final int[] initialState = new int[]{1,2,3,4,0,5,6,7};

    @Test
    public void TestGetConnectedVertexes() {
        ConundrumFreeCell Cell = new ConundrumFreeCell(initialState);
        HashMap<Integer,Integer> ConnectedVertexesExcepted = new HashMap<>();
        ConnectedVertexesExcepted.put(3,4);
        ConnectedVertexesExcepted.put(5,5);

        HashMap<Integer,Integer> ConnectedVertexesResult = Cell. GetConnectedVertexesWithMain();
        Assert.assertEquals(ConnectedVertexesExcepted, ConnectedVertexesResult);
    }
    @Test
    public void TestSwapVertex(){

        TestSwapVertexDataSet1();
        TestSwapVertexDataSet2();
    }
        private void TestSwapVertexDataSet1(){
        ConundrumFreeCell Cell = new ConundrumFreeCell(initialState);
        Cell.SwapVertex(5);
        HashMap<Integer,Integer> ConnectedVertexesExcepted = new HashMap<>();
        ConnectedVertexesExcepted.put(4,5);
        ConnectedVertexesExcepted.put(2,3);
        ConnectedVertexesExcepted.put(7,7);

        HashMap<Integer,Integer> ConnectedVertexesResult = Cell. GetConnectedVertexesWithMain();
        Assert.assertEquals(ConnectedVertexesExcepted, ConnectedVertexesResult);
    }
        private void TestSwapVertexDataSet2(){
        ConundrumFreeCell Cell = new ConundrumFreeCell(initialState);
        Cell.SwapVertex(3);
        HashMap<Integer,Integer> ConnectedVertexesExcepted = new HashMap<>();
        ConnectedVertexesExcepted.put(1,2);
        ConnectedVertexesExcepted.put(4,4);
        ConnectedVertexesExcepted.put(6,6);

        HashMap<Integer,Integer> ConnectedVertexesResult = Cell. GetConnectedVertexesWithMain();
        Assert.assertEquals(ConnectedVertexesExcepted, ConnectedVertexesResult);
    }

    @Test
    public void TestGetCurrentFieldState(){

        TestGetCurrentFieldStateDataSet1();
        TestGetCurrentFieldStateDataSet2();
    }
        private void TestGetCurrentFieldStateDataSet1() {
        ConundrumFreeCell Cell = new ConundrumFreeCell(initialState);
        Cell.SwapVertex(5);
        int[] CurrentState = Cell.GetCurrentFieldState();
        int[] CurrentStateExcepted = new int[]{1,2,3,4,5,0,6,7};

        Assert.assertArrayEquals(CurrentStateExcepted, CurrentState);
    }
        private void TestGetCurrentFieldStateDataSet2() {
        ConundrumFreeCell Cell = new ConundrumFreeCell(initialState);
        Cell.SwapVertex(3);
        int[] CurrentState = Cell.GetCurrentFieldState();
        int[] CurrentStateExcepted = new int[]{1,2,3,0,4,5,6,7};

        Assert.assertArrayEquals(CurrentStateExcepted, CurrentState);
    }

    @Test
    public void TestGetNumberOfEntryCurrentFieldWithArray(){
        TestGetNumberOfEntryCurrentFieldWithArrayDataSet1();
        TestGetNumberOfEntryCurrentFieldWithArrayDataSet2();
    }

    private void TestGetNumberOfEntryCurrentFieldWithArrayDataSet1() {
        ConundrumFreeCell Cell = new ConundrumFreeCell(initialState);
        int numberOfEntry = Cell.GetNumberOfEntryCurrentFieldWithArray(initialState);

        Assert.assertEquals(8, numberOfEntry);
    }
    private void TestGetNumberOfEntryCurrentFieldWithArrayDataSet2() {
        ConundrumFreeCell Cell = new ConundrumFreeCell(initialState);
        Cell.SwapVertex(5);
        int numberOfEntry = Cell.GetNumberOfEntryCurrentFieldWithArray(initialState);

        Assert.assertEquals(6, numberOfEntry);
    }
}
