
interface List<Type>
{
	public void add(Type x);
	public void traverse();
	public void remove(Type O);
	public int search(Type O);
	public int size();
	public Type getElementAt(int pos);
	public boolean isEmpty();
}