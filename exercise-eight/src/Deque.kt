class Deque<T> {
    private var head: Element<T>? = null

    fun push(value: T) {
        var newNode : Element<T>? = Element(value)
        if (head == null){
            head = newNode
        }
        else{
            var lastNode : Element<T>? = head
            while (lastNode?.next != null){
                var tempNode : Element<T>? = head
                lastNode = lastNode?.next
                lastNode?.prev = tempNode
                tempNode = tempNode?.next
            }
            lastNode?.next = newNode
            if (newNode?.prev == null){newNode?.prev = head}
        }
    }

    fun pop(): T? {
        var value = head?.value
        var getValue : Element<T>? = head
        while (getValue?.next != null){
            getValue = getValue.next
        }
        value = getValue?.value
        getValue?.prev?.next = null
        return value
    }

    fun unshift(value: T) {
        var headCopy : Element<T>? = head
        var newHead : Element<T> = Element(value)
        head = newHead
        head?.next = headCopy
        headCopy?.prev = newHead
    }

    fun shift(): T? {
        var value = head?.value
        head = head?.next
        return value
    }

    private data class Element<T>(val value: T, var prev: Element<T>? = null, var next: Element<T>? = null)
}