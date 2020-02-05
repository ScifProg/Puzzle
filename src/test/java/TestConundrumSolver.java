import org.junit.Assert;
import org.junit.Test;
/**
 * @author Krasyuk Vladimir Andreevich Cheliabins 2020
 */
public class TestConundrumSolver {
    @Test
    public void TestResolveNullInputArray() throws Exception {
        int[] inputDataArray = null;
        int[] outputDataArrayResultExcepted = new int[8];;

        ConundrumSolver solver = new ConundrumSolveAlgorithm();
        int[] outputDataArrayResult = solver.resolve(inputDataArray);
        Assert.assertArrayEquals(outputDataArrayResultExcepted, outputDataArrayResult);
    }
    @Test
    public void TestResolveInputArrayWithSameValues() throws Exception {
        int[] inputDataArray = new int[]{1,2,7,7,7,7,6,7};
        int[] outputDataArrayResultExcepted = new int[8];

        ConundrumSolver solver = new ConundrumSolveAlgorithm();
        int[] outputDataArrayResult = solver.resolve(inputDataArray);
        Assert.assertArrayEquals(outputDataArrayResultExcepted, outputDataArrayResult);
    }
    @Test
    public void TestResolveInputArrayWithWrongLength() throws Exception {
        int[] inputDataArray = new int[]{1,2,3,4,0,5};
        int[] outputDataArrayResultExcepted = new int[8];

        ConundrumSolver solver = new ConundrumSolveAlgorithm();
        int[] outputDataArrayResult = solver.resolve(inputDataArray);
        Assert.assertArrayEquals(outputDataArrayResultExcepted, outputDataArrayResult);
    }
    @Test
    public void TestResolveInputArrayWithWrongValues() throws Exception {
        int[] inputDataArray = new int[]{1,2,3,4,0,5};
        int[] outputDataArrayResultExcepted = new int[8];

        ConundrumSolver solver = new ConundrumSolveAlgorithm();
        int[] outputDataArrayResult = solver.resolve(inputDataArray);
        Assert.assertArrayEquals(outputDataArrayResultExcepted, outputDataArrayResult);
    }
    @Test
    public void TestResolveNoSteps() throws Exception {
        int[] inputDataArray = new int[]{2,3,4,5,6,7,8,9};
        int[] outputDataArrayResultExcepted = new int[8];

        ConundrumSolver solver = new ConundrumSolveAlgorithm();
        int[] outputDataArrayResult = solver.resolve(inputDataArray);
        Assert.assertArrayEquals(outputDataArrayResultExcepted, outputDataArrayResult);
    }
    @Test
    public void TestResolveOneStep() throws Exception {
        int[] inputDataArray = new int[]{1,2,3,4,5,0,6,7};
        int[] outputDataArrayResultExcepted = new int[]{5};

        ConundrumSolver solver = new ConundrumSolveAlgorithm();
        int[] outputDataArrayResult = solver.resolve(inputDataArray);
        Assert.assertArrayEquals(outputDataArrayResultExcepted, outputDataArrayResult);
    }
    @Test
    public void TestResolveSixStep() throws Exception {
        int[] inputDataArray = new int[]{2,4,1,6,5,3,0,7};
        int[] outputDataArrayResultExcepted = new int[]{6,4,2,1,3,5};

        ConundrumSolver solver = new ConundrumSolveAlgorithm();
        int[] outputDataArrayResult = solver.resolve(inputDataArray);
        Assert.assertArrayEquals(outputDataArrayResultExcepted, outputDataArrayResult);
    }
    @Test
    public void TestResolveSevenStep() throws Exception {
        int[] inputDataArray = new int[]{2,1,3,4,0,5,6,7};
        int[] outputDataArrayResultExcepted = new int[]{5,3,2,1,2,3,5};

        ConundrumSolver solver = new ConundrumSolveAlgorithm();
        int[] outputDataArrayResult = solver.resolve(inputDataArray);
        Assert.assertArrayEquals(outputDataArrayResultExcepted, outputDataArrayResult);
    }
    @Test
    public void TestResolveEighteenStep() throws Exception {
        int[] inputDataArray = new int[]{0,1,2,3,4,5,6,7};
        int[] outputDataArrayResultExcepted = new int[]{1,2,1,2,3,4,5,1,3,2,3,1,5,4,2,3,1,3,2,4};

        ConundrumSolver solver = new ConundrumSolveAlgorithm();
        int[] outputDataArrayResult = solver.resolve(inputDataArray);
        Assert.assertArrayEquals(outputDataArrayResultExcepted, outputDataArrayResult);
    }

}
