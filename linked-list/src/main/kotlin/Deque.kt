
class Deque<T> {

    private var header: Node<T>? = null

    fun push (item: T) {
        val node = Node(item)
        if (header == null) {
            header = node
            return
        }
        var ptr = header
        while (ptr!!.next != null) {
            ptr = ptr.next
        }
        ptr.next = node
    }

    fun pop (): T{
        if (header == null) {
            throw ArrayIndexOutOfBoundsException()
        }
        var ptr = header
        var prev: Node<T>? = null
        while (ptr!!.next != null) {
            prev = ptr
            ptr = ptr.next
        }
        prev?.next = null
        return ptr.item
    }

    fun shift (): T {
        if (header == null) {
            throw ArrayIndexOutOfBoundsException()
        }
        val node = header
        header = header!!.next
        node!!.next = null
        return node.item
    }

    fun unshift (item: T) {
        val node = Node(item)
        node.next = header
        header = node
    }
}