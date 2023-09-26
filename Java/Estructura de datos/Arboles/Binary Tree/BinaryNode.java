public class BinaryNode
{
    private String value;
    private BinaryNode rightChild;
    private BinaryNode leftChild;
    public BinaryNode(String value)
    {
        this.value = value;
    }


    public int getValueAsInt()
    {
        return Integer.valueOf(this.value);
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public BinaryNode getRightChild() {
        return this.rightChild;
    }

    public void setRightChild(BinaryNode rightChild) {
        this.rightChild = rightChild;
    }

    public BinaryNode getLeftChild() {
        return this.leftChild;
    }

    public void setLeftChild(BinaryNode leftChild) {
        this.leftChild = leftChild;
    }


    @Override
    public String toString() {
        return this.value;
    }


}