## Heap
- 출처: https://st-lab.tistory.com/205#클래스
- **최솟값 또는 최댓값**을 **빠르게** 찾아내기 위해 **완전이진트리** 형태로 만들어진 자료구조
- **부모 노드는 항상 자식 노드보다 우선순위가 높음**
    - 형제간 우선순위는 고려되지 않음
- 최소 힙 : 부모 노드의 값(key 값) ≤ 자식 노드의 값(key 값)
- 최대 힙 : 부모 노드의 값(key 값) ≥ 자식 노드의 값(key 값)
- 시간 복잡도 ```O(NlogN)```
- 트리 구조를 배열로 구현
    1. 구현의 용이함을 위해 시작 인덱스(root)는 1 부터 시작
    2. 각 노드와 대응되는 배열의 인덱스는 불변
    - [성질]
        1. 왼쪽 자식 노드 인덱스 = 부모 노드 인덱스 × 2 
        2. 오른쪽 자식 노드 인덱스 = 부모 노드 인덱스 × 2 + 1
        3. 부모 노드 인덱스 = 자식 노드 인덱스 / 2
## 우선순위 큐(Priority Queue)
- 출처: https://st-lab.tistory.com/219
- **우선 순위가 높은 요소가** 우선 순위가 낮은 요소보다 **먼저 제공되는** 자료구조
- 우선순위 큐를 구현하는 데 있어 가장 대표적인 방식이 Heap을 활용하는 방식
## Java 에서의 java.util.PriorityQueue
- 출처: https://velog.io/@gillog/Java-Priority-Queue우선-순위-큐
- 우선순위 큐에 저장할 객체는 필수적으로 Comparable Interface를 구현
- Comparable Interface를 구현하면 compareTo method를 override 하게 되고 해당 객체에서 처리할 우선순위 조건을 리턴해주면 PriorityQueue 가 알아서 우선순위가 높은 객체를 추출
- 선언
```java
import java.util.PriorityQueue;
import java.util.Collections;

//최소 힙 사용 우선순위 큐
PriorityQueue<Integer> priorityQueueLowest = new PriorityQueue<>();

//최대 힙 사용 우선순위 큐
PriorityQueue<Integer> priorityQueueHighest = new PriorityQueue<>(Collections.reverseOrder());
```
- Add
```java
// add(value) 메서드의 경우 만약 삽입에 성공하면 true를 반환, 
// 큐에 여유 공간이 없어 삽입에 실패하면 IllegalStateException을 발생
priorityQueueLowest.add(1);
priorityQueueLowest.add(10);
priorityQueueLowest.offer(100);

priorityQueueHighest.add(1);
priorityQueueHighest.add(10);
priorityQueueHighest.offer(100);
```
- Remove
```java
// 첫번째 값을 반환하고 제거 비어있다면 null
priorityQueueLowest.poll();

// 첫번째 값 제거 비어있다면 예외 발생
priorityQueueLowest.remove(); 

// 첫번째 값을 반환만 하고 제거 하지는 않는다.
// 큐가 비어있다면 null을 반환
priorityQueueLowest.peek();

// 첫번째 값을 반환만 하고 제거 하지는 않는다.
// 큐가 비어있다면 예외 발생
priorityQueueLowest.element();

// 초기화
priorityQueueLowest.clear();  
```
### Priority Queue Using Costom Class
- PriorityQueue 안에 담길 객체를 자신만의 Class로 사용하려면 Comparable Interface를 implements하는 Class를 생성한 후, compareTo method를 우선 순위에 맞게 구현
- Custom Class
```java
class T implements Comparable<T> {

    private int writeRowNumber;
    private String content;

    public T(int writeRowNumber, String content) {
        this.writeRowNumber = writeRowNumber;
        this.content = content;
    }

    public int getWriteRowNumber() {
        return this.writeRowNumber;
    }

    public String getContent() {
        return this.content;
    }

    @Override
    public int compareTo(T t) {

        if (this.writeRowNumber > t.getWriteRowNumber())
            return 1;
        else if (this.writeRowNumber < t.getWriteRowNumber())
            return -1;
        return 0;
    }
}
```
- Priority Queue에 적용
```java
public static void main(String[] args) {

        PriorityQueue<T> priorityQueue = new PriorityQueue<>();

        priorityQueue.add(new T(3650, "10년후 글"));
        priorityQueue.add(new T(31, "한달 후 글"));
        priorityQueue.add(new T(1, "첫번째 글"));
        priorityQueue.add(new T(365, "1년후 글"));

        while (!priorityQueue.isEmpty()) {
            T t = priorityQueue.poll();
            System.out.println("글 넘버 : " + t.getWriteRowNumber() + " 글 내용 : " + t.getContent());
        }
    }
```