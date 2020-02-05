import java.util.*;
/**
 * @author Krasyuk Vladimir Andreevich Cheliabins 2020
 */
public class ConundrumSolveAlgorithm implements ConundrumSolver
{
    final private int[] idealState = new int[]{1,2,3,4,0,5,6,7};

    private ConundrumFreeCell mainVertex;
    private ArrayList<Integer> conundrumResolvingStep;

    @Override
    public int[] resolve(int[] initialState){
        if(CheckWrongArrayFormat(initialState))
            return new int[8];
        mainVertex = new ConundrumFreeCell(initialState);
        conundrumResolvingStep = new ArrayList<Integer>();
        return GetConundrumResolvingSteps();
    }

    private boolean CheckWrongArrayFormat(int[] initialState) {
        if(initialState == null)
            return true;
        if(Arrays.equals(initialState,idealState))
            return true;
        if(initialState.length != idealState.length)
            return true;
        if(UsefulMethods.GetUniqueArrayValues(initialState) != idealState.length)
            return true;
        if(UsefulMethods.GetNumberOfEntryArrays(initialState,idealState) != initialState.length)
            return true;
        return false;
    }

    private int[] GetConundrumResolvingSteps(){
        if(Arrays.equals(idealState,mainVertex.GetCurrentFieldState()))
            return GetConundrumResult();
        AddingWinStep();
        return GetConundrumResolvingSteps();

    }
    private void AddingWinStep() {
        HashMap<Integer,Integer> vertexes = mainVertex.GetConnectedVertexesWithMain();
        int ExceptedMaxStepEfficiency = 0;
        int ExceptedNextStepEfficiency = 0;
        int indexToSwap = 0;
        if(vertexes.size() > 1)
            vertexes.remove(mainVertex.lastVertexMainIndex);
        for (int vertexIndex: vertexes.keySet())
        {
            int[] mainVertexSaveState = mainVertex.GetCurrentFieldState();
            mainVertex.SwapVertex(vertexIndex);
            ExceptedNextStepEfficiency = GetExceptedStepEfficiency(12);
            mainVertex = new ConundrumFreeCell(mainVertexSaveState);
            if(ExceptedNextStepEfficiency >  ExceptedMaxStepEfficiency){
                ExceptedMaxStepEfficiency = ExceptedNextStepEfficiency;
                indexToSwap = vertexIndex;
            }
        }
        mainVertex.SwapVertex(indexToSwap);
        conundrumResolvingStep.add(vertexes.get(indexToSwap));
    }
    private int GetExceptedStepEfficiency(int iteration) {
        int numberOfMaxEntry = mainVertex.GetNumberOfEntryCurrentFieldWithArray(idealState);
        while (iteration != 0){

            if(iteration == 0 | numberOfMaxEntry == 8)
                return numberOfMaxEntry;

            iteration -= 1;
            numberOfMaxEntry = 0;
            int numberOfNextEntry;
            int indexToSwap = 0;
            HashMap<Integer,Integer> vertexes = mainVertex.GetConnectedVertexesWithMain();
            if(vertexes.size() > 1)
                vertexes.remove(mainVertex.lastVertexMainIndex);

            for (int vertexIndex: vertexes.keySet())
            {
                mainVertex.SwapVertex(vertexIndex);
                numberOfNextEntry = mainVertex.GetNumberOfEntryCurrentFieldWithArray(idealState);
                mainVertex.SwapVertex(mainVertex.lastVertexMainIndex);

                if(numberOfNextEntry >  numberOfMaxEntry){
                    numberOfMaxEntry = numberOfNextEntry;
                    indexToSwap = vertexIndex;
                }
                else if(numberOfMaxEntry == 0){
                    indexToSwap = vertexIndex;
                }
            }

            mainVertex.SwapVertex(indexToSwap);
        }
        return numberOfMaxEntry;
    }

    private int[] GetConundrumResult() {
        int[] result = new int[ conundrumResolvingStep.size()];
        int index = 0;
        for (int step : conundrumResolvingStep)
        {
            result[index] = step;
            index += 1;
        }
        return result;
    }
}
