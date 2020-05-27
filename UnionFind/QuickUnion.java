public class QuickUnion
{

    private int[] id;
    private int[] sizeTree;
    private int connectedItems;

    /* Constructor for the Quick Union class */
    public QuickUnion(int totalItems)
    {
        id = new int[totalItems];
        sizeTree = new int[totalItems];
        connectedItems = totalItems - 1;
        for(int index = 0; index < totalItems; index++)
        {
            sizeTree[index] = 1;
            id[index] = index;
        }
    }

    /* Find the root of the item in the array */
    private int root(int item)
    {
        int localItem = item;
        while(localItem != id[localItem]) localItem = id[localItem];
        return localItem;
    }

    /* Merge two of the connected components */
    public void union(int itemP, int itemQ)
    {
        int rootP = root(itemP);
        int rootQ = root(itemQ);

        if(rootP == rootQ) return;
        
        if(sizeTree[rootP] <= sizeTree[rootQ])
        {
            id[rootP] = rootQ;
            sizeTree[rootQ] += sizeTree[rootP];
        }
        else
        {
            id[rootQ] = rootP;
            sizeTree[rootP] += sizeTree[rootQ];
        }
        connectedItems--;
    }

    /* Verify if the items are in the same component */
    public boolean isConnected(int itemP, int itemQ)
    {
        return root(itemP) == root(itemQ);
    }

    /* Check if all the items in the set are connected */
    public boolean allConnected()
    {
        return 0 == connectedItems;
    }
}
