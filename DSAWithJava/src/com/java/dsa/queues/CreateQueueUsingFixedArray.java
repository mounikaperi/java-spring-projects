public class CreateQueueUsingFixedSizeArray {
    private int[] arr;
    private int size;
    private int front;
    public static final int DEFAULT_CAPACITY = 10;
    public Queue() {
        this(DEFAULT_CAPACITY);
    }
    public Queue(int capacity) {
        if (capacity < 1) {
           throw new Exception("Invalid Capacity");
        }
        this.arr = new int[capacity];
        this.size = 0;
        this.front = 0;
    }
    // O(1)
    public void enqueue(int value) throws Exception {
        if (this.size == this.arr.length) {
            throw new Exception("Queue is full. No elements can be added");
        }
        int rear = (this.front + this.size) % (this.arr.length);
        this.arr[rear] = value;
        this.size++;
    }
    // O(1)
    public int dequeue(int value) throws Exception {
        if (this.size == 0) {
            throw new Exception("Queue is empty, no value can be removed");
        }
        int ans = this.arr[this.front];
        this.front = (this.front + 1) % (this.arr.length);
        this.size--;
        return ans;
    }
    // O(1)
    public int peek() throws Exception {
        if (this.size == 0) {
            throw new Exception("Queue is empty");
        }
        return this.arr[this.front];
    }
    public boolean isEmpty() {
        return this.size == 0;
    }
    public boolean isFull() {
        return this.size == this.arr.length;
    }
    public int getSize() {
        return this.size;
    }
    public void displayQueue() {
        System.out.println(Arrays.toString(this.arr));
        // to print elements from front to rear
        for (int i=0; i<this.size; i++) {
            int index = (this.front + 1) % (this.arr.length);
            System.out.println(this.arr[index] + ", ");
        }
        System.out.println();
    }
}
