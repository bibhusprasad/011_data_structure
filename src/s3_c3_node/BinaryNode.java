package s3_c3_node;

public class BinaryNode {

	private int value;
	private int height;
	private BinaryNode left;
	private BinaryNode right;

	public int getValue() {
		return this.value;
	}

	public void setValue(final int value) {
		this.value = value;
	}

	public int getHeight() {
		return this.height;
	}

	public void setHeight(final int height) {
		this.height = height;
	}

	public BinaryNode getLeft() {
		return this.left;
	}

	public void setLeft(final BinaryNode left) {
		this.left = left;
	}

	public BinaryNode getRight() {
		return this.right;
	}

	public void setRight(final BinaryNode right) {
		this.right = right;
	}

	@Override
	public String toString() {
		return this.value + "";
	}

}
