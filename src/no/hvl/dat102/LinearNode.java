package no.hvl.dat102;

public class LinearNode<T> {

	private LinearNode<T> next;
	private T element;

	public LinearNode() {
		this.next = null;
		this.element = null;
	}

	public LinearNode(T element) {
		this.next = null;
		this.element = element;
	}

	public void setNext(LinearNode<T> next) {
		this.next = next;
	}

	public LinearNode<T> getNext() {
		return this.next;
	}

	public void setElement(T element) {
		this.element = element;
	}

	public T getElement() {
		return this.element;
	}
}

